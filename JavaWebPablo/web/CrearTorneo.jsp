<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <title name="titulo">Ingrese los datos para el torneo</title>  
        <link type ="text/css" rel="stylesheet" href="css/bootstrap.css"> 
       
        <script type="text/javascript" src="js/bootstrap.js"></script>
        
    </head>
    
    <body class ="well">
            
        <form name="form1" class ="well" action="CrearTorneo" method="post">
            <br>
            <c:choose>
                <c:when test="${param.valido == true}">
                    Nombre : <input type="text" class="span3" name="usuarioDis"  value="${param.user}" disabled>
                    <input type="hidden" value="${param.user}" name="usuario" />
                    <br><br>
                    Nombre del torneo : <input type="text" class="span3" name="nombTorneoDis" value="${param.nomTor} " disabled>
                    <input type="hidden" value="${param.nomTor}" name="nombTorneo" />
                    <br><br>
                </c:when>
                <c:when test="${param.valido == false}">
                    <c:choose>
                        <c:when test="${param.user == ''}">
                            Nombre : <input type="text" class="span3" name="usuario" placeholder="Ingrese el nombre de usuario..." >
                            <br><br>
                            Nombre del torneo : <input type="text" class="span3" name="nombTorneo" placeholder="Ingrese el nombre del torneo...">
                            <br><br>
                            Error: Usuario vacio
                            <br>
                            <c:if test="${param.nomTor == ''}">
                                Error: Torneo vacio
                                <br>
                            </c:if> 
                            <br>
                        </c:when>
                        <c:when test="${param.userValid == false}">
                            Nombre : <input type="text" class="span3" name="usuario" placeholder="Ingrese el nombre de usuario..." >
                            <br><br>
                            Nombre del torneo : <input type="text" class="span3" name="nombTorneo" placeholder="Ingrese el nombre del torneo...">
                            <br><br>
                            Error: Usuario invalido
                            <br>
                            <c:choose>
                                <c:when test="${param.nomTor == ''}">
                                    Error: Torneo vacio
                                    <br>
                                </c:when>
                                <c:when test="${param.torEq == ''}">
                                    Error: Nombre de torneo ya registrado para este usuario.
                                    <br>
                                </c:when>
                            </c:choose>
                            <br>
                        </c:when>
                        <c:when test="${param.userValid == true}">
                            Nombre : <input type="text" class="span3" name="usuario" value="${param.user}" >
                            <br><br>
                            Nombre del torneo : <input type="text" class="span3" name="nombTorneo" placeholder="Ingrese el nombre del torneo...">
                            <br><br>
                            <c:choose>
                                <c:when test="${param.nomTor == ''}">
                                    Error: Torneo vacio
                                    <br>
                                </c:when>
                                <c:when test="${param.torEq == true}">
                                    Error: Nombre de torneo ya registrado para este usuario.
                                    <br>
                                </c:when>
                            </c:choose>
                            <br>
                        </c:when>
                        <c:otherwise>
                            =S<br>
                        </c:otherwise>            
                    </c:choose>
                </c:when>
                <c:otherwise>
                    Nombre : <input type="text" class="span3" name="usuario" placeholder="Ingrese el nombre de usuario..." >
                    <br><br>
                    Nombre del torneo : <input type="text" class="span3" name="nombTorneo" placeholder="Ingrese el nombre del torneo...">
                    <br><br>
                </c:otherwise>            
            </c:choose>
 
            <c:choose>
            <c:when test="${param.valido == true}">
                Numero de jugadores: 
                <select name="numJugDis" disabled>
                    <option value="${param.numJug}">${param.numJug}</option>
                </select>
                <br><br>
                Tipo de torneo:
                <select name="tipoTorneoDis" disabled="">
                    <option value="${param.tipoTorneo}">${param.tipoTorneo}</option>
                </select>
                <br><br>
                Torneo Creado!<br><br>
                <input type="hidden" value="${param.numJug}" name="numJug" />
                <input type="hidden" value="${param.tipoTorneo}" name="tipoTorneo" />
                <button name="botonSubmit" class="btn btn-primary" type="submit" disabled>Crear Torneo!</button>
                <button name="botonInvitar" class="btn btn-primary" type="submit">Invitar amigos!</button><br><br>
            </c:when>
            <c:when test="${param.valido == false}">
                Numero de jugadores: 
                <select name="numJug">
                    <option value="8">8</option>
                    <option value="16">16</option>  
                    <option value="32">32</option>  
                </select>
                <br><br>
                Tipo de torneo:
                <select name="tipoTorneo">
                    <option value="Llaves">Llaves</option>
                    <option value="Grupos">Grupos</option>  
                </select>
                <br><br>
                <button name="botonSubmit" class="btn btn-primary" type="submit">Crear Torneo!</button>
                <button name="botonBorrar" class="btn" type="reset">Borrar</button><br><br>
                <button name="botonInvitar" class="btn btn-primary" type="submit" disabled>Invitar amigos!</button><br><br>
            </c:when>
            <c:otherwise>
                Numero de jugadores: 
                <select name="numJug">
                    <option value="8">8</option>
                    <option value="16">16</option>  
                    <option value="32">32</option>  
                </select>
                <br><br>
                Tipo de torneo:
                <select name="tipoTorneo">
                    <option value="Llaves">Llaves</option>
                    <option value="Grupos">Grupos</option>  
                </select>
                <br><br>
                <button name="botonSubmit" class="btn btn-primary" type="submit">Crear Torneo!</button>
                <button name="botonBorrar" class="btn" type="reset">Borrar</button><br><br>
                <button name="botonInvitar" class="btn btn-primary" type="submit" disabled>Invitar amigos!</button><br><br>
            </c:otherwise>            
            </c:choose>
        </form>
       
    </body>
</html>
