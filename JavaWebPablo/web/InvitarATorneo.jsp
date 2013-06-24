<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <title name="titulo">Invite a los amigos que desea en el torneo</title>  
        <link type ="text/css" rel="stylesheet" href="css/bootstrap.css"> 
       
        <script type="text/javascript" src="js/bootstrap.js"></script> 
          
        <script>
            function llenarComboBox(AProbar){
                var a = AProbar;
                var b = ${inscritos};
                for (var i=0;i<b.length;i++){
                    document.write(i);
                }
            }
        </script>
    </head>
    
    <body class ="well" action="InvitarATorneo" method="post">
                    
        <form name="form1" class ="well" action="InvitarATorneo" method="post">
                
            Nombre : <label name="lblUsuario">${usuario}</label>
            <input type="hidden" name="usuario" value="${usuario}">
            Torneo : <label name="lblTorneo">${nombTorneo}</label>
            <input type="hidden" value="${nombTorneo}" name="nombTorneo" />
            Num Jug : <label name="lblNumJug">${numJug}</label>
            <input type="hidden" value="${numJug}" name="numJug" />
            <c:choose>
                <c:when test="${param.amigos == true}">
                    Seleccione los amigos que desea invitar al torneo:<br><br>
                    <c:if test="${param.success == false}">
                        El amigo ya se encuentra inscrito<br>
                    </c:if>
                    <c:if test="${param.success == true}">
                        ${param.insc} inscrito correctamente<br>
                    </c:if>
                    <br>
                    <select name="amigosCB">
                        <c:forEach items="${listaAmigos}" var="option">
                            <option value="${option[0]}">${option[0]}</option>
                        </c:forEach>
                    </select>
                    <br><br>
                </c:when>
                <c:when test="${param.amigos == false}">
                    No tiene amigos!!<br>
                </c:when>
                <c:otherwise>
                    ES ODERWAIS!!!QQ
                </c:otherwise>
            </c:choose>
            <br>
            <c:choose>
                <c:when test="${param.lleno == true}">
                    <button name="botonAgregar" class="btn btn-primary" type="submit" disabled>Agregar amigo!</button>
                    <button name="botonDesinvi" class="btn" type="button">Desinvitar amigo!</button>
                    <button name="botonCalendarizar" class="btn btn-primary" type="submit">Calendarizar!</button>
                </c:when>
                <c:when test="${param.lleno == false}">
                    <button name="botonAgregar" class="btn btn-primary" type="submit">Agregar amigo!</button>
                    <button name="botonDesinvi" class="btn" type="button">Desinvitar amigo!</button>
                    <button name="botonCalendarizar" class="btn btn-primary" type="submit" disabled>Calendarizar!</button>
                </c:when>
                <c:otherwise>
                    <button name="botonAgregar" class="btn btn-primary" type="submit">Agregar amigo!</button>
                    <button name="botonDesinvi" class="btn" type="button">Desinvitar amigo!</button>
                    <button name="botonCalendarizar" class="btn btn-primary" type="submit" disabled>Calendarizar!</button>
                </c:otherwise>
            </c:choose>
            
            <br>
        </form>
       
    </body>
</html>
