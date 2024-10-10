import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

class LeftFectoror{
    private final Stack<String> st;
    private final ArrayList<String> result;

    LeftFectoror(String productions[]){
        // creating object
        st = new Stack<>();
        result = new ArrayList<>();

        // adding productions in stack 
        for(int i=0; i<productions.length; i++){
            st.push(productions[i]);
        }
    }

    // this function creates list form of string from productions 
    private ArrayList<String> getList(String prod){
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=2; i<prod.length(); i++){
            if(prod.charAt(i) == '|'){
                if(sb.length() == 0) continue;

                list.add(sb.toString());
                sb.setLength(0);
            }
            else{
                sb.append(prod.charAt(i));
            }
        }

        if(sb.length() > 0) list.add(sb.toString());
        
        return list;
    }

    
    private String getCommon(ArrayList<String> list){
        String ans = list.get(0);

        for(int i=1; i<list.size(); i++){
            int j = 0; 
            int k=0;
            boolean flag = true;
            while (j<ans.length() && k<ans.length()) {
                if(ans.charAt(j) != list.get(i).charAt(k)){
                    ans = ans.substring(0, j);
                    flag = false;
                    break;
                }
                j++;
                k++;
            }

            if(flag){
                ans = ans.length() < list.get(i).length() ? ans : list.get(i);
            }
        }


        return ans;
    }

    private char getNewVar(HashSet<Character> hs){
        for(int i=65; i<=91; i++){
            if(!hs.contains((char) i)){
                hs.add((char)i);
                return (char)i;
            }
        }
        
        // dummy return statement 
        return 'a';
    }

    private String getNewProd(char ch,String prefix,ArrayList<String> list ){
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        sb.append("=");

        for(int i=0; i<list.size(); i++){
            String temp = list.get(i).substring(prefix.length());
            if(temp.length() > 0) {
                if(sb.length() > 2) sb.append('|');
                sb.append(temp);
            }
        }

        if(sb.length() == 2) return "";
        return sb.toString();
    }

    private void performLF(){
        // symbol which are used
        HashSet<Character> hs = new HashSet<>();
        
        while (!st.isEmpty()) {
            // get any production 
            String topProd = st.peek();
            hs.add(topProd.charAt(0));
            st.pop();

            // generate anyList
            ArrayList<String> list = this.getList(topProd);

            // if production have single rule then go for next
            if(list.size()<2){
                this.result.add(topProd);
                continue;
            }

            // get commmon prefix form all the productions 
            String prefix = this.getCommon(list);
            if(prefix.length() == 0){
                result.add(topProd);
                continue;
            }

            StringBuilder sb = new StringBuilder(topProd.substring(0, 2));
            sb.append(prefix);
            char ch = this.getNewVar(hs);
            sb.append(ch);
            result.add(sb.toString());

            
            String newProd = this.getNewProd(ch, prefix, list );
            if(!(newProd.length() == 0)) st.push(newProd);
        }
    }

    public void printLF(){
        performLF();

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}


public class LeftFectoring{
    public static void main(String args[]){
        String[] productions = {"S=aabb|babb|abab"};
        LeftFectoror lf = new LeftFectoror(productions);
        lf.printLF();
    }
}
