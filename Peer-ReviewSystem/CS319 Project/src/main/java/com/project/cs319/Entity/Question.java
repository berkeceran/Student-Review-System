package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This is the Question Entity class of the application
 */
public class Question
{
    // variables
    private String question;
    private String questionType;

    // Constructors

    /**
     * This class is the default constructor of Question class.
     */
    public Question() {}

    /**
     * This class is the  constructor of Question class
     * @param question the string type of question
     * @param questionType the type of the question
     */
    public Question(String question,String questionType)
    {
        this.question = question;
        this.questionType = questionType;
    }

    /**
     * This method gets the string version of the question
     * @return question
     *
     */
    public String getQuestion() {
        return question;
    }

    /**
     * this method sets the question
     * @param question
     *
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * This method gets the question type e.g. open-ended or multiple-choice
     * @return questionType
     *
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     *
     * @param questionType
     * sets the type of the question
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
