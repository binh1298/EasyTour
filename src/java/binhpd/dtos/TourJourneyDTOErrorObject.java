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
public class TourJourneyDTOErrorObject implements Serializable
{
    String tourDetailsIDError, timeStampError, titleError, descriptionError, imageDirectoryError;

    public TourJourneyDTOErrorObject()
    {
    }
    
    public String getTourDetailsIDError()
    {
        return tourDetailsIDError;
    }

    public void setTourDetailsIDError(String tourDetailsIDError)
    {
        this.tourDetailsIDError = tourDetailsIDError;
    }

    public String getTimeStampError()
    {
        return timeStampError;
    }

    public void setTimeStampError(String timeStampError)
    {
        this.timeStampError = timeStampError;
    }

    public String getTitleError()
    {
        return titleError;
    }

    public void setTitleError(String titleError)
    {
        this.titleError = titleError;
    }

    public String getDescriptionError()
    {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError)
    {
        this.descriptionError = descriptionError;
    }

    public String getImageDirectoryError()
    {
        return imageDirectoryError;
    }

    public void setImageDirectoryError(String imageDirectoryError)
    {
        this.imageDirectoryError = imageDirectoryError;
    }
    
}
