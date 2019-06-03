package org.fundaciobit.plugins.validatesignature.tester.ejb;

import javax.ejb.Local;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface ValidateSignatureLocalJNDI {
  
  public static final String JNDI_NAME = "validatesignature/ValidateSignatureEjb/local";
  
  /*
   * 
        java:global/validatesignature/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
        java:app/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
        java:module/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
        ejb:validatesignature/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
        java:global/validatesignature/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb
        
        java:app/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb
        java:module/ValidateSignatureEjb

   */
  
  
  //public static final String JNDI_NAME = "java:app/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb";
  
  

}
