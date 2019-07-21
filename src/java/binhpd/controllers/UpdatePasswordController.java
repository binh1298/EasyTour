/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import binhpd.daos.AccountDAO;
import binhpd.utils.BinhPDUltilities;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class UpdatePasswordController extends HttpServlet
{
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "aboutPassword.jsp";
    private static final String SUCCESS = "PersonalInfoController";
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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try
        {
            String username = (String)request.getSession().getAttribute("USERNAME");
            String password = request.getParameter("password");
            String cfpassword = request.getParameter("cfPassword");
            if(password.equals(cfpassword) && BinhPDUltilities.isInRange(6, 50, password))
            {
                AccountDAO dao = new AccountDAO();
                if(dao.updatePassword(username, password))
                {
                    request.setAttribute("SUCCESS", "Update password successfully!");
                    url = SUCCESS;
                } else
                {
                    url = INVALID;
                    request.setAttribute("INVALID", "Sorry we could not change your password");
                }
            } else
            {
                url = INVALID;
                request.setAttribute("INVALID", "Password and confirm password has to match and has to be between 6 and 50 characters!");
            }
        } catch (Exception e)
        {
            log("ERROR at UpdatePasswordController: " + e.getMessage());
        } finally
        {
            request.getRequestDispatcher(url).forward(request, response);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
