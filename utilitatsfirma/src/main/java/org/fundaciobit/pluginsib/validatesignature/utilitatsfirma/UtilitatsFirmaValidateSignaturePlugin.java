package org.fundaciobit.pluginsib.validatesignature.utilitatsfirma;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.fundaciobit.pluginsib.validatecertificate.InformacioCertificat;
import org.fundaciobit.pluginsib.validatesignature.api.AbstractValidateSignaturePlugin;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureCheck;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureDetailInfo;
import org.fundaciobit.pluginsib.validatesignature.api.SignatureRequestedInformation;
import org.fundaciobit.pluginsib.validatesignature.api.TimeStampInfo;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureRequest;
import org.fundaciobit.pluginsib.validatesignature.api.ValidateSignatureResponse;
import org.fundaciobit.pluginsib.validatesignature.api.ValidationStatus;

import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.api.UtilitatsFirmaV2Api;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.CertificateInformation;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.servicesforutilitatsfirma.ApiClientWithJsonSupport;

/**
 * 
 * @author anadal (u80067)
 * 7 abr 2026 12:06:20
 */
public class UtilitatsFirmaValidateSignaturePlugin extends AbstractValidateSignaturePlugin {

    public static final String PROPERTY_BASE = VALIDATE_SIGNATURE_BASE_PROPERTY + "utilitatsfirma.";

    /**
     * 
     */
    public UtilitatsFirmaValidateSignaturePlugin() {
        super();
    }

    /**
     * @param propertyKeyBase
     * @param properties
     */
    public UtilitatsFirmaValidateSignaturePlugin(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
    }

    /**
     * @param propertyKeyBase
     */
    public UtilitatsFirmaValidateSignaturePlugin(String propertyKeyBase) {
        super(propertyKeyBase);
    }

    @Override
    public SignatureRequestedInformation getSupportedSignatureRequestedInformation() {

        try {
            String languageUI = getPropertyRequired(PROPERTY_BASE + "languageui");
            es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignatureRequestedInformation sri_ws;
            sri_ws = getApi(languageUI).getSignatureRequestedInformation(languageUI);

            SignatureRequestedInformation sri_plugin = new SignatureRequestedInformation();

            sri_plugin.setReturnCertificateInfo(sri_ws.getReturnCertificateInfo());
            sri_plugin.setReturnCertificates(sri_ws.getReturnCertificates());
            sri_plugin.setReturnSignatureTypeFormatProfile(sri_ws.getReturnSignatureTypeFormatProfile());
            sri_plugin.setReturnTimeStampInfo(sri_ws.getReturnTimeStampInfo());
            sri_plugin.setReturnValidationChecks(sri_ws.getReturnValidationChecks());
            sri_plugin.setValidateCertificateRevocation(sri_ws.getValidateCertificateRevocation());

            return sri_plugin;
        } catch (Exception e) {
            log.error("Error obtenint la informació que pot retornar UtilitatsFirma al validar", e);
            return null;
        }
    }

    @Override
    public SignatureRequestedInformation getSupportedSignatureRequestedInformationBySignatureType(String signType) {
        // TODO Cridar al Servidor per veure si hi ha alguna diferència segons el tipus de signatura
        return getSupportedSignatureRequestedInformation();
    }

