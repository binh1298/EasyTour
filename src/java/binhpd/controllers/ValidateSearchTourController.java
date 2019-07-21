/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import binhpd.dtos.TourDetailsDTO;
import binhpd.dtos.TourDetailsDTOErrorObject;
import binhpd.utils.BinhPDUltilities;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ValidateSearchTourController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS_SEARCH = "SearchTourController";
    private static final String SUCCESS_PAGING = "SearchTourPagingController";
    private static final String INVALID = "searchTour.jsp";

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
            String depatureCity = request.getParameter("depatureCity");
            String destination = request.getParameter("destination");
            String txtDepatureDateTime = request.getParameter("depatureDateTime");
            String txtReturnDateTime = request.getParameter("returnDateTime");
            String txtAvailableSeats = request.getParameter("availableSeats");
            boolean valid = true;
            TourDetailsDTOErrorObject errorObj = new TourDetailsDTOErrorObject();
            if (!BinhPDUltilities.isInRange(1, 100, depatureCity))
            {
                valid = false;
                errorObj.setDepatureCityError("Please enter 1 to 100 characters");
            }
            if (!BinhPDUltilities.isInRange(1, 100, destination))
            {
                valid = false;
                errorObj.setDestinationError("Please enter 1 to 100 characters");
            }

            Timestamp depatureDateTime = null, returnDateTime = null;
            int availableSeats = -1;
            depatureDateTime = BinhPDUltilities.convertDateStringToSqlDateTime(txtDepatureDateTime);
            if (depatureDateTime == null)
            {
                valid = false;
                errorObj.setDepatureDateTimeError("Please enter a valid date");
            }
            returnDateTime = BinhPDUltilities.convertDateStringToSqlDateTime(txtReturnDateTime);
            if (returnDateTime == null)
            {
                valid = false;
                errorObj.setReturnDateTimeError("Please enter a valid date");
            }
            availableSeats = BinhPDUltilities.convertToInt(txtAvailableSeats);
            if (availableSeats <= 0)
            {
                availableSeats = 0;
                valid = false;
                errorObj.setAvailableSeatsError("Please enter a positive integer");
            }
            TourDetailsDTO dto = new TourDetailsDTO(depatureCity, destination, depatureDateTime, returnDateTime, availableSeats);
            request.setAttribute("errorObj", errorObj);
            request.setAttribute("tourDetailsDTO", dto);
            if (!valid)
            {
                url = INVALID;
            } else
            {
                if(request.getParameter("requestedPage") == null) url = SUCCESS_SEARCH;
                else url = SUCCESS_PAGING;
            }

        } catch (Exception e)
        {
            log("ERROR at ValidateSearchTourController: " + e.getMessage());
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
