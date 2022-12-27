import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;

public class Problem19 {
    /*
    Counting Sundays
    Submit

    You are given the following information, but you may prefer to do some
    research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century unless
    it is divisible by 400.
    How many Sundays fell on the first of the month during the twentieth century
    (1 Jan 1901 to 31 Dec 2000)?
     */

    public static int numTwentiethCenturySundays(){
        int numSundays = 0;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1901,Calendar.JANUARY, 1);

        while (true) {// loop til end date

            // compare Day Of Week to Sunday, and day of month to 1, increment count
            if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY &&
                    calendar.get(Calendar.DAY_OF_MONTH)==1) {
                numSundays++;
                //System.out.println(calendar.getTime());
            }
            if( calendar.get(Calendar.YEAR) == 2000 &&
                calendar.get(Calendar.MONTH)==Calendar.DECEMBER &&
                calendar.get(Calendar.DAY_OF_MONTH)==31
            )
                break; // break at end date

            // Add one day
            calendar.add(Calendar.DATE, 1);
        }
        return numSundays;
    }

    public static void main(String[] args) {
        System.out.println(numTwentiethCenturySundays()); // 171
    }

}
