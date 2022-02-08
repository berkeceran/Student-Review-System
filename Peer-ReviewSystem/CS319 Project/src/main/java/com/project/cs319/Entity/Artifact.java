package com.project.cs319.Entity;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class is the entity class of Artifact.
 */
public class Artifact {

    // Variables
    private String giverGroupName;
    private String name;
    private String description;
    private Date uploadDate;
    private double grade;
    private ArrayList<String> reviews;

    // Constructors

    /**
     * This is the default constructor of Artifact class
     */
    public Artifact() {}

    /**
     * This is the constructor of Artifact class
     * @param giverGroupName the group which is done the artifact
     * @param name  the name of the artifact e.g. analysis report
     * @param description the description of the artifact
     * @param uploadDate the upload date of the artifact
     * @param grade the grade(rate) of the artifact
     * @param reviews the reviews of the artifact
     */
    public Artifact(String giverGroupName, String name, String description, Date uploadDate,
                    double grade, ArrayList<String> reviews) {
        setGiverGroupName(giverGroupName);
        setName(name);
        setDescription(description);
        setUploadDate(uploadDate);
        setGrade(grade);
        setReviews(reviews);
    }

    // Getters and Setters //
    /**
     * This method gets the group which has done the artifact
     * @return giverGroupName
     */
    public String getGiverGroupName() {
        return giverGroupName;
    }

    /**
     * This method sets the group of the artifact
     * @param giverGroupName
     */
    public void setGiverGroupName(String giverGroupName) {
        this.giverGroupName = giverGroupName;
    }

    /**
     * This method gets the name of the artifact
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the artifact
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the description of the artifact
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the description of the artifact
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method gets the upload date of the artifact
     * @return uploadDate
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * This method sets the upload date of the artifact
     * @param uploadDate
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * This method gets the grade of the artifact
     * @return grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * This method sets the grade of the artifact
     * @param grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * This method gets the review of the artifact
     * @return reviews
     */
    public ArrayList<String> getReviews() {
        return reviews;
    }

    /**
     * This method sets the review of the artifact
     * @param reviews
     */
    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }
}
