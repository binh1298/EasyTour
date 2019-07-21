/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.daos;

import binhpd.db.MyConnection;
import binhpd.dtos.TourDetailsDTO;
import binhpd.utils.BinhPDUltilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Binh_Pham
 */
public class TourDetailsDAO implements Serializable
{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception
    {
        if(rs!=null) rs.close();
        if(preStm!=null) preStm.close();
        if(conn!=null) conn.close();
    }
    public boolean insert(TourDetailsDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Insert into TourDetails(TourDetailsID, TourTitle, DepatureDateTime, DepatureArrivalDateTime, DepatureFlightName, "
                + "ReturnDateTime, ReturnArrivalDateTime, ReturnFlightName, HotelDescription, GuideName, GuideAddress, GuidePhoneNumber, "
                + "GatherDateTime, GatherPlace, PriceAdults, PriceChildren, NumberOfJourneys, TotalAvailableSeats, AvailableSeats, CreatorUsername, "
                + "DepatureCity, Destination, Duration, Status, DateTimeCreated) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTourDetailsID());
            preStm.setString(2, dto.getTourTitle());
            preStm.setObject(3, dto.getDepatureDateTime());
            preStm.setObject(4, dto.getDepatureArrivalDateTime());
            preStm.setString(5, dto.getDepatureFlightName());
            preStm.setObject(6, dto.getReturnDateTime());
            preStm.setObject(7, dto.getReturnArrivalDateTime());
            preStm.setString(8, dto.getReturnFlightName());
            preStm.setString(9, dto.getHotelDescription());
            preStm.setString(10, dto.getGuideName());
            preStm.setString(11, dto.getGuideAddress());
            preStm.setString(12, dto.getGuidePhoneNumber());
            preStm.setObject(13, dto.getGatherDateTime());
            preStm.setString(14, dto.getGatherPlace());
            preStm.setFloat(15, dto.getPriceAdults());
            preStm.setFloat(16, dto.getPriceChildren());
            preStm.setInt(17, dto.getNumberOfJourneys());
            preStm.setInt(18, dto.getTotalAvailableSeats());
            preStm.setInt(19, dto.getAvailableSeats());
            preStm.setString(20, dto.getCreatorUsername());
            preStm.setString(21, dto.getDepatureCity());
            preStm.setString(22, dto.getDestination());
            preStm.setInt(23, dto.getDuration());
            preStm.setString(24, dto.getStatus());
            preStm.setObject(25, dto.getDateTimeCreated());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    
    public boolean update(TourDetailsDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Update TourDetails set TourTitle = ?,DepatureDateTime = ?,DepatureArrivalDateTime = ?,DepatureFlightName = ?,"
                + "ReturnDateTime = ?,ReturnArrivalDateTime = ?,ReturnFlightName = ?,HotelDescription = ?,GuideName = ?,GuideAddress = ?,GuidePhoneNumber = ?,"
                + "GatherDateTime = ?,GatherPlace = ?,PriceAdults = ?,PriceChildren = ?,NumberOfJourneys = ?,TotalAvailableSeats = ?,AvailableSeats = ?,CreatorUsername = ?,"
                + "DepatureCity = ?,Destination = ?,Duration = ?,Status = ?,DateTimeCreated = ? Where TourDetailsID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTourTitle());
            preStm.setObject(2, dto.getDepatureDateTime());
            preStm.setObject(3, dto.getDepatureArrivalDateTime());
            preStm.setString(4, dto.getDepatureFlightName());
            preStm.setObject(5, dto.getReturnDateTime());
            preStm.setObject(6, dto.getReturnArrivalDateTime());
            preStm.setString(7, dto.getReturnFlightName());
            preStm.setString(8, dto.getHotelDescription());
            preStm.setString(9, dto.getGuideName());
            preStm.setString(10, dto.getGuideAddress());
            preStm.setString(11, dto.getGuidePhoneNumber());
            preStm.setObject(12, dto.getGatherDateTime());
            preStm.setString(13, dto.getGatherPlace());
            preStm.setFloat(14, dto.getPriceAdults());
            preStm.setFloat(15, dto.getPriceChildren());
            preStm.setInt(16, dto.getNumberOfJourneys());
            preStm.setInt(17, dto.getTotalAvailableSeats());
            preStm.setInt(18, dto.getAvailableSeats());
            preStm.setString(19, dto.getCreatorUsername());
            preStm.setString(20, dto.getDepatureCity());
            preStm.setString(21, dto.getDestination());
            preStm.setInt(22, dto.getDuration());
            preStm.setString(23, dto.getStatus());
            preStm.setObject(24, dto.getDateTimeCreated());
            preStm.setString(25, dto.getTourDetailsID());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean delete(String tourDetailsID) throws Exception
    {
        boolean check = false;
        String sql = "Update TourDetails set Status = ? Where TourDetailsID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Not Available");
            preStm.setString(2, tourDetailsID);
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean isPrimaryKeyTaken(String tourDetailsID) throws Exception
    {
        boolean check = false;
        String sql = "Select TourDetailsID FROM TourDetails WHERE TourDetailsID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tourDetailsID);
            rs = preStm.executeQuery();
            check = rs.next();
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public TourDetailsDTO findByPrimaryKey(String id) throws Exception
    {
        TourDetailsDTO dto = null;
        String sql = "Select TourDetailsID, TourTitle, DepatureDateTime, DepatureArrivalDateTime, DepatureFlightName, "
                + "ReturnDateTime, ReturnArrivalDateTime, ReturnFlightName, HotelDescription, GuideName, GuideAddress, GuidePhoneNumber, "
                + "GatherDateTime, GatherPlace, PriceAdults, PriceChildren, NumberOfJourneys, TotalAvailableSeats, AvailableSeats, CreatorUsername, "
                + "DepatureCity, Destination, Duration, Status, DateTimeCreated From TourDetails WHERE TourDetailsID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                String tourDetailsID = rs.getString("TourDetailsID");
                String tourTitle = rs.getString("TourTitle");
                Timestamp depatureDateTime = rs.getTimestamp("DepatureDateTime");
                Timestamp depatureArrivalDateTime = rs.getTimestamp("DepatureArrivalDateTime");
                String depatureFlightName = rs.getString("DepatureFlightName");
                Timestamp returnDateTime = rs.getTimestamp("ReturnDateTime");
                Timestamp returnArrivalDateTime = rs.getTimestamp("ReturnArrivalDateTime");
                String returnFlightName = rs.getString("ReturnFlightName");
                String hotelDescription = rs.getString("HotelDescription");
                String guideName = rs.getString("GuideName");
                String guideAddress = rs.getString("GuideAddress");
                String guidePhoneNumber = rs.getString("GuidePhoneNumber");
                Timestamp gatherDateTime = rs.getTimestamp("GatherDateTime");
                String gatherPlace = rs.getString("GatherPlace");
                float priceAdults = rs.getFloat("PriceAdults");
                float priceChildren = rs.getFloat("PriceChildren");
                int numberOfJourneys = rs.getInt("NumberOfJourneys");
                int totalAvailableSeats = rs.getInt("TotalAvailableSeats");
                int availableSeats = rs.getInt("AvailableSeats");
                String CreatorUsername = rs.getString("CreatorUsername");
                String depatureCity = rs.getString("DepatureCity");
                String destination = rs.getString("Destination");
                int duration = rs.getInt("Duration");
                String status = rs.getString("status");
                Timestamp dateTimeCreated = rs.getTimestamp("DateTimeCreated");
                dto = new TourDetailsDTO(tourDetailsID, tourTitle, depatureFlightName, returnFlightName, hotelDescription, guideName, guideAddress, guidePhoneNumber, gatherPlace, depatureCity, destination, status, CreatorUsername, depatureDateTime, depatureArrivalDateTime, returnDateTime, returnArrivalDateTime, gatherDateTime, dateTimeCreated, priceAdults, priceChildren, availableSeats, duration, totalAvailableSeats, numberOfJourneys);
            }
        } finally
        {
            closeConnection();
        }
        return dto;
        
    }
    
    // For customers
    public ArrayList<TourDetailsDTO> searchAvailableTour(TourDetailsDTO dto) throws Exception
    {
        ArrayList<TourDetailsDTO> list = null;
        String sql = "Select TourDetailsID, PriceAdults, DepatureDateTime, ReturnDateTime, Duration, TourTitle, DepatureCity, Destination, AvailableSeats, TotalAvailableSeats, Status "
                + "from TourDetails Where (DepatureCity LIKE ? OR Destination LIKE ? ) AND Status = 'Available' "
                + "AND (DepatureDateTime >= ? OR DepatureDateTime IS NULL) "
                + "AND (ReturnDateTime <= ? OR DepatureDateTime IS NULL) "
                + "AND (AvailableSeats >= ?) ";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + dto.getDepatureCity() + "%");
            preStm.setString(2, "%" + dto.getDestination() + "%");
            preStm.setTimestamp(3, BinhPDUltilities.minusOneDay(dto.getDepatureDateTime()));
            preStm.setTimestamp(4, BinhPDUltilities.addOneDay(dto.getReturnDateTime()));
            preStm.setInt(5, dto.getAvailableSeats());
            rs = preStm.executeQuery();
            String tourTitle, depatureCity, destination, id, status;
            Timestamp depatureDateTime, returnDateTime;
            Float price;
            int duration, availableSeats, totalAvailableSeats;
            list = new ArrayList();
            while(rs.next())
            {
                tourTitle = rs.getString("TourTitle");
                depatureCity = rs.getString("DepatureCity");
                destination = rs.getString("Destination");
                depatureDateTime = rs.getTimestamp("DepatureDateTime");
                returnDateTime = rs.getTimestamp("ReturnDateTime");
                price = rs.getFloat("PriceAdults");
                duration = rs.getInt("Duration");
                id = rs.getString("TourDetailsID");
                availableSeats = rs.getInt("AvailableSeats");
                totalAvailableSeats = rs.getInt("TotalAvailableSeats");
                status = rs.getString("Status");
                TourDetailsDTO foundDTO = new TourDetailsDTO(id, tourTitle, depatureCity, destination, status, depatureDateTime, returnDateTime, price, availableSeats, duration, totalAvailableSeats);
                list.add(foundDTO);
            }
        } finally 
        {
            closeConnection();
        }
        return list;
    }
    
