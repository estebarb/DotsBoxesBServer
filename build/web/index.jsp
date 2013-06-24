<%@page import="java.util.List"%>
<%@page import="entities.Pendientes"%>
<%@page import="service.service.UsuariosFacadeREST"%>
<%@page import="utils.EMF"%>
<%@page import="javax.persistence.EntityManager"%>
<%
    Long id = Long.parseLong((String) request.getSession().getAttribute("user"));
    UsuariosFacadeREST usrFacade = new UsuariosFacadeREST();
    entities.Usuarios user = usrFacade.find(id);
/*
    EntityManager em = EMF.createEntityManager();
    List<Pendientes> pendientes = em.createQuery("SELECT p FROM Pendientes p WHERE p.jugador = :jugador")
            .setParameter("jugador", id)
            .getResultList(); */
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Dots & Boxes</title>
        <%@include file="app/partials/header.jspf" %>
    </head>
    <body>

        <!-- Si no ha iniciado sesión -->
        <div class="container">
            <%@include file="app/partials/menu.jspf" %>

            <div class="row">
                <div class="span12">
                    <h1><%= user.getNombre()%></h1>
                </div>
            </div>
            <div class="row">
                <div class="span4">
                    <h2>Juegos pendientes (<%--= pendientes.size()--%>):</h2>
                    <ul>
                        <%--
                            for (Pendientes p : pendientes) {
                                out.println("<li>" + p.getJuego().getFecha() + "</li>");
                            }
                        --%>
                    </ul>
                </div>
            </div>
        </div>

        <input type="hidden" value="<%= request.getSession().getAttribute("user")%>"/>
        <%@include file="app/partials/footer.jspf" %>        
    </body>
</html>