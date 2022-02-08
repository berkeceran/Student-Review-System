package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GroupFormationController")
public class GroupFormationController {
    private  mongoDB database;
    private ArrayList<User> membersOfGroup;

    public GroupFormationController(){
        database = new mongoDB();
    }

    @GetMapping("/randomGeneratorAllSections")
    public void randomGeneratorAllSections(int size) throws JSONException {
        database = new mongoDB();
        SectionController s = new SectionController();
        String sectionNumbers = s.getAllSectionNames();
        JSONObject array = new JSONObject(sectionNumbers);
        ArrayList<Integer> remainStudents = new ArrayList<>();
        // For each section
        for (int i = 0; i < array.names().length(); i++) {
            // Assign remaining students to the students ArrayList
            // Print All Remaining Users
            System.out.println( randomGenerator(size, Integer.parseInt(array.getString("" + i))));
        }
    }

    @GetMapping("/randomGenerator")
    public  String randomGenerator(int size, int sectionID) {
        if (database == null) {
            database = new mongoDB();
        }
        int numberOfStudent = database.getNumberOfStudentsFromSection(sectionID);
        int groupSize = size;

        ArrayList<Integer> idOfStudentsInSection = database.getAllStudentsIdFromSection(sectionID);

        Collections.shuffle(idOfStudentsInSection, new Random());

        char groupName = 'a';
        int index =0;
        for (int i = 0; i < (Integer) (numberOfStudent / groupSize); i++, groupName++) {
            String groupID = "CS319-" + sectionID + groupName;

            // database
            database.createGroup(groupID);
            for (int whileIndex = 0; whileIndex < groupSize; whileIndex++, index++) {
                database.insertStudentToGroup(groupID, idOfStudentsInSection.get(whileIndex + groupSize * i), sectionID);
            }
        }
        if(index == numberOfStudent)
        {
            return null;
        }
        ArrayList<Integer> remainStudents = new ArrayList<Integer>();
        for(int i = index;  i < numberOfStudent; i++)
        {
            remainStudents.add(idOfStudentsInSection.get(i));

        }
        System.out.println((new JSONArray(remainStudents)).toString());
        return (new JSONArray(remainStudents)).toString();
    }

    @GetMapping("/notRandomGenerator")
    public String notRandomGenerator(int sectionID, int studentID) throws JSONException {
        database = new mongoDB();
        JSONObject arr = new JSONObject();
        arr.put("result", ""+database.createGroupByUser(sectionID,studentID));
        arr.put("group", database.getGroupNameFromStudent(sectionID));
        return arr.toString();
    }

    @GetMapping("/notRandomGeneratorAddMember")
    public void notRandomGeneratorAddMember(int studentID, String groupName, int sectionID) {
        database = new mongoDB();
        database.insertStudentToGroup(groupName,studentID,sectionID);
    }

    @GetMapping("/removeUserFromGroup")
    public String removeUserFromGroup(int studentID) {
        database = new mongoDB();
        return database.removeUserFromGroup(studentID) ? "true" : "false";
    }

    @GetMapping("/removeGroup")
    public String removeGroup(String name) {
        Group gr = database.getGroup(name);
        for(int i=0; i<gr.getStudentIDs().size(); i++) {
            if(removeUserFromGroup(gr.getStudentIDs().get(i)).equals("true") ) {
                System.out.println("User " + gr.getStudentIDs().get(i) + " couldn't removed from group.");
            }
        }
        return "true";
    }

    @GetMapping("/addGithubLink")
    public void addGithubLink(String link, String groupName, String description)
    {
        System.out.println(link + " " + groupName + " " + description);
        database.addGithubLink(link, groupName,description);
    }

    @GetMapping("/getGithubLink")
    public String getGithubLink(String groupName) {
        if (database == null) {
            database = new mongoDB();
        }
        JSONArray json = new JSONArray();

        ArrayList<String> arr = database.getGithubLink(groupName);
        for(int i=0; i<arr.size(); i++) {
            json.put(arr.get(i));
        }
        return json.toString();
    }

    @GetMapping("/getGroupMembers")
    public String getGroupMembers(String groupID) {
        if (database == null) {
            database = new mongoDB();
        }
        ArrayList<Integer> students = database.getGroup(groupID).getStudentIDs();
        JSONArray json = new JSONArray();
        for(int i=0; i<students.size(); i++) {
            json.put(""+students.get(i));
        }
        System.out.println("burda bastııı");
        return json.toString();
    }
}
