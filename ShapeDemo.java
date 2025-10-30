import java.util.Scanner;

// Abstract class Shape
abstract class Shape {
    int a, b;  // dimensions (can represent length, breadth, radius, etc.)

    // Abstract method
    abstract void printArea();
}

// Rectangle class extending Shape
class Rectangle extends Shape {
    Rectangle(int x, int y) {
        a = x;
        b = y;
    }

    void printArea() {
        double area = a * b;
        System.out.println("Area of Rectangle = " + area);
    }
}

// Triangle class extending Shape
class Triangle extends Shape {
    Triangle(int x, int y) {
        a = x;
        b = y;
    }

    void printArea() {
        double area = 0.5 * a * b;
        System.out.println("Area of Triangle = " + area);
    }
}

// Circle class extending Shape
class Circle extends Shape {
    Circle(int r) {
        a = r;
    }

    void printArea() {
        double area = 3.14 * a * a;
        System.out.println("Area of Circle = " + area);
    }
}

// Main class
public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length and breadth of Rectangle: ");
        int l = sc.nextInt();
        int b = sc.nextInt();
        Shape rect = new Rectangle(l, b);
        rect.printArea();

        System.out.print("\nEnter base and height of Triangle: ");
        int base = sc.nextInt();
        int height = sc.nextInt();
        Shape tri = new Triangle(base, height);
        tri.printArea();

        System.out.print("\nEnter radius of Circle: ");
        int r = sc.nextInt();
        Shape cir = new Circle(r);
        cir.printArea();

        sc.close();
    }
}