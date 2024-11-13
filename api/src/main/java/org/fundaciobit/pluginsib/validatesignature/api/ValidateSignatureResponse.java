package org.fundaciobit.pluginsib.validatesignature.api;

import org.fundaciobit.pluginsib.utils.signature.SignatureConstants;

/**
 * 
 * @author anadal
 *
 */
public class ValidateSignatureResponse implements SignatureConstants {

    /** CADES, XADES, PADES, ... */
    private String signType;

    /** Attached-implicit, detached-explicit, enveloped, enveloping, ..., */
    private int signMode;

    /** Perfil: BES, EPES, A, XL, .. */
    private String signProfile; //

    private ValidationStatus validationStatus = new ValidationStatus();

    private SignatureDetailInfo[] signatureDetailInfo = null;

    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public SignatureDetailInfo[] getSignatureDetailInfo() {
        return signatureDetailInfo;
    }

    public void setSignatureDetailInfo(SignatureDetailInfo[] signatureDetailInfo) {
        this.signatureDetailInfo = signatureDetailInfo;
    }

    public void setValidationStatus(ValidationStatus validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public int getSignMode() {
        return signMode;
    }

    public void setSignMode(int signMode) {
        this.signMode = signMode;
    }

    public String getSignProfile() {
        return signProfile;
    }

    public void setSignProfile(String signProfile) {
        this.signProfile = signProfile;
    }

}
