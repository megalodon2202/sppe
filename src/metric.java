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
    public ArrayList<String[]> searchByUnitprice(int low, int high){
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
    public ArrayList<String[]> searchByProduct(String stockCode){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //jayed
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
