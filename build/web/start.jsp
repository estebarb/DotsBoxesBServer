<%-- 
    Document   : login
    Created on : 22/06/2013, 09:04:00 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dots & Boxes</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.min.css"/>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootswatch/2.3.2/cosmo/bootstrap.min.css"/>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="hero-unit">
                <h1>Bienvenidos a Dots & Boxes</h1>
                <p>Este es un divertido juego para dos o más jugadores, donde
                    gana quien completa más cuadrados.</p>
            </div>
            <% // En este caso vamos a mostrar un error al usuario, 
                // en caso de que antes estuviera logueado y ahora no.
                // (o nos intentara engañar)
                if (request.getParameter("retry") != null && request.getParameter("retry").equals("true")) {
                    out.println("<div class='row'>");
                    out.println("<div class='span12'>");
                    out.println("<div class='alert alert-error'>");
                    out.println("<button type='button' class='close' data-dismiss='alert'>&times;</button>");
                    out.println("<h2>:-( Hubo problemas con su sesión</h2>");
                    out.println("Vuelva a iniciar sesión en Dots & Boxes, o, si no tiene cuenta, cree una. ¡Se divertirá muchísimo!");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                } else if(request.getParameter("retry") != null && request.getParameter("retry").equals("badpass")){
                    out.println("<div class='row'>");
                    out.println("<div class='span12'>");
                    out.println("<div class='alert alert-warning'>");
                    out.println("<button type='button' class='close' data-dismiss='alert'>&times;</button>");
                    out.println("<h2>No se pudo crear su cuenta</h2>");
                    out.println("Por favor verifique:");
                    out.println("<ol>");
                    out.println("<li>Su correo electrónico esté correcto y no lo haga registrado antes.</li>");
                    out.println("<li>Ambas contraseñas coincidan.</li>");
                    out.println("</ol>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                } else {
                    out.println("<div class='row'>");
                    out.println("<div class='span12'>");
                    out.println("<div class='alert alert-info'>");
                    out.println("<button type='button' class='close' data-dismiss='alert'>&times;</button>");
                    out.println("<h2>¡Hola!</h2>");
                    out.println("Inicie sesión o cree una cuenta nueva para comenzar a jugar");

                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                }
            %>
            <div class="row">
                <div class="span6">
                    <h1>Iniciar sesión</h1>
                    <form method="post" action="/login" class="form-horizontal">
                        <div class="control-group">
                            <label class="control-group" for="login-inputMail">Correo electrónico</label>
                            <input type="text" id="login-inputMail" placeholder="Su correo electrónico" name="email">
                        </div>
                        <div class="control-group">
                            <label class="control-group" for="login-inputPassword">Contraseña:</label>
                            <input type="password" id="login-inputPassword" placeholder="Contraseña" name="password">
                        </div>
                        <button class="btn btn-primary btn-large" type="submit">Iniciar Sesión</button>
                    </form>
                </div>
                <div class="span6">
                    <h1>Registrarse</h1>
                    <form method="post" action="/register" class="form-horizontal">
                        <div class="control-group">
                            <label class="control-group" for="reg-inputMail">Correo electrónico</label>
                            <input type="text" id="reg-inputMail" placeholder="Su correo electrónico" name="email">
                        </div>
                        <div class="control-group">
                            <label class="control-group" for="reg-inputName">Nombre:</label>
                            <input type="text" id="reg-inputName" placeholder="Su nombre" name="name">
                        </div>
                        <div class="control-group">
                            <label class="control-group" for="reg-inputPassword">Contraseña:</label>
                            <input type="password" id="reg-inputPassword" placeholder="Su contraseña" name="password1">
                        </div>
                        <div class="control-group">
                            <label class="control-group" for="reg-inputPassword2">Repita la contraseña:</label>
                            <input type="password" id="reg-inputPassword2" placeholder="Repita su contraseña" name="password2">
                        </div>
                        <button class="btn btn-success btn-large" type="submit">Registrarse</button>
                    </form>
                </div>
            </div>
            <div class="footer">
                <p class="muted credit">
                    &copy; Proyecto de Ingenier&iacute;a de Software 2012-2013 | <a
                        href="http://stats.pingdom.com/qikt2b86ybuv/868786">Estado del
                        sistema</a>
                </p>
            </div>
        </div>
    </body>
</html>
