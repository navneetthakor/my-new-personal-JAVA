import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

class SymbolTableEntry{
    String name;
    String type;
    String value;

    SymbolTableEntry(String name, String type, String value){
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString(){
        return(this.name + "\t" + this.type + "\t" + this.value);
    }

    public String getValue(){
        return this.value;
    }
}

class SymbolTableGenerator {
    HashSet<String> type;
    HashSet<Character> opt;

    SymbolTableGenerator(){
        this.type = new HashSet<>();
        type.add("int");
        type.add("double");

        this.opt = new HashSet<>();
        opt.add('+');
        opt.add('-');
        opt.add('*');
        opt.add('/');
        opt.add('^');
    }

    private String[] helper(String str, int index) throws Error{
        String ans[] = new String[2];

        // data structures 
        Stack<String> st = new Stack<>();

        while (index < str.length()) {
            char ch = str.charAt(index);
            if (ch == ',' || ch == ';') {
                ans[0] = st.pop(); // if input is correct then this will be final result
                ans[1] = String.valueOf(index);
                return ans;
            }
            
            if(!opt.contains(ch)){
                st.push(Character.toString(ch));
                continue;
            }

            String arg2 = st.pop();
            String arg1 = st.pop();

            switch (ch) {
                case '+':
                    st.push(String.valueOf(Integer.valueOf(arg1) + Integer.valueOf(arg2)));
                    break;
                case '-':
                    st.push(String.valueOf(Integer.valueOf(arg1) - Integer.valueOf(arg2)));
                    break;
                case '*':
                    st.push(String.valueOf(Integer.valueOf(arg1) * Integer.valueOf(arg2)));
                    break;
                case '/':
                    st.push(String.valueOf(Integer.valueOf(arg1) / Integer.valueOf(arg2)));
                    break;
                case '^':
                    st.push(String.valueOf(Integer.valueOf(arg1) ^ Integer.valueOf(arg2)));
                    break;
            
                default:
                    throw new Error();
            }
        }

        // dummy return 
        return ans;
    }

    
}

public class SymbolTable {
    
}
