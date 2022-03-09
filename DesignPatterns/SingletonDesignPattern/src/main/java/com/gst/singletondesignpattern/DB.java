/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.singletondesignpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author OBITO
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class DB {

    private static Connection c;

    private static void setUpConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234");
    }

    public static void iud(String sql) throws Exception {
        if (c == null) {
            setUpConnection();
        }
        c.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        if (c == null) {
            setUpConnection();
        }
        return c.createStatement().executeQuery(sql);
    }

    public static Connection getcon() throws Exception {
        if (c == null) {
            setUpConnection();
        }
        return c;
    }

}
