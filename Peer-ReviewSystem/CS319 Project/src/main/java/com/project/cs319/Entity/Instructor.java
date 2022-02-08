package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This class is the Instructor Entity extended from User class.
 */
public class Instructor extends User {
    // Variables
    private ArrayList<Integer> sections;
    private ArrayList<ArrayList<Integer>> TAlist;

    // constructors
    /**
     * This class is the default constructor of Instructor class.
     */
    public Instructor() {}

    /**
     * This class is the constructor of Instructor class.
     * @param name of the instructor
     * @param surname of the instructor
     * @param email the email of the instructor
     * @param password of the instructor
     * @param schoolId of the instructor
     * @param sections the sections of the instructor
     * @param TAlist the ta list of the instructor
     */
    public Instructor(String name, String surname, String email, String password, int schoolId,
                      ArrayList<Integer> sections, ArrayList<ArrayList<Integer>> TAlist)
    {
       super(name,surname,email,password, schoolId, "instructor");
        this.sections = sections;
        this.TAlist = TAlist;
    }

    /**
     * This method gets the TA list of the instructor
     * @return TAlist
     */
    public ArrayList<ArrayList<Integer>> getTAlist() {
        return TAlist;
    }

    /**
     * This method sets the TA list of the instructor
     * @param taList
     */
    public void setTAlist(ArrayList<ArrayList<Integer>> taList) {
        this.TAlist = TAlist;
    }

    /**
     * This method gets the sections of the instructor
     * @return sections
     */
    public ArrayList<Integer> getSections() {
        return sections;
    }

    /**
     * This method gets the TA list of the instructor
     * @return TAlist
     */
    public void setSections(ArrayList<Integer> sections) {
        this.sections = sections;
    }
}
