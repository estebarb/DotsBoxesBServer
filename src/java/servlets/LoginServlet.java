/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import cus.Autenticar.Autenticar;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Esteban
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aquí debemos registrar el usuario, SIEMPRE Y CUANDO
        // NO haya otro usuario registrado con el mismo correo
        // electrónico.
        HttpSession session = request.getSession(true);
        Autenticar autenticador = new Autenticar();

        // Lee los argumentos
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Verifica que la contraseña repetida esté igual
        try {
            // Se puede proceder a crear el usuario
            Long idAsignado = autenticador.AutenticarUsuario(email, password);
            if (idAsignado != null) {
                // Inicializa la sesión
                session.setAttribute("user", idAsignado.toString());
                session.setAttribute("token", autenticador.GenerateSessionHash(idAsignado.toString(), session.getId()));
                response.sendRedirect(request.getContextPath());
            } else {
                response.sendRedirect(request.getContextPath() + "/start.jsp?retry=badpass");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, "Problemas SQL al registrarse", ex);
            response.sendRedirect(request.getContextPath() + "/bsod.jsp");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, "Al parecer no tenemos SHA-1", ex);
            response.sendRedirect(request.getContextPath() + "/bsod.jsp");
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
