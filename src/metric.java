import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class metric {
    private dbAccessor dbAccess;

    public metric() throws IOException {
        dbAccess = new dbAccessor();
        URL url = new URL(
                "https://nrc.canada.ca/en/certifications-evaluations-standards/canadas-official-time/3-when-do-seasons-start");
        InputStream thepage = url.openStream();
        Scanner readRow = new Scanner(thepage);

    }

    // metric: Search by country name
    // returns an ArrayList of String Array
    // each ArrayList is an individual row
    public ArrayList<String[]> searchByCountry(String country) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        ArrayList<String> colHData = dbAccess.getColH();
        for (int i = 0; i < colHData.size(); i++) {
            if (colHData.get(i).compareToIgnoreCase(country) == 0) {
                data.add(dbAccess.getRow(i));
            }
        }
        return data;
    }

    // metric: search by price
    // returns an ArrayList of String Array
    // low<=x & high>=x
    // if want an exact price, low==high
    public ArrayList<String[]> searchByUnitPrice(int low, int high) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        // parsh
        return data;
    }

    // metric: search by quantity
    // returns an ArrayList of String Array
    // low<=x & high>=x
    // if want an exact quantity, low==high
    public ArrayList<String[]> searchByUnitQuantity(int low, int high) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        // parsh
        return data;
    }

    // metric: search by date
    // date format mm/dd/yy hh:mm
    // use of date constructor (tool.java)
    // from<=x & upto>=x
    // if want an exact time, from==upto
    /**
     * metric: search by date
     * date format mm/dd/yy hh:mm
     * use of date constructor (tool.java)
     * from<=x & upto>=x
     * if want an exact time, from==upto
     * 
     * @param from
     * @param upto
     * @return
     */
    public ArrayList<String[]> searchByDate(String from, String upto) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        // zihan
        String regex = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,2}";
        if (from.equals(upto)) {
            boolean i = true;
            int j = 1;
            if (from.matches(regex)) {
                from += " 00:00";
            }
            for (String cur : dbAccess.getColE()) {
                if (i) {
                    i = false;
                    continue;
                }
                if (cur.matches(regex)) {
                    cur += " 00:00";
                }
                if (tool.timeCmpTo(cur, from) == 0) {
                    data.add(dbAccess.getRow(j));
                }
                j++;
            }
        } else {
            boolean i = true;
            int j = 1;
            if (from.matches(regex)) {
                from += " 00:00";
            }
            if (upto.matches(regex)) {
                upto += " 23:59";
            }
            for (String cur : dbAccess.getColE()) {
                if (i) {
                    i = false;
                    continue;
                }
                if (cur.matches(regex)) {
                    cur += " 00:00";
                }
                if (tool.timeCmpTo(cur, from) >= 0 && tool.timeCmpTo(cur, upto) <= 0) {
                    data.add(dbAccess.getRow(j));
                }
                j++;
            }
        }
        return data;
    }

    // options: spring, summer, fall, winter
    // season timing: pick recent or make an average and then implement the average
    // timing
    // https://nrc.canada.ca/en/certifications-evaluations-standards/canadas-official-time/3-when-do-seasons-start
    // returns an ArrayList of String Array
    /**
     * options: spring, summer, fall, winter
     * season timing:
     * spring = { "03/21 00:00", "06/20 23:59" }
     * summer = { "06/21 00:00", "09/20 23:59" }
     * fall = { "09/21 00:00", "12/20 23:59" }
     * winter = { "12/21 00:00", "03/20 23:59" }
     * 
     * @param season
     * @return
     */
    public ArrayList<String[]> searchBySeason(String season) {
        // zihan
        ArrayList<String[]> result = new ArrayList<String[]>();
        boolean i = true;
        int j = 1;
        for (String cur : dbAccess.getColE()) {
            if (i) {
                i = false;
                continue;
            }
            if (tool.isInSeason(cur, season) == 1) {
                result.add(dbAccess.getRow(j));
            }
            j++;
        }
        return result;

    }

    // metric: search by customer
    // note: each customer is identified by a unique id
    // returns an ArrayList of String Array
    public ArrayList<String[]> searchByCustomer(String id) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        for (int i = 0; i < dbAccess.getColG().size(); i++) {
            if (dbAccess.getColG().get(i).compareToIgnoreCase(id) == 0) {
                data.add(dbAccess.getRow(i));
            }
        }
        return data;
    }

    // metric: search by product name
    public ArrayList<String[]> searchByProduct(String stockCode) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        // jashan
        return data;
    }

    // test your metric
    public void toString(ArrayList<String[]> data) {
        String[] row;
        String print = "";
        for (int i = 0; i < data.size(); i++) {
            row = data.get(i);
            for (int j = 0; j < row.length; j++) {
                print += "[" + row[j] + "] ";
            }
            print += "\n";
        }
        System.out.println(print);
    }
}
