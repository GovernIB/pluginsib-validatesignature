package org.fundaciobit.plugins.validatesignature.afirmacxf;

public class ExpectedValidation {

    final int validationStatus;
    final String signType;
    final String signProfile;
    final String signFormat;
    final int signatureDetailLength;

    public ExpectedValidation(int validationStatus, String signType, String signProfile, String signFormat,
                              int signatureDetailLength) {
        this.validationStatus = validationStatus;
        this.signType = signType;
        this.signProfile = signProfile;
        this.signFormat = signFormat;
        this.signatureDetailLength = signatureDetailLength;
    }
}
