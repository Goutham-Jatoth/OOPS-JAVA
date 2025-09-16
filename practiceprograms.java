// public class practiceprograms {
//     public static void main(String[] args) {
//         System.out.println("Hello. Java!");
//     }
// }





// public class practiceprograms {
//     public static void main(String[] args) {
//         int a = 10;
//         double b = 8/5;
//         boolean c = true;
//         System.out.println("a = " + a);
//         System.out.println("b = " + b);
//         System.out.println("c = " + c);
//     }
// }





// public class practiceprograms {
//     public static void main(String[] args) {
//         int x = 10;
//         if (x>5) {
//             int y = 20;
//             System.out.println("X = " + x + " , Y = " + y);
//         }
//     }
// }






// public class practiceprograms {
//     public static void main(String[] args) {
//         int num = 7;
//         if (num%2 == 0) {
//             System.out.println(num + " is Even");
//         }
//         else {
//             System.out.println(num + " is Odd");
//         }
//     }
// }




// public class practiceprograms {
//     public static void main(String[] args) {
//         int day = 2;
//         switch(day) {
//             case 1: System.out.println("Monday");
//             break;
//             case 2: System.out.println("Tuesday");
//             break;
//             default:
//             System.out.println("Other Day");
//         }
//     }
// }







// public class practiceprograms {
//     public static void main(String[] args) {
//         for (int i=0;i<=5;i++) {
//             System.out.println("The value of i is : " + i);
//         }
//     }
// }



// public class practiceprograms {
//     public static void main(String[] args) {
//          int i = 1;
//          while(i<=5) {
//             System.out.println("The value of i is : " + i);
//             i++;
//          }
//     }
// }






// public class practiceprograms {
//     public static void main(String[] args) {
//         int i = 1;
//         do {
//             System.out.println("The value is : " + i);
//             i++;
//         } while(i<=5);
//     }
// }






// public class practiceprograms {
//     public static void main(String[] args) {
//         int[] arr = {10,20,30};
//         for (int x: arr) {
//             System.out.println(x + " ");
//         }
//     }
// }







// public class practiceprograms {
//     public static void main(String[] args) {
//         int [][] arr = {{1,2},{3,4}};
//             for (int i=0;i<arr.length;i++) {
//                 for (int j=0;j<arr[i].length;j++) {
//                     System.out.println(arr[i][j] + " ");
//                 }
//                 System.out.println();
//             }
//     }
// }




// class Student {
//     String name;
//     int age;
// }
// public class practiceprograms {
//     public static void main(String[] args) {
//         Student s = new Student();
//         s.name = "Goutham";
//         s.age = 19;
//         System.out.println(s.name + " " + s.age);
//     }
// }





// class Car {
//     String model;
//     Car(String m) {
//         model = m;
//     }
// }
// public class practiceprograms {
//     public static void main(String[] args) {
//         Car c = new Car("Tesla");
//         System.out.println("Model : " + c.model);
//     }
// }






// public class practiceprograms {
//     public static void main(String[] args) {
//         var x = 10;
//         var y = (Object)x;
//         System.out.println(y);
//         System.out.println(((Object)x).getClass());
//     }
// }