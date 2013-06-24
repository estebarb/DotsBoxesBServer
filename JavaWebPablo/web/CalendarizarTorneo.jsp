<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Ingrese los datos para calendarizar el torneo</title>  
        <link type ="text/css" rel="stylesheet" href="css/bootstrap.css"> 
        
        <link href="css/bootstrap-combined.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap-datetimepicker.min.css">
        
        <script type="text/javascript" src="js/bootstrap.js"></script>
        
        <script type="text/javascript"src="js/jquery.min.js"></script> 
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
        
    </head>
    <h3>Seleccione el juego y la fecha en la cual desea colocarlo</h3>
    <body class="well">
        
        <form name="form1" class="well" action="CalendarizarTorneo" method="post">   
            <select name="inscritos1">
                <c:forEach items="${inscritos}" var="inscrito" >
                    <option value="${inscrito[0]}">${inscrito[0]}</option>
                </c:forEach>
            </select>
            <select name="inscritos2">
                <c:forEach items="${inscritos}" var="inscrito" >
                    <option value="${inscrito[0]}">${inscrito[0]}</option>
                </c:forEach>
            </select>
            <br>
            <input type="hidden" value="${nmTr}" name="nmTr" />
            <div id="datetimepicker" class="input-append">
                <input data-format="yyyy-MM-dd" name ="fecha" type="text" placeholder="AAAA-MM-DD"></input>
                <span class="add-on">
                    <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                </span>
            </div>
            <br><br>     
            <c:if test="${param.add == true}">
                Agregado correctamente!<br>
                <c:if test="${param.todList == true}">
                    Todos los encuentros calendarizados!<br>
                </c:if>
            </c:if>
            <c:if test="${param.add == false}">
                No se logro agregar!<br>
                <c:if test="${param.fecInvalid == true}">
                    Fecha vacia!<br>
                </c:if>
                <c:if test="${param.contr == true}">
                    Contrincantes iguales!<br>
                </c:if>
            </c:if>
            <br><br>
            <c:choose>
                <c:when test="${param.todList == false}">
                    <button name="guardarJuego" class="btn btn-primary" type="submit" >Guardar juego</button><br><br>
                    <button name="iniciarTorneo" class="btn btn-primary" type="submit" disabled>Iniciar torneo</button><br><br>
                    <button name="calendAuto" class="btn" type="submit" disabled>Calendarizar automatico</button> (no implementado aun) <br><br>
                </c:when>
                <c:when test="${param.todList == true}">
                    <button name="guardarJuego" class="btn btn-primary" type="submit" disabled>Guardar juego</button><br><br>
                    <button name="iniciarTorneo" class="btn btn-primary" type="submit" >Iniciar torneo</button><br><br>
                    <button name="calendAuto" class="btn" type="submit" disabled>Calendarizar automatico</button> (no implementado aun) <br><br>
                </c:when>
                <c:otherwise>
                    <button name="guardarJuego" class="btn btn-primary" type="submit" >Guardar juego</button><br><br>
                    <button name="iniciarTorneo" class="btn btn-primary" type="submit" disabled>Iniciar torneo</button><br><br>
                    <button name="calendAuto" class="btn" type="submit" disabled>Calendarizar automatico</button> (no implementado aun) <br><br>
                </c:otherwise>
            </c:choose>
        </form>
        <script type="text/javascript">
            $(function() {
                $('#datetimepicker').datetimepicker({
                    pickTime: false
                });
            });
        </script>
        
    </body>
</html>
