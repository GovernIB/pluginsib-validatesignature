package org.fundaciobit.plugins.validatesignature.api;

import org.fundaciobit.pluginsib.core.IPlugin;


/**
 * 
 * @author anadal
 *
 */
public interface IValidateSignaturePlugin extends IPlugin {
  
  
  public static final String VALIDATE_SIGNATURE_BASE_PROPERTY = IPLUGIN_BASE_PROPERTIES + "validatesignature.";
  
  
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
