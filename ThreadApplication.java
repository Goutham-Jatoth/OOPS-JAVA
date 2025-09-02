// import java.util.Random;

// public class multithreadapplication {
//     private static Integer sharedNumber = null;

//     public static void main(String[] args) {
//         Object lock = new Object();

//         // Thread 1: Generates random number every 1 second
//         Thread generator = new Thread(() -> {
//             Random rand = new Random();
//             while (true) {
//                 synchronized (lock) {
//                     sharedNumber = rand.nextInt(100);  // random number 0-99
//                     System.out.println("Generated number: " + sharedNumber);
//                     lock.notifyAll();  // notify waiting threads
//                     try {
//                         lock.wait();  // wait for worker thread to finish
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                 }
//                 try {
//                     Thread.sleep(1000);  // wait 1 second before next number
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         });

//         // Thread 2: Computes square if number is even
//         Thread squareThread = new Thread(() -> {
//             while (true) {
//                 synchronized (lock) {
//                     try {
//                         while (sharedNumber == null || sharedNumber % 2 != 0) {
//                             lock.wait();
//                         }
//                         int val = sharedNumber;
//                         System.out.println("Square of " + val + " = " + (val * val));
//                         sharedNumber = null;
//                         lock.notifyAll();
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                 }
//             }
//         });

//         // Thread 3: Computes cube if number is odd
//         Thread cubeThread = new Thread(() -> {
//             while (true) {
//                 synchronized (lock) {
//                     try {
//                         while (sharedNumber == null || sharedNumber % 2 == 0) {
//                             lock.wait();
//                         }
//                         int val = sharedNumber;
//                         System.out.println("Cube of " + val + " = " + (val * val * val));
//                         sharedNumber = null;
//                         lock.notifyAll();
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                 }
//             }
//         });

//         // Start all threads
//         generator.start();
//         squareThread.start();
//         cubeThread.start();
//     }
// }






// import java.util.Random;

// class multithreadapplication extends Thread {
//     public void run() {
//         Random rand = new Random();
//         while (true) {
//             int num = rand.nextInt(100); // Random number 0–99
//             System.out.println("Generated: " + num);

//             if (num % 2 == 0) {
//                 new Square(num).start();
//             } else {
//                 new Cube(num).start();
//             }

//             try {
//                 Thread.sleep(1000); // Wait for 1 second
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class Square extends Thread {
//     int num;

//     Square(int n) {
//         num = n;
//     }

//     public void run() {
//         System.out.println("Square of " + num + " is " + (num * num));
//     }
// }

// class Cube extends Thread {
//     int num;

//     Cube(int n) {
//         num = n;
//     }

//     public void run() {
//         System.out.println("Cube of " + num + " is " + (num * num * num));
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         new NumberGenerator().start();
//     }
// }







import java.util.Random;

class multithreadapplication extends Thread {
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) { // Loop only 5 times
            int num = rand.nextInt(100);
            System.out.println("Generated: " + num);

            if (num % 2 == 0) {
                new Square(num).start();
            } else {
                new Cube(num).start();
            }

            try {
                Thread.sleep(5); // Wait 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Square extends Thread {
    int num;
    Square(int n) {
        num = n;
    }

    public void run() {
        System.out.println("Square of " + num + " is " + (num * num));
    }
}

class Cube extends Thread {
    int num;
    Cube(int n) {
        num = n;
    }

    public void run() {
        System.out.println("Cube of " + num + " is " + (num * num * num));
    }
}

public class ThreadApplication {
    public static void main(String[] args) {
        new multithreadapplication().start();
    }
}