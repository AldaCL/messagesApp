package com.aldacortes.messagesapp;

public class MessageModel {
    private int ID_Message;
    private String message;
    private String authorMessage;
    private String dateMessage;

    public MessageModel(){

    }

    public MessageModel(String message, String authorMessage, String dateMessage) {
        this.message = message;
        this.authorMessage = authorMessage;
        this.dateMessage = dateMessage;
    }

    public int getID_Message() {
        return ID_Message;
    }

    public void setID_Message(int ID_Message) {
        this.ID_Message = ID_Message;
    }

    public String getAuthorMessage() {
        return authorMessage;
    }

    public void setAuthorMessage(String authorMessage) {
        this.authorMessage = authorMessage;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
