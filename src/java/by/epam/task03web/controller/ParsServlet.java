package by.epam.task03web.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ValidatingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Helena.Grouk
 */
public class ParsServlet extends HttpServlet {
    static final String LOG_PROPERTIES_FILE = "Log4J.properties";
    static {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }
    public static Logger localLog = Logger.getLogger("localLoger");

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
 
        Map<String, String> errors = new HashMap<>();
        try {
            
            RespParse resp = new RespParse(request, response);
            resp.getResponse();
            request.getRequestDispatcher("result.jsp").forward(request, response);
            
        } catch (NullInitException ex) {
            String msg = ex.getMessage();
            errors.put("parser", ex.getMessage());
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ValidatingException ex) {
            String msg = ex.getMessage();
            errors.put("parsername", ex.getMessage());
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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

}
