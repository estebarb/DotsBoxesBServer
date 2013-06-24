package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo
 */
@WebServlet(name = "CrearTorneo", urlPatterns = {"/CrearTorneo"})
public class CrearTorneo extends HttpServlet {
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
    private FuenteProyecto.Conexion conexion = new FuenteProyecto.Conexion();
   
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
        request.getRequestDispatcher("CrearTorneo.jsp").forward(request, response);
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
        String nombre = request.getParameter("usuario");
        String nombTorneo = request.getParameter("nombTorneo");
        String numJug = request.getParameter("numJug");
        String tipoTorneo = request.getParameter("tipoTorneo");
        if(request.getParameter("botonSubmit")!=null){
            boolean success = false;
            boolean userValid = false;
            //String ip = request.getRemoteAddr();
            ArrayList<ArrayList<String>> consulta;
            boolean torneoEq = false;
            if(!nombre.equals("")){
                consulta = conexion.consultaGetArrayList("select * from usuarios where username='" + nombre+"'");
                if(!consulta.isEmpty()){
                    userValid = true;
                    consulta = conexion.consultaGetArrayList("select * from torneo where admin='" + nombre+"'");
                    if(!nombTorneo.equals("")){
                        for(int i = 0; i < consulta.size() && !torneoEq; i++){
                            if(consulta.get(i).get(2).equals(nombTorneo)){
                                torneoEq = true;
                            }
                        }
                        if(!torneoEq){
                            if(conexion.consulta("insert into torneo (admin, nombreTorneo, numJug, tipoTorneo) values('"+nombre+"','"+ nombTorneo +"',"+numJug+",'"+tipoTorneo+"');")){
                                consulta = conexion.consultaGetArrayList("select * from torneo where admin = '"+nombre+"'");
                                success = true;
                            }
                        }
                    }
                }
            }
            request.getRequestDispatcher("CrearTorneo.jsp?valido=" + success+"&user="+nombre+"&nomTor="+nombTorneo+"&torEq="+torneoEq+"&userValid="+userValid+"&numJug="+numJug+"&tipoTorneo="+tipoTorneo).forward(request, response);  
        }else{
            response.sendRedirect("InvitarATorneo?usuario="+nombre+"&nombTorneo="+nombTorneo+"&numJug="+numJug);
        }
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
