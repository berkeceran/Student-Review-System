package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import java.util.Hashtable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ArtifactReviewController")
public class ArtifactReviewController
{
    public static  mongoDB database;

    public ArtifactReviewController()
    {
        database = new mongoDB();
    }

    @GetMapping("/giveArtifactReviewToGroup")
    public String giveArtifactReviewToGroup(String groupName, String artifactType, String answer, int giverID)
    {
        if(database == null) {
            database = new mongoDB();
        }
        database = new mongoDB();
        return database.giveArtifactReviewToGroup(groupName, artifactType, answer, giverID) ? "true" : "false";
    }

    @GetMapping("/getArtifactReviewFromGroup")
    public Hashtable<Integer,String> getArtifactReviewFromGroup(String groupName, String artifactType)
    {
        if(database == null) {
            database = new mongoDB();
        }

        return database.getArtifactReviewFromGroup(groupName,artifactType);
    }

}