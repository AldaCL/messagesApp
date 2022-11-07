/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.aldacortes.messagesapp;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author alda-
 */
public class MessagesApp {

    public static void main(String[] args) throws SQLException {
        ConnectionHandler connectionHandler = new ConnectionHandler();

        try(Connection cnx = connectionHandler.getConnection()){

        }catch (SQLException e){
            System.out.println(e);
        }
    }

}