    // For Cart Info
    public TourDetailsDTO searchTourForCart(String tourDetailsID) throws Exception
    {
        TourDetailsDTO dto = null;
        String sql = "Select TourDetailsID, PriceAdults, PriceChildren, DepatureDateTime, ReturnDateTime, Duration, TourTitle, DepatureCity, Destination, AvailableSeats, TotalAvailableSeats, Status "
                + "From TourDetails WHERE TourDetailsID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tourDetailsID);
            rs = preStm.executeQuery();
            String tourTitle, depatureCity, destination, id, status;
            Timestamp depatureDateTime, returnDateTime;
            Float priceAdults, priceChildren;
            int duration, availableSeats, totalAvailableSeats;
            if(rs.next()) 
            {
                tourTitle = rs.getString("TourTitle");
                depatureCity = rs.getString("DepatureCity");
                destination = rs.getString("Destination");
                depatureDateTime = rs.getTimestamp("DepatureDateTime");
                returnDateTime = rs.getTimestamp("ReturnDateTime");
                priceAdults = rs.getFloat("PriceAdults");
                priceChildren = rs.getFloat("PriceChildren");
                duration = rs.getInt("Duration");
                id = rs.getString("TourDetailsID");
                availableSeats = rs.getInt("AvailableSeats");
                totalAvailableSeats = rs.getInt("TotalAvailableSeats");
                status = rs.getString("Status");
                dto = new TourDetailsDTO(tourDetailsID, tourTitle, depatureCity, destination, status, depatureDateTime, returnDateTime, priceAdults, availableSeats, duration, totalAvailableSeats, priceChildren);
            }
        } finally
        {
            closeConnection();
        }
        return dto;
    }
    
    // Receive Order
    public boolean decreaseAvailableSeats(String tourDetailsID, int requiredSeats) throws Exception
    {
        boolean check = false;
        String sql = "Update TourDetails set AvailableSeats = AvailableSeats - ? WHERE TourDetailsID = ? AND AvailableSeats >= ?";
        try 
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, requiredSeats);
            preStm.setString(2, tourDetailsID);
            preStm.setInt(3, requiredSeats);
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    
    // Cancel Order
    public boolean increaseAvailableSeats(String tourDetailsID, int requiredSeats) throws Exception
    {
        boolean check = false;
        String sql = "Update TourDetails set AvailableSeats = AvailableSeats + ? WHERE TourDetailsID = ?";
        try 
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, requiredSeats);
            preStm.setString(2, tourDetailsID);
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    // Manage Tour
    public ArrayList<TourDetailsDTO> searchTourSortByDateTimeCreated(String inputStatus) throws Exception
    {
        ArrayList<TourDetailsDTO> list = null;
        String sql = "Select TourDetailsID, TourTitle, DepatureCity, Destination, DepatureDateTime, ReturnDateTime, PriceAdults, PriceChildren, "
                + "AvailableSeats, TotalAvailableSeats, Duration, NumberOfJourneys, "
                + "CreatorUsername, DateTimeCreated, Status FROM TourDetails Where Status != ? ORDER BY DateTimeCreated";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, inputStatus);
            rs = preStm.executeQuery();
            
            String tourDetailsID, tourTitle, depatureCity, destination, creatorUsername, status;
            Timestamp depatureDateTime, returnDateTime, dateCreated;
            float priceAdults, priceChildren;
            int availableSeats, totalAvailableSeats, numberOfJourneys, duration;
            TourDetailsDTO dto = null;
            list = new ArrayList();
            while(rs.next())
            {
                tourDetailsID = rs.getString("TourDetailsID");
                tourTitle = rs.getString("TourTitle");
                depatureCity = rs.getString("DepatureCity");
                destination = rs.getString("Destination");
                depatureDateTime = rs.getTimestamp("DepatureDateTime");
                returnDateTime = rs.getTimestamp("ReturnDateTime");
                priceAdults = rs.getFloat("PriceAdults");
                priceChildren = rs.getFloat("PriceChildren");
                availableSeats = rs.getInt("AvailableSeats");
                totalAvailableSeats = rs.getInt("TotalAvailableSeats");
                duration = rs.getInt("Duration");
                numberOfJourneys = rs.getInt("NumberOfJourneys");
                creatorUsername = rs.getString("CreatorUsername");
                dateCreated = rs.getTimestamp("DateTimeCreated");
                status = rs.getString("Status");
                dto = new TourDetailsDTO(tourDetailsID, tourTitle, depatureCity, destination, status, creatorUsername, depatureDateTime, returnDateTime, dateCreated, priceAdults, priceChildren, availableSeats, duration, totalAvailableSeats, numberOfJourneys);
                list.add(dto);
            }
        } finally
        {
            closeConnection();
        }
        return list;
    }
    
}
