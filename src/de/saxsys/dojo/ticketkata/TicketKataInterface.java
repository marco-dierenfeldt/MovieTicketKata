package de.saxsys.dojo.ticketkata;

/**
 * Interface for the coding dojo TicketKata
 *
 * @author x9dfd
 * @version 0.1
 */
public interface TicketKataInterface {

    /**
     * (1) New customers arrive at your ticket booth and tell you
     * what movie they'd like to see (so keep it in mind ;-)
     *
     * @param runtime       movie's runtime in minutes
     * @param day           day of the week (enum)
     * @param isParquet     true if seating category is 'parquet' (and not 'loge')
     * @param is3D          true if the movie's shown in 3D
     */
    void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D);

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age           the age of the ticket buyer in years
     * @param isStudent     true if the ticket buyer is a student
     */
    void addTicket(int age, boolean isStudent);

    /**
     * (3) Calculate the total admission for the current customer(s)
     *
     * @return  total in dollars
     */
    float finishPurchase();
}

/** Custom enum to represent the 7 days of the week */
enum Day { SUN, MON, TUE, WED, THU, FRI, SAT; }