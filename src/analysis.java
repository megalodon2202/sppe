import java.util.ArrayList;
import java.util.HashSet;

public class analysis {
    private metric dbMetric;
    private String[]customerSummary;
    public analysis(){
        dbMetric = new metric();
        customerSummary=new String[4];
        summaryProcessor();
    }

    public void analyzeByCustomer(String id) {
        ArrayList<String[]> localData = dbMetric.searchByCustomer(id);
        //summary

        //comparison

        //whole info return & change void

    }


    //Get summary of a customer
    //format for each customer:
    private String[] getSummary(String id){
        String[]data={"NA","NA","NA","NA","NA"};

        return data;
    }

    //Process summary of customers
    //First store all ids
    //Format: [id],[location],[total quantity fall,winter,spring,summer],[money spent fall,winter,spring,summer]
    void summaryProcessor(){
        ArrayList<String>id = new ArrayList<String>();
        dbAccessor dbObj = new dbAccessor();
        ArrayList<String> colA = dbObj.getColA();

        boolean condition = true;
        //Make a list of all unique ids
        //1 because first row is not valid data
        for(int i=1;i<colA.size(); i++){
            for(int j=0; j<id.size();j++){
                if(colA.get(i).compareTo(id.get(j))==0){
                    condition=false;
                }
                if(condition){
                    id.add(colA.get(i));
                    condition=true;
                }
            }
        }

        //start processing for each customer
        for(int i=0; i<id.size();i++){
            //get all info
            ArrayList<String[]>cusInfo = dbMetric.searchByCustomer(id.get(i));

        }
    }

    //parsh
    //use getUcustomer from dbAcessor class to get all customers
    //generate summery for each customer and populate the followings (customerSummary)
    //[id][products name-quantity (each product seperated by comma)][total purchase - location(each product seperated by comma)][country(s)]
    //example[1234][ab bottle-2,brush-1][200-france,100-united kingdom][france,united kingdom]
    //note each row is summery of a specific customer
    void genCustomerSum(){
        //customerSummary
    }

    //zihan
    //returns all rows associated with the id
    ArrayList<String[]> genCustomerHistory(String id){
        ArrayList<String[]>data = new ArrayList<String[]>();
        return data;
    }

    //jashan
    //format [num of purchased products][num of country]....tbd
    //will discuss the info on chat later but format will be same
    int[] genCustomerNumericSummary(){
        int[] data = new int[2];

        dbAccessor accessor = new dbAccessor();
        ArrayList<String> customers = accessor.getUcustomer();
        ArrayList<String[]> customerData;
        HashSet<String> setOfCountries = new HashSet<>();
        HashSet<String> setOfProducts = new HashSet<>();
        int totalQuantity = 0;
        int totalCountries = 0;
        int totalProducts  = 0;

        for (String customerID: customers) {
            totalQuantity = 0;
            customerData = dbMetric.searchByCustomer(customerID);

            for ( String[] row: customerData) { // single row data of a specific customer
                if ( row != null && !row[3].equals("") && !row[7].equals("") && !row[2].equals("") ) {
                    int quantity = convertToInt(row[3]); // quantity;
                    if (quantity != -1)
                        totalQuantity += quantity;

                    setOfProducts.add(row[2]); // name of the product -> description
                    setOfCountries.add(row[7]); // country
                }
            }

            totalProducts = setOfProducts.size();
            totalCountries = setOfCountries.size();

            System.out.println( "CUSTOMER: " + customerID + ", Quantity: " + totalQuantity + ", Products: "+ totalProducts +", Countries: "+ totalCountries );

            setOfProducts.clear();
            setOfCountries.clear();
        }
        return data;
    }


    private int convertToInt(String data) {
        int result = -1;

        try {
            result = Integer.parseInt(data);
        }
        catch (Exception e) {
            System.out.println("An error occurred in Analysis file, data type invalid.");
        }

        return result;
    }

}
