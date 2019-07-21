/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers.admin;

import binhpd.daos.TourDetailsDAO;
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
public class ValidateTourDetailsController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String INVALID_INSERT = "adminAddTourDetails.jsp";
    private static final String INVALID_UPDATE = "adminEditTourDetails.jsp";
    private static final String SUCCESS_INSERT = "InsertTourDetailsController";
    private static final String SUCCESS_UPDATE = "UpdateTourDetailsController";

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
            // Strings 
            String submit = request.getParameter("submit");

            String tourDetailsID = request.getParameter("tourDetailsID");
            String tourTitle = request.getParameter("tourTitle");
            String depatureFlightName = request.getParameter("depatureFlightName");
            String returnFlightName = request.getParameter("returnFlightName");
            String hotelDescription = request.getParameter("hotelDescription");
            String guideName = request.getParameter("guideName");
            String guideAddress = request.getParameter("guideAddress");
            String guidePhoneNumber = request.getParameter("guidePhoneNumber");
            String gatherPlace = request.getParameter("gatherPlace");
            String depatureCity = request.getParameter("depatureCity");
            String destination = request.getParameter("destination");
            String status = request.getParameter("status");
            String creatorUsername = (String) request.getSession().getAttribute("USERNAME");

            // Time stamps
            String txtDepatureDateTime = request.getParameter("depatureDateTime");
            String txtDepatureArrivalDateTime = request.getParameter("depatureArrivalDateTime");
            String txtReturnDateTime = request.getParameter("returnDateTime");
            String txtReturnArrivalDateTime = request.getParameter("returnArrivalDateTime");
            String txtGatherDateTime = request.getParameter("gatherDateTime");

            Timestamp depatureDateTime = BinhPDUltilities.convertTimestampStringToSqlDatetime(txtDepatureDateTime);
            Timestamp depatureArrivalDateTime = BinhPDUltilities.convertTimestampStringToSqlDatetime(txtDepatureArrivalDateTime);
            Timestamp returnDateTime = BinhPDUltilities.convertTimestampStringToSqlDatetime(txtReturnDateTime);
            Timestamp returnArrivalDateTime = BinhPDUltilities.convertTimestampStringToSqlDatetime(txtReturnArrivalDateTime);
            Timestamp gatherDateTime = BinhPDUltilities.convertTimestampStringToSqlDatetime(txtGatherDateTime);

            // Integers
            String txtDuration = request.getParameter("duration");
            String txtNumberOfJourneys = request.getParameter("numberOfJourneys");
            String txtTotalAvailableSeats = request.getParameter("totalAvailableSeats");

            int duration = BinhPDUltilities.convertToInt(txtDuration);
            int numberOfJourneys = BinhPDUltilities.convertToInt(txtNumberOfJourneys);
            int totalAvailableSeats = BinhPDUltilities.convertToInt(txtTotalAvailableSeats);
            // Floats
            String txtPriceAdults = request.getParameter("priceAdults");
            String txtPriceChildren = request.getParameter("priceChildren");

            float priceAdults = BinhPDUltilities.convertToFloat(txtPriceAdults);
            float priceChildren = BinhPDUltilities.convertToFloat(txtPriceChildren);

            boolean valid = true;
            TourDetailsDTOErrorObject errorObj = new TourDetailsDTOErrorObject();
            Timestamp dateTimeCreated = BinhPDUltilities.getCurrentDateTime();
            TourDetailsDTO dto = new TourDetailsDTO(tourDetailsID, tourTitle, depatureFlightName, returnFlightName, hotelDescription, guideName, guideAddress, guidePhoneNumber, gatherPlace, depatureCity, destination, status, creatorUsername, depatureDateTime, depatureArrivalDateTime, returnDateTime, returnArrivalDateTime, gatherDateTime, dateTimeCreated, priceAdults, priceChildren, totalAvailableSeats, duration, totalAvailableSeats, numberOfJourneys);

            valid = BinhPDUltilities.isValid(dto, errorObj, txtNumberOfJourneys, txtDuration, txtTotalAvailableSeats, txtPriceAdults, txtPriceChildren, txtDepatureDateTime, txtDepatureArrivalDateTime, txtReturnDateTime, txtReturnArrivalDateTime, txtGatherDateTime);
                
            TourDetailsDAO dao = new TourDetailsDAO();
            if (submit.equals("Add Details"))
            {
                if (dao.isPrimaryKeyTaken(tourDetailsID))
                {
                    valid = false;
                    errorObj.setTourDetailsIDError("This ID is taken!");
                }
            }

            request.setAttribute("tourDetailsDTO", dto);
            request.setAttribute("errorObj", errorObj);

            if (valid)
            {
                if (submit.equals("Add Details"))
                {
                    url = SUCCESS_INSERT;
                } else if (submit.equals("Update Details"))
                {
                    url = SUCCESS_UPDATE;
                }
            } else
            {
                if (submit.equals("Add Details"))
                {
                    url = INVALID_INSERT;
                } else if (submit.equals("Update Details"))
                {
                    url = INVALID_UPDATE;
                }
            }
        } catch (Exception e)
        {
            log("ERROR at ValidateTourDetailsController: " + e.getMessage());
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
