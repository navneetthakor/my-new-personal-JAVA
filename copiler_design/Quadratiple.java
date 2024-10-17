import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

class QuadratipleEntry{
    final String opt;
    final String arg1;
    final String arg2;
    final String temp_result;

    QuadratipleEntry(String opt, String arg1, String arg2, String t_r){
        this.opt = opt;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.temp_result = t_r;
    }

    @Override
    public String toString(){
        return (this.opt + "\t" + this.arg1 + "\t" + this.arg2 + "\t" + this.temp_result);
    }
}

class QuadratipleGenerator {
    Stack<String> st;
    int count;

    QuadratipleGenerator(){
        this.st = new Stack<>();
        this.count = 0;
    }

    private String symolGenerator(){
        return ("t" + this.count++);
    }

    public ArrayList<QuadratipleEntry> solve(String postfix){

        // reset datapoints
        this.st.clear();
        this.count = 0;

        // required data structures 
        ArrayList<QuadratipleEntry> ans = new ArrayList<>();
        HashSet<Character> lookup = new HashSet<>();
        lookup.add('+');
        lookup.add('-');
        lookup.add('*');
        lookup.add('/');
        lookup.add('^');

        for(Character ch : postfix.toCharArray()){
            if(!lookup.contains(ch)){
                this.st.add(Character.toString(ch));
                continue;
            }

            String arg2 = st.pop();
            String arg1 = st.pop();
            String temp_result = this.symolGenerator();

            // adding in data structure 
            ans.add(new QuadratipleEntry(Character.toString(ch), arg1, arg2, temp_result));
            this.st.push(temp_result);
            
        }

        return ans;
    }
    
}

public class Quadratiple {
    public static void main(String[] args) {
        QuadratipleGenerator parser = new QuadratipleGenerator();
        String postfix = "ab*cd*+";

        ArrayList<QuadratipleEntry> ans = parser.solve(postfix);

        System.out.println("opt\targ1\targ2\ttemp_result");
        for(QuadratipleEntry t : ans){
            System.out.println(t);
        }
    }
}
