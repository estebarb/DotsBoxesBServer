<%-- 
    Document   : hello
    Created on : 22/06/2013, 12:04:43 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" ng-app="myApp">
    <head>
        <meta charset="utf-8">
        <title>Dots & Boxes</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="app/css/app.css"/>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.min.css"/>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootswatch/2.3.2/cosmo/bootstrap.min.css"/>
    </head>
    <body>
        <h1>Bienvenidos a Dots & Boxes</h1>
        <a class="btn btn-primary btn-large">Iniciar Sesión</a>
        <a class="btn btn-success btn-large">Registrarse</a>

        <div ng-view></div>

        <div>Angular seed app: v<span app-version></span></div>

        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
        <script src="app/js/app.js"></script>
        <script src="app/js/services.js"></script>
        <script src="app/js/controllers.js"></script>
        <script src="app/js/filters.js"></script>
        <script src="app/js/directives.js"></script>
    </body>
</html>