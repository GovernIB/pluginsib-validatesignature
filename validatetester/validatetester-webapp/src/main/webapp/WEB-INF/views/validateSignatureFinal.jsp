<%@page import="org.fundaciobit.plugins.validatesignature.api.ValidateSignatureRequest"%>
<%@page import="org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<%@ include file="/WEB-INF/views/html_header.jsp"%>

<un:useConstants var="ValidationStatus" className="org.fundaciobit.plugins.validatesignature.api.ValidationStatus" />

<div style="margin:10px;">
<br>

    <h3 class="tabs_involved"><fmt:message key="validatesignature.final.msg1" /></h3>
    <fmt:message key="validatesignature.final.msg2" />
    <table class="table table-bordered" >

       <%
       
    //   ValidateSignatureRequest validateRequest;
    //   validateRequest.signatureRequestedInformation
  //ValidateSignatureResponse validateResponse;
  //validateResponse.getValidationStatus().getErrorMsg()
    //   CertificateInfo ci;
  //validateResponse.getSignatureDetailInfo()[0].getCertificateInfo().
       
       %>
        
            <c:set var="response" value="${infoGlobal.validateResponse}" ></c:set>
            <c:set var="request" value="${infoGlobal.validateRequest}" ></c:set>
            
            <tr>
                <td>
                   <h4>Petici&oacute;</h4>
                   
                  Retornar informació de Tipus, Format i Perfil: <b>${request.signatureRequestedInformation.returnSignatureTypeFormatProfile}</b> <br/>
                  Validate Certificate Revocation: <b>${request.signatureRequestedInformation.validateCertificateRevocation}</b> <br/>
                  Return Certificate Info: <b>${request.signatureRequestedInformation.returnCertificateInfo}</b> <br/>
                  Return Validation Checks: <b>${request.signatureRequestedInformation.returnValidationChecks}</b> <br/>
                  Return Certificates: <b>${request.signatureRequestedInformation.returnCertificates}</b> <br/>
                  Return TimeStamp Info: <b>${request.signatureRequestedInformation.returnTimeStampInfo}</b>
              </td>
            </tr>
            
            <tr>
                <td>
                   
                  <c:set var="status" value="${response.validationStatus}" ></c:set>
                
                  <h4>Estat Validaci&oacute;</h4>
                  

                  Status Number: <b>${status.status}</b> <br/>
                  Estat:
                  <c:choose>
                     <c:when test = "${status.status == ValidationStatus.SIGNATURE_INVALID}">
                        <b style="color:red">INVALID</b><br/>
                        Ra&oacute: <b style="color:red">${status.errorMsg}</b>
           
                     </c:when>
                     <c:when test = "${status.status == ValidationStatus.SIGNATURE_VALID}">
                       <b>VALID</b>
                     </c:when>                     
                     <c:otherwise>
                        Estat Desconegut
                     </c:otherwise>
                  </c:choose>
                  <br/>                  
                </td>
                
            </tr>
            
            <%--DADES BÀSIQUES  --%>
            <tr>
                <td>
                  <h4>Dades Bàsiques</h4>
                      <ul>
                         <li>Tipus: <b>${response.signType }</b></li>
                         <li>Format: <b>${response.signFormat }</b></li>
                         <li>Perfil: <b>${response.signProfile }</b></li>                                 
                      </ul>
                </td>
            </tr>
            
            
            
            <%-- DETALLS DE LES FIRMES  --%>
            <c:set var="arraySignatures" value="${response.signatureDetailInfo}" ></c:set>
            <c:if test="${ not empty arraySignatures }">
            <tr>
                <td>
                  <h4>Informaci&oacute; de les Firmes</h4>
                  <table class="table">
                     <tr>
                     <%
                     /*
                     ValidateSignatureResponse validateResponse;
                      validateResponse.getSignatureDetailInfo()[0].getAlgorithm()
                      validateResponse.getSignatureDetailInfo()[0].getDigestValue()
                      
                      validateResponse.getSignatureDetailInfo()[0].getPolicyIdentifier()
                      
                      validateResponse.getSignatureDetailInfo()[0].getTimeStampInfo()

                      validateResponse.getSignatureDetailInfo()[0].getTimeStampInfo().getAlgorithm()
                      validateResponse.getSignatureDetailInfo()[0].getTimeStampInfo().getCertificateIssuer()
                      validateResponse.getSignatureDetailInfo()[0].getTimeStampInfo().getCertificateSubject()
                      validateResponse.getSignatureDetailInfo()[0].getTimeStampInfo().getCreationTime()
                      */
                       %>  
                      <c:forEach items="${arraySignatures}" var="infosign" varStatus="index">
                    
                            <td>
                              <h5>Firma ${index.count}</h5>
                              
                              <%--  DADES GENERALS --%>
                              <b>Dades Generals</b> <br/>
                              <ul>
                                 <li>Algorithm: <b>${infosign.algorithm }</b></li>
                                 <li>DigestValue: <b>${infosign.digestValue }</b></li>
                                 <li>PolicyIdentifier: <b>${infosign.policyIdentifier }</b></li>                                 
                              </ul>
                             
                              <%-- INFO TIMESTAMP --%>
                             <c:set var="timestamp" value="${infosign.timeStampInfo}" ></c:set>
                             <c:if test="${ not empty timestamp }">
                             <b>TimeStamp Info</b>
                             <ul>
                                 <li>TS::Algorithm: <b>${timestamp.algorithm }</b></li>
                                 <li>TS::CertificateIssuer: <b>${timestamp.certificateIssuer }</b></li>
                                 <li>TS::CertificateSubject: <b>${timestamp.certificateSubject }</b></li>
                                 <li>TS::CreationTime: <b><fmt:formatDate value="${timestamp.creationTime }" pattern="d-MM-yyyy HH:mm:ss"></fmt:formatDate></b></li>
                             </ul>
                             </c:if>
                              
                              
                              <%--  Informació del certificat --%>
                              <c:set var="infoCert" value="${infosign.certificateInfo}" ></c:set>
                              
 
                            <c:if test="${ not empty infoCert }">
                            <b>CertificateInfo</b> <br/>
                            <ul>
                            
                            <c:if test="${ not empty infoCert.nomResponsable}">
                               <li>nomResponsable:<b> ${ infoCert.nomResponsable}</b></li>
                            </c:if>

                            <c:if test="${ not empty infoCert.primerLlinatgeResponsable}">
                               <li>primerLlinatgeResponsable:<b> ${ infoCert.primerLlinatgeResponsable}</b></li>
                            </c:if>

                            <c:if test="${ not empty infoCert.segonLlinatgeResponsable}">
                               <li>segonLlinatgeResponsable:<b> ${ infoCert.segonLlinatgeResponsable}</b></li>
                            </c:if>

                            <c:if test="${ not empty infoCert.nomCompletResponsable}">
                               <li>nomCompletResponsable:<b> ${ infoCert.nomCompletResponsable}</b></li>
                            </c:if>

                            <c:if test="${ not empty infoCert.llinatgesResponsable}">
                               <li>apellidosResponsable:<b> ${ infoCert.llinatgesResponsable}</b></li>
                            </c:if>
                            
                            
                            <c:if test="${ not empty infoCert.nifResponsable}">
                               <li>nifResponsable:<b> ${ infoCert.nifResponsable}</b></li>
                            </c:if>
                            
                            <c:if test="${ not empty infoCert.subject}">
                               <li>subject:<b> ${ infoCert.subject}</b></li>
                            </c:if>
                            
                            
                            <c:if test="${ not empty infoCert.llocDeFeina}">
                               <li>llocDeFeina:<b> ${ infoCert.llocDeFeina}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.documentRepresentacio}">
                               <li>documentRepresentacio:<b> ${ infoCert.documentRepresentacio}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.email}">
                               <li>email:<b> ${ infoCert.email}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.dataNaixement}">
                               <li>dataNaixement:<b> ${ infoCert.dataNaixement}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.raoSocial}">
                               <li>raoSocial:<b> ${ infoCert.raoSocial}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.pais}">
                               <li>pais:<b> ${ infoCert.pais}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.numeroIdentificacionPersonal}">
                               <li>numeroIdentificacionPersonal:<b> ${ infoCert.numeroIdentificacionPersonal}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.idlogOn}">
                               <li>idlogOn:<b> ${ infoCert.idlogOn}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.idEuropeu}">
                               <li>idEuropeu:<b> ${ infoCert.idEuropeu}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.oiEuropeu}">
                               <li>oiEuropeu:<b> ${ infoCert.oiEuropeu}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.entitatSubscriptoraNom}">
                               <li>entitatSubscriptoraNom:<b> ${ infoCert.entitatSubscriptoraNom}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.entitatSubscriptoraNif}">
                               <li>entitatSubscriptoraNif:<b> ${ infoCert.entitatSubscriptoraNif}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.emissorOrganitzacio}">
                               <li>emissorOrganitzacio:<b> ${ infoCert.emissorOrganitzacio}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.unitatOrganitzativaNifCif}">
                               <li>unitatOrganitzativaNifCif:<b> ${ infoCert.unitatOrganitzativaNifCif}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.unitatOrganitzativa}">
                               <li>unitatOrganitzativa:<b> ${ infoCert.unitatOrganitzativa}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.organitzacio}">
                               <li>organitzacio:<b> ${ infoCert.organitzacio}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.emissorID}">
                               <li>emissorID:<b> ${ infoCert.emissorID}</b></li>
                            </c:if>
                            
                            <c:if test="${ not empty infoCert.nomDomini}">
                               <li>nomDomini:<b> ${ infoCert.nomDomini}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.denominacioSistemaComponent}">
                               <li>denominacioSistemaComponent:<b> ${ infoCert.denominacioSistemaComponent}</b></li>
                            </c:if>
 
                            <c:if test="${ not empty infoCert.tipusCertificat}">
                               <li>tipusCertificat:<b> ${ infoCert.tipusCertificat}</b></li>
                            </c:if>

                            <c:if test="${ not empty infoCert.classificacioEidas}">
                               <li>classificacioEidas:<b> ${ infoCert.classificacioEidas}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.certificatQualificat}">
                               <li>certificatQualificat:<b> ${ infoCert.certificatQualificat}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.creatAmbUnDispositiuSegur}">
                               <li>creatAmbUnDispositiuSegur:<b> ${ infoCert.creatAmbUnDispositiuSegur}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.classificacio}">
                               <li>classificacio:<b> ${ infoCert.classificacio}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.numeroSerie}">
                               <li>numeroSerie:<b> ${ infoCert.numeroSerie}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.usCertificat}">
                               <li>usCertificat:<b> ${ infoCert.usCertificat}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.usCertificatExtensio}">
                               <li>usCertificatExtensio:<b> ${ infoCert.usCertificatExtensio}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.validFins}">
                               <li>validFins:<b> ${ infoCert.validFins}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.validDesDe}">
                               <li>validDesDe:<b> ${ infoCert.validDesDe}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.politica}">
                               <li>politica:<b> ${ infoCert.politica}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.politicaVersio}">
                               <li>politicaVersio:<b> ${ infoCert.politicaVersio}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.politicaID}">
                               <li>politicaID:<b> ${ infoCert.politicaID}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.qcCompliance}">
                               <li>qcCompliance:<b> ${ infoCert.qcCompliance}</b></li>
                            </c:if>
                            <c:if test="${ not empty infoCert.qcSSCD}">
                               <li>qcSSCD:<b> ${ infoCert.qcSSCD}</b></li>
                            </c:if>
                            
                               <li><b> FALTA IMPRIMIR ALTRES VALORS XYZ ZZZ</b></li>

                            </ul>
                              
                            </c:if>

                            </td>                    
                    </c:forEach>
                    </tr>
               </table>
    
            </td>
                
            </tr>
            </c:if>
    </table>
    

   
    <a href="<c:url value="/" />" class="btn"><fmt:message key="tornar"/></a>
   
</div>

<%@ include file="/WEB-INF/views/html_footer.jsp"%>