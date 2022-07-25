import java.util.ArrayList;
public class metric {
    private dbAccessor dbAccess;
    public metric(){
        dbAccess=new dbAccessor();
    }

    //metric: Search by country name
    //returns an ArrayList of String Array
    //each ArrayList is an individual row
    public ArrayList<String[]> searchByCountry(String country){
        ArrayList<String[]>data=new ArrayList<String[]>();
        ArrayList<String>colHData = dbAccess.getColH();
        for(int i=0; i<colHData.size(); i++){
            if(colHData.get(i).compareToIgnoreCase(country)==0){
                data.add(dbAccess.getRow(i));
            }
        }
        return data;
    }

    //metric: search by price
    //returns an ArrayList of String Array
    //low<=x & high>=x
    //if want an exact price, low==high
    public ArrayList<String[]> searchByUnitPrice(int low, int high){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //parsh
        return data;
    }

    //metric: search by quantity
    //returns an ArrayList of String Array
    //low<=x & high>=x
    //if want an exact quantity, low==high
    public ArrayList<String[]> searchByUnitQuantity(int low, int high){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //parsh
        return data;
    }

    //metric: search by date
    //date format mm/dd/yy hh:mm
    //use of date constructor (tool.java)
    //from<=x & upto>=x
    //if want an exact time, from==upto
    public ArrayList<String[]> searchByDate(String from, String upto){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //zihan
        return data;
    }

    //options: spring, summer, fall, winter
    //season timing: pick recent or make an average and then implement the average timing
    //https://nrc.canada.ca/en/certifications-evaluations-standards/canadas-official-time/3-when-do-seasons-start
    //returns an ArrayList of String Array
    public ArrayList<String[]> searchBySeason(String season){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //zihan
        return data;
    }

    //metric: search by customer
    //note: each customer is identified by a unique id
    //returns an ArrayList of String Array
    public ArrayList<String[]> searchByCustomer(String id){
        ArrayList<String[]>data=new ArrayList<String[]>();
        for(int i=0; i<dbAccess.getColG().size(); i++){
            if(dbAccess.getColG().get(i).compareToIgnoreCase(id)==0){
                data.add(dbAccess.getRow(i));
            }
        }
        return data;
    }

    //metric: search by product name
    //returns an ArrayList of String Array
    public ArrayList<String[]> searchByProduct(String stockCode){
        ArrayList<String[]>data=new ArrayList<String[]>();
        ArrayList<String>colBData = dbAccess.getColB();
        for(int i=0; i<colBData.size(); i++){
            if(colBData.get(i).compareToIgnoreCase(stockCode)==0){
                data.add(dbAccess.getRow(i));
            }
        }
        return data;
    }

    //metric: search by description
    //returns an ArrayList of String Array
    //E.g. if user asks mug, the algorithm go through descriptions and search for mug
    //and return every row associated with that information.
    //user input can be one word or multiple
    public ArrayList<String[]> searchByDescription(String info){
        ArrayList<String[]>data=new ArrayList<String[]>();

        if ( info.trim().length() > 0 ) {
            // gets all the descriptions
            ArrayList<String> colC = dbAccess.getColC();

            for (int i = 0; i < colC.size(); i++) {
                if (containsIgnoreCase(colC.get(i), info))
                    data.add(dbAccess.getRow(i));
            }
        }

        return data;
    }

    private boolean containsIgnoreCase(String src, String what) {
        final int length = what.length();
        if (length == 0)
            return true; // Empty string is contained

        final char firstLo = Character.toLowerCase(what.charAt(0));
        final char firstUp = Character.toUpperCase(what.charAt(0));

        for (int i = src.length() - length; i >= 0; i--) {
            // Quick check before calling the more expensive regionMatches() method:
            final char ch = src.charAt(i);
            if (ch != firstLo && ch != firstUp)
                continue;

            if (src.regionMatches(true, i, what, 0, length))
                return true;
        }

        return false;
    }

    //metric: search by invoice
    public ArrayList<String[]>searchByInvoice(String invoice){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //parsh
        return data;
    }

    //metric: request maintainer for the user interface
    //even if the request is not valid/complete
    //program won't crash and try to return by assumption
    public ArrayList<String[]> reqMaintainer(String[] info){
        ArrayList<String[]>data=new ArrayList<String[]>();
        return data;
    }

    //test your metric
    public void toString(ArrayList<String[]> data){
        String[] row;
        String print="";
        for(int i=0; i<data.size(); i++){
            row=data.get(i);
            for(int j=0; j<row.length; j++){
                print+="["+row[j]+"] ";
            }
            print+="\n";
        }
        System.out.println(print);
    }
}
