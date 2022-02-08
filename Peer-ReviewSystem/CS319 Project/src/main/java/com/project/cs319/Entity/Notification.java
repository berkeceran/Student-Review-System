package com.project.cs319.Entity;
import java.util.Date;
/**
 * This is the Notification Entity class of the application
 */
public class Notification
{
    // variables
    private String message;
    private int senderId;
    private int receiverId;
    private Date date;

    // Constructor
    /**
     * This class is the constructor of Notification class.
     * @param message the message notice
     * @param senderId the id of the sender
     * @param receiverId the id of the receiver
     * @param date the date of the notification
     */
    public Notification(String message, int senderId, int receiverId, Date date)
    {
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}