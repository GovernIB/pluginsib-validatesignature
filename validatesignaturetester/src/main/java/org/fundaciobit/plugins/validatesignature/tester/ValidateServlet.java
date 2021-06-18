package org.fundaciobit.plugins.validatesignature.tester;

import org.fundaciobit.plugins.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/validate")
@MultipartConfig
public class ValidateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private PluginMapBean pluginMapBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part fitxer = request.getPart("fitxer");
        if (fitxer == null || fitxer.getSize() == 0) {
            response.sendError(400, "No s'ha rebut el paràmetre fitxer");
            return;
        }

        String pluginName = request.getParameter("pluginName");
        if (pluginName == null || !pluginMapBean.containsPlugin(pluginName)) {
            response.sendError(400, "Nom de plugin invàlid: " + pluginName);
            return;
        }

        ValidateSignatureRequest validateRequest = new ValidateSignatureRequest();
        try (var inputStream = fitxer.getInputStream()) {
            validateRequest.setSignatureData(inputStream.readAllBytes());
        }
        SignatureRequestedInformation sri = new SignatureRequestedInformation();
        sri.setReturnSignatureTypeFormatProfile(true);
        sri.setReturnCertificateInfo(true);
        sri.setReturnTimeStampInfo(true);

        validateRequest.setSignatureRequestedInformation(sri);

        IValidateSignaturePlugin plugin = pluginMapBean.getPlugin(pluginName);

        try {
            ValidateSignatureResponse validateResponse = plugin.validateSignature(validateRequest);
            request.setAttribute("validateResponse", validateResponse);

            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
