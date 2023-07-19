
class Shape{
    String color;
}

class Triangle extends Shape{
    void area(int h, int l){
        System.out.println("Area is : " + (double)(h*l/2));
    }
}

class EquyTriangle extends Triangle{
    void display(){
        System.out.println("Hey, I am EquyTriangle");
    }
}

public class multiLevelInherit {
    public static void main(String[] args) {
        EquyTriangle me = new EquyTriangle();
        me.color = "red";
        System.out.println("The color of equi Triangle is : " + me.color);
        me.area(5, 10);
        me.display();
    }
}
