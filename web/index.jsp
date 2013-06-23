<%-- 
    Document   : hello
    Created on : 22/06/2013, 12:04:43 PM
    Author     : Esteban
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" ng-app="myApp">
    <head>
        <meta charset="utf-8">
        <title>Dots & Boxes</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.min.css"/>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootswatch/2.3.2/cosmo/bootstrap.min.css"/>
        <link rel="stylesheet" href="app/css/app.css"/>
    </head>
    <body>

        <!-- Si no ha iniciado sesión -->
        <div class="container">
            <div ng-switch="userID">
                <div ng-switch-when="null">
                    <div ng-include="'/app/partials/notlogged.html'">
                </div>
            </div>
            
            <div class="row">
                <div class="span12">
                    <div ng-view></div>
                </div>
            </div>
        </div>

        <input type="hidden" ng-model="userID" value="<%= request.getSession().getAttribute("userID")%>"/>

        <div class="footer container">
            <p class="muted credit">
                &copy; Proyecto de Ingenier&iacute;a de Software 2012-2013 | <a
                    href="http://stats.pingdom.com/qikt2b86ybuv/868786">Estado del
                    sistema</a> | Versión <span app-version></span>
            </p>
        </div>

        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
        <script src="app/js/app.js"></script>
        <script src="app/js/services.js"></script>
        <script src="app/js/controllers.js"></script>
        <script src="app/js/filters.js"></script>
        <script src="app/js/directives.js"></script>
    </body>
</html>