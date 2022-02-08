package com.project.cs319;
import com.project.cs319.Controller.*;
import com.project.cs319.DataBase.*;
import com.project.cs319.Entity.User;
import org.json.JSONException;

import java.util.ArrayList;

public class databaseTest {

    public static void main(String[] args) throws JSONException {
        mongoDB db = new mongoDB();
        UserController ct = new UserController();
        SectionController sc = new SectionController();
        SignUpController sign = new SignUpController();
        PeerReviewController pr = new PeerReviewController();

//        pr.insertOpenEndedQuestion("dsfgg");
//        ArrayList<String> ans = new ArrayList<>();
//        ans.add("gfd");
//        ans.add("sdfs");
//        db.insertMultipleChoiceQuestion("sdfdf", ans);
//        ArrayList<String> a = new ArrayList<>();
//        a.add("sdffghg");
//        pr.getPeerReviewQuestions();
//        pr.giveAnswerQuestions(113,112,a);
//        pr.getPeerReviewAnswers(113, 112);
//        sign.signUp("akmami", "ash", "akmuhammet99@gmail.com", "pass", 218, "admin");
//        User instructor = new User("Aynur", "Adayanik","ayananik@bilkent.com", "pass",200,"user");
//        User st1 = new User("Mert","Yildirim","mert2bilejnt.edu.tr","pass", 201,"user");
//        User st2 = new User("Cagtay","Kutlu","ck@bilejnt.edu.tr","pass", 202,"user");
//        User st3 = new User("Elif","Tugay","et@bilejnt.edu.tr","pass", 203,"user");
////        // Add Students
//        db.insertUser(instructor);
//        db.insertUser(st1);
//        db.insertUser(st2);
//        db.insertUser(st3);
////
////        // Assign role to Instructor
//        ct.assignRoleToUser(200, "instructor");
////
////        // Add section
//        sc.addSection(1, 2);
////
////        // Ass students to section
//        sc.addUserToSection(201, 1);
//        sc.addUserToSection(202, 1);
//        sc.addUserToSection(203, 1);

            GroupFormationController df = new GroupFormationController();
//            df.addGithubLink("sdef", "CS319-1a", "bos");
////            df.randomGeneratorAllSections(3);
////            db.removeGroup("CS319-3a");
            df.removeUserFromGroup(201);
        df.removeUserFromGroup(203);
//             df.removeUserFromGroup(1);
//        System.out.println(sc.getSectionOfStudent(111));

    }
}
