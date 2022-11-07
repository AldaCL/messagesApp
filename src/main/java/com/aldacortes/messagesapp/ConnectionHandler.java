package com.aldacortes.messagesapp;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionHandler{

    public Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app","root","");
            if (connection != null) {
                System.out.println("Successful connections");
            }

    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return connection;
    }
}
