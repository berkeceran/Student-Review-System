package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This is the MultipleChoiceQuestion Entity class of the application
 * It extends the Question class
 */
public class MultipleChoiceQuestion extends Question
{
    // variables
    private ArrayList<String> choices;

    /**
     * This class is the constructor of Instructor class.
     * @param question string of question
     * @param  choices the choices of the question
     */
    public MultipleChoiceQuestion(String question, ArrayList<String> choices)
    {
        super(question,"multiple-choice");
        setChoices(choices);
    }

    /**
     * This method gets the choices list of the question
     * @return choices
     *
     */
    public ArrayList<String> getChoices() {
        return choices;
    }

    /**
     * This method sets the choices of the question
     * @return choices
     *
     */
    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

}
