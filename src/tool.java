public class tool {
    public tool(){

    }

    //format:12/1/10 8:26
    //format: MM/DD/YY HH:MM
    public int getDate(String ufs){
        String[] _time = ufs.split(" ");
        String[]_date=_time[0].split("/");
        return Integer.parseInt(_date[1]);
    }

    public int getMonth(String ufs){
        String[] _time = ufs.split(" ");
        String[]_date=_time[0].split("/");
        return Integer.parseInt(_date[0]);
    }

    public int getYear(String ufs){
        String[] _time = ufs.split(" ");
        String[]_date=_time[0].split("/");
        return Integer.parseInt(_date[2]);
    }

    public int getHour(String ufs){
        String[] _time = ufs.split(" ");
        String[]_date=_time[1].split(":");
        return Integer.parseInt(_date[0]);
    }

    public int getMin(String ufs){
        String[] _time = ufs.split(" ");
        String[]_date=_time[1].split(":");
        return Integer.parseInt(_date[1]);
    }
}
