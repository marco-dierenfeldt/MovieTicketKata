package de.saxsys.dojo.ticketkata;

/**
 * Cashregister implementation that is able to support the salesprocess of
 * multiple tickets for a movie as defined in the
 * <code>TicketKataInterface</code>.
 * <table width="500px" border="1">
 * <tr>
 *  <th colspan="2" align ="left" bgcolor="#CCCCFF">Basic admission rates (regular weekday, 2D movie, &lt;=120 min, parquet)</th>
 * </tr>
 * <tr><td>General admission</td><td>$11.00</td></tr>
 * <tr><td>Students</td><td>$8.00</td></tr>
 * <tr><td>Senior Citizens (65 & older)</td><td>$6.00</td></tr>
 * <tr><td>Children (under 13)</td><td>$5.50</td></tr>
 * <tr><td>Group (20 people or more)</td><td>$6.00 each</td></tr>
 *
 * <tr><th colspan="2" align="left" bgcolor="#CCCCFF">Exceptions</th></tr>
 * <tr><td>3D movie</td><td>+$3.00</td></tr>
 * <tr><td>Over-length (more than 120 min.)</td><td>+$1.50</td></tr>
 * <tr><td>Movie Day (Thurdsday, except for groups!)</td><td>-$2.00</td></tr>
 * <tr><td>Weekends</td><td>+$1.50</td></tr>
 * <tr><td>Loge</td><td>+$2.00</td></tr>
 * </table>
 * @author Marco Dierenfeldt
 * @version 0.1
 * @see TicketKataInterface
 */
public class CinemaCashRegister implements TicketKataInterface {

    //defining the constant values for the cashregister
    private final float GENERAL_ADMISSION_FEE = 11.00f;
    private final float STUDENTS_FEE = 8.00f;
    private final float SENIOR_CITIZENS_FEE = 6.00f;
    private final float CHILDREN_FEE = 5.50f;
    private final float GROUP_FEE = 6.00f;
    private final float MOVIE_3D_ADDITION = 3.00f;
    private final float OVERLENGTH_ADDITION = 1.50f;
    private final float MOVIE_DAY_RESIDUE = 2.00f;
    private final float WEEKEND_ADDITION = 1.50f;
    private final float LOGE_ADDITION = 2.00f;
    private final int OVERLENGTH_LIMIT = 120;
    private final int SENIOR_AGE_LIMIT = 64;
    private final int CHILDREN_AGE_LIMIT = 13;
    private final int GROUP_LIMIT = 20;
    private final Day MOVIE_DAY = Day.THU;


    private Day day = null;
    private float priceModificator = 0.0f;
    private float sum = 0.0f;
    private int numberOfTickets = 0;

    /**
     * (1) New customers arrive at your ticket booth and tell you
     * what movie they'd like to see (so keep it in mind ;-)
     *
     * @param runtime       movie's runtime in minutes
     * @param day           day of the week (enum)
     * @param isParquet     true if seating category is 'parquet' (and not 'loge')
     * @param is3D          true if the movie's shown in 3D
     */
    public void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D) {
        /* re-init numberOfTickets, sum and priceModificator because this
           object could be used multiple times */
        numberOfTickets = 0;
        priceModificator = 0.0f;
        sum = 0.0f;
        
        this.day = day;

        //calculate the priceModificator
        if (is3D) {
            priceModificator += MOVIE_3D_ADDITION;
        }
        if (!isParquet) {
            priceModificator += LOGE_ADDITION;
        }
        if (day.equals(MOVIE_DAY)) {
            priceModificator -= MOVIE_DAY_RESIDUE;
        }
        if (day.equals(Day.SAT) || day.equals(Day.SUN)) {
            priceModificator += WEEKEND_ADDITION;
        }
        if (runtime > OVERLENGTH_LIMIT) {
            priceModificator += OVERLENGTH_ADDITION;
        }
    }

    /**
     * (2) Add a ticket to the customers' bill
     *
     * @param age           the age of the ticket buyer in years
     * @param isStudent     true if the ticket buyer is a student
     */
    public void addTicket(int age, boolean isStudent) {
        numberOfTickets++;

        if (isStudent && age <= SENIOR_AGE_LIMIT && age >= CHILDREN_AGE_LIMIT) {
            sum += STUDENTS_FEE;
        } else {
            if (age > SENIOR_AGE_LIMIT) {
                sum += SENIOR_CITIZENS_FEE;
            } else {
                if (age < CHILDREN_AGE_LIMIT) {
                    sum += CHILDREN_FEE;
                } else {
                    sum += GENERAL_ADMISSION_FEE;
                }
            }
        }

        sum += priceModificator;
    }

    /**
     * (3) Calculate the total admission for the current customer(s)
     *
     * @return  total in dollars
     */
    public float finishPurchase() {
        if (numberOfTickets >= GROUP_LIMIT) {
            if (day.equals(MOVIE_DAY)) {
                //no residue on moviedays for groups
                priceModificator += MOVIE_DAY_RESIDUE;
            }
            float groupSum = (GROUP_FEE + priceModificator) * numberOfTickets;
            sum = (groupSum < sum) ? groupSum : sum;
        }

        return sum;
    }
}
