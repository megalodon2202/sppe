import java.io.IOException;
import java.util.ArrayList;

public class tool {
    // if time1 is before time2, return -1
    // if time1 is after time2, return 1
    // if time1 is the same as time2, return 0
    // time format: mm/dd/yy hh:mm
    /**
     * This method is used to compare two time strings.
     * if time1 is before time2, return -1
     * if time1 is after time2, return 1
     * if time1 is the same as time2, return 0
     * time format: mm/dd/yy hh:mm
     * if there is a problem with the time format, return -2
     * @param time1Arr
     * @param time2Arr
     * @return 
     */
    public static int timeCmpTo(String time1Arr, String time2Arr) {
        String[] time1 = time1Arr.split(" ");
        String[] time2 = time2Arr.split(" ");
        String[] date1 = time1[0].split("/");
        String[] date2 = time2[0].split("/");
        String[] time1_ = time1[1].split(":");
        String[] time2_ = time2[1].split(":");
        try {
            int date1_ = Integer.parseInt(date1[0]) * 10000 + Integer.parseInt(date1[1]) * 100
                    + Integer.parseInt(date1[2]);
            int date2_ = Integer.parseInt(date2[0]) * 10000 + Integer.parseInt(date2[1]) * 100
                    + Integer.parseInt(date2[2]);
            int time1__ = Integer.parseInt(time1_[0]) * 100 + Integer.parseInt(time1_[1]);
            int time2__ = Integer.parseInt(time2_[0]) * 100 + Integer.parseInt(time2_[1]);
            if (date1_ < date2_) {
                return -1;
            } else if (date1_ > date2_) {
                return 1;
            } else {
                if (time1__ < time2__) {
                    return -1;
                } else if (time1__ > time2__) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return -2;
        }
    }

    
    /**
     * This method is used to check if a time string is in a certain seasno range.
     * if time is in the range, return 1
     * if time is not in the range, return 0
     * time format: mm/dd/yy hh:mm
     * if there is a error, return -1 and print the error
     * @param date
     * @param season
     * @return
     */
    public static int isInSeason(String date, String season) {
        String[] spring = { "03/21 00:00", "06/20 23:59" };
        String[] summer = { "06/21 00:00", "09/20 23:59" };
        String[] fall = { "09/21 00:00", "12/20 23:59" };
        String[] winter = { "12/21 00:00", "03/20 23:59" };
        String start = "";
        String end = "";
        int result = -1;
        try {

            switch (season.toLowerCase()) {
                case "spring":
                    start = date.split("/")[2].split(" ")[0] + "/" + spring[0];
                    end = date.split("/")[2].split(" ")[0]+ "/" + spring[1];
                    break;
                case "summer":
                    start = date.split("/")[2].split(" ")[0]+ "/" + summer[0];
                    end = date.split("/")[2].split(" ")[0]+ "/" + summer[1];
                    break;
                case "fall":
                    start = date.split("/")[2].split(" ")[0]+ "/" + fall[0];
                    end = date.split("/")[2].split(" ")[0]+ "/" + fall[1];
                    break;
                case "winter":
                    start = date.split("/")[2].split(" ")[0]+ "/" + winter[0];
                    end = date.split("/")[2].split(" ")[0]+ "/" + winter[1];
                    break;

                default:
                    throw new Exception("season is not spring, summer, fall, or winter");
            }
        } catch (Exception e) {
            System.out.println(e);
            return result;
        }
        if (timeCmpTo(start, date) == 0 || timeCmpTo(end, date) == 0
                || (timeCmpTo(start, date) == -1 && timeCmpTo(end, date) == 1)) {
            result = 1;
        } else {
            result = 0;
        }
        return result;

    }

    public static void main(String args[]) throws IOException {
        String timeOne = "01/01/01 01:01";
        String timeTwo = "02/01/01 01:01";
        System.out.println(timeCmpTo(timeOne, timeTwo));
        String regex = "[0-9]{2}/[0-9]{2}/[0-9]{2}";
        String time = "01/01/01 01:01";
        System.out.println(time.matches(regex));
        metric metrix = new metric();
        // ArrayList<String[]> result = metrix.searchByDate("12/1/10 8:26", "12/1/10
        // 8:26");
        ArrayList<String[]> result = metrix.searchBySeason("summer");
        metrix.toString(result);
    }
}
