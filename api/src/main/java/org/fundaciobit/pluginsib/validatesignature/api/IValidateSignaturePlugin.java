package org.fundaciobit.pluginsib.validatesignature.api;

import org.fundaciobit.pluginsib.core.v3.IPluginIB;

/**
 * 
 * @author anadal
 *
 */
public interface IValidateSignaturePlugin extends IPluginIB {

    public static final String VALIDATE_SIGNATURE_BASE_PROPERTY = IPLUGINSIB_BASE_PROPERTIES + "validatesignature.";

    /**
     * 
     * @param validationRequest
     * @return null si tot ha anat bé. Sinó el missatge de l'error.
     */
    public String filter(ValidateSignatureRequest validationRequest);

    /**
     * El valors que retorni null, significa que per alguns tipus de firma retorna
     * la informació i per altres tipus no.
     * @see IValidateSignaturePlugin#getSupportedSignatureRequestedInformationBySignatureType(String signType)
     * @return
     */
    public SignatureRequestedInformation getSupportedSignatureRequestedInformation();

    public SignatureRequestedInformation getSupportedSignatureRequestedInformationBySignatureType(String signType);

    public ValidateSignatureResponse validateSignature(ValidateSignatureRequest validationRequest) throws Exception;

}
