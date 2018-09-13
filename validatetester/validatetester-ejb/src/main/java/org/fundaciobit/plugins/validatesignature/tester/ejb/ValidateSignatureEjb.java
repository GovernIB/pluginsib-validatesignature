package org.fundaciobit.plugins.validatesignature.tester.ejb;

import java.util.List;

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
@Stateless(name = "ValidateSignatureEJB")
public class ValidateSignatureEjb implements ValidateSignatureLocal {

  protected Logger log = Logger.getLogger(this.getClass());
  
  
  // XYZ ZZZ
  /*
  protected IValidateSignaturePlugin instantiatePlugin() throws Exception {
    Properties pluginProperties = new Properties();
    pluginProperties.load(new FileInputStream(new File("D:/dades/dades/CarpetesPersonals/Programacio/pluginsib-1.0/plugins-validatesignature/afirmacxf/config/plugin.properties")));

    String propertyKeyBase = "org.fundaciobit.exemple.base.";

    IValidateSignaturePlugin plugin;
    plugin = new AfirmaCxfValidateSignaturePlugin(propertyKeyBase, pluginProperties);
    return plugin;
  }
  */
  
  @Override
  public ValidateSignatureResponse validate(ValidateSignatureRequest validationRequest,
      long pluginID) throws Exception {
    
    
    
    ValidateSignaturePluginManager vspm = ValidateSignaturePluginManager.getInstance();
    
    
    
    // XYZ ZZZ
    IValidateSignaturePlugin plugin= vspm.getInstanceByPluginID(pluginID);
    
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
    
    
    return  plugins;

  }


