import java.util.ArrayList;
public class analysis {
    private dbAccessor dbAccess;
    public analysis(){
        dbAccess=new dbAccessor();
    }

    public void analyzeByCustomer(String id){
        ArrayList<String[]>localData = new ArrayList<String[]>();
        for(int i=0; i<dbAccess.getColG().size(); i++){
            if(dbAccess.getColG().get(i).compareToIgnoreCase(id)==0){
                localData.add(dbAccess.getRow(i));
            }
        }

        //summery

        //comparison

        //return

    }
}
