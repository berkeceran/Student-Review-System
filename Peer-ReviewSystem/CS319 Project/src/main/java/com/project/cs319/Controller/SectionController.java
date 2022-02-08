package com.project.cs319.Controller;
import com.project.cs319.DataBase.*;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SectionController")
public class SectionController {
    private  mongoDB database;

    public SectionController(){ database = new mongoDB();}

    @GetMapping("/addSection")
    public String addSection(int sectionNumber, int instructorID)
    {
        database = new mongoDB();
        return database.createSection(sectionNumber, instructorID) ? "true" : "false";
    }

    @GetMapping("/addUserToSection")
    public String addUserToSection(int schoolID, int sectionNumber)
    {
        database = new mongoDB();
        return database.insertUserToSection(schoolID, sectionNumber)  ? "true" : "false";
    }

    @GetMapping("/getGroupsOfSection")
    public String getGroupsOfSection(int sectionNumber) throws JSONException {
        database = new mongoDB();
        JSONArray array = new JSONArray();
        ArrayList<String> groups = database.getGroupsOfSection(sectionNumber);
        for (int i=0; i<groups.size(); i++) {
            array.put(groups.get(i));
        }
        return array.toString();
    }

    @GetMapping("/getAllSectionNames")
    public String getAllSectionNames() throws JSONException {
        JSONObject obj = new JSONObject();
        ArrayList<Integer> sections = database.getAllSectionNames();
        for (int i=0; i<sections.size(); i++) {
            obj.put(""+i, (int)sections.get(i));
        }
        return obj.toString();
    }
    // Get instructors sections
    @GetMapping("/getAllSectionsOfInstructor")
    public String getAllSectionsOfInstructor(int instructorID) throws JSONException
    {
        database = new mongoDB();
        ArrayList<Integer> sections = database.getAllSectionsOfInstructor(instructorID);
        JSONArray array = new JSONArray();
        StringBuilder sct = new StringBuilder();
        for (int i=0; i<sections.size(); i++) {
            array.put(sections.get(i));
        }
        System.out.println(array.toString());
        return array.toString();
    }

    @GetMapping("/getSectionOfStudent")
    public String getSectionOfStudent(int studentID)
    {
        System.out.println("The section of user " + studentID + " is " + database.getSectionOfStudent(studentID));
        return "" + database.getSectionOfStudent(studentID);
    }
}
