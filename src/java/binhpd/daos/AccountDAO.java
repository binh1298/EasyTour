/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.daos;

import binhpd.db.MyConnection;
import binhpd.dtos.AccountDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Binh_Pham
 */
public class AccountDAO implements Serializable
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
    
    public AccountDTO checkLogin(String username, String password) throws Exception
    {
        AccountDTO dto = null;
        String sql = "Select Role, Username, Fullname from Account WHERE Username = ? and Password = ?";
        try 
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                String role = rs.getString("Role");
                String fullname = rs.getString("Fullname");
                dto = new AccountDTO(username, fullname, "", "", "", role);
            } 
        } finally 
        {
            closeConnection();
        }
        return dto;
    }
    
    public boolean isDuplicated(String username) throws Exception
    {
        boolean check = false;
        String sql = "Select Username From Account WHERE Username = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            check = rs.next();
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public AccountDTO findByPrimaryKey(String username) throws Exception
    {
        AccountDTO dto = null;
        String sql = "Select Fullname, Email, PhoneNumber, Address, Role From Account WHERE Username = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                String name = rs.getString("Fullname");
                String email = rs.getString("Email");
                String phone = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                String role = rs.getString("Role");
                dto = new AccountDTO(username, name, phone, address, email, role);
            }
        }finally 
        { 
            closeConnection();
        }
        return dto;
    }
    public boolean insert(AccountDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Insert into Account(Username, Password, Fullname, PhoneNumber, Address, Email, Role) values(?, ?, ?, ?, ?, ?, ?)";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getPhoneNumber());
            preStm.setString(5, dto.getAddress());
            preStm.setString(6, dto.getEmail());
            preStm.setString(7, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean updatePersonalInfo(AccountDTO dto) throws Exception
    {
        boolean check = false;
        String sql = "Update Account set Fullname = ?, Email = ? , PhoneNumber = ? , Address = ? Where Username = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFullname());
            preStm.setString(2, dto.getEmail());
            preStm.setString(3, dto.getPhoneNumber());
            preStm.setString(4, dto.getAddress());
            preStm.setString(5, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    public boolean updatePassword(String username, String password) throws Exception
    {
        boolean check = false;
        String sql = "Update Account set Password = ? Where Username = ?";
        try
        {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, password);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally 
        {
            closeConnection();
        }
        return check;
    }
}
