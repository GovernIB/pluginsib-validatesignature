<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="validateResponse" scope="request" type="org.fundaciobit.plugins.validatesignature.api.ValidateSignatureResponse" />
<!DOCTYPE html>
<html>
<head>
    <title>Pàgina de resultat</title>
</head>
<body>    
    <h1>Pàgina de resultat</h1>

    <span id="status"><c:out value="${validateResponse.validationStatus.status}" /></span>
    <span id="errorMsg"><c:out value="${validateResponse.validationStatus.errorMsg}" /></span>       
    <ol>
        <c:forEach var="detail" items="${validateResponse.signatureDetailInfo}">
            <li>${detail.certificateInfo.nomCompletResponsable}</li>       
        </c:forEach>
    </ol>
</body>
</html>