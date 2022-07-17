import java.util.ArrayList;

public class filter {
    private dbAccessor dbAccess;
    private boolean decision;

    public filter(){
        dbAccess = new dbAccessor();
        decision=true;
        infoValidator();
    }

    private void infoValidator(){

        //check colA
        //check colB
        //check colC

        //check colD (int)
        ArrayList<String> colD = dbAccess.getColD();
        for(int i=1; i<colD.size(); i++){
            if(colD.get(i)!=null||colD.get(i)!=""){
                System.out.print(colD.get(i)+"\n");
                if(!isInt(colD.get(i))){
                    decision=false;
                }
            }
        }
        //check colE
        //check colF (float)
        ArrayList<String> colF = dbAccess.getColF();
        for(int i=1; i<colF.size(); i++){
            if(colF.get(i)!=null||colF.get(i)!=""){
                System.out.print(colF.get(i)+"\n");
                if(!isFloat(colF.get(i))){
                    decision=false;
                }
            }
        }
        //check colG
        //check colH

    }

    //checks if the data is integer type
    private boolean isInt(String data){
        boolean localDecision =false;
        try {
            int checker = Integer.parseInt(data);
            localDecision = true;
        } catch (NumberFormatException e) {
            System.out.println("Error while processing.");
        }
        return localDecision;
    }

    //checks if the data is integer type
    private boolean isFloat(String data){
        boolean localDecision =false;
        try {
            float checker = Float.parseFloat(data);
            localDecision = true;
        } catch (NumberFormatException e) {
            System.out.println("Error while processing.");
        }
        return localDecision;
    }



    //checks if the data is a valid country
    private boolean isCountry(String data){
        boolean localDecision =false;
        return localDecision;
    }

    public boolean getApproval(){
        return decision;
    }
}
