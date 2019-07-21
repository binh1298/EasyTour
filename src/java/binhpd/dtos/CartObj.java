/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Binh_Pham
 */
public class CartObj implements Serializable
{

    private HashMap<String, Seats> cart;
    private String customerUsername;
    public CartObj(String customerUsername)
    {
        this.cart = new HashMap<>();
        this.customerUsername = customerUsername;
    }

    public CartObj(HashMap<String, Seats> cart, String customerUsername)
    {
        this.cart = new HashMap<>();
        this.customerUsername = customerUsername;
    }

    public HashMap<String, Seats> getCart()
    {
        return cart;
    }

    public void setCart(HashMap<String, Seats> cart)
    {
        this.cart = cart;
    }

    public String getCustomerUsername()
    {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername)
    {
        this.customerUsername = customerUsername;
    }
          
    public void addToCart(TourDetailsDTO dto, ArrayList<String> images) throws Exception
    {
        String key = dto.getTourDetailsID();
        if(!this.cart.containsKey(key))
        {
            Seats newSeats = new Seats(dto, images);
            this.cart.put(key, newSeats);
        }
    }
    
    public void updateCart(String tourDetailsID, int numOfAdults, int numOfChildrens) throws Exception
    {
        if(this.cart.containsKey(tourDetailsID))
        {
            this.cart.get(tourDetailsID).setAdultsSeats(numOfAdults);
            this.cart.get(tourDetailsID).setChildrenSeats(numOfChildrens);
        }
    }
    public void removeFromCart(String id) throws Exception
    {
        if(this.cart.containsKey(id))
        {
            this.cart.remove(id);
        }
    }
    public void clearCart() throws Exception 
    {
        this.cart.clear();
    }
}
