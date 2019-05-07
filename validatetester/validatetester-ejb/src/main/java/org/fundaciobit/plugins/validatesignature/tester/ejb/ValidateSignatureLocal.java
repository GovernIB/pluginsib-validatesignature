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
public interface ValidateSignatureLocal extends ValidateSignatureLocalJNDI {
  
  // JBOSS 5
  //public static final String JNDI_NAME = "validatesignature/ValidateSignatureEjb/local";
  
  
  // JBOSS 7
//        java:global/validatesignature/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
//        java:app/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
//        java:module/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
//        ejb:validatesignature/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb!org.fundaciobit.plugins.validatesignature.tester.ejb.ValidateSignatureLocal
//        java:global/validatesignature/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb
//        
//        java:app/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb
//        java:module/ValidateSignatureEjb
  
  //public static final String JNDI_NAME = "java:app/pluginsib-validatesignature-tester-ejb-2.0.0/ValidateSignatureEjb";
  
  
  public ValidateSignatureResponse validate(ValidateSignatureRequest validationRequest,
      long pluginID) throws Exception;
  
  public List<Plugin> getPlugins() throws Exception;
  
  
  public void esborrarCachePlugins() throws Exception;

  /* XYZ ZZZ
  public List<Plugin> getAllPluginsFiltered(String signaturesSetID) throws Exception;
  
  public SignaturesSet signDocuments(Long pluginID, String signaturesSetID) throws Exception;
  
  public SignaturesSet getSignaturesSet(String signaturesSetID);

  public void clearSignaturesSet(String signaturesSetID);
  */

}
