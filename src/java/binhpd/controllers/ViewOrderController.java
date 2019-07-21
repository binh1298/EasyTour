/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers;

import binhpd.daos.OrderDAO;
import binhpd.daos.OrderDetailsDAO;
import binhpd.dtos.OrderDTO;
import binhpd.dtos.OrderDetailsDTO;
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
public class ViewOrderController extends HttpServlet
{
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "viewOrder.jsp";
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
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("USERNAME");
            OrderDAO orderDao = new OrderDAO();
            ArrayList<OrderDTO> orderDtoList = orderDao.searchByUser(username);
            OrderDetailsDAO orderDetailsDao = new OrderDetailsDAO();
            ArrayList<ArrayList<OrderDetailsDTO>> orderDetailsListLists = new ArrayList<>();
            for (OrderDTO orderDTO : orderDtoList)
            {
                 ArrayList<OrderDetailsDTO> orderDetailsDtoList = orderDetailsDao.searchByOrderID(orderDTO.getOrderID());
                 orderDetailsListLists.add(orderDetailsDtoList);
            }
            request.setAttribute("orderDtoList", orderDtoList);
            request.setAttribute("orderDetailsListLists", orderDetailsListLists);
            url = SUCCESS;
        } catch (Exception e)
        {
            log("ERROR at ViewOrderController: " + e.getMessage());
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
