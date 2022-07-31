import java.util.ArrayList;
public class console {
    public static void main(String[]args){
        System.out.println("... Start test console ...");


        metric info = new metric();
        dbAccessor t = new dbAccessor();
        //t.getUcustomer();
        System.out.println(t.getUcustomer());

        System.out.println(t.getUcountry());
        System.out.println(t.getUproduct());
        System.out.println(t.getUtime());

        //System.out.println(t.getRow(0)[0]);
        //info.toString(info.searchByCountry("france"));
        //System.out.println("Total result: "+info.searchByCountry("france").size());
        //filter f = new filter();
        //System.out.println(f.getApproval());
        //info.toString(info.searchByProduct("85123A"));
        //info.toString(info.searchByCustomer("17850"));
        //info.toString(info.searchByUnitPrice(0,0));
        //info.toString(info.searchByUnitPrice(3,3));

        // //test time constructor
        // tool t = new tool();
        // System.out.println("Date: "+t.getDate("12/1/10 8:26"));
        // System.out.println("Month: "+t.getMonth("12/1/10 8:26"));
        // System.out.println("Year: "+t.getYear("12/1/10 8:26"));
        // System.out.println("Hour: "+t.getHour("12/1/10 8:26"));
        // System.out.println("Min: "+t.getMin("12/1/10 8:26"));

        // //test filter
        // filter f = new filter();
        // System.out.println("Data validates: "+f.getApproval());

        // //random tests
        // String xyz = "MM/DD/YY HH:MM";
        // System.out.println(xyz.length());
        //end
        System.out.println("... End test console ...");
    }


}