    @Override
    public ValidateSignatureResponse validateSignature(ValidateSignatureRequest validationRequest) throws Exception {

        SignatureRequestedInformation sri_plugin = validationRequest.getSignatureRequestedInformation();

        es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignatureRequestedInformation sri_ws;
        sri_ws = new es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignatureRequestedInformation();
        sri_ws.setReturnCertificateInfo(sri_plugin.getReturnCertificateInfo());
        sri_ws.setReturnCertificates(sri_plugin.getReturnCertificates());
        sri_ws.setReturnSignatureTypeFormatProfile(sri_plugin.getReturnSignatureTypeFormatProfile());
        sri_ws.setReturnTimeStampInfo(sri_plugin.getReturnTimeStampInfo());
        sri_ws.setReturnValidationChecks(sri_plugin.getReturnValidationChecks());
        sri_ws.setValidateCertificateRevocation(sri_plugin.getValidateCertificateRevocation());

        File signatureFile = null;
        File documentDetachedFile = null;
        try {
            {
                byte[] sdata = validationRequest.getSignatureData();

                signatureFile = File.createTempFile("plugin_signature_utilitatsFirma", ".signature");

                Files.write(signatureFile.toPath(), sdata);
                byte[] detached = validationRequest.getSignedDocumentData();
                if (detached != null) {

                    documentDetachedFile = File.createTempFile("plugin_signature_utilitatsFirma", ".detached");
                    Files.write(documentDetachedFile.toPath(), detached);
                }
            }

            String languageUI = getPropertyRequired(PROPERTY_BASE + "languageui");
            es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.ValidateSignatureResponse response_ws;
            response_ws = getApi(languageUI).validateSignature(languageUI, sri_ws, signatureFile, documentDetachedFile);

            /*
            {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String response_json = gson.toJson(response_ws);
                System.err.println("Resposta de UtilitatsFirma:\n" + response_json);
            }
            */

            ValidateSignatureResponse si = new ValidateSignatureResponse();

            ValidationStatus vs_plugin = new ValidationStatus();
            {
                es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.ValidationStatus vs_ws = response_ws
                        .getValidationStatus();

                vs_plugin.setStatus(vs_ws.getStatus());
                vs_plugin.setErrorMsg(vs_ws.getErrorMsg());

                if (vs_ws.getErrorException() != null) {
                    log.error(vs_ws.getErrorException());
                }

                si.setValidationStatus(vs_plugin);

            }

            if (vs_plugin.getStatus() != ValidationStatus.SIGNATURE_ERROR) {

                List<es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignatureDetailInfo> all_sdi_ws;
                all_sdi_ws = response_ws.getSignatureDetailInfo();

                SignatureDetailInfo[] all_sdi_plugin = null;

                if (all_sdi_ws != null) {

                    all_sdi_plugin = new SignatureDetailInfo[all_sdi_ws.size()];

                    int count = 0;
                    for (es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignatureDetailInfo sdi_ws : all_sdi_ws) {
                        SignatureDetailInfo sdi_plugin = new SignatureDetailInfo();
                        sdi_plugin.setAlgorithm(sdi_ws.getAlgorithm());

                        sdi_plugin.setCertificateChain(convertCertificateChain(sdi_ws.getCertificateChain()));

                        {
                            CertificateInformation ic_ws = sdi_ws.getCertificateInfo();

                            InformacioCertificat ic_plugin = new InformacioCertificat();
                            ic_plugin.setAltresValors(ic_ws.getAltresValors());
                            ic_plugin.setCarrec(ic_ws.getPositionInTheCompany());
                            ic_plugin.setCertificatQualificat(ic_ws.getCertificateQualified());
                            ic_plugin.setClassificacio(ic_ws.getCertificateTypeMinetur());
                            ic_plugin.setClassificacioEidas(ic_ws.getCertificateTypeEidas());
                            ic_plugin.setCreatAmbUnDispositiuSegur(ic_ws.getCreatedWithASecureDevice());
                            ic_plugin.setDataNaixement(ic_ws.getBirthDate());
                            ic_plugin.setDenominacioSistemaComponent(ic_ws.getSystemOrComponentDescription());
                            ic_plugin.setDocumentRepresentacio(ic_ws.getRepresentationDocument());
                            ic_plugin.setEmail(ic_ws.getEmail());
                            ic_plugin.setEmissorID(ic_ws.getIssuerID());
                            ic_plugin.setEmissorOrganitzacio(ic_ws.getIssuerOrganization());
                            // TODO ¿?????
                            ic_plugin.setEntitatSubscriptoraNif(ic_ws.getEntityAdministrationID());
                            ic_plugin.setEntitatSubscriptoraNom(ic_ws.getEntityName());
                            ic_plugin.setIdEuropeu(ic_ws.getEuropeanAdministrationID());
                            ic_plugin.setIdlogOn(ic_ws.getIdlogOn());
                            ic_plugin.setLlinatgesResponsable(ic_ws.getSurnames());
                            ic_plugin.setLlocDeFeina(ic_ws.getPositionInTheCompany());
                            ic_plugin.setNifResponsable(ic_ws.getAdministrationID());
                            ic_plugin.setNomCompletResponsable(ic_ws.getFullName());
                            ic_plugin.setNomDomini(ic_ws.getDomainName());
                            ic_plugin.setNomResponsable(ic_ws.getFirstName());
                            ic_plugin.setNumeroIdentificacionPersonal(ic_ws.getFunctionaryID());
                            try {
                                ic_plugin.setNumeroSerie(new BigInteger(ic_ws.getSerialNumber()));
                            } catch (Exception e) {
                                // TODO: handle exception
                                e.printStackTrace();
                            }

                            ic_plugin.setOiEuropeu(ic_ws.getEuropeanOrganizationAdministrationID());
                            ic_plugin.setOrganitzacio(ic_ws.getOrganization());
                            //ic.plugin.setOrganitzacioNifCif(ic_ws.getOrganizationID());
                            ic_plugin.setPais(ic_ws.getCountry());
                            ic_plugin.setPolitica(ic_ws.getPolicy());
                            ic_plugin.setPoliticaID(ic_ws.getPolicyID());
                            ic_plugin.setPoliticaVersio(ic_ws.getPolicyVersion());
                            ic_plugin.setPrimerLlinatgeResponsable(ic_ws.getFirstSurname());
                            ic_plugin.setPseudonim(ic_ws.getPseudonym());
                            ic_plugin.setQcCompliance(ic_ws.getQcCompliance());
                            ic_plugin.setQcSSCD(ic_ws.getQcSSCD());
                            ic_plugin.setRaoSocial(ic_ws.getCompanyName());
                            ic_plugin.setSegonLlinatgeResponsable(ic_ws.getSecondSurname());
                            ic_plugin.setSubject(ic_ws.getSubject());
                            ic_plugin.setTipusCertificat(ic_ws.getCertificateDescription());// TODO ??????
                            // TODO ¿?????
                            //ic_plugin.setTipusIdentificador(ic_ws.());
                            ic_plugin.setUnitatOrganitzativa(ic_ws.getOrganizationUnitName());
                            ic_plugin.setUnitatOrganitzativaNifCif(ic_ws.getOrganizationUnitID());
                            ic_plugin.setUsCertificat(ic_ws.getKeyUsageCertificate());
                            ic_plugin.setUsCertificatExtensio(ic_ws.getKeyUsageCertificateExtension());

                            ic_plugin.setValidDesDe(convertOffsetDateTimeToDate(ic_ws.getValidSince()));
                            ic_plugin.setValidFins(convertOffsetDateTimeToDate(ic_ws.getValidUntil()));

                            sdi_plugin.setCertificateInfo(ic_plugin);

                        }

                        sdi_plugin.setDigestValue(sdi_ws.getDigestValue());
                        sdi_plugin.setIndeterminateChecks(convertSignatureChecks(sdi_ws.getIndeterminateChecks()));
                        sdi_plugin.setInvalidChecks(convertSignatureChecks(sdi_ws.getInvalidChecks()));

                        sdi_plugin.setPolicyIdentifier(sdi_ws.getPolicyIdentifier());
                        sdi_plugin.setSignDate(convertOffsetDateTimeToDate(sdi_ws.getSignDate()));

                        sdi_plugin.setTimeStampInfo(convertTimeStampInfo(sdi_ws.getTimeStampInfo()));

                        sdi_plugin.setValidChecks(convertSignatureChecks(sdi_ws.getValidChecks()));

                        all_sdi_plugin[count] = sdi_plugin;
                        count++;
                    }

                }
                
                
                if (all_sdi_plugin != null) {

                    Arrays.sort(all_sdi_plugin, new Comparator<SignatureDetailInfo>() {
                        @Override
                        public int compare(SignatureDetailInfo o1, SignatureDetailInfo o2) {
                            try {
                                if (o1.getSignDate() == null) {
                                    return o2.getDigestValue().hashCode() - o1.getDigestValue().hashCode();
                                } else if (o2.getSignDate() == null) {
                                    return o2.getDigestValue().hashCode() - o1.getDigestValue().hashCode();
                                } else {
                                    return o1.getSignDate().compareTo(o2.getSignDate());
                                }
                            } catch (Throwable t) {
                                return 0;
                            }
                        }
                    });

                }

                si.setSignatureDetailInfo(all_sdi_plugin);

                si.setSignMode(response_ws.getSignMode());
                si.setSignType(response_ws.getSignType());
                si.setSignProfile(response_ws.getSignProfile());

            }

            return si;
        } finally {
            if (signatureFile != null) {
                if (!signatureFile.delete()) {
                    signatureFile.deleteOnExit();
                }

            }
            if (documentDetachedFile != null) {
                if (!documentDetachedFile.delete()) {
                    documentDetachedFile.deleteOnExit();
                }

            }
        }
    }

