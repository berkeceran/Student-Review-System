package com.project.cs319.Entity;
import java.util.Date;


/**
 * This is the Message Entity class of the application
 */
public class Message {

    // variables
    private int senderid;
    private String message;
    private Date date;
    private boolean deleted;

    /**
     * This class is the constructor of Message class.
     * @param senderid the id of the sender
     * @param  message the message
     * @param date the date of the message
     * @param deleted the status of the message, is it deleted or not
     */
    public Message(int senderid, String message, Date date, boolean deleted )
    {
        this.senderid = senderid;
        this.message = message;
        this.date = date;
        this.deleted = deleted;
    }

    public int getSenderid() {
        return senderid;
    }

    public void setSenderid(int senderid) {
        this.senderid = senderid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
