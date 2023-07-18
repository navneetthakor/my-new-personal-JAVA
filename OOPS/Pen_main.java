import java.util.*;
class Pen{
String name;
String type;

Pen(){
    System.out.println("Default Constructor : ");
}
Pen(String name, String type){
    System.out.println("Parameterized Constructor : ");
    this.name = name;
    this.type = type;
}

void write(){
    System.out.println("Hello my name is " + this.name + " and I am fine.");
}
void mytype(){
    System.out.println("Hello my name is " + this.name + " and type : " + type);

}
};

public class Pen_main{
    public static void main(String[] args) {
        Pen pen1 = new Pen("NK", "Master");
        pen1.write();
        pen1.mytype();
    }
}