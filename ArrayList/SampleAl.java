
import java.util.ArrayList;
import java.util.Collections;

public class SampleAl {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<Integer>();

        // appendig elements in arraylist 
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        System.out.println(mylist);

        // adding element at specific location 
        mylist.add(0,0);
        mylist.add(1, 1);
        System.out.println(mylist);

        //getting element form specific location
        int ele = mylist.get(0);
        System.out.println(ele);

        // removing element form arraylist
        mylist.remove(0);
        System.out.println(mylist);

        // sorting it (few element added as it's already sorted)
        mylist.add(0);
        System.out.println(mylist);
        Collections.sort(mylist);
        System.out.println(mylist);
    }
    

}