    public TimeStampInfo convertTimeStampInfo(
            es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.TimeStampInfo tsi_ws) {
        if (tsi_ws == null) {
            return null;
        }
        TimeStampInfo tsi_plugin = new TimeStampInfo();

        tsi_plugin.setAlgorithm(tsi_ws.getAlgorithm());
        tsi_plugin.setCertificate(tsi_ws.getCertificate());
        tsi_plugin.setCertificateIssuer(tsi_ws.getCertificateIssuer());
        tsi_plugin.setCertificateSubject(tsi_ws.getCertificateSubject());
        tsi_plugin.setCreationTime(convertOffsetDateTimeToDate(tsi_ws.getCreationTime()));

        return tsi_plugin;
    }

    public Date convertOffsetDateTimeToDate(java.time.OffsetDateTime odt) {
        if (odt == null) {
            return null;
        }
        return Date.from(odt.toInstant());
    }

    public List<SignatureCheck> convertSignatureChecks(
            List<es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignatureCheck> checks_ws) {
        if (checks_ws == null || checks_ws.isEmpty()) {
            return null;
        }
        List<SignatureCheck> checks_plugin = new java.util.ArrayList<>();
        for (es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignatureCheck check_ws : checks_ws) {
            SignatureCheck check_plugin = new SignatureCheck();
            check_plugin.setName(check_ws.getName());
            check_plugin.setType(check_ws.getType());
            checks_plugin.add(check_plugin);
        }
        return checks_plugin;
    }

