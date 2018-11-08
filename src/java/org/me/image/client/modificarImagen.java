package org.me.image.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.lang.Object; 
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;
import org.me.image.ImageWS_Service;

/**
 *
 * @author adri
 */
@WebServlet(name = "modificarImagen", urlPatterns = {"/modificarImagen"})
@MultipartConfig
public class modificarImagen extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebApplicationUltraSophisticated/imageWS.wsdl")
    private ImageWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        
        HttpSession session = request.getSession();        
        if(session.getAttribute("user")==null) response.sendRedirect("login.jsp");
        try {
            /* TODO output your page here. You may use following sample code. */
         
            //agafem els parametres introduits al formulari més l'id de la imatge
            int id= Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titol");
            String ddata = request.getParameter("data_creacio");
            String pclau = request.getParameter("paraulesclau");
            String autor = request.getParameter("author");
            
            
            System.out.println(id+titulo+autor+pclau+ddata);
            //modifiquem els camps de la imatge a la DB    
            modifyImage(id,titulo,autor,pclau,ddata);
          
  
            
            
               out.println("<html><body><link rel='stylesheet' href='css/styles.css'>"
                                + "<h2>L'imatge s'ha modificat satisfactoriament</h2> "
                                + "<br>"
                                + "<a href='menu.jsp'>Tornar al menu</a>"
                                + "<br>"
                                + "</body></html>");
        }
        catch(java.lang.IllegalStateException e) {
            System.err.println(e.getMessage());
            response.sendRedirect("menu.jsp");
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

    private int modifyImage(java.lang.Integer idImag, java.lang.String titulo, java.lang.String author, java.lang.String paraulaclau, java.lang.String fecha) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.me.image.ImageWS port = service.getImageWSPort();
        return port.modifyImage(titulo,author,paraulaclau,fecha);
    }

}
