import java.util.*;

public class LeftRecursionRemoval {

    public static void removeLeftRecursion(ArrayList<String> productions) {
        for (int i = 0; i < productions.size(); i++) {
            String production = productions.get(i);
            String leftHandSide = production.substring(0, production.indexOf(" -> "));
            String rightHandSide = production.substring(production.indexOf(" -> ") + 4);

            if (rightHandSide.startsWith(leftHandSide)) {
                // Left-recursion detected
                String newLeftHandSide = leftHandSide + "'";
                String newRightHandSide = "";

                while (rightHandSide.startsWith(leftHandSide)) {
                    newRightHandSide += rightHandSide.substring(leftHandSide.length()) + " " + newLeftHandSide;
                    rightHandSide = productions.get(i + 1).substring(production.indexOf(" -> ") + 4);
                    productions.remove(i + 1);
                }

                newRightHandSide += "| " + newLeftHandSide + "'";
                productions.set(i, leftHandSide + " -> " + newRightHandSide);
                productions.add(newLeftHandSide + " -> " + rightHandSide + "| ε");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> productions = new ArrayList<>();
        productions.add("E -> Eab");
        productions.add("E -> T");

        System.out.println("Original productions:");
        for (String production : productions) {
            System.out.println(production);
        }

        removeLeftRecursion(productions);

        System.out.println("\nProductions after removing left-recursion:");
        for (String production : productions) {
            System.out.println(production);
        }
    }
}