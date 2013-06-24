/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo
 */
@WebServlet(name = "InvitarATorneo", urlPatterns = {"/InvitarATorneo"})
public class InvitarATorneo extends HttpServlet {

    private FuenteProyecto.Conexion conexion = new FuenteProyecto.Conexion();
    private ArrayList<String> inscritos = new ArrayList<String>();
    
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
        String nombre = request.getParameter("usuario");
        String nomTorneo = request.getParameter("nombTorneo");
        int numJug = Integer.parseInt(request.getParameter("numJug"));
        ArrayList<ArrayList<String>> listaAmigos = conexion.consultaGetArrayList("select amigo2 from sonamigos where amigo1='"+nombre+"'");
        //String[] listaAmigos ={nombre, nomTorneo};
        request.setAttribute("usuario", nombre);
        request.setAttribute("nombTorneo", nomTorneo);
        request.setAttribute("listaAmigos", listaAmigos);
        request.setAttribute("numJug", numJug);
        request.setAttribute("inscritos", inscritos);
        if(!listaAmigos.isEmpty()){
            request.getRequestDispatcher("InvitarATorneo.jsp?amigos=true").forward(request, response);
        }else{
            request.getRequestDispatcher("InvitarATorneo.jsp?amigos=false").forward(request, response);
        }
        
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
            String amigo = request.getParameter("amigosCB");
            int numJug = Integer.parseInt(request.getParameter("numJug"));
            ArrayList<ArrayList<String>> listaAmigos = conexion.consultaGetArrayList("select amigo2 from sonamigos where amigo1='"+nombre+"'");
            request.setAttribute("usuario", nombre);
            request.setAttribute("nombTorneo", nombTorneo);
            request.setAttribute("listaAmigos", listaAmigos);
            request.setAttribute("numJug", numJug);
            ArrayList<ArrayList<String>> numTorneo = conexion.consultaGetArrayList("select idTorneo from torneo where admin='"+nombre+"' and nombreTorneo='"+nombTorneo+"'");
        if(request.getParameter("botonAgregar") != null){     
            boolean insercion = conexion.consulta("insert into registradoEn values('"+amigo+"', "+numTorneo.get(0).get(0) +")");
            if(insercion){     
                inscritos.add(amigo);
                if(inscritos.size()<numJug){
                    request.setAttribute("inscritos", inscritos);
                    request.getRequestDispatcher("InvitarATorneo.jsp?amigos=true&success="+insercion+"&insc="+amigo).forward(request, response);      
                }else{
                    request.setAttribute("inscritos", inscritos);
                    request.getRequestDispatcher("InvitarATorneo.jsp?amigos=true&success="+insercion+"&insc="+amigo+"&lleno=true").forward(request, response);
                }
            }else{
                request.setAttribute("inscritos", inscritos);
                request.getRequestDispatcher("InvitarATorneo.jsp?amigos=true&success="+insercion+"&insc="+amigo).forward(request, response);
            }
        }else{
            response.sendRedirect("CalendarizarTorneo?usuario="+nombre+"&nombTorneo="+nombTorneo+"&numJug="+numJug+"&nmTr="+numTorneo.get(0).get(0));     
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
