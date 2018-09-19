
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.fundaciobit.pluginsib.validatesignature.esignature.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidateSignature_QNAME = new QName("http://validation.dss.esig.europa.eu/", "validateSignature");
    private final static QName _ValidateSignatureResponse_QNAME = new QName("http://validation.dss.esig.europa.eu/", "validateSignatureResponse");
    private final static QName _WSReportsDTO_QNAME = new QName("http://validation.dss.esig.europa.eu/", "WSReportsDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.fundaciobit.pluginsib.validatesignature.esignature.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WsReportsDTO }
     * 
     */
    public WsReportsDTO createWsReportsDTO() {
        return new WsReportsDTO();
    }

    /**
     * Create an instance of {@link BasicBuildingBlocks }
     * 
     */
    public BasicBuildingBlocks createBasicBuildingBlocks() {
        return new BasicBuildingBlocks();
    }

    /**
     * Create an instance of {@link DetailedReport2 }
     * 
     */
    public DetailedReport2 createDetailedReport2() {
        return new DetailedReport2();
    }

    /**
     * Create an instance of {@link Signature2 .Timestamps }
     * 
     */
    public Signature2 .Timestamps createSignature2Timestamps() {
        return new Signature2 .Timestamps();
    }

    /**
     * Create an instance of {@link VCI }
     * 
     */
    public VCI createVCI() {
        return new VCI();
    }

    /**
     * Create an instance of {@link ManifestFile.Entries }
     * 
     */
    public ManifestFile.Entries createManifestFileEntries() {
        return new ManifestFile.Entries();
    }

    /**
     * Create an instance of {@link Certificate3 .Revocations }
     * 
     */
    public Certificate3 .Revocations createCertificate3Revocations() {
        return new Certificate3 .Revocations();
    }

    /**
     * Create an instance of {@link TLAnalysis }
     * 
     */
    public TLAnalysis createTLAnalysis() {
        return new TLAnalysis();
    }

    /**
     * Create an instance of {@link Certificate3 .QCStatementIds }
     * 
     */
    public Certificate3 .QCStatementIds createCertificate3QCStatementIds() {
        return new Certificate3 .QCStatementIds();
    }

    /**
     * Create an instance of {@link TimestampedObject }
     * 
     */
    public TimestampedObject createTimestampedObject() {
        return new TimestampedObject();
    }

    /**
     * Create an instance of {@link Signature2 .CommitmentTypeIndication }
     * 
     */
    public Signature2 .CommitmentTypeIndication createSignature2CommitmentTypeIndication() {
        return new Signature2 .CommitmentTypeIndication();
    }

    /**
     * Create an instance of {@link PSV }
     * 
     */
    public PSV createPSV() {
        return new PSV();
    }

    /**
     * Create an instance of {@link ValidationProcessArchivalData }
     * 
     */
    public ValidationProcessArchivalData createValidationProcessArchivalData() {
        return new ValidationProcessArchivalData();
    }

    /**
     * Create an instance of {@link SimpleReport2 .Signature }
     * 
     */
    public SimpleReport2 .Signature createSimpleReport2Signature() {
        return new SimpleReport2 .Signature();
    }

    /**
     * Create an instance of {@link CV }
     * 
     */
    public CV createCV() {
        return new CV();
    }

    /**
     * Create an instance of {@link TrustedService.CapturedQualifiers }
     * 
     */
    public TrustedService.CapturedQualifiers createTrustedServiceCapturedQualifiers() {
        return new TrustedService.CapturedQualifiers();
    }

    /**
     * Create an instance of {@link TrustedService.AdditionalServiceInfoUris }
     * 
     */
    public TrustedService.AdditionalServiceInfoUris createTrustedServiceAdditionalServiceInfoUris() {
        return new TrustedService.AdditionalServiceInfoUris();
    }

    /**
     * Create an instance of {@link DiagnosticData2 .Signatures }
     * 
     */
    public DiagnosticData2 .Signatures createDiagnosticData2Signatures() {
        return new DiagnosticData2 .Signatures();
    }

    /**
     * Create an instance of {@link Revocation.DigestAlgoAndValues }
     * 
     */
    public Revocation.DigestAlgoAndValues createRevocationDigestAlgoAndValues() {
        return new Revocation.DigestAlgoAndValues();
    }

    /**
     * Create an instance of {@link OID }
     * 
     */
    public OID createOID() {
        return new OID();
    }

    /**
     * Create an instance of {@link SignatureLevel }
     * 
     */
    public SignatureLevel createSignatureLevel() {
        return new SignatureLevel();
    }

    /**
     * Create an instance of {@link DiagnosticData.Signatures }
     * 
     */
    public DiagnosticData.Signatures createDiagnosticDataSignatures() {
        return new DiagnosticData.Signatures();
    }

    /**
     * Create an instance of {@link Certificate3 .CertificateChain }
     * 
     */
    public Certificate3 .CertificateChain createCertificate3CertificateChain() {
        return new Certificate3 .CertificateChain();
    }

    /**
     * Create an instance of {@link PCV }
     * 
     */
    public PCV createPCV() {
        return new PCV();
    }

    /**
     * Create an instance of {@link SubXCV }
     * 
     */
    public SubXCV createSubXCV() {
        return new SubXCV();
    }

    /**
     * Create an instance of {@link Certificate3 .ExtendedKeyUsages }
     * 
     */
    public Certificate3 .ExtendedKeyUsages createCertificate3ExtendedKeyUsages() {
        return new Certificate3 .ExtendedKeyUsages();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link ContainerInfo }
     * 
     */
    public ContainerInfo createContainerInfo() {
        return new ContainerInfo();
    }

    /**
     * Create an instance of {@link TrustedService }
     * 
     */
    public TrustedService createTrustedService() {
        return new TrustedService();
    }

    /**
     * Create an instance of {@link MimeType }
     * 
     */
    public MimeType createMimeType() {
        return new MimeType();
    }

    /**
     * Create an instance of {@link Certificate }
     * 
     */
    public Certificate createCertificate() {
        return new Certificate();
    }

    /**
     * Create an instance of {@link RemoteDocument }
     * 
     */
    public RemoteDocument createRemoteDocument() {
        return new RemoteDocument();
    }

    /**
     * Create an instance of {@link SimpleReport.Policy }
     * 
     */
    public SimpleReport.Policy createSimpleReportPolicy() {
        return new SimpleReport.Policy();
    }

    /**
     * Create an instance of {@link Signature2 .CertificateChain }
     * 
     */
    public Signature2 .CertificateChain createSignature2CertificateChain() {
        return new Signature2 .CertificateChain();
    }

    /**
     * Create an instance of {@link Certificate3 .CertificateChain.ChainItem }
     * 
     */
    public Certificate3 .CertificateChain.ChainItem createCertificate3CertificateChainChainItem() {
        return new Certificate3 .CertificateChain.ChainItem();
    }

    /**
     * Create an instance of {@link ConstraintsConclusion }
     * 
     */
    public ConstraintsConclusion createConstraintsConclusion() {
        return new ConstraintsConclusion();
    }

    /**
     * Create an instance of {@link ValidateSignatureResponse }
     * 
     */
    public ValidateSignatureResponse createValidateSignatureResponse() {
        return new ValidateSignatureResponse();
    }

    /**
     * Create an instance of {@link ConstraintsConclusionWithControlTime }
     * 
     */
    public ConstraintsConclusionWithControlTime createConstraintsConclusionWithControlTime() {
        return new ConstraintsConclusionWithControlTime();
    }

    /**
     * Create an instance of {@link org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertificateChain }
     * 
     */
    public org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertificateChain createCertificateChain() {
        return new org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertificateChain();
    }

    /**
     * Create an instance of {@link ValidationCertificateQualification }
     * 
     */
    public ValidationCertificateQualification createValidationCertificateQualification() {
        return new ValidationCertificateQualification();
    }

    /**
     * Create an instance of {@link CertificateChain2 }
     * 
     */
    public CertificateChain2 createCertificateChain2() {
        return new CertificateChain2();
    }

    /**
     * Create an instance of {@link SignatureProductionPlace }
     * 
     */
    public SignatureProductionPlace createSignatureProductionPlace() {
        return new SignatureProductionPlace();
    }

    /**
     * Create an instance of {@link Certificate3 .DigestAlgoAndValues }
     * 
     */
    public Certificate3 .DigestAlgoAndValues createCertificate3DigestAlgoAndValues() {
        return new Certificate3 .DigestAlgoAndValues();
    }

    /**
     * Create an instance of {@link Signature2 }
     * 
     */
    public Signature2 createSignature2() {
        return new Signature2();
    }

    /**
     * Create an instance of {@link org.fundaciobit.pluginsib.validatesignature.esignature.ws.SignatureScope }
     * 
     */
    public org.fundaciobit.pluginsib.validatesignature.esignature.ws.SignatureScope createSignatureScope() {
        return new org.fundaciobit.pluginsib.validatesignature.esignature.ws.SignatureScope();
    }

    /**
     * Create an instance of {@link Revocation.CertificateChain.ChainItem }
     * 
     */
    public Revocation.CertificateChain.ChainItem createRevocationCertificateChainChainItem() {
        return new Revocation.CertificateChain.ChainItem();
    }

    /**
     * Create an instance of {@link BasicSignature }
     * 
     */
    public BasicSignature createBasicSignature() {
        return new BasicSignature();
    }

    /**
     * Create an instance of {@link org.fundaciobit.pluginsib.validatesignature.esignature.ws.Signature }
     * 
     */
    public org.fundaciobit.pluginsib.validatesignature.esignature.ws.Signature createSignature() {
        return new org.fundaciobit.pluginsib.validatesignature.esignature.ws.Signature();
    }

    /**
     * Create an instance of {@link Signature2 .CertificateChain.ChainItem }
     * 
     */
    public Signature2 .CertificateChain.ChainItem createSignature2CertificateChainChainItem() {
        return new Signature2 .CertificateChain.ChainItem();
    }

    /**
     * Create an instance of {@link SimpleReport2 }
     * 
     */
    public SimpleReport2 createSimpleReport2() {
        return new SimpleReport2();
    }

    /**
     * Create an instance of {@link CertifiedRole }
     * 
     */
    public CertifiedRole createCertifiedRole() {
        return new CertifiedRole();
    }

    /**
     * Create an instance of {@link RFC }
     * 
     */
    public RFC createRFC() {
        return new RFC();
    }

    /**
     * Create an instance of {@link DetailedReport }
     * 
     */
    public DetailedReport createDetailedReport() {
        return new DetailedReport();
    }

    /**
     * Create an instance of {@link ValidateSignature }
     * 
     */
    public ValidateSignature createValidateSignature() {
        return new ValidateSignature();
    }

    /**
     * Create an instance of {@link Signature2 .SignatureScopes }
     * 
     */
    public Signature2 .SignatureScopes createSignature2SignatureScopes() {
        return new Signature2 .SignatureScopes();
    }

    /**
     * Create an instance of {@link ValidationSignatureQualification }
     * 
     */
    public ValidationSignatureQualification createValidationSignatureQualification() {
        return new ValidationSignatureQualification();
    }

    /**
     * Create an instance of {@link Certificate3 .Info.Message }
     * 
     */
    public Certificate3 .Info.Message createCertificate3InfoMessage() {
        return new Certificate3 .Info.Message();
    }

    /**
     * Create an instance of {@link SigningCertificate }
     * 
     */
    public SigningCertificate createSigningCertificate() {
        return new SigningCertificate();
    }

    /**
     * Create an instance of {@link SimpleReport2 .Signature.SignatureScope }
     * 
     */
    public SimpleReport2 .Signature.SignatureScope createSimpleReport2SignatureSignatureScope() {
        return new SimpleReport2 .Signature.SignatureScope();
    }

    /**
     * Create an instance of {@link XCV }
     * 
     */
    public XCV createXCV() {
        return new XCV();
    }

    /**
     * Create an instance of {@link SimpleReport }
     * 
     */
    public SimpleReport createSimpleReport() {
        return new SimpleReport();
    }

    /**
     * Create an instance of {@link Conclusion }
     * 
     */
    public Conclusion createConclusion() {
        return new Conclusion();
    }

    /**
     * Create an instance of {@link Revocation.Info.Message }
     * 
     */
    public Revocation.Info.Message createRevocationInfoMessage() {
        return new Revocation.Info.Message();
    }

    /**
     * Create an instance of {@link Signature2 .ClaimedRoles }
     * 
     */
    public Signature2 .ClaimedRoles createSignature2ClaimedRoles() {
        return new Signature2 .ClaimedRoles();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link Timestamp.CertificateChain }
     * 
     */
    public Timestamp.CertificateChain createTimestampCertificateChain() {
        return new Timestamp.CertificateChain();
    }

    /**
     * Create an instance of {@link ValidationProcessLongTermData }
     * 
     */
    public ValidationProcessLongTermData createValidationProcessLongTermData() {
        return new ValidationProcessLongTermData();
    }

    /**
     * Create an instance of {@link org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertificateChain.ChainItem }
     * 
     */
    public org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertificateChain.ChainItem createCertificateChainChainItem() {
        return new org.fundaciobit.pluginsib.validatesignature.esignature.ws.CertificateChain.ChainItem();
    }

    /**
     * Create an instance of {@link Revocation.Info }
     * 
     */
    public Revocation.Info createRevocationInfo() {
        return new Revocation.Info();
    }

    /**
     * Create an instance of {@link FC }
     * 
     */
    public FC createFC() {
        return new FC();
    }

    /**
     * Create an instance of {@link DiagnosticData }
     * 
     */
    public DiagnosticData createDiagnosticData() {
        return new DiagnosticData();
    }

    /**
     * Create an instance of {@link Certificate3 .CRLDistributionPoints }
     * 
     */
    public Certificate3 .CRLDistributionPoints createCertificate3CRLDistributionPoints() {
        return new Certificate3 .CRLDistributionPoints();
    }

    /**
     * Create an instance of {@link CertificatePolicy }
     * 
     */
    public CertificatePolicy createCertificatePolicy() {
        return new CertificatePolicy();
    }

    /**
     * Create an instance of {@link SimpleReport.Signature }
     * 
     */
    public SimpleReport.Signature createSimpleReportSignature() {
        return new SimpleReport.Signature();
    }

    /**
     * Create an instance of {@link Certificate3 .KeyUsageBits }
     * 
     */
    public Certificate3 .KeyUsageBits createCertificate3KeyUsageBits() {
        return new Certificate3 .KeyUsageBits();
    }

    /**
     * Create an instance of {@link Certificate3 .CertificatePolicies }
     * 
     */
    public Certificate3 .CertificatePolicies createCertificate3CertificatePolicies() {
        return new Certificate3 .CertificatePolicies();
    }

    /**
     * Create an instance of {@link Certificate3 .QCTypes }
     * 
     */
    public Certificate3 .QCTypes createCertificate3QCTypes() {
        return new Certificate3 .QCTypes();
    }

    /**
     * Create an instance of {@link VTS }
     * 
     */
    public VTS createVTS() {
        return new VTS();
    }

    /**
     * Create an instance of {@link Certificate3 .TrustedServiceProviders }
     * 
     */
    public Certificate3 .TrustedServiceProviders createCertificate3TrustedServiceProviders() {
        return new Certificate3 .TrustedServiceProviders();
    }

    /**
     * Create an instance of {@link Certificate3 }
     * 
     */
    public Certificate3 createCertificate3() {
        return new Certificate3();
    }

    /**
     * Create an instance of {@link DiagnosticData2 .TrustedLists }
     * 
     */
    public DiagnosticData2 .TrustedLists createDiagnosticData2TrustedLists() {
        return new DiagnosticData2 .TrustedLists();
    }

    /**
     * Create an instance of {@link DiagnosticData2 }
     * 
     */
    public DiagnosticData2 createDiagnosticData2() {
        return new DiagnosticData2();
    }

    /**
     * Create an instance of {@link DataToValidateDTO }
     * 
     */
    public DataToValidateDTO createDataToValidateDTO() {
        return new DataToValidateDTO();
    }

    /**
     * Create an instance of {@link ISC }
     * 
     */
    public ISC createISC() {
        return new ISC();
    }

    /**
     * Create an instance of {@link org.fundaciobit.pluginsib.validatesignature.esignature.ws.Policy }
     * 
     */
    public org.fundaciobit.pluginsib.validatesignature.esignature.ws.Policy createPolicy() {
        return new org.fundaciobit.pluginsib.validatesignature.esignature.ws.Policy();
    }

    /**
     * Create an instance of {@link ManifestFile }
     * 
     */
    public ManifestFile createManifestFile() {
        return new ManifestFile();
    }

    /**
     * Create an instance of {@link StructuralValidation }
     * 
     */
    public StructuralValidation createStructuralValidation() {
        return new StructuralValidation();
    }

    /**
     * Create an instance of {@link TrustedList }
     * 
     */
    public TrustedList createTrustedList() {
        return new TrustedList();
    }

    /**
     * Create an instance of {@link DiagnosticData2 .UsedCertificates }
     * 
     */
    public DiagnosticData2 .UsedCertificates createDiagnosticData2UsedCertificates() {
        return new DiagnosticData2 .UsedCertificates();
    }

    /**
     * Create an instance of {@link DistinguishedName }
     * 
     */
    public DistinguishedName createDistinguishedName() {
        return new DistinguishedName();
    }

    /**
     * Create an instance of {@link Certificate3 .Info }
     * 
     */
    public Certificate3 .Info createCertificate3Info() {
        return new Certificate3 .Info();
    }

    /**
     * Create an instance of {@link TrustedServiceProvider }
     * 
     */
    public TrustedServiceProvider createTrustedServiceProvider() {
        return new TrustedServiceProvider();
    }

    /**
     * Create an instance of {@link Certificate3 .OCSPAccessUrls }
     * 
     */
    public Certificate3 .OCSPAccessUrls createCertificate3OCSPAccessUrls() {
        return new Certificate3 .OCSPAccessUrls();
    }

    /**
     * Create an instance of {@link ValidationProcessTimestamps }
     * 
     */
    public ValidationProcessTimestamps createValidationProcessTimestamps() {
        return new ValidationProcessTimestamps();
    }

    /**
     * Create an instance of {@link Certificate2 }
     * 
     */
    public Certificate2 createCertificate2() {
        return new Certificate2();
    }

    /**
     * Create an instance of {@link Certificate3 .AuthorityInformationAccessUrls }
     * 
     */
    public Certificate3 .AuthorityInformationAccessUrls createCertificate3AuthorityInformationAccessUrls() {
        return new Certificate3 .AuthorityInformationAccessUrls();
    }

    /**
     * Create an instance of {@link Revocation.CertificateChain }
     * 
     */
    public Revocation.CertificateChain createRevocationCertificateChain() {
        return new Revocation.CertificateChain();
    }

    /**
     * Create an instance of {@link Timestamp.TimestampedObjects }
     * 
     */
    public Timestamp.TimestampedObjects createTimestampTimestampedObjects() {
        return new Timestamp.TimestampedObjects();
    }

    /**
     * Create an instance of {@link DiagnosticData.TrustedLists }
     * 
     */
    public DiagnosticData.TrustedLists createDiagnosticDataTrustedLists() {
        return new DiagnosticData.TrustedLists();
    }

    /**
     * Create an instance of {@link ContainerInfo.ManifestFiles }
     * 
     */
    public ContainerInfo.ManifestFiles createContainerInfoManifestFiles() {
        return new ContainerInfo.ManifestFiles();
    }

    /**
     * Create an instance of {@link Constraint }
     * 
     */
    public Constraint createConstraint() {
        return new Constraint();
    }

    /**
     * Create an instance of {@link SimpleReport.Signature.SignatureScope }
     * 
     */
    public SimpleReport.Signature.SignatureScope createSimpleReportSignatureSignatureScope() {
        return new SimpleReport.Signature.SignatureScope();
    }

    /**
     * Create an instance of {@link DigestAlgoAndValue }
     * 
     */
    public DigestAlgoAndValue createDigestAlgoAndValue() {
        return new DigestAlgoAndValue();
    }

    /**
     * Create an instance of {@link TrustedServiceProvider.TrustedServices }
     * 
     */
    public TrustedServiceProvider.TrustedServices createTrustedServiceProviderTrustedServices() {
        return new TrustedServiceProvider.TrustedServices();
    }

    /**
     * Create an instance of {@link TrustedService.ServiceSupplyPoints }
     * 
     */
    public TrustedService.ServiceSupplyPoints createTrustedServiceServiceSupplyPoints() {
        return new TrustedService.ServiceSupplyPoints();
    }

    /**
     * Create an instance of {@link SAV }
     * 
     */
    public SAV createSAV() {
        return new SAV();
    }

    /**
     * Create an instance of {@link ValidationProcessBasicSignatures }
     * 
     */
    public ValidationProcessBasicSignatures createValidationProcessBasicSignatures() {
        return new ValidationProcessBasicSignatures();
    }

    /**
     * Create an instance of {@link DiagnosticData.UsedCertificates }
     * 
     */
    public DiagnosticData.UsedCertificates createDiagnosticDataUsedCertificates() {
        return new DiagnosticData.UsedCertificates();
    }

    /**
     * Create an instance of {@link Timestamp.CertificateChain.ChainItem }
     * 
     */
    public Timestamp.CertificateChain.ChainItem createTimestampCertificateChainChainItem() {
        return new Timestamp.CertificateChain.ChainItem();
    }

    /**
     * Create an instance of {@link SimpleReport2 .Policy }
     * 
     */
    public SimpleReport2 .Policy createSimpleReport2Policy() {
        return new SimpleReport2 .Policy();
    }

    /**
     * Create an instance of {@link ContainerInfo.ContentFiles }
     * 
     */
    public ContainerInfo.ContentFiles createContainerInfoContentFiles() {
        return new ContainerInfo.ContentFiles();
    }

    /**
     * Create an instance of {@link Revocation }
     * 
     */
    public Revocation createRevocation() {
        return new Revocation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateSignature }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.dss.esig.europa.eu/", name = "validateSignature")
    public JAXBElement<ValidateSignature> createValidateSignature(ValidateSignature value) {
        return new JAXBElement<ValidateSignature>(_ValidateSignature_QNAME, ValidateSignature.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateSignatureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.dss.esig.europa.eu/", name = "validateSignatureResponse")
    public JAXBElement<ValidateSignatureResponse> createValidateSignatureResponse(ValidateSignatureResponse value) {
        return new JAXBElement<ValidateSignatureResponse>(_ValidateSignatureResponse_QNAME, ValidateSignatureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsReportsDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.dss.esig.europa.eu/", name = "WSReportsDTO")
    public JAXBElement<WsReportsDTO> createWSReportsDTO(WsReportsDTO value) {
        return new JAXBElement<WsReportsDTO>(_WSReportsDTO_QNAME, WsReportsDTO.class, null, value);
    }

}
