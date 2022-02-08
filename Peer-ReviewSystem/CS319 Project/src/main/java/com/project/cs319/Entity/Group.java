package com.project.cs319.Entity;
import java.util.ArrayList;


/**
 * This is the Group Entity class of the application
 */
public class Group
{
    // variables
    private ArrayList<Integer> studentIDs;
    private String groupId;
    private ArrayList<String> peerReviews;

    // Constructors
    /**
     * This class is the default constructor of Instructor class.
     */
    public Group() {}

    /**
     * This class is the main constructor of of Group class.
     * @param studentIDs the id list of the students of the group
     * @param groupId the id of the group
     * @param peerReviews the peer reviews list
     */
    public Group(ArrayList<Integer> studentIDs, String groupId, ArrayList<String> peerReviews)
    {
        this.studentIDs = studentIDs;
        this.groupId = groupId;
        this.peerReviews = peerReviews;
    }

    // Getters and Setters //
    /**
     * this method gets the list of the students of the group
     * @return getStudentIDs
     */
    public ArrayList<Integer> getStudentIDs() {
        return studentIDs;
    }

    /**
     * this method sets the list of the students of the group
     * @param  studentIDs
     */
    public void setStudentIDs(ArrayList<Integer> studentIDs) {
        this.studentIDs = studentIDs;
    }

    /**
     * This method gets the group id
     * @return getGroupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method sets the id of the group
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method gets the peer reviews
     * @return peerReviews
     */
    public ArrayList<String> getPeerReviews() {
        return peerReviews;
    }

    /**
     * This method sets the peer reviews
     * @param  peerReviews
     */
    public void setPeerReviews(ArrayList<String> peerReviews) {
        this.peerReviews = peerReviews;
    }
}
