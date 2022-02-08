package com.project.cs319.Entity;

/**
 * This is the OpenEnded Entity class of the application
 * It extends Question class
 */
public class OpenEndedQuestion extends Question
{
    /**
     * This class is the constructor of OpenEndedQuestion class.
     * @param question string of question
     */
    public OpenEndedQuestion(String question)
    {
        super(question,"open-ended");
    }

}
