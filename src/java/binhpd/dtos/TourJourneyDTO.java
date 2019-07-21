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
public class TourJourneyDTO implements Serializable
{
    String tourDetailsID, timeStamp, title, description, imageDirectory;
    int tourJourneyID;
    public TourJourneyDTO()
    {
    }

    public TourJourneyDTO(int tourJourneyID, String tourDetailsID, String timeStamp, String title, String description, String imageDirectory)
    {
        this.tourJourneyID = tourJourneyID;
        this.tourDetailsID = tourDetailsID;
        this.timeStamp = timeStamp;
        this.title = title;
        this.description = description;
        this.imageDirectory = imageDirectory;
    }

    public int getTourJourneyID()
    {
        return tourJourneyID;
    }

    public void setTourJourneyID(int tourJourneyID)
    {
        this.tourJourneyID = tourJourneyID;
    }
    
    public String getTourDetailsID()
    {
        return tourDetailsID;
    }

    public void setTourDetailsID(String tourDetailsID)
    {
        this.tourDetailsID = tourDetailsID;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImageDirectory()
    {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory)
    {
        this.imageDirectory = imageDirectory;
    }

    @Override
    public String toString()
    {
        return "TourJourneyDTO{" + "tourJourneyID=" + tourJourneyID + ", tourDetailsID=" + tourDetailsID + ", timeStamp=" + timeStamp + ", title=" + title + ", description=" + description + ", imageDirectory=" + imageDirectory + '}';
    }
    
}
