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
        //all invoice num are int/numeric
        //avoid the first alphabet
        ArrayList<String>colA=dbAccess.getColA();
        for(int i=1;i<colA.size();i++){
            if(colA.get(i)!=null && colA.get(i)!="") {
                if(!isInt(Character.toString(colA.get(i).charAt(0)))){
                    if (!isInt(colA.get(i).substring(1))) {
                        decision = false;
                    }
                }
                else {
                    if (!isInt(colA.get(i))) {
                        decision = false;
                    }
                }
            }
        }
        //check colB
        //check colC

        //check colD (int)
        ArrayList<String> colD = dbAccess.getColD();
        for(int i=1; i<colD.size(); i++){
            if(colD.get(i)!=null && colD.get(i)!=""){
                if(!isInt(colD.get(i))){
                    decision=false;
                }
            }
        }
        //check colE
        ArrayList<String>colE=dbAccess.getColE();
        for(int i=1; i<colE.size();i++){
            if(colE.get(i)!=null && colE.get(i)!=""){
                if(!isValidTime(colE.get(i))){
                    decision=false;
                }
            }
        }
        //check colF (double)
        ArrayList<String> colF = dbAccess.getColF();
        for(int i=1; i<colF.size(); i++){
            if(colF.get(i)!=null && colF.get(i)!=""){
                if(!isDouble(colF.get(i))){
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

    //checks if the data is double type
    private boolean isDouble(String data){
        boolean localDecision =false;
        try {
            double checker = Double.parseDouble(data);
            localDecision = true;
        } catch (NumberFormatException e) {
            System.out.println("Error while processing.");
        }
        return localDecision;
    }

    //Formats:
    //M/D/YY H:MM
    //MM/D/YY H:MM
    //MM/DD/YY H:MM
    //MM/DD/YY HH:MM
    private boolean isValidTime(String data){
        boolean localDecision=true;
        char[] validChars = {};
        String highestFormat = "MM/DD/YY HH:MM";
        //max len
        if(data.length()>highestFormat.length()){
            localDecision=false;
        }
        //valid entries
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)!=' '&&data.charAt(i)!='/'&&data.charAt(i)!=':'){
                if(!isInt(Character.toString(data.charAt(i)))){
                    localDecision=false;
                }
            }
        }
        return localDecision;
    }

    //read all country from libCountry.txt (https://github.com/megalodonlab/avocado/blob/main/libCountry.txt)
    //match with input
    //if matches true else false
    //not case sensitive
    //note: for testing I've made it public, but will change it to private once it's working
    public boolean isValidCountry(String data){
        boolean localDecision=true;
        //parsh
        return localDecision;
    }

    public boolean getApproval(){
        return decision;
    }
}
