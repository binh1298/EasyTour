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
public class OrderDetailsDTO implements Serializable
{
    int orderDetailsID, adultsSeats, childrenSeats, totalSeats;
    float totalChildrenPrice, totalAdultsPrice, totalPrice;
    String tourDetailsID, orderID;

    public OrderDetailsDTO(int orderDetailsID, String orderID, String tourDetailsID, int adultsSeats, int childrenSeats, int totalSeats, float totalChildrenPrice, float totalAdultsPrice, float totalPrice)
    {
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.tourDetailsID = tourDetailsID;
        this.adultsSeats = adultsSeats;
        this.childrenSeats = childrenSeats;
        this.totalSeats = totalSeats;
        this.totalChildrenPrice = totalChildrenPrice;
        this.totalAdultsPrice = totalAdultsPrice;
        this.totalPrice = totalPrice;
    }

    public int getOrderDetailsID()
    {
        return orderDetailsID;
    }

    public void setOrderDetailsID(int orderDetailsID)
    {
        this.orderDetailsID = orderDetailsID;
    }

    public String getOrderID()
    {
        return orderID;
    }

    public void setOrderID(String orderID)
    {
        this.orderID = orderID;
    }

    public String getTourDetailsID()
    {
        return tourDetailsID;
    }

    public void setTourDetailsID(String tourDetailsID)
    {
        this.tourDetailsID = tourDetailsID;
    }

    public int getAdultsSeats()
    {
        return adultsSeats;
    }

    public void setAdultsSeats(int adultsSeats)
    {
        this.adultsSeats = adultsSeats;
    }

    public int getChildrenSeats()
    {
        return childrenSeats;
    }

    public void setChildrenSeats(int childrenSeats)
    {
        this.childrenSeats = childrenSeats;
    }

    public int getTotalSeats()
    {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats)
    {
        this.totalSeats = totalSeats;
    }

    public float getTotalChildrenPrice()
    {
        return totalChildrenPrice;
    }

    public void setTotalChildrenPrice(float totalChildrenPrice)
    {
        this.totalChildrenPrice = totalChildrenPrice;
    }

    public float getTotalAdultsPrice()
    {
        return totalAdultsPrice;
    }

    public void setTotalAdultsPrice(float totalAdultsPrice)
    {
        this.totalAdultsPrice = totalAdultsPrice;
    }

    public float getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
}
