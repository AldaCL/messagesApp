/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.aldacortes.messagesapp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author alda-
 */
public class MessagesApp {

    public static void main(String[] args){
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("\n\n");
            System.out.println("Select an option: \n");
            System.out.println("1. Create a message");
            System.out.println("2. List messages");
            System.out.println("3. Edit a message");
            System.out.println("4. Delete a message");
            System.out.println("5. Exit");

            option = scanner.nextInt();

            switch (option){
                case 1:
                    MessageService.createMessate();
                    break;
                case 2:
                    MessageService.listMessages();
                    break;
                case 3:
                    MessageService.editMessages();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
            }

        }while (option != 5);
    }

}
