package com.project.cs319.Entity;
import java.util.ArrayList;


/**
 * This is the Peer_Review Entity class of the application
 * It extends the review class
 */
public class Peer_Review extends Review
{
    // variables
    private String peerReviewType;

    /**
     * This class is the default constructor of Peer_Review class.
     */
    public Peer_Review(){ }

    /**
     * This class is the constructor of Peer_Review class.
     * @param giverId the id of the review giver
     * @param receiverId the id of the receiver
     * @param peerReviewType the type of the peer review
     */
    public Peer_Review(int giverId, String receiverId, String peerReviewType) {
        super(giverId,receiverId,"student");
        this.peerReviewType = peerReviewType;
    }


    /**
     * this method gets the type of the peer review
     * @return peerReviewType
     *
     */
    public String getPeerReviewType() {
        return peerReviewType;
    }

    /**
     * this method sets the peer review type
     * @param peerReviewType
     *
     */
    public void setPeerReviewType(String peerReviewType) {
        this.peerReviewType = peerReviewType;
    }
}