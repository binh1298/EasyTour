/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.dtos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Binh_Pham
 */
public class Seats implements Serializable
{

    int adultsSeats, childrenSeats;
    float totalAdultsPrice, totalChildrenPrice, totalPrice;
    ArrayList<String> imagesDir;
    TourDetailsDTO dto;

    public Seats(TourDetailsDTO dto, ArrayList<String> imagesDir)
    {
        adultsSeats = 0;
        childrenSeats = 0;
        totalAdultsPrice = 0;
        totalChildrenPrice = 0;
        this.dto = dto;
        this.imagesDir = imagesDir;
    }

    public Seats(int adultSeats, int childrenSeats, TourDetailsDTO dto, ArrayList<String> imagesDir)
    {
        this.adultsSeats = adultSeats;
        this.childrenSeats = childrenSeats;
        totalAdultsPrice = 0;
        totalChildrenPrice = 0;
        this.dto = dto;
        this.imagesDir = imagesDir;
    }

    public ArrayList<String> getImagesDir()
    {
        return imagesDir;
    }

    public void setImagesDir(ArrayList<String> imagesDir)
    {
        this.imagesDir = imagesDir;
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

    public TourDetailsDTO getDto()
    {
        return dto;
    }

    public void setDto(TourDetailsDTO dto)
    {
        this.dto = dto;
    }

    public float getTotalAdultsPrice()
    {
        return adultsSeats * dto.getPriceAdults();
    }

    public float getTotalChildrenPrice()
    {
        return childrenSeats * dto.getPriceChildren();
    }

    public float getTotalPrice()
    {
        return getTotalAdultsPrice() + getTotalChildrenPrice();
    }
}
