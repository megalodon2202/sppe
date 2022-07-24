import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class db {

    private ArrayList<String> database;
    public db(){
        String dbLocation = "";
        String dbFileName = "data";
        String dbFormat = "csv";
        database = new ArrayList<String>();
        database = read(dbLocation,dbFileName,dbFormat);
    }
    private ArrayList<String> read(String location, String fileName, String format){
        ArrayList<String> data = new ArrayList<String>();
        String filePath = location+fileName+"."+format;
        try {
            File rawFile = new File(filePath);
            Scanner readRow = new Scanner(rawFile);
            while (readRow.hasNextLine()) {
                String row = readRow.nextLine();
                data.add(row);
            }
            readRow.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading.");
        }
        return data;
    }

    //accessor of raw data
    public ArrayList<String> getDatabase(){
        return database;
    }
}
