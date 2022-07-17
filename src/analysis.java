import java.util.ArrayList;
public class analysis {
    private metric dbMetric;
    public analysis(){
        dbMetric = new metric();

    }

    public void analyzeByCustomer(String id){
        ArrayList<String[]>localData = dbMetric.searchByCustomer(id);

        //summary

        //comparison

        //whole info return & change void
            }
        }
