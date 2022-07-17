import java.util.ArrayList;
public class metric {
    private dbAccessor dbAccess;
    public metric(){
        dbAccess=new dbAccessor();
    }

    //metric: Search by country name
    //Returns an ArrayList of String Array
    //Each ArrayList is an individual row
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

    public ArrayList<String[]> searchByUnitprice(int low, int high){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //parsh
        return data;
    }

    public ArrayList<String[]> searchByUnitQuantity(int low, int high){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //parsh
        return data;
    }

    public ArrayList<String[]> searchByDate(String from, String upto){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //zihan
        return data;
    }

    //options: spring, summer, fall, winter
    public ArrayList<String[]> searchBySeason(String low){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //zihan
        return data;
    }

    public ArrayList<String[]> searchByCustomer(String id){
        ArrayList<String[]>data=new ArrayList<String[]>();
        //jayed
        return data;
    }

    //options: spring, summer, fall, winter
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
