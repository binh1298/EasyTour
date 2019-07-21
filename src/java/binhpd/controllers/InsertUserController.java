/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import binhpd.daos.AccountDAO;
import binhpd.dtos.AccountDTO;
import binhpd.dtos.AccountDTOErrorObject;
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
public class InsertUserController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "signUp.jsp";
    private static final String SUCCESS = "login.jsp";

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
            String cfPassword = request.getParameter("cfPassword");
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String role = "user";
            AccountDTO dto = new AccountDTO(username, fullname, phone, address, email, role);
            dto.setPassword(password);
            AccountDTOErrorObject dtoErrorObj = new AccountDTOErrorObject();

            boolean valid = BinhPDUltilities.isValid(dto, dtoErrorObj, cfPassword);
            request.setAttribute("errorObj", dtoErrorObj);
            request.setAttribute("dto", dto);
            if (valid)
            {
                AccountDAO dao = new AccountDAO();
                if (dao.isDuplicated(username))
                {
                    dtoErrorObj.setUsernameError("This username has already been taken!");
                } else
                {
                    if (dao.insert(dto))
                    {
                        request.setAttribute("SUCCESS", "Register successfully!");
                        url = SUCCESS;
                    }
                }
            } else
            {
                url = INVALID;
            }
        } catch (Exception e)
        {
            log("ERROR at InsertUserController: " + e.getMessage());
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
