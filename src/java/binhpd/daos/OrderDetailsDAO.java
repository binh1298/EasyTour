/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.daos;

import binhpd.db.MyConnection;
import binhpd.dtos.OrderDetailsDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Binh_Pham
 */
public class OrderDetailsDAO implements Serializable
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
    
    public boolean insert(OrderDetailsDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Insert into tbl_OrderDetails(OrderID, TourDetailsID, AdultsSeats, ChildrenSeats, TotalSeats, TotalChildrenPrice, TotalAdultsPrice, TotalPrice) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getOrderID());
            preStm.setString(2, dto.getTourDetailsID());
            preStm.setInt(3, dto.getAdultsSeats());
            preStm.setInt(4, dto.getChildrenSeats());
            preStm.setInt(5, dto.getTotalSeats());
            preStm.setFloat(6, dto.getTotalChildrenPrice());
            preStm.setFloat(7, dto.getTotalAdultsPrice());
            preStm.setFloat(8, dto.getTotalPrice());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    
    public ArrayList<OrderDetailsDTO> searchByOrderID(String orderID) throws Exception
    {
        ArrayList<OrderDetailsDTO> list = null;
        OrderDetailsDTO dto = null;
        String sql = "Select OrderDetailsID, OrderID, TourDetailsID, AdultsSeats, ChildrenSeats, TotalSeats, TotalChildrenPrice, TotalAdultsPrice, TotalPrice "
                + "From tbl_OrderDetails WHERE OrderID = ?";

        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderID);
            rs = preStm.executeQuery();
            int orderDetailsID, adultsSeats, childrenSeats, totalSeats;
            float totalChildrenPrice, totalAdultsPrice, totalPrice;
            String tourDetailsID;
            list = new ArrayList<>();    
            while(rs.next())
            {
                orderDetailsID = rs.getInt("OrderDetailsID");
                adultsSeats = rs.getInt("AdultsSeats");
                childrenSeats = rs.getInt("ChildrenSeats");
                totalSeats = rs.getInt("TotalSeats");
                totalChildrenPrice = rs.getFloat("TotalChildrenPrice");
                totalAdultsPrice = rs.getFloat("TotalAdultsPrice");
                totalPrice = rs.getFloat("TotalPrice");
                tourDetailsID = rs.getString("TourDetailsID");
                dto = new OrderDetailsDTO(orderDetailsID, orderID, tourDetailsID, adultsSeats, childrenSeats, totalSeats, totalChildrenPrice, totalAdultsPrice, totalPrice);
                list.add(dto);
            }
        } finally
        {
            closeConnection();
        }
        return list;
    }
    
    public HashMap<String, Integer> getTakenSeats(String orderID) throws Exception
    {
        HashMap<String, Integer> list = null;
        String sql = "Select TourDetailsID, TotalSeats From tbl_OrderDetails WHERE OrderID = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderID);
            rs = preStm.executeQuery();
            Integer num;
            String tourDetailsID;
            list = new HashMap<>();
            while(rs.next())
            {
                num = rs.getInt("TotalSeats");
                tourDetailsID = rs.getString("TourDetailsID");
                list.put(tourDetailsID, num);
            }
        } finally
        {
            closeConnection();
        }
        return list;
    }
}
