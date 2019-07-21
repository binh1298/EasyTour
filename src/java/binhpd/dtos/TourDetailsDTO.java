/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Binh_Pham
 */
public class TourDetailsDTO implements Serializable
{
    String tourDetailsID, tourTitle, depatureFlightName, returnFlightName, hotelDescription, guideName, guideAddress, guidePhoneNumber, gatherPlace, depatureCity, destination, status, creatorUsername;
    Timestamp depatureDateTime, depatureArrivalDateTime, returnDateTime, returnArrivalDateTime, gatherDateTime, dateTimeCreated;
    float priceAdults, priceChildren;
    int availableSeats, duration, totalAvailableSeats, numberOfJourneys;

    
    // Search DTO
    public TourDetailsDTO(String depatureCity, String destination, Timestamp depatureDateTime, Timestamp returnDateTime, int availableSeats)
    {
        this.depatureCity = depatureCity;
        this.destination = destination;
        this.depatureDateTime = depatureDateTime;
        this.returnDateTime = returnDateTime;
        this.availableSeats = availableSeats;
    }

    // Customers Search tour using this
    public TourDetailsDTO(String tourDetailsID, String tourTitle, String depatureCity, String destination, String status, Timestamp depatureDateTime, Timestamp returnDateTime, float priceAdults, int availableSeats, int duration, int totalAvailableSeats)
    {
        this.tourDetailsID = tourDetailsID;
        this.tourTitle = tourTitle;
        this.depatureCity = depatureCity;
        this.destination = destination;
        this.status = status;
        this.depatureDateTime = depatureDateTime;
        this.returnDateTime = returnDateTime;
        this.priceAdults = priceAdults;
        this.availableSeats = availableSeats;
        this.duration = duration;
        this.totalAvailableSeats = totalAvailableSeats;
    }
    
    // For cart info
    public TourDetailsDTO(String tourDetailsID, String tourTitle, String depatureCity, String destination, String status, Timestamp depatureDateTime, Timestamp returnDateTime, float priceAdults, int availableSeats, int duration, int totalAvailableSeats, float priceChildren)
    {
        this.tourDetailsID = tourDetailsID;
        this.tourTitle = tourTitle;
        this.depatureCity = depatureCity;
        this.destination = destination;
        this.status = status;
        this.depatureDateTime = depatureDateTime;
        this.returnDateTime = returnDateTime;
        this.priceAdults = priceAdults;
        this.priceChildren = priceChildren;
        this.availableSeats = availableSeats;
        this.duration = duration;
        this.totalAvailableSeats = totalAvailableSeats;
    }
    // Main
    public TourDetailsDTO(String tourDetailsID, String tourTitle, String depatureCity, String destination, String status, String creatorUsername, Timestamp depatureDateTime, Timestamp returnDateTime, Timestamp dateTimeCreated, float priceAdults, float priceChildren, int availableSeats, int duration, int totalAvailableSeats, int numberOfJourneys)
    {
        this.tourDetailsID = tourDetailsID;
        this.tourTitle = tourTitle;
        this.depatureCity = depatureCity;
        this.destination = destination;
        this.status = status;
        this.creatorUsername = creatorUsername;
        this.depatureDateTime = depatureDateTime;
        this.returnDateTime = returnDateTime;
        this.dateTimeCreated = dateTimeCreated;
        this.priceAdults = priceAdults;
        this.priceChildren = priceChildren;
        this.availableSeats = availableSeats;
        this.duration = duration;
        this.totalAvailableSeats = totalAvailableSeats;
        this.numberOfJourneys = numberOfJourneys;
    }
                
    
    public TourDetailsDTO(String tourDetailsID, String tourTitle, String depatureFlightName, String returnFlightName, String hotelDescription, String guideName, String guideAddress, String guidePhoneNumber, String gatherPlace, String depatureCity, String destination, String status, String creatorUsername, Timestamp depatureDateTime, Timestamp depatureArrivalDateTime, Timestamp returnDateTime, Timestamp returnArrivalDateTime, Timestamp gatherDateTime, Timestamp dateTimeCreated, float priceAdults, float priceChildren, int availableSeats, int duration, int totalAvailableSeats, int numberOfJourneys)
    {
        this.tourDetailsID = tourDetailsID;
        this.tourTitle = tourTitle;
        this.depatureFlightName = depatureFlightName;
        this.returnFlightName = returnFlightName;
        this.hotelDescription = hotelDescription;
        this.guideName = guideName;
        this.guideAddress = guideAddress;
        this.guidePhoneNumber = guidePhoneNumber;
        this.gatherPlace = gatherPlace;
        this.depatureCity = depatureCity;
        this.destination = destination;
        this.status = status;
        this.creatorUsername = creatorUsername;
        this.depatureDateTime = depatureDateTime;
        this.depatureArrivalDateTime = depatureArrivalDateTime;
        this.returnDateTime = returnDateTime;
        this.returnArrivalDateTime = returnArrivalDateTime;
        this.gatherDateTime = gatherDateTime;
        this.dateTimeCreated = dateTimeCreated;
        this.priceAdults = priceAdults;
        this.priceChildren = priceChildren;
        this.availableSeats = availableSeats;
        this.duration = duration;
        this.totalAvailableSeats = totalAvailableSeats;
        this.numberOfJourneys = numberOfJourneys;
    }

