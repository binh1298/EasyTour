/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.daos;

import binhpd.db.MyConnection;
import binhpd.dtos.OrderDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Binh_Pham
 */
public class OrderDAO implements Serializable
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
    
    public boolean insert(OrderDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Insert Into tbl_Order(OrderID, Username, NumberOfOrders, TotalIncome, Status) values(?, ?, ?, ?, ?)";

        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getOrderID());
            preStm.setString(2, dto.getUsername());
            preStm.setInt(3, dto.getNumberOfOrders());
            preStm.setFloat(4, dto.getTotalIncome());
            preStm.setString(5, dto.getStatus());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    
    public ArrayList<OrderDTO> getOrders() throws Exception
    {
        ArrayList<OrderDTO> list = null;  
        String sql = "Select Username, OrderID, NumberOfOrders, TotalIncome, Status From tbl_Order";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            String orderID, status;
            String username;
            int numberOfOrders;
            float totalIncome;
            OrderDTO dto = null;
            list = new ArrayList<>();    
            while(rs.next())
            {
                orderID = rs.getString("OrderID");
                username = rs.getString("Username");
                status = rs.getString("Status");
                numberOfOrders = rs.getInt("NumberOfOrders");
                totalIncome = rs.getFloat("TotalIncome");
                dto = new OrderDTO(orderID, username, numberOfOrders, totalIncome, status);
                list.add(dto);
            }
        } finally
        {
            closeConnection();
        }
        return list;
    }
    public ArrayList<OrderDTO> searchByUser(String username) throws Exception
    {
        ArrayList<OrderDTO> list = null;  
        String sql = "Select OrderID, NumberOfOrders, TotalIncome, Status From tbl_Order where Username = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            String orderID, status;
            int numberOfOrders;
            float totalIncome;
            OrderDTO dto = null;
            list = new ArrayList<>();    
            while(rs.next())
            {
                orderID = rs.getString("OrderID");
                status = rs.getString("Status");
                numberOfOrders = rs.getInt("NumberOfOrders");
                totalIncome = rs.getFloat("TotalIncome");
                dto = new OrderDTO(orderID, username, numberOfOrders, totalIncome, status);
                list.add(dto);
            }
        } finally
        {
            closeConnection();
        }
        return list;
    }
    
    public boolean changeStatus(String orderID, String newStatus) throws Exception
    {
        boolean check = false;
        String sql = "Update tbl_Order set Status = ? WHERE OrderID = ?";

        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, newStatus);
            preStm.setString(2, orderID);
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
}
