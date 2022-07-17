import java.util.ArrayList;
public class analysis {
    private dbAccessor dbAccess;
    private metric dbMetric;
    public analysis(){
        dbAccess=new dbAccessor();
        dbMetric = new metric();

    }

    public void analyzeByCustomer(String id){
        ArrayList<String[]>localData = dbMetric.searchByCustomer(id);

        //summary

        //comparison

        //whole info return & change void
            }
        }
