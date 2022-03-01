import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.Month;

class t1 {
    public static void main(String[] args) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/M/dd hh:mm:ss", Locale.ENGLISH);

            // time of death
            // user will select the time in their's timezone
            String dateInString = "2022/1/15 10:15:55";
            System.out.println("User selected time of death : " + dateInString);
            Date date = formatter.parse(dateInString);

            Calendar calendar = new GregorianCalendar();

            // set the time zone as GMT/UTC
            // save the UTC time in database
            calendar.setTimeZone(TimeZone.getTimeZone("GMT/UTC"));
            calendar.setTime(date);

            System.out.println("Time of death in UTC : " + calendar.get(Calendar.YEAR)
                    + "/" + (Month.of(calendar.get(Calendar.MONTH) + 1))
                    + "/" + calendar.get(Calendar.DAY_OF_MONTH)
                    + " " + calendar.get(Calendar.HOUR_OF_DAY)
                    + ":" + calendar.get(Calendar.MINUTE)
                    + ":" + calendar.get(Calendar.SECOND));

            // now user from sri lanka
            // get time and set timezone in browser
            // Asia/Colombo
            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
            System.out.println("Time of death in Sri Lanka : " + calendar.get(Calendar.YEAR)
                    + "/" + (Month.of(calendar.get(Calendar.MONTH) + 1))
                    + "/" + calendar.get(Calendar.DAY_OF_MONTH)
                    + " " + calendar.get(Calendar.HOUR_OF_DAY)
                    + ":" + calendar.get(Calendar.MINUTE)
                    + ":" + calendar.get(Calendar.SECOND));

            // now user from New York
            // get time and set timezone in browser
            // America/New_York
            calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            System.out.println("Time of death in New York : " + calendar.get(Calendar.YEAR)
                    + "/" + (Month.of(calendar.get(Calendar.MONTH) + 1))
                    + "/" + calendar.get(Calendar.DAY_OF_MONTH)
                    + " " + calendar.get(Calendar.HOUR_OF_DAY)
                    + ":" + calendar.get(Calendar.MINUTE)
                    + ":" + calendar.get(Calendar.SECOND));

            // GregorianCalendar uses month in zero based index, Jan = 0 && Calender.Jan = 0
            // next time use
            // Time zone problem eliminated
            // If you follow the code seen here you will have no time zone problems.
            // None of this code depends on the JVM's current default time zone.
            // None of this code depends on the database server's current default time zone.
            // ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Etc/UTC"));
            // why - https://i.stack.imgur.com/bXtIS.pngv
        } catch (ParseException ex) {
            Logger.getLogger(t1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

// OUTPUT
// User selected time of death : 2022/01/15 10:15:55
// Time of death in UTC : 2022/JANUARY/15 4:45:55
// Time of death in Sri Lanka : 2022/JANUARY/15 10:15:55
// Time of death in New York : 2022/JANUARY/14 23:45:55
