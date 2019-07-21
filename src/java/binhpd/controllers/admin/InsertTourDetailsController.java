/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers.admin;

import binhpd.daos.TourDetailsDAO;
import binhpd.dtos.TourDetailsDTO;
import binhpd.dtos.TourJourneyDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class InsertTourDetailsController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "adminAddTourJourney.jsp";
    private static final String INVALID = "adminAddTourDetails.jsp";

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
            TourDetailsDTO dto = (TourDetailsDTO)request.getAttribute("tourDetailsDTO");
            TourDetailsDAO dao = new TourDetailsDAO();
            if (dao.insert(dto))
            {
                ArrayList<TourJourneyDTO> journeyDTOs = new ArrayList<>();;
                for (int i = 0; i < dto.getNumberOfJourneys(); i++)
                {
                    journeyDTOs.add(new TourJourneyDTO());
                }
                request.setAttribute("journeys", journeyDTOs);
                request.setAttribute("tourDetailsID", dto.getTourDetailsID());
                request.setAttribute("errorObj", null);
                url = SUCCESS;
            } else
            {
                url = INVALID;
            }
        } catch (Exception e)
        {
            log("ERROR at InsertTourDetailsController: " + e.getMessage());
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
