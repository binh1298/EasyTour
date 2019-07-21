/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author User
 */
public class MainController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String VALIDATE_DETAILS = "ValidateTourDetailsController";
    private static final String VALIDATE_JOURNEY = "ValidateTourJourneyController";
    private static final String INSERT_USER = "InsertUserController";
    private static final String LOGIN = "LoginController";
    private static final String PERSONAL_INFO = "PersonalInfoController";
    private static final String UPDATE_PERSONAL_INFO = "UpdatePersonalInfoController";
    private static final String UPDATE_PASSWORD = "UpdatePasswordController";
    private static final String LOGOUT = "LogoutController";
    private static final String VIEW_TOUR_DETAILS = "ViewTourDetailsController";
    private static final String MANAGE_TOUR = "ManageTourController";
    private static final String EDIT_TOUR = "EditTourDetailsController";
    private static final String DELETE_TOUR = "DeleteTourDetailsController";
    private static final String MANAGE_ORDER = "ManageOrderController";
    private static final String UPDATE_DETAILS = "ValidateTourDetailsController";
    private static final String CHECK_ORDERS = "ViewOrderController";
    private static final String CANCEL_ORDER = "CancelOrderController";
    private static final String APPROVE_ORDER = "ApproveOrderController";
    
    private static final String SEARCH_TOUR = "ValidateSearchTourController";
    private static final String REQUEST_PAGE_SEARCH_TOUR = "ValidateSearchTourController";

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try
        {
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (!isMultiPart)
            {
                String submit = request.getParameter("submit");
//                System.out.println(submit);
                if (submit.equals("Add Details"))
                {
                    url = VALIDATE_DETAILS;
                } else if (submit.equals("Sign Up"))
                {
                    url = INSERT_USER;
                } else if (submit.equals("Login"))
                {
                    url = LOGIN;
                } else if (submit.equals("Personal Info"))
                {
                    url = PERSONAL_INFO;
                } else if (submit.equals("Update Personal Info"))
                {
                    url = UPDATE_PERSONAL_INFO;
                } else if (submit.equals("Update Password"))
                {
                    url = UPDATE_PASSWORD;
                } else if (submit.equals("Logout"))
                {
                    url = LOGOUT;
                } else if (submit.equals("Search Tour"))
                {
                    url = SEARCH_TOUR;
                } else if (submit.equals("View Tour Details"))
                {
                    url = VIEW_TOUR_DETAILS;
                } else if (submit.equals("Manage Tour"))
                {
                    url = MANAGE_TOUR;
                } else if (submit.equals("Manage Order"))
                {
                    url = MANAGE_ORDER;
                } else if (submit.equals("Edit Tour"))
                {
                    url = EDIT_TOUR;
                } else if (submit.equals("Update Details"))
                {
                    url = UPDATE_DETAILS;
                } else if (submit.equals("Delete Tour"))
                {
                    url = DELETE_TOUR;
                } else if (submit.equals("Check Orders"))
                {
                    url = CHECK_ORDERS;
                } else if (submit.equals("Cancel Order"))
                {
                    url = CANCEL_ORDER;
                } else if (submit.equals("Approve Order"))
                {
                    url = APPROVE_ORDER;
                } else if (submit.equals("Request Page"))
                {
                    url = REQUEST_PAGE_SEARCH_TOUR;
                } else
                {
                    request.setAttribute("ERROR", "Your request is not supported!");
                }
            } else
            {
                url = VALIDATE_JOURNEY;
            }
        } catch (Exception e)
        {
            log("ERROR at MainController: " + e.getMessage());
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
