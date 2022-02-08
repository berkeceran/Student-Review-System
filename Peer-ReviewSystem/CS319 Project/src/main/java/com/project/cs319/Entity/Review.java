package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This is the Review Entity class of the application
 */
public class Review {

    // variables
    private int giverId;
    private String receiverId;
    private String receiverType;

    // Constructors

    /**
     * This class is the default constructor of Review class.
     */
    public Review() { }

    /**
     * This class is the constructor of Review class
     * @param giverId the id of the review giver
     * @param receiverId the id of the receiver
     * @param receiverType the type of the receiver
     */
    public Review(int giverId, String  receiverId, String receiverType)
    {
            setGiverId(giverId);
            setReceiverId(receiverId);
            setReceiverType(receiverType);
    }

    /**
     * This method gets the receiver type of the review (course,peer,artifact)
     * @return receiverType
     *
     */
    public String getReceiverType() {
        return receiverType;
    }

    /**
     * This method sets the receiver type of the review
     * @param receiverType
     *
     */
    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    /**
     * This method gets the id of the receiver
     * @return receiverId
     *
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * This method sets the id of the receiver
     * @param receiverId
     *
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * This method gets the id of the review giver
     * @return giverId
     *
     */
    public int getGiverId() {
        return giverId;
    }

    /**
     * This method sets the id of the giver
     * @param giverId
     *
     */
    public void setGiverId(int giverId) {
        this.giverId = giverId;
    }

}
