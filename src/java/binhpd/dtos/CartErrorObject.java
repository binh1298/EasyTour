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
public class CartErrorObject implements Serializable
{
    String adultsSeatsError, childrenSeatsError;

    public CartErrorObject()
    {
    }

    public CartErrorObject(String adultsSeatsError, String childrenSeatsError)
    {
        this.adultsSeatsError = adultsSeatsError;
        this.childrenSeatsError = childrenSeatsError;
    }

    public String getAdultsSeatsError()
    {
        return adultsSeatsError;
    }

    public void setAdultsSeatsError(String adultsSeatsError)
    {
        this.adultsSeatsError = adultsSeatsError;
    }

    public String getChildrenSeatsError()
    {
        return childrenSeatsError;
    }

    public void setChildrenSeatsError(String childrenSeatsError)
    {
        this.childrenSeatsError = childrenSeatsError;
    }
    
}
