/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.daos;

import binhpd.db.MyConnection;
import binhpd.dtos.TourJourneyDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Binh_Pham
 */
public class TourJourneyDAO implements Serializable
{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    
    public void closeConnection() throws Exception
    {
        if(rs!=null) rs = null;
        if(preStm!=null) preStm = null;
        if(conn!=null) conn = null;
    }
    
    public boolean insert(TourJourneyDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Insert into TourJourney(TourDetailsID, TimeStamp, ImageDirectory, Title, Description) values(?, ?, ?, ?, ?)";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTourDetailsID());
            preStm.setString(2, dto.getTimeStamp());
            preStm.setString(3, dto.getImageDirectory());
            preStm.setString(4, dto.getTitle());
            preStm.setString(5, dto.getDescription());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean update(TourJourneyDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Update TourJourney set TourDetailsID = ?, TimeStamp = ?, ImageDirectory = ?, Title = ?, Description = ? WHERE TourJourneyID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTourDetailsID());
            preStm.setString(2, dto.getTimeStamp());
            preStm.setString(3, dto.getImageDirectory());
            preStm.setString(4, dto.getTitle());
            preStm.setString(5, dto.getDescription());
            preStm.setInt(6, dto.getTourJourneyID());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public ArrayList<TourJourneyDTO> search(String tourDetailsID) throws Exception
    {
        ArrayList<TourJourneyDTO> list = null;
        String sql = "Select TourJourneyID, TimeStamp, ImageDirectory, Title, Description From TourJourney Where TourDetailsID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tourDetailsID);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            String timeStamp, imageDirectory, title, description;
            int id;
            TourJourneyDTO dto = null;
            while(rs.next())
            {
                timeStamp = rs.getString("TimeStamp");
                imageDirectory = rs.getString("ImageDirectory");
                title = rs.getString("Title");
                description = rs.getString("Description");
                id = rs.getInt("TourJourneyID");
                dto = new TourJourneyDTO(id, tourDetailsID, timeStamp, title, description, imageDirectory);
                list.add(dto);
            }
        } finally
        {
            closeConnection();
        }
        return list;
    }
    public ArrayList<String> getJourneyImagesDirectory(String tourDetailsID) throws Exception
    {
        ArrayList<String> list = null;
        String sql = "Select ImageDirectory From TourJourney WHERE TourDetailsID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tourDetailsID);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while(rs.next())
            {
                list.add(rs.getString("ImageDirectory"));
            }
        }finally 
        {
            closeConnection();
        }
        return list;
    }
}
