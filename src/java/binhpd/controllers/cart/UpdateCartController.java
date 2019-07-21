/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.controllers.cart;

import binhpd.dtos.CartErrorObject;
import binhpd.dtos.CartObj;
import binhpd.dtos.Seats;
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
public class UpdateCartController extends HttpServlet
{
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ViewShoppingCartController";
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
            CartObj cart = (CartObj)session.getAttribute("CART");
            String txtNumAdults, txtNumChildren;
            int numAdults, numChildren;
            boolean valid = true;
            int count = 0;
            ArrayList<CartErrorObject> errorObjList = new ArrayList();
            
            for (Seats value : cart.getCart().values())
            {
                txtNumAdults = request.getParameter("adultsSeats" + count);
                txtNumChildren = request.getParameter("childrenSeats" + count);
                numAdults = BinhPDUltilities.convertToInt(txtNumAdults);
                numChildren = BinhPDUltilities.convertToInt(txtNumChildren);
                CartErrorObject cartErrObj = new CartErrorObject();
                if(numAdults < 0) 
                {
                    valid = false;
                    cartErrObj.setAdultsSeatsError("Invalid number of adults");
                } else
                {
                    value.setAdultsSeats(numAdults);
                }
                
                if(numChildren < 0) 
                {
                    valid = false;
                    cartErrObj.setChildrenSeatsError("Invalid number of childrens");
                } else
                {
                    value.setChildrenSeats(numChildren);
                }
                if(numAdults + numChildren > value.getDto().getAvailableSeats())
                {
                    valid = false;
                    cartErrObj.setAdultsSeatsError("Not enough available seats");
                }
                if(numAdults + numChildren == 0)
                {
                    valid = false;
                    cartErrObj.setAdultsSeatsError("At lease one person has to join the tour!");
                }
                errorObjList.add(cartErrObj);
                count++;
            }
            request.setAttribute("errorObjList", errorObjList);
            if(valid)
            {
                url = SUCCESS;
            }
            else
            {
                request.setAttribute("INVALID_CART", valid);
                url = INVALID;
            }
        } catch (Exception e)
        {
            log("ERROR at UpdateCartController: " + e.getMessage());
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
