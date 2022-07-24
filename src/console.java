import java.util.ArrayList;
public class console {
    public static void main(String[]args){
        //System.out.println("Testing...");
        metric info = new metric();
        //dbAccessor t = new dbAccessor();
        //System.out.println(t.getRow(0)[0]);
        //info.toString(info.searchByCountry("france"));
        //System.out.println("Total result: "+info.searchByCountry("france").size());
        //filter f = new filter();
        //System.out.println(f.getApproval());
        //info.toString(info.searchByProduct("85123A"));
        //info.toString(info.searchByCustomer("17850"));
        tool t = new tool();
        System.out.println(t.getDate("12/1/10 8:26"));
        System.out.println(t.getMonth("12/1/10 8:26"));
        System.out.println(t.getYear("12/1/10 8:26"));
        System.out.println(t.getHour("12/1/10 8:26"));
        System.out.println(t.getMin("12/1/10 8:26"));
    }


}
