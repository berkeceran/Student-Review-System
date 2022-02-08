package com.project.cs319.Entity;
import java.util.ArrayList;
import java.util.Map;

/**
 * This is the Project_Rating Entity class of the application
 */
public class Project_Rating {

    // variables
    private int rate;
    private ArrayList<Integer> ratersIDs;
    private Map<Integer,Integer> rateDistribution;

    // Constructor

    /**
     * This class is the default constructor of Project_Rating class.
     */
    public Project_Rating() {}

    /**
     * This class is the constructor of PointQuestion class.
     * @param rate the overall rate
     * @param ratersIDs the list of the ratersId
     * @param rateDistribution the rate distribution of rates
     */
    public Project_Rating(int rate, ArrayList<Integer> ratersIDs, Map<Integer,Integer> rateDistribution)
    {
        setRate(rate);
        setRatersIDs(ratersIDs);
        setRateDistribution(rateDistribution);
    }

    /**
     * This method gets the overall rate of the project
     * @return rate
     *
     */
    public int getRate() {
        return rate;
    }

    /**
     * This method sets the overall rate of the project
     * @param rate
     *
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * This method gets the ids' of the raters
     * @return ratersIDs
     *
     */
    public ArrayList<Integer> getRatersIDs() {
        return ratersIDs;
    }

    /**
     * This method sets the id of the raters
     * @param ratersIDs
     *
     */
    public void setRatersIDs(ArrayList<Integer> ratersIDs) {
        this.ratersIDs = ratersIDs;
    }

    /**
     * This method gets the rate distribution
     * @return rateDistribution
     *
     */
    public Map<Integer, Integer> getRateDistribution() {
        return rateDistribution;
    }

    /**
     * this method sets the distribution of rates
     * @param rateDistribution
     *
     */
    public void setRateDistribution(Map<Integer, Integer> rateDistribution) {
        this.rateDistribution = rateDistribution;
    }
}