  @Override
  public void esborrarCachePlugins() throws Exception {
    ValidateSignaturePluginManager.getInstance().clearCache();   
  }
  
  
/* XYZ ZZZ
  private static final Map<String, SignaturesSet> signaturesSetsMap = new HashMap<String, SignaturesSet>();
  
  private static final Map<String, Long> caducitatPerSignaturesSets = new HashMap<String, Long>();


  private static long lastCheckFirmesCaducades = 0;

  
  private static final long ONE_MINUTE_IN_MS = 60 * 1000;

  @Override
  public void startSignatureProcess(SignaturesSet signaturesSet) {

    synchronized (signaturesSetsMap) {
     final String signaturesSetID = signaturesSet.getSignaturesSetID();

     signaturesSetsMap.put(signaturesSetID, signaturesSet);
     
     // Donam marge suficient: un minut per firma en servidor
     
     caducitatPerSignaturesSets.put(signaturesSetID, 
         System.currentTimeMillis() + 30 * ONE_MINUTE_IN_MS * signaturesSet.getFileInfoSignatureArray().length );
    }
    
  }
  
  
  
  @Override
  public List<Plugin> getAllPluginsFiltered(String signaturesSetID) throws Exception {


    SignaturesSet signaturesSet = getSignaturesSet(signaturesSetID);
    
 
    // TODO CHECK signature Set
    List<Plugin> plugins = SignatureServerPluginManager.getInstance().getAllPlugins();
    if (plugins == null || plugins.size() == 0) {
      String msg = "S'ha produit un error llegint els plugins o no se n'han definit.";
      throw new Exception(msg);
    }
    
    List<Plugin> pluginsFiltered = new ArrayList<Plugin>();
    
    ISignatureServerPlugin signaturePlugin;
 
    
    for (Plugin pluginDeFirma : plugins) {
      // 1.- Es pot instanciar el plugin ?
      signaturePlugin = SignatureServerPluginManager.getInstance().getInstanceByPluginID(
            pluginDeFirma.getPluginID());
      
      
      if (signaturePlugin == null) {
        throw new Exception("No s'ha pogut instanciar Plugin amb ID " + pluginDeFirma.getPluginID());
      }


      // 2.- Passa el filtre ...
      
      if (signaturePlugin.filter(signaturesSet)) {
          pluginsFiltered.add(pluginDeFirma);
      } else {
          // Exclude Plugin
          log.info("Exclos plugin [" + pluginDeFirma.getNom() + "]: NO PASSA FILTRE");
      }
      
    }

    return  pluginsFiltered;
  
  }

  @Override
  public SignaturesSet signDocuments(Long pluginID, String signaturesSetID) throws Exception {
    
    SignaturesSet signaturesSet = getSignaturesSet( signaturesSetID);

    log.info("SSM :: signDocuments: PluginID = " + pluginID);
    log.info("SSM :: signDocuments: signaturesSetID = " + signaturesSet.getSignaturesSetID());
    

    // El plugin existeix?
    ISignatureServerPlugin signaturePlugin;
    
    signaturePlugin = SignatureServerPluginManager.getInstance().getInstanceByPluginID(pluginID);

    if (signaturePlugin == null) {
      String msg = "plugin.signatureweb.noexist: " + String.valueOf(pluginID);
      throw new Exception( msg);
    }

    final String timeStampUrlBase = null;

    signaturesSet = signaturePlugin.signDocuments(signaturesSet, timeStampUrlBase);
    
    

    StatusSignaturesSet sss = signaturesSet.getStatusSignaturesSet();
    if (sss.getStatus() == StatusSignaturesSet.STATUS_INITIALIZING 
        || sss.getStatus() ==  StatusSignaturesSet.STATUS_IN_PROGRESS) {
      // Vull presuposar que si el mòdul de firma s'ha oblidat d'indicar aquest fet 
      // llavors significa que no funciona correctament o s'ha produït un error???
      
      String msg = " El proces de firma amb id " + signaturesSetID 
          + " que l'ha processat el plugin amb ID " + pluginID 
          + " ha finalitzat amb estat " 
          + ((sss.getStatus() == StatusSignaturesSet.STATUS_INITIALIZING)? "INICIALITZANT" : "EN_PROGRES");
      
      log.error(msg);
      
      sss.setStatus(StatusSignaturesSet.STATUS_FINAL_ERROR);
      sss.setErrorMsg(msg);
    }

    return signaturesSet;

  }


  
  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------
  // ----------------------------- U T I L I T A T  S  ----------------------
  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------


  public void clearSignaturesSet(String signaturesSetID) {

    synchronized (signaturesSetsMap) {
      signaturesSetsMap.remove(signaturesSetID);
      caducitatPerSignaturesSets.remove(signaturesSetID);
    }
  }
  */

  /**
   * Fa neteja
   * 
   * @param signaturesSetID
   * @return
   */
  /*
  public synchronized SignaturesSet getSignaturesSet(String signaturesSetID) {
    // Fer net peticions caducades SignaturesSet.getExpiryDate()
    // Check si existeix algun proces de firma caducat s'ha d'esborrar
    // Com a mínim cada minut es revisa si hi ha caducats
    Long now = System.currentTimeMillis();
    
    final long un_minut_en_ms =  60 * 60 * 1000;
    
    if (now + un_minut_en_ms > lastCheckFirmesCaducades) {
      lastCheckFirmesCaducades = now;
      List<String> keysToDelete = new ArrayList<String>();
      
      Set<String> ids = signaturesSetsMap.keySet();
      for (String id : ids) {
        Long expiry = caducitatPerSignaturesSets.get(id);
        if (now > expiry) {
          keysToDelete.add(id);
          SimpleDateFormat sdf = new SimpleDateFormat();
          log.info("Tancant Signature SET amb ID = " + id + " a causa de que està caducat "
              + "( ARA: " + sdf.format(new Date(now)) + " | CADUCITAT: " + sdf.format(expiry) + ")");
        }
      }
      
      if (keysToDelete.size() != 0) {
        synchronized (signaturesSetsMap) {

          for (String id : keysToDelete) {
            clearSignaturesSet(id);
          }
        }
      }
    }

    return signaturesSetsMap.get(signaturesSetID);
  }

*/






}
