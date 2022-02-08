package com.project.cs319.Entity;
import java.io.File;
import java.util.ArrayList;

/**
 * This class is the entity class of Artifact_Review extended from Review class.
 */
public class Artifact_Review extends Review {

    // Variables
    private String comment;
    private File reviewFile;


    /**
     * This is the default constructor of ArtifactReview class
     */
    public Artifact_Review() {}

    // constructors
    /**
     * This is the constructor of ArtifactReview class
     * @param giverId the id of the giver.
     * @param receiverId the receiver's id.
     * @param comment the comment that is givem
     * @param reviewFile the File with artifact reviews that is given.
     */
    public Artifact_Review (int giverId, String receiverId, String comment, File reviewFile)
    {
        super(giverId, receiverId, "group");
        setComment(comment);
        setReviewFile(reviewFile);
    }

    // Getters and Setters //
    /**
     * This method gets the comment artifact review
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method sets the comment of the artifact review
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Getters and Setters //
    /**
     * This method gets the review file
     * @return File
     */
    public File getReviewFile() {
        return reviewFile;
    }

    /**
     * This method sets the review file
     * @param reviewFile
     */
    public void setReviewFile(File reviewFile) {
        this.reviewFile = reviewFile;
    }
}