    public byte[][] convertCertificateChain(List<byte[]> certificateChain) {
        if (certificateChain == null) {
            return null;
        }
        byte[][] result = new byte[certificateChain.size()][];
        int count = 0;
        for (byte[] cert : certificateChain) {
            result[count] = cert;
            count++;
        }
        return result;
    }

    @Override
    public String getResourceBundleName() {
        return "validatesignature-utilitatsfirma";
    }

    // ------------------------------

    public UtilitatsFirmaV2Api getApi(String languageUI) throws Exception {
        return getApi(getApiClient(languageUI));
    }

    protected UtilitatsFirmaV2Api getApi(ApiClientWithJsonSupport client) throws Exception {
        UtilitatsFirmaV2Api api = new UtilitatsFirmaV2Api(client);
        return api;
    }

    protected ApiClientWithJsonSupport getApiClient(String languageUI) throws Exception {

        String basePath = getPropertyRequired(PROPERTY_BASE + "host");
        log.debug("BasePath: " + basePath);
        String username = getPropertyRequired(PROPERTY_BASE + "username");
        log.debug("Username: " + username);
        String password = getPropertyRequired(PROPERTY_BASE + "password");

        ApiClientWithJsonSupport client = new ApiClientWithJsonSupport();
        client.setBasePath(basePath);
        client.setUsername(username);
        client.setPassword(password);

        client.setDebugging(true);

        client.addDefaultHeader("Accept-Language", languageUI);
        return client;

    }

}
