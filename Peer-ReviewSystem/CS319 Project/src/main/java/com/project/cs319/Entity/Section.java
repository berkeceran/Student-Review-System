package com.project.cs319.Entity;
import java.util.ArrayList;
/**
 * This is the Section Entity class of the application
 * It represents sections of the course
 */
public class Section
{
    // variables
    private int sectionId;
    private ArrayList<String> groupIds;
    private int instructorID;
    private ArrayList<Integer> TAlist;
    private ArrayList<Integer> students;
    private String courseReviewsID;

    // Constructors

    /**
     * This class is the default constructor of Section class.
     */
    public Section() {}

    /**
     * This class is the  constructor of Section class
     * @param sectionId the id of the section
     * @param groupIds the id of the groups in the section
     * @param instructorID the id of the instructor of the section
     * @param TAlist the list of TAs of the section
     * @param students the students of the sections
     * @param courseReviewsID the ids of the course reviews
     *
     */
    public Section(int sectionId, ArrayList<String> groupIds, int instructorID, ArrayList<Integer> TAlist,
                   ArrayList<Integer> students, String courseReviewsID)
    {
        this.sectionId = sectionId;
        this.groupIds = groupIds;
        this.instructorID = instructorID;
        this.TAlist = TAlist;
        this.students = students;
        this.courseReviewsID = courseReviewsID;
    }

    /**
     *
     * @return TAlist
     * gets the TA list of the section
     */
    public ArrayList<Integer> getTAlist() {
        return TAlist;
    }

    /**
     *
     * @param TAlist the TA list of the section
     * sets the TA list of the section
     */
    public void setTAlist(ArrayList<Integer> TAlist) {
        this.TAlist = TAlist;
    }

    /**
     *
     * @return students
     * gets the students of the sections
     */
    public ArrayList<Integer> getStudents() {
        return students;
    }

    /**
     *
     * @param students
     * sets the students of the section
     */
    public void setStudents(ArrayList<Integer> students) {
        this.students = students;
    }

    /**
     *
     * @return sectionId
     * gets the sectionId
     */
    public int getSectionId() {
        return sectionId;
    }

    /**
     *
     * @param sectionId
     * sets the id of the section
     */
    public void setSectionId( int sectionId) {
        this.sectionId = sectionId;
    }

    /**
     *
     * @return instrcutorID
     * gets the id of the instructor
     */
    public int getInstructor() {
        return instructorID;
    }

    /**
     *
     * @param instructorID the id of the instructor
     * sets the instructor id of the section
     */
    public void setInstructor(int instructorID) {
        this.instructorID = instructorID;
    }

    /**
     *
     * @return groupIds
     * gets the ids of the group
     */
    public ArrayList<String> getGroupIds() {
        return groupIds;
    }

    /**
     *
     * @param groupIds
     * sets the id of the groups
     */
    public void setGroupIds(ArrayList<String> groupIds) {
        this.groupIds = groupIds;
    }

    /**
     *
     * @return courseReviewsID
     * gets the review of the courses in section
     */

    public String getCourseReviews() {
        return courseReviewsID;
    }

    /**
     * @param courseReviews
     * sets the course reviews of the section
     */
    public void setCourseReviews(ArrayList<Course_Review> courseReviews) {
        this.courseReviewsID = courseReviewsID;
    }

}
