/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers.cart;

import binhpd.daos.OrderDAO;
import binhpd.daos.OrderDetailsDAO;
import binhpd.daos.TourDetailsDAO;
import binhpd.dtos.CartObj;
import binhpd.dtos.OrderDTO;
import binhpd.dtos.OrderDetailsDTO;
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
public class ConfirmCartController extends HttpServlet
{

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "login.jsp";
    private static final String SUCCESS = "ViewOrderController";
    private static final String INVALID = "ViewShoppingCartController";

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
            if (username == null || username.length() <= 0)
            {
                request.setAttribute("INVALID", "You have to login first!");
                url = LOGIN;
            } else
            {
                String txtNumOfOrders = request.getParameter("numberOfOrders");
                int numberOfOrders = BinhPDUltilities.convertToInt(txtNumOfOrders);
                String status = "Pending";
                String txtTotalIncome = request.getParameter("totalIncome");
                float totalIncome = BinhPDUltilities.convertToFloat(txtTotalIncome);
                String orderID = BinhPDUltilities.generateUniqueTimeString() + "-" + username;

                OrderDTO orderDto = new OrderDTO(orderID, username, numberOfOrders, totalIncome, status);
                String txtAdultsSeats, txtChildrenSeats, txtTotalAdultsPrice, txtTotalChildrenPrice, txtTotalPrice, tourDetailsID;
                float totalAdultsPrice, totalChildrenPrice, totalPrice;
                int adultsSeats, childrenSeats, totalSeats;
                ArrayList<OrderDetailsDTO> detailsList = new ArrayList<>();
                OrderDetailsDTO detailsDto = null;
                TourDetailsDAO tourDetailsDAO = new TourDetailsDAO();
                boolean valid = true;
                for (int i = 0; i < numberOfOrders; i++)
                {
                    txtAdultsSeats = request.getParameter("adultsSeats" + i);
                    txtChildrenSeats = request.getParameter("childrenSeats" + i);
                    txtTotalAdultsPrice = request.getParameter("totalAdultsPrice" + i);
                    txtTotalChildrenPrice = request.getParameter("totalChildrenPrice" + i);
                    txtTotalPrice = request.getParameter("totalPrice" + i);
                    tourDetailsID = request.getParameter("tourDetailsID" + i);

                    adultsSeats = BinhPDUltilities.convertToInt(txtAdultsSeats);
                    childrenSeats = BinhPDUltilities.convertToInt(txtChildrenSeats);
                    totalAdultsPrice = BinhPDUltilities.convertToFloat(txtTotalAdultsPrice);
                    totalChildrenPrice = BinhPDUltilities.convertToFloat(txtTotalChildrenPrice);
                    totalPrice = BinhPDUltilities.convertToFloat(txtTotalPrice);

                    totalSeats = childrenSeats + adultsSeats;

                    if (!tourDetailsDAO.decreaseAvailableSeats(tourDetailsID, totalSeats))
                    {
                        request.setAttribute("ERROR", "Oops, someone must have gotten the seats you want. Better book more quickly!");
                        url = INVALID;
                        valid = false;
                    }
                    detailsDto = new OrderDetailsDTO(0, orderID, tourDetailsID, adultsSeats, childrenSeats, totalSeats, totalChildrenPrice, totalAdultsPrice, totalPrice);
                    detailsList.add(detailsDto);
                }

                if (valid)
                {
                    OrderDAO orderDao = new OrderDAO();
                    OrderDetailsDAO orderDetailsDao = new OrderDetailsDAO();
                    if (orderDao.insert(orderDto))
                    {
                        for (OrderDetailsDTO orderDetailsDTO : detailsList)
                        {
                            if (orderDetailsDao.insert(orderDetailsDTO))
                            {
                                numberOfOrders--;
                            }
                        }
                    }
                }

                if (numberOfOrders == 0) // Insert successfully
                {
                    request.setAttribute("SUCCESS", "Booking successfully. Please come to Innovation Building in Quang Trung Software City to make your payment!");
                    CartObj cartObj = (CartObj) session.getAttribute("CART");
                    cartObj.clearCart();
                    url = SUCCESS;
                } else
                {
                    request.setAttribute("INVALID", "Booking tour failed!");
                    url = ERROR;
                }
            }
        } catch (Exception e)
        {
            log("ERROR at ConfirmCartController: " + e.getMessage());
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
