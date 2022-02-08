package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This is the PointQuestion Entity class of the application
 * This class extends the Question class
 */
public class PointQuestion extends Question
{
    // variables
    private int outOfGrade;

    // Constructor

    /**
     * This class is the constructor of PointQuestion class.
     * @param question string of question
     * @param outOfGrade the out of grade of the question
     */
    public PointQuestion(String question, int outOfGrade)
    {
        super(question,"point-type");
        setOutOfGrade(outOfGrade);
    }

    /**
     * This method gets the out of grade of the question
     * @return outOfGrade
     *
     */
    public int getOutOfGrade() {
        return outOfGrade;
    }

    /**
     * This method sets the out of grade of the question
     * @param outOfGrade
     *
     */
    public void setOutOfGrade(int outOfGrade) {
        this.outOfGrade = outOfGrade;
    }
}
