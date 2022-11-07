package com.aldacortes.messagesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {
    
    public static void createMessageDB(MessageModel messageModel) throws SQLException {

        ConnectionHandler connectionHandler = new ConnectionHandler();
        try(Connection connection = connectionHandler.getConnection()){
            PreparedStatement statement = null;
            try{
                String query = "INSERT INTO `messages` (`message`, `author_message`) VALUES ( ?, ?)";
                statement = connection.prepareStatement(query);
                statement.setString(1,messageModel.getMessage());
                statement.setString(2,messageModel.getAuthorMessage());
                statement.executeUpdate();
                System.out.println("Mensaje creado");
            }catch (SQLException e){
                System.out.println("Error al ejecutar statement: " + e );
            }

        }catch (SQLException e){

        }

    }

    public static ArrayList<MessageModel> readMessageDB(){
        ConnectionHandler connectionHandler = new ConnectionHandler();

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<MessageModel> allMessages =  new ArrayList<>();

        try(Connection connection = connectionHandler.getConnection()){
            String query = "SELECT * from messages limit 10";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                MessageModel current_message = new MessageModel();
                current_message.setID_Message(resultSet.getInt("id_messages"));
                current_message.setAuthorMessage(resultSet.getString("author_message"));
                current_message.setMessage(resultSet.getString("message"));
                current_message.setDateMessage(resultSet.getString("fecha_message"));

                allMessages.add(current_message);
            }

        }catch (SQLException e){
        }
        return allMessages;
    }

    public static int deleteMessageDB (int id_message){
        ConnectionHandler connectionHandler = new ConnectionHandler();
        int rowsAffected = 0;
        try(Connection connection = connectionHandler.getConnection()){
            PreparedStatement statement = null;
            try{
                String query = "DELETE FROM messages WHERE id_messages = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_message);
                rowsAffected = statement.executeUpdate();
            }catch (SQLException e){
                System.out.println("No fue posible eliminar el mensaje. razon : " + e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    public static int updateMessageDB(MessageModel messageModel){
        ConnectionHandler connectionHandler = new ConnectionHandler();
        int rowsAffected = 0;

        try(Connection connection = connectionHandler.getConnection()){
            PreparedStatement statement = null;
            try{
                String query = " UPDATE messages SET message = ?, fecha_message = default WHERE id_messages = ?";
                statement = connection.prepareStatement(query);
                statement.setString(1, messageModel.getMessage());
                statement.setInt(2,messageModel.getID_Message());
                rowsAffected = statement.executeUpdate();
                System.out.println("Numero de columnas actualizadas: " + rowsAffected);

            }catch (SQLException e){
                System.out.println("No fue posible actualizar el mensaje. razon : " + e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;

    }
}
