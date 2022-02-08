package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This class is the Course Entity class.
 */
public class Course {
    // Variables
    private String courseName;
    private String courseId;
    private ArrayList<Integer> sectionId;

    // constructors
    /**
     * This class is the default constructor of Course class.
     */
    public Course() {}

    
    /**
     * This class is the main constructor of of Course class.
     * @param courseName the name of the course
     * @param courseId the id of the course
     * @param sectionId the sections of the course
     */
    public Course(String courseName, String courseId, ArrayList<Integer> sectionId)
    {
        setCourseName(courseName);
        setCourseId(courseId);
        setSectionId(sectionId);
    }

    // Getters and Setters //
    /**
     * This method gets the name of the course
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method sets the name of the course
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * This method gets the id of the course
     * @return courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * This method sets the id of the course
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * This method gets the ids of the section
     * @return sectionId
     */
    public ArrayList<Integer> getSectionId() {
        return sectionId;
    }

    /**
     * This method sets the section ids of the course
     * @param sectionId
     */
    public void setSectionId(ArrayList<Integer> sectionId) {
        this.sectionId = sectionId;
    }


}