    public int getTotalAvailableSeats()
    {
        return totalAvailableSeats;
    }

    public void setTotalAvailableSeats(int totalAvailableSeats)
    {
        this.totalAvailableSeats = totalAvailableSeats;
    }

    public int getNumberOfJourneys()
    {
        return numberOfJourneys;
    }

    public void setNumberOfJourneys(int numberOfJourneys)
    {
        this.numberOfJourneys = numberOfJourneys;
    }
    
    
    public String getCreatorUsername()
    {
        return creatorUsername;
    }

    public void setCreatorUsername(String creatorUsername)
    {
        this.creatorUsername = creatorUsername;
    }
    
    public Timestamp getDateTimeCreated()
    {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Timestamp dateTimeCreated)
    {
        this.dateTimeCreated = dateTimeCreated;
    }
    
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    
    public String getDepatureCity()
    {
        return depatureCity;
    }

    public void setDepatureCity(String depatureCity)
    {
        this.depatureCity = depatureCity;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getTourDetailsID()
    {
        return tourDetailsID;
    }

    public void setTourDetailsID(String tourDetailsID)
    {
        this.tourDetailsID = tourDetailsID;
    }

    public String getTourTitle()
    {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle)
    {
        this.tourTitle = tourTitle;
    }

    public String getDepatureFlightName()
    {
        return depatureFlightName;
    }

    public void setDepatureFlightName(String depatureFlightName)
    {
        this.depatureFlightName = depatureFlightName;
    }

    public String getReturnFlightName()
    {
        return returnFlightName;
    }

    public void setReturnFlightName(String returnFlightName)
    {
        this.returnFlightName = returnFlightName;
    }

    public String getHotelDescription()
    {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription)
    {
        this.hotelDescription = hotelDescription;
    }

    public String getGuideName()
    {
        return guideName;
    }

    public void setGuideName(String guideName)
    {
        this.guideName = guideName;
    }

    public String getGuideAddress()
    {
        return guideAddress;
    }

    public void setGuideAddress(String guideAddress)
    {
        this.guideAddress = guideAddress;
    }

    public String getGuidePhoneNumber()
    {
        return guidePhoneNumber;
    }

    public void setGuidePhoneNumber(String guidePhoneNumber)
    {
        this.guidePhoneNumber = guidePhoneNumber;
    }

    public String getGatherPlace()
    {
        return gatherPlace;
    }

    public void setGatherPlace(String gatherPlace)
    {
        this.gatherPlace = gatherPlace;
    }

    public Timestamp getDepatureDateTime()
    {
        return depatureDateTime;
    }

    public void setDepatureDateTime(Timestamp depatureDateTime)
    {
        this.depatureDateTime = depatureDateTime;
    }

    public Timestamp getDepatureArrivalDateTime()
    {
        return depatureArrivalDateTime;
    }

    public void setDepatureArrivalDateTime(Timestamp depatureArrivalDateTime)
    {
        this.depatureArrivalDateTime = depatureArrivalDateTime;
    }

    public Timestamp getReturnDateTime()
    {
        return returnDateTime;
    }

    public void setReturnDateTime(Timestamp returnDateTime)
    {
        this.returnDateTime = returnDateTime;
    }

    public Timestamp getReturnArrivalDateTime()
    {
        return returnArrivalDateTime;
    }

    public void setReturnArrivalDateTime(Timestamp returnArrivalDateTime)
    {
        this.returnArrivalDateTime = returnArrivalDateTime;
    }

    public Timestamp getGatherDateTime()
    {
        return gatherDateTime;
    }

    public void setGatherDateTime(Timestamp gatherDateTime)
    {
        this.gatherDateTime = gatherDateTime;
    }

    public float getPriceAdults()
    {
        return priceAdults;
    }

    public void setPriceAdults(float priceAdults)
    {
        this.priceAdults = priceAdults;
    }

    public float getPriceChildren()
    {
        return priceChildren;
    }

    public void setPriceChildren(float priceChildren)
    {
        this.priceChildren = priceChildren;
    }

    public int getAvailableSeats()
    {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats)
    {
        this.availableSeats = availableSeats;
    }
    
}
