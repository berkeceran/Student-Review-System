package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/OtherController")
public class OtherController {

    private mongoDB database;

    public OtherController() {
        database = new mongoDB();
    }

    @GetMapping("/insertContactUsInfo")
    public void insertContactUsInfo(String nameOfContact, String emailOfContact, String findUsHow, String choiceOfFindUs, String messageOfUser) {

    }
}
