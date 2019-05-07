package org.fundaciobit.plugins.validatesignature.tester.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.fundaciobit.plugins.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.plugins.validatesignature.tester.utils.Plugin;
import org.fundaciobit.plugins.validatesignature.tester.utils.ValidateSignaturePluginManager;

/**
 *
 * @author anadal
 *
 */
@Stateless(name = "ValidateSignatureEjb")
public class ValidateSignatureEjb implements ValidateSignatureLocal {

  protected Logger log = Logger.getLogger(this.getClass());


  @Override
  public ValidateSignatureResponse validate(ValidateSignatureRequest validationRequest,
      long pluginID) throws Exception {

    ValidateSignaturePluginManager vspm = ValidateSignaturePluginManager.getInstance();

    // XYZ ZZZ
    IValidateSignaturePlugin plugin = vspm.getInstanceByPluginID(pluginID);

    String error = plugin.filter(validationRequest);

    if (error != null) {
      // TODO XYZ ZZZ Traduir
      throw new Exception("El plugin no suporta el format de firma"
          + " o alguna de la informació requerida: " + error);
    }

    ValidateSignatureResponse valResponse = plugin.validateSignature(validationRequest);

    return valResponse;

  }

  @Override
  public List<Plugin> getPlugins() throws Exception {

    // TODO CHECK signature Set
    List<Plugin> plugins = ValidateSignaturePluginManager.getInstance().getAllPlugins();
    if (plugins == null || plugins.size() == 0) {
      String msg = "S'ha produit un error llegint els plugins o no se n'han definit.";
      throw new Exception(msg);
    }

    return plugins;

  }

  @Override
  public void esborrarCachePlugins() throws Exception {
    ValidateSignaturePluginManager.getInstance().clearCache();
  }

}
