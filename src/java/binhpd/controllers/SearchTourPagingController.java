/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import binhpd.dtos.TourDetailsDTO;
import binhpd.utils.BinhPDUltilities;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class SearchTourPagingController extends HttpServlet
{

    public static final String ERROR = "error.jsp";
    public static final String SUCCESS = "searchTour.jsp";
    public static int maximumRecord = 2;

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
            String txtRequestedPage = request.getParameter("requestedPage");
            int requestedPage;
            if (txtRequestedPage == null)
            {
                requestedPage = 1;
            } else
            {
                requestedPage = BinhPDUltilities.convertToInt(txtRequestedPage);
            }
            HttpSession session = request.getSession();
            ArrayList<TourDetailsDTO> masterList = (ArrayList<TourDetailsDTO>) session.getAttribute("INFO");
            ArrayList<String> masterImages = (ArrayList<String>) session.getAttribute("AVATAR");
            ArrayList<TourDetailsDTO> list = new ArrayList<>();
            ArrayList<String> images = new ArrayList<>();
            if (masterList.isEmpty() || masterImages.isEmpty())
            {

            } else
            {
                if (requestedPage <= 0)
                {
                    requestedPage = 1;
                }
                if (requestedPage > masterList.size())
                {
                    requestedPage = masterList.size() - 1;
                }
                int firstRecordIndex = (requestedPage - 1) * maximumRecord;
                int lastRecordIndex = (requestedPage) * maximumRecord;

                for (int i = firstRecordIndex; i < lastRecordIndex; i++)
                {
                    list.add(masterList.get(i));
                    images.add(masterImages.get(i));
                }

            }
            request.setAttribute("INFO", list);
            request.setAttribute("AVATAR", images);
            request.setAttribute("requestedPage", requestedPage);
            int modded = 0;
            if(masterList.size() % maximumRecord != 0) modded = 1;
            int maximumNumberOfPages = masterList.size() / maximumRecord + modded;
            request.setAttribute("maximumNumberOfPages", maximumNumberOfPages);
            url = SUCCESS;
        } catch (Exception e)
        {
            log("ERROR at SearchTourPagingController: " + e.getMessage());
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
