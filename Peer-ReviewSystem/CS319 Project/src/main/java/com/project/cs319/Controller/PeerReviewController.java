package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PeerReviewController")
public class PeerReviewController {

    public static  mongoDB database;

    public PeerReviewController()
    {
        database = new mongoDB();
    }

    @GetMapping("/insertOpenEndedQuestion")
    public String insertOpenEndedQuestion(String question) {
        database = new mongoDB();
        return database.insertOpenEndedQuestion(question) ? "true" : "false";
    }

    @GetMapping("/insertMultipleChoiceQuestion")
    public boolean insertMultipleChoiceQuestion(String question,String choices)  {
        String[] parts = choices.split("-");

        ArrayList<String> list1 = new ArrayList<String>();
        for(String text:parts) {
            if(!text.equals("")) {
                list1.add(text);
            }
        }
        database = new mongoDB();
        return database.insertMultipleChoiceQuestion(question,list1);
    }

    @GetMapping("/insertPointQuestion")
    public boolean insertPointQuestion(String question, int outOfGrade) {
        database = new mongoDB();
        return database.insertPointQuestion(question, outOfGrade);
    }

    @GetMapping("/getPeerReviewQuestions")
    public String getPeerReviewQuestions() throws JSONException {
        database = new mongoDB();

        ArrayList<Question> questions = database.getPeerReviewQuestions();
        JSONObject jsonFinal = new JSONObject();
            JSONArray pageArray = new JSONArray();
                JSONObject pageArrayObject = new JSONObject();
                    JSONArray elementArray = new JSONArray();
                    for(int i=0; i<questions.size(); i++) {
                        if (questions.get(i).getQuestionType().equals("multiple-choice")) {
                            MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) questions.get(i);
                            ArrayList<String> choice = mcq.getChoices();
                            JSONObject question = new JSONObject();
                            // Add attributes of question
                            question.put("type", "radiogroup");
                            question.put("name", mcq.getQuestion());
                            // Create array of choices
                            JSONArray choices = new JSONArray();
                            for (int j = 0; j < choice.size(); j++) {
                                choices.put(choice.get(j));
                            }
                            // Add choices to the question JSONObject
                            question.put("choices", choices);
                            elementArray.put(question);
                        } else if(questions.get(i).getQuestionType().equals("open-ended")) {
                            OpenEndedQuestion oeq = (OpenEndedQuestion)questions.get(i);
                            JSONObject openEnded = new JSONObject();
                            openEnded.put("type", "text");
                            openEnded.put("name", oeq.getQuestion());
                            elementArray.put(openEnded);
                        } else {
                            PointQuestion pq = (PointQuestion) questions.get(i);
                            String question = pq.getQuestionType();
                            int max = pq.getOutOfGrade();
                            JSONObject fin = new JSONObject();
                            fin.put("type", "rating");
                            fin.put("name", pq.getQuestion());
                            fin.put("rateMax", pq.getOutOfGrade());
                            elementArray.put(fin);
                        }
                    }
                pageArrayObject.put("elements", elementArray);
            pageArray.put(pageArrayObject);
        jsonFinal.put("pages", pageArray);
        System.out.println(jsonFinal.toString());
        return jsonFinal.toString();
    }

    @GetMapping("/giveAnswerQuestions")
    public boolean giveAnswerQuestions(int giverId, int receiverId, String answer) {
        database = new mongoDB();
        ArrayList<String> ans = new ArrayList<String>();
        return database.giveAnswerQuestions(giverId,receiverId,ans);
    }

    @GetMapping("/getPeerReviewAnswers")
    public String getPeerReviewAnswers(int giverID, int receiverID) throws JSONException {
        database = new mongoDB();
//        JSONObject js = new JSONObject();
        String questions = "";
        ArrayList<String> list = database.getPeerReviewAnswers(giverID,receiverID);
        for(int i=0; i<list.size(); i++) {
            questions = questions + list.get(i) + "\n";
        }
        return questions;
    }

}
