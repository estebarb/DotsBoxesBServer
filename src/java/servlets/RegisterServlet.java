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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Esteban
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Aquí debemos registrar el usuario, SIEMPRE Y CUANDO
        // NO haya otro usuario registrado con el mismo correo
        // electrónico.        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        Autenticar autenticador = new Autenticar();

        // Lee los argumentos
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");

        // Verifica que la contraseña repetida esté igual
        if (!pass1.equals(pass2)) {
            res.sendRedirect(request.getContextPath() + "/start.jsp?retry=badpass");
        } else {
            try {
                // Se puede proceder a crear el usuario
                boolean valido = autenticador.createUser(email, name, pass2);
                Long idAsignado = autenticador.getUserFromMail(email);
                valido &= (idAsignado != null);
                if (valido) {
                    // Inicializa la sesión
                    session.setAttribute("user", idAsignado.toString());
                    session.setAttribute("token", autenticador.GenerateSessionHash(idAsignado.toString(), session.getId()));
                    res.sendRedirect(request.getContextPath());
                } else {
                    res.sendRedirect(request.getContextPath() + "/start.jsp?retry=badpass");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, "Problemas SQL al registrarse", ex);
                res.sendRedirect(request.getContextPath() + "/bsod.jsp");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, "Al parecer no tenemos SHA-1", ex);
                res.sendRedirect(request.getContextPath() + "/bsod.jsp");
            }
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
