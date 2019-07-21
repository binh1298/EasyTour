/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import binhpd.daos.AccountDAO;
import binhpd.dtos.AccountDTO;
import binhpd.dtos.CartObj;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class LoginController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "login.jsp";
    private static final String ADMIN = "ManageTourController";
    private static final String USER = "index.jsp";

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            AccountDAO dao = new AccountDAO();
            AccountDTO dto = dao.checkLogin(username, password);
            String role = "failed";
            HttpSession session = request.getSession();
            if (dto != null)
            {
                role = dto.getRole();
                username = dto.getUsername();
                session.setAttribute("ROLE", role);
                session.setAttribute("USERNAME", username);
            }
            if (role.equals("admin"))
            {
                url = ADMIN;
            } else if (role.equals("user"))
            {
                url = USER;
                CartObj cartObj = (CartObj) session.getAttribute("CART");
                if (cartObj == null)
                {
                    cartObj = new CartObj(username);
                } else
                {
                    cartObj.setCustomerUsername(username);
                }
                session.setAttribute("CART", cartObj);
            } else if (role.equals("failed"))
            {
                url = INVALID;
                request.setAttribute("INVALID", "Incorrect Username or Password!");
            } else
            {
                request.setAttribute("INVALID", "Please make sure your account is usable!");
            }
        } catch (Exception e)
        {
            log("ERROR at LoginController: " + e.getMessage());
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
