package de.saxsys.dojo.ticketkata;

/**
 * Cashregister implementation that is able to support the salesprocess of
 * multiple tickets for a movie as defined in the
 * <code>TicketKataInterface</code>.
 *
 * Basic admission rates (regular weekday, 2D movie, &lt;=120 min, parquet)
 * General admission 	                      $11.00
 * Students                                   $8.00
 * Senior Citizens (65 & older) 	      $6.00
 * Children (under 13)                        $5.50
 * Group (20 people or more)                  $6.00 each
 *
 * Exceptions *******************************************
 * 3D movie                                  +$3.00
 * Over-length (more than 120 min.)          +$1.50
 * Movie Day (Thurdsday, except for groups!) -$2.00
 * Weekends                                  +$1.50
 * Loge                                      +$2.00
 *
 * @author Marco Dierenfeldt
 * @version 0.1
 */
public class CinemaCashRegister implements TicketKataInterface {

    private final float generalAdmissionFee = 11.00f;
    private final float studentsFee = 8.00f;
    private final float seniorCitizensFee = 6.00f;
    private final float childrenFee = 5.50f;
    private final float groupFee = 6.00f;
    private final float movie3dAddition = 3.00f;
    private final float overlengthAddition = 1.50f;
    private final float movieDayResidue = 2.00f;
    private final float weekendAddition = 1.50f;
    private final float logeAddition = 2.00f;
    private final int overlengthLimit = 120;
    private final int seniorAgeLimit = 64;
    private final int childrenAgeLimit = 13;
    private final int groupLimit = 20;
    private final Day movieDay = Day.THU;
    private Day day = null;
    private float priceModificator = 0.0f;
    private float sum = 0.0f;
    private int numberOfTickets = 0;

    public void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D) {
        this.day = day;

        if (is3D) {
            priceModificator += movie3dAddition;
        }
        if (!isParquet) {
            priceModificator += logeAddition;
        }
        if (day.equals(movieDay)) {
            priceModificator -= movieDayResidue;
        }
        if (day.equals(Day.SAT) || day.equals(Day.SUN)) {
            priceModificator += weekendAddition;
        }
        if (runtime > overlengthLimit) {
            priceModificator += overlengthAddition;
        }
    }

    public void addTicket(int age, boolean isStudent) {
        numberOfTickets++;

        if (isStudent && age <= seniorAgeLimit && age >= childrenAgeLimit) {
            sum += studentsFee;
        } else {
            if (age > seniorAgeLimit) {
                sum += seniorCitizensFee;
            } else {
                if (age < childrenAgeLimit) {
                    sum += childrenFee;
                } else {
                    sum += generalAdmissionFee;
                }
            }
        }

        sum += priceModificator;
    }

    public float finishPurchase() {
        if (numberOfTickets >= groupLimit) {
            if (day.equals(movieDay)) {
                //no residue on moviedays for groups
                priceModificator += movieDayResidue;
            }
            float groupSum = (groupFee + priceModificator) * numberOfTickets;
            sum = (groupSum < sum) ? groupSum : sum;
        }

        return sum;
    }
}
