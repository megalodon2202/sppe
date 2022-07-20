public class tool {
    //if time1 is before time2, return -1
    //if time1 is after time2, return 1
    //if time1 is the same as time2, return 0
    //time format: mm/dd/yy hh:mm


    public static int timeCmpTo(String time1Arr, String time2Arr) {
        String[] time1 = time1Arr.split(" ");
        String[] time2 = time2Arr.split(" ");
        String[] date1 = time1[0].split("/");
        String[] date2 = time2[0].split("/");
        String[] time1_ = time1[1].split(":");
        String[] time2_ = time2[1].split(":");
        int date1_ = Integer.parseInt(date1[0]) * 10000 + Integer.parseInt(date1[1]) * 100 + Integer.parseInt(date1[2]);
        int date2_ = Integer.parseInt(date2[0]) * 10000 + Integer.parseInt(date2[1]) * 100 + Integer.parseInt(date2[2]);
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
    }

    //season to start and end time
    public static String[] seasonToTime(String season) {
        String[] time = new String[2];
        switch (season) {
            case "spring":
                time[0] = "03/01/20 00:00";
                time[1] = "06/30/20 23:59";
                break;
            case "summer":
                time[0] = "06/01/20 00:00";
                time[1] = "09/30/20 23:59";
                break;
            case "fall":
                time[0] = "09/01/20 00:00";
                time[1] = "12/31/20 23:59";
                break;
            case "winter":
                time[0] = "12/01/20 00:00";
                time[1] = "03/31/20 23:59";
                break;
            default:
                time[0] = "";
                time[1] = "";
                break;
        }
        return time;
    }

    public static void main(String args[]){
        String timeOne="01/01/01 01:01";
        String timeTwo="02/01/01 01:01";
        System.out.println(timeCmpTo(timeOne,timeTwo));
    }
}
