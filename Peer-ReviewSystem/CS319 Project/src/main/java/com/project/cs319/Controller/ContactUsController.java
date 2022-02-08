package com.project.cs319.Controller;

import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import java.util.Hashtable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ContactUsController {
    private  mongoDB database;

    public ContactUsController()
    {
        database = new mongoDB();
    }


    public void addContactRequest(String name, String email, String howFound, String message)
    {
        database = new mongoDB();
        database.addContactRequest(name,email,howFound,message);
    }


}
