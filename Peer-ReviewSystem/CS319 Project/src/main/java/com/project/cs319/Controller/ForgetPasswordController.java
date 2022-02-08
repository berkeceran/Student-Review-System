package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;


public class ForgetPasswordController {
    public static  mongoDB database;

    public ForgetPasswordController(){database = new mongoDB();}

    public void performForgetPassword(String email, int schoolID)
    {
        database.performForgetPassword(email,schoolID);
    }

}
