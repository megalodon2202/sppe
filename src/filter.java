import java.util.ArrayList;

public class filter {
    private ArrayList<String> rawData;
    private boolean approval;

    public filter(){
        db dbObj = new db();
        rawData = dbObj.getDatabase();
    }

    private boolean infoValidator(){
        boolean decision=true;

        //check colA
        //check colB
        //check colC
        //check colD
        //check colE
        //check colF
        //check colG
        //check colH

        return decision;
    }

    public boolean getApproval(){
        return approval;
    }
}
