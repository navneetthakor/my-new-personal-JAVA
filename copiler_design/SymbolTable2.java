import java.util.ArrayList;
import java.util.HashSet;

class SymbolTableEntry {
    String name;
    String type;
    String value;

    SymbolTableEntry(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return (this.name + "\t" + this.type + "\t" + this.value);
    }

    public String getValue() {
        return this.value;
    }
}

class SymbolTableGenerator {
    HashSet<String> type;

    SymbolTableGenerator() {
        this.type = new HashSet<>();
        type.add("int");
        type.add("double");
        type.add("short");
        type.add("long");
    }

    public ArrayList<SymbolTableEntry> solve(String[] str) {

        // required data structures
        ArrayList<SymbolTableEntry> ans = new ArrayList<>();

        for (String currstr : str) {
            int index = 0;
            String localType = "";
            while (index < currstr.length() && currstr.charAt(index) != ';') {
                StringBuilder temp = new StringBuilder();
                
                if (currstr.charAt(index) == '=' && localType != "" && ans.size() > 0) {
                    temp.delete(0, temp.toString().length());
                    while (currstr.charAt(index) != ',' && currstr.charAt(index) != ';'){
                        temp.append(currstr.charAt(index));
                        index++;
                    } 
                    
                    ans.get(ans.size()-1).value = temp.toString().substring(1).trim();
                    index++;
                }
                temp.delete(0, temp.toString().length());
                
                while (currstr.length()> index && currstr.charAt(index) != ',' && currstr.charAt(index) != ' ' && currstr.charAt(index) != ';'
                && currstr.charAt(index) != '=') {
                    temp.append(currstr.charAt(index));
                    index++;
                }
                
                
                String temp_result = temp.toString().trim();
                
                
                if (localType == "" && !this.type.contains(temp_result)) {
                    throw new Error("Not valid input: " + currstr);
                }
                
                if (localType == "") {
                    localType = temp_result;
                }
                
                if (localType != "" && temp_result != " " && temp_result != localType) {
                    ans.add(new SymbolTableEntry(temp_result, localType, "uninitialized"));
                }
                while(currstr.length() > index && ( currstr.charAt(index) == ',' || currstr.charAt(index) == ' ')) index++; // to avoid infinite loop
                
            }
        }

        return ans;

    }

}

public class SymbolTable2 {
    public static void main(String[] args) {
        SymbolTableGenerator parser = new SymbolTableGenerator();

        String[] str = {"int a,b,c;", "int d = 5,n;", "double m = 5.025;"};
        ArrayList<SymbolTableEntry> ans = parser.solve(str);

        for(SymbolTableEntry t : ans){
            System.out.println(t);
        }
    }
}
