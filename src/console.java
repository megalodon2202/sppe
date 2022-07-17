import java.util.ArrayList;
public class console {
    public static void main(String[]args){
        System.out.println("Testing...");
        metric info = new metric();
        info.toString(info.searchByCountry("france"));
        System.out.println("Total result: "+info.searchByCountry("france").size());


    }


}
