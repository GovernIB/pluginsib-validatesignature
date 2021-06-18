<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pàgina de validació</title>
</head>
<body>    
    <h1>Pàgina de validació</h1>
    <c:url value="/validate" var="formAction" />
    <form id="signForm" method="post" action="${formAction}" enctype="multipart/form-data">
        <p>
            <label id="fileLabel" for="fitxer">Fitxer a validar:</label>
            <input type="file" name="fitxer">
        </p>
        <p>
            <label id="pluginNameLabel" for="pluginName">Plugin de validació:</label>
            <select name="pluginName">
                <c:forEach items="${pluginMapBean.pluginNames}" var="pluginName">
                    <option label="${pluginName}" value="${pluginName}">
                </c:forEach>
            </select>
        </p>
        
        <input type="submit" value="Enviar">        
    </form>
</body>
</html>