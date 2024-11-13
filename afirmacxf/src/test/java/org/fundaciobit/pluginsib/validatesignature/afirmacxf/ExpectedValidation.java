package org.fundaciobit.pluginsib.validatesignature.afirmacxf;

/**
 * 
 * @author anadal
 * 5 nov 2024 8:02:29
 */
public class ExpectedValidation {

    final int validationStatus;
    final String signType;
    final String signProfile;
    final int signMode;
    final int signatureDetailLength;

    public ExpectedValidation(int validationStatus, String signType, String signProfile, int signMode,
            int signatureDetailLength) {
        this.validationStatus = validationStatus;
        this.signType = signType;
        this.signProfile = signProfile;
        this.signMode = signMode;
        this.signatureDetailLength = signatureDetailLength;
    }
}
