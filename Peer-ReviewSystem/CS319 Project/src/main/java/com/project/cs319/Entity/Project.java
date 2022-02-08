package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This is the Project Entity class of the application
 */
public class Project
{
    // variables
    private ArrayList<Artifact> artifacts;
    private String groupName;
    private String projectDescription;
    private String projectRatingID;

    /**
     * This class is the default constructor of Project class.
     */
    public Project() {}

    /**
     * This class is the constructor of PointQuestion class.
     * @param artifacts artifacts of the project
     * @param groupName the group name of the project
     * @param projectDescription the description of the project
     * @param projectRatingID the id of project rating
     */
    public Project(ArrayList<Artifact> artifacts, String groupName, String projectDescription, String projectRatingID)
    {
        setArtifacts(artifacts);
        setProjectDescription(projectDescription);
        setGroupName(groupName);
        setProjectRatingID(projectRatingID);
    }

    /**
     * This method gets the artifacts of the project
     * @return artifacts
     *
     */
    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }

    /**
     * This method sets the artifacts of the project
     * @param artifacts
     *
     */
    public void setArtifacts(ArrayList<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    /**
     * This method gets the artifacts of the project
     * @return groupName
     *
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method gets the group name who did the project
     * @param groupName
     *
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * This method gets the description of the project
     * @return projectDescription
     *
     */
    public String getProjectDescription() {
        return projectDescription;
    }

    /**
     * This method sets the project description
     * @param projectDescription
     *
     */
     public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    /**
     * This method gets the rate id of the project
     * @return projectRatingID
     *
     */
    public String getProjectRatingID() {
        return projectRatingID;
    }

    /**
     * This method sets the id of the project ratings
     * @param projectRatingID
     *
     */
    public void setProjectRatingID(String projectRatingID) {
        this.projectRatingID = projectRatingID;
    }
}
