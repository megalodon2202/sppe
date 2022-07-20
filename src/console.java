import java.util.ArrayList;
public class console {
    public static void main(String[]args){
        System.out.println("Testing...");
        metric info = new metric();
        dbAccessor t = new dbAccessor();
        System.out.println(t.getRow(0)[0]);
        info.toString(info.searchByCountry("france"));
        System.out.println("Total result: "+info.searchByCountry("france").size());
        filter f = new filter();
        System.out.println(f.getApproval());
        info.toString(info.searchByStockCode("85123A"));
    }


}
