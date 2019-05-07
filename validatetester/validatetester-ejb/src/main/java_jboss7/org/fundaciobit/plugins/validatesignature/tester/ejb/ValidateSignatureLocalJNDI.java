package org.fundaciobit.plugins.validatesignature.tester.ejb;

import java.util.List;

import javax.ejb.Local;

import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.plugins.validatesignature.tester.utils.Plugin;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface ValidateSignatureLocalJNDI {
  

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
  
  
  public static final String JNDI_NAME = "java:app/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb";
  
  //public static final String JNDI_NAME = "java:app/pluginsib-validatesignature-tester-ejb/ValidateSignatureEjb";
  
  //public static final String JNDI_NAME = "java:module/ValidateSignatureEjb"; //!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal";
  
  

}
