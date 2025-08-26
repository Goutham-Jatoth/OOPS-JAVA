// Basic Java Implementation

// public class oopjava {
//     public static void main(String[] args) {
//         System.out.println("Hello JAVA ");
//     }
// }



// single Inheritence

// class Animal {
//     void eat() {
//         System.out.println("Animal eats Food");
//     }
// }

// class Dog extends Animal {
//     void bark() {
//         System.out.println("Dog barks you know !");
//     }
// }

// public class oopjava {
//     public static void main(String[] args) {
//         Dog d = new Dog();
//         d.eat();
//         d.bark();
//     }
// }




// Multi Level Inheritence

// class Student {
//     void name() {
//         System.out.println("Hello I'm Goutham");
//     }
// }

// class Stud extends Student {
//     void age() {
//         System.out.println("I'm 18 years boy");
//     }
// }

// class details extends Stud {
//     void study() {
//         System.out.println("I'm persuing Graduation");
//     }
// }

// public class oopjava {
//     public static void main(String[] args) {
//         details d = new details();
//         d.name();
//         d.age();
//         d.study();
//     }
// }






// Multilevel Inheritence 

// class Animal {
//     void eat() {
//         System.out.println("Animal eats Food");
//     }
// }

// class Mammal extends Animal {
//     void walk() {
//         System.out.println("Mammal Walks");
//     }
// }

// class Dog extends Mammal {
//     void bark() {
//         System.out.println("Dog eats, walks and also Bark !");
//     }
// }

// public class oopjava {
//     public static void main(String[] args) {
//         Dog d = new Dog();
//         d.eat();
//         d.walk();
//         d.bark();
//     }
// }



// Multiple Inheritence

// class grandfather {
//     void oldage() {
//         System.out.println("Grandfather is very Old");
//     }
// }

// class father extends grandfather {
//     void midage() {
//         System.out.println("Father is Young !");
//     }
// }

// class child extends father {
//     void infant() {
//         System.out.println("Child is Infant");
//     }
// }

// public class oopjava {
//     public static void main(String[] args) {
//         child c = new child();
//             c.oldage();
//             c.midage();
//             c.infant();
//     }
// }






// Static Method for Method Binding

// class Animal {
//     private void sound() {
//         System.out.println("Animal Makes Sound !");
//     }
//     // Static method
//     static void type () {
//         System.out.println("This is Mammal");
//     }
//     public static void main(String[] args) {
//         Animal a = new Animal();
//         Animal.type(); // Static Binding
//         System.out.println("Method Binding using Static Method");
//     }
// }    



// Dynamic Method for Method Binding

// class Animal {
//     void Sound() {
//         System.out.println("Animal makes Sound");
//     }
// }

// class Dog extends Animal {
//     void Sound() {
//         System.out.println("Dog Barks");
//     }
// }

// class Cat extends Animal {
//     void Sound() {
//         System.out.println("Cat makes Meow");
//     }
// }

// public class oopjava {
//     public static void main (String[] args) {
//         Animal d = new Dog();
//         Animal c = new Cat();
//         d.Sound();
//         c.Sound();
//     }
// }







// One Dimensional Array Implementation

// import java.util.Scanner;
// public class oopjava {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the Size : ");
//         int size = sc.nextInt();
//         int[] arr = new int[size];
//         System.out.println("Enter" + " " + size + " " + "Elements");

//         for (int i=0;i<size;i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.println("Array Elements are : ");

//         for (int i=0;i<size;i++) {
//             System.out.println(arr[i] + " ");
//         }
//         sc.close();
//     }
// }