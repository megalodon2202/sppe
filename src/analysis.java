import java.util.ArrayList;
public class analysis {
    private metric dbMetric;
    private ArrayList<String[]>customerSummary;
    public analysis(){
        dbMetric = new metric();
        customerSummary=new ArrayList<String[]>();
        summaryProcessor();
    }

    public void analyzeByCustomer(String id) {
        ArrayList<String[]> localData = dbMetric.searchByCustomer(id);

        //summary

        //comparison

        //whole info return & change void
    }


    //Get summary of a customer
    private String[] getSummary(String id){
        String[]data={"NA","NA","NA","NA","NA"};
        for(int i=0; i<customerSummary.size(); i++){
            if(customerSummary.get(i)[0].compareToIgnoreCase(id)==0){

            }
        }
        return data;
    }

    //Process summary of customers
    void summaryProcessor(){

    }

    //helper method to generate summary
    //returns a String Array
    //format: per array
    private String[] summaryForCustomer(String id){
        String[] data = {};

        return data;
    }
        }
