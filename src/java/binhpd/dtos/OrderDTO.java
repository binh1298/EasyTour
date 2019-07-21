/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.dtos;

import java.io.Serializable;

/**
 *
 * @author Binh_Pham
 */
public class OrderDTO implements Serializable
{
    int numberOfOrders;
    float totalIncome;
    String status, username, orderID;

    public OrderDTO(String orderID, String username, int numberOfOrders, float totalIncome, String status)
    {
        this.orderID = orderID;
        this.username = username;
        this.numberOfOrders = numberOfOrders;
        this.totalIncome = totalIncome;
        this.status = status;
    }

    public String getOrderID()
    {
        return orderID;
    }

    public void setOrderID(String orderID)
    {
        this.orderID = orderID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getNumberOfOrders()
    {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders)
    {
        this.numberOfOrders = numberOfOrders;
    }

    public float getTotalIncome()
    {
        return totalIncome;
    }

    public void setTotalIncome(float totalIncome)
    {
        this.totalIncome = totalIncome;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
}
