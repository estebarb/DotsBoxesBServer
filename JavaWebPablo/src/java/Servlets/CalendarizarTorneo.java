/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "CalendarizarTorneo", urlPatterns = {"/CalendarizarTorneo"})
public class CalendarizarTorneo extends HttpServlet {

    private FuenteProyecto.Conexion conexion = new FuenteProyecto.Conexion();
    private int numeroEncuentros;
    
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
        numeroEncuentros = 0;
        int numTorneo = Integer.parseInt(request.getParameter("nmTr"));
        request.setAttribute("nmTr", numTorneo);
        ArrayList<ArrayList<String>> listaInscritos = conexion.consultaGetArrayList("select username from registradoEn where idTorneo="+numTorneo);
        request.setAttribute("inscritos", listaInscritos);
        request.getRequestDispatcher("CalendarizarTorneo.jsp").forward(request, response);
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
        if(request.getParameter("guardarJuego")!= null){
            String contrincante1 = request.getParameter("inscritos1");
            String contrincante2 = request.getParameter("inscritos2");
            String fecha = request.getParameter("fecha");
            String numTorneo = request.getParameter("nmTr");
            if(!contrincante1.equals(contrincante2)){
                if(checkFecha(fecha)){
                    boolean exito = conexion.consulta("insert into encuentrosTorneos (jugador1, jugador2, idTorneo, fecha) values('"+contrincante1+"', '"+contrincante2+"', "+numTorneo+", '"+fecha+"');");
                    if(exito){
                        numeroEncuentros++;
                        if(numeroEncuentros< 10){
                            ArrayList<ArrayList<String>> listaInscritos = conexion.consultaGetArrayList("select username from registradoEn where idTorneo="+numTorneo);
                            request.setAttribute("inscritos", listaInscritos);
                            request.setAttribute("nmTr", numTorneo);
                            request.getRequestDispatcher("CalendarizarTorneo.jsp?add=true").forward(request, response);      
                        }else{
                            ArrayList<ArrayList<String>> listaInscritos = conexion.consultaGetArrayList("select username from registradoEn where idTorneo="+numTorneo);
                            request.setAttribute("inscritos", listaInscritos);
                            request.setAttribute("nmTr", numTorneo);
                            request.getRequestDispatcher("CalendarizarTorneo.jsp?todList=true&add=true").forward(request, response);     
                        }
                    }else{
                        ArrayList<ArrayList<String>> listaInscritos = conexion.consultaGetArrayList("select username from registradoEn where idTorneo="+numTorneo);
                        request.setAttribute("inscritos", listaInscritos);
                        request.setAttribute("nmTr", numTorneo);
                        request.getRequestDispatcher("CalendarizarTorneo.jsp?add=false").forward(request, response); 
                    }
                }else{
                    ArrayList<ArrayList<String>> listaInscritos = conexion.consultaGetArrayList("select username from registradoEn where idTorneo="+numTorneo);
                    request.setAttribute("inscritos", listaInscritos);
                    request.setAttribute("nmTr", numTorneo);
                    request.getRequestDispatcher("CalendarizarTorneo.jsp?add=false&fecInvalid=true").forward(request, response); 
                }
            }else{
                if(!checkFecha(fecha)){
                    ArrayList<ArrayList<String>> listaInscritos = conexion.consultaGetArrayList("select username from registradoEn where idTorneo="+numTorneo);
                    request.setAttribute("inscritos", listaInscritos);
                    request.setAttribute("nmTr", numTorneo);
                    request.getRequestDispatcher("CalendarizarTorneo.jsp?add=false&contr=true&fecInvalid=true").forward(request, response); 
                }else{
                    ArrayList<ArrayList<String>> listaInscritos = conexion.consultaGetArrayList("select username from registradoEn where idTorneo="+numTorneo);
                    request.setAttribute("inscritos", listaInscritos);
                    request.setAttribute("nmTr", numTorneo);
                    request.getRequestDispatcher("CalendarizarTorneo.jsp?add=false&contr=true").forward(request, response); 
                }  
            }
        }else{
            if(request.getParameter("iniciarTorneo")!= null){
                response.sendRedirect("IniciarTorneo");
            }else{
                //Aca va auto calend
            }
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
    
    private boolean checkFecha(String fecha){
        boolean correcta = true;
        if(fecha.length()!=0 && fecha.length()==10){
            for(int i = 0; i < 10 && correcta; i++){
                if(i==4||i==7){
                    if(fecha.charAt(i)!='-'){
                        correcta = false;
                    }
                }else{
                    if(!checkNumero(fecha.charAt(i))){
                        correcta = false;
                    }
                }
            }
        }else{
            correcta = false;
        }
        return correcta;
    }
    
    private boolean checkNumero(char car){
        boolean correcta = false;
        char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        for(int i = 0; i < 10 && !correcta; i++){
            if(nums[i] == car){
                correcta=true;
            }
        }
        return correcta;
    }
}
