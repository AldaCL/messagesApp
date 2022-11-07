package com.aldacortes.messagesapp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {

    public static void createMessate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEscribe el mensaje que quieres introducir");
        String message = scanner.nextLine();

        System.out.println("\nEscribe el autor del mensaje");
        String author = scanner.nextLine();

        MessageModel registro = new MessageModel();
        registro.setMessage(message);
        registro.setAuthorMessage(author);

        try {
            MessageDAO.createMessageDB(registro);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void listMessages(){
        ArrayList<MessageModel> messageList = MessageDAO.readMessageDB();

        for (MessageModel currentMessage:messageList){
            System.out.println("\nID Message: " + currentMessage.getID_Message());
            System.out.println("Author: " + currentMessage.getAuthorMessage());
            System.out.println("Message: " + currentMessage.getMessage());
            System.out.println("Timestamp: " + currentMessage.getDateMessage());
        }
    }

    public static void editMessages(){
        listMessages();
        int idMessage = 0;
        String newMessage = null;
        MessageModel messageToUpdate  = new MessageModel();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indiquie el ID del mensaje a modificar");
        idMessage = scanner.nextInt();
        messageToUpdate.setID_Message(idMessage);

        System.out.println("Indique el nuevo mensaje :\n");
        scanner.nextLine();
        newMessage = scanner.nextLine();
        messageToUpdate.setMessage(newMessage);

        MessageDAO.updateMessageDB(messageToUpdate);
    }

    public static void deleteMessage(){
        listMessages();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInput the ID of the message to delete");
        int id_message = scanner.nextInt();
        int rowsAffected = MessageDAO.deleteMessageDB(id_message);
        if(rowsAffected != 0){
            System.out.println("Numero de registros eliminados = " + rowsAffected);
        }else{
            System.out.println("No se elminino ningun registro");
        }

    }

}
