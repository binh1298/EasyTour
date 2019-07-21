/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Binh_Pham
 */
public class MyConnection 
{
    public static Connection getMyConnection() throws Exception
    {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://SE130691\\SQLEXPRESS; database=PRJ321Tour; username=sa; password=123123";
        conn = DriverManager.getConnection(url);
        return conn;
    }
}
