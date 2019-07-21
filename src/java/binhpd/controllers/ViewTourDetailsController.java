/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import binhpd.daos.TourDetailsDAO;
import binhpd.daos.TourJourneyDAO;
import binhpd.dtos.TourDetailsDTO;
import binhpd.dtos.TourJourneyDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ViewTourDetailsController extends HttpServlet
{
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "viewTour.jsp";
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
            String id = request.getParameter("tourDetailsID");
            TourDetailsDAO dao = new TourDetailsDAO();
            TourDetailsDTO dto = dao.findByPrimaryKey(id);
            TourJourneyDAO journeyDao = new TourJourneyDAO();
            List<TourJourneyDTO> journeys = journeyDao.search(id); 
            if(dto != null)
            {
                request.setAttribute("tourDetailsDTO", dto);
                request.setAttribute("Journeys", journeys);
                url = SUCCESS;
            } else
            {
                request.setAttribute("ERROR", "The tour you looking for maynot be available or simply doesnt exist!");
            }
        } catch (Exception e)
        {
            log("ERROR at ViewTourDetailsController: " + e.getMessage());
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
