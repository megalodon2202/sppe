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
    //format for each customer:
    private String[] getSummary(String id){
        String[]data={"NA","NA","NA","NA","NA"};
        for(int i=0; i<customerSummary.size(); i++){
            if(customerSummary.get(i)[0].compareToIgnoreCase(id)==0){
                data=customerSummary.get(i);//replace
            }
        }
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
        }
