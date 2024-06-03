package org.fundaciobit.pluginsib.validatesignature.fake;

import java.util.Properties;

import org.fundaciobit.pluginsib.validatesignature.api.AbstractValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus;

/**
 *
 * @author anadal
 *
 */
public class FakeValidateSignaturePlugin extends AbstractValidateSignaturePlugin  {

  /**
   * 
   */
  public FakeValidateSignaturePlugin() {
    super();
  }

  /**
   * @param propertyKeyBase
   * @param properties
   */
  public FakeValidateSignaturePlugin(String propertyKeyBase, Properties properties) {
    super(propertyKeyBase, properties);
  }

  /**
   * @param propertyKeyBase
   */
  public FakeValidateSignaturePlugin(String propertyKeyBase) {
    super(propertyKeyBase);
  }



  @Override
  public SignatureRequestedInformation getSupportedSignatureRequestedInformation() {
    SignatureRequestedInformation sri = new SignatureRequestedInformation();
    return sri;
  }

  @Override
  public SignatureRequestedInformation getSupportedSignatureRequestedInformationBySignatureType(
      String signType) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ValidateSignatureResponse validateSignature(ValidateSignatureRequest validationRequest)
      throws Exception {
    ValidateSignatureResponse si = new ValidateSignatureResponse();

    ValidationStatus validationStatus = new ValidationStatus();

    validationStatus.setStatus(ValidationStatus.SIGNATURE_VALID);

    si.setValidationStatus(validationStatus);

    return si;
  }

  @Override
  public String getResourceBundleName() {
  	return "validatesignature-fake";
  }
}
