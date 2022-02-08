package com.project.cs319.Controller;
import com.project.cs319.DataBase.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserController")
public class UserController {

    private mongoDB database = new mongoDB();

    public UserController()
    {
        database = new mongoDB();
    }

    @GetMapping("/assignRoleToUser")
    public void assignRoleToUser(int schoolID, String role)
    {
        // Testing purposes
        System.out.println("buraya geldi.");
        String oldRole = database.getUser(schoolID).getUserRole();
        database = new mongoDB();
        database.assignRoleToUser(schoolID, role);
        System.out.println("User " + schoolID + " was " + oldRole + " but now " + database.getUser(schoolID));
    }
}
