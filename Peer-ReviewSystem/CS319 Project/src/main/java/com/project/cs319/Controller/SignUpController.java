package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/SignUpController")
public class SignUpController {

    private mongoDB database = new mongoDB();

    public SignUpController()
    {
        database = new mongoDB();
    }

    @GetMapping("/signUp")
    public void signUp( String name, String surname, String email, String password, int schoolID,String userRole){
        User u = new User(name, surname, email, password, schoolID,userRole);
        database.insertUser(u);
    }
    @GetMapping("/getUserInformation")
    public String getUserInformation(int schoolID) throws JSONException {
        database = new mongoDB();
        User u = database.getUser(schoolID);
        JSONObject user = new JSONObject();
        user.put("name",u.getName());
        user.put("surname", u.getSurname());
        user.put("id", u.getSchoolId());
        user.put("email", u.getEmail());
        user.put("userRole",u.getUserRole());
        return user.toString();

    }
    @GetMapping("/login")
    public String login(int schoolID) throws JSONException {
        System.out.println(schoolID);
        User u1 = database.getUser(schoolID);

        JSONObject obj = new JSONObject();
        obj.put("name",u1.getName());
        obj.put("surname", u1.getSurname());
        obj.put("id", u1.getSchoolId());
        obj.put("email", u1.getEmail());
        obj.put("password", u1.getPassword());
        obj.put("userRole",u1.getUserRole());
        return obj.toString();
    }

    @GetMapping("/validateUser")
    public String validateUser(int schoolID, String password) {
        User u1 = database.getUser(schoolID);
        if(u1.getPassword().equals(password)) {
            return "true";
        }
        return "false";
    }
}