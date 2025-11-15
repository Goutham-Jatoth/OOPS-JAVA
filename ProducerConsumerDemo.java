// ProducerConsumerDemo.java
class Q {
    int item;
    boolean available = false;

    // synchronized method for producer to put item
    synchronized void put(int value) {
        while (available) { // if item not yet consumed, wait
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        item = value;
        available = true;
        System.out.println("Producer produced: " + item);
        notify(); // notify the consumer
    }

    // synchronized method for consumer to get item
    synchronized int get() {
        while (!available) { // if no item to consume, wait
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Consumer consumed: " + item);
        available = false;
        notify(); // notify the producer
        return item;
    }
}

// Producer thread
class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 1;
        while (i <= 5) {
            q.put(i++);
            try {
                Thread.sleep(500); // simulate time to produce
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Consumer thread
class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        int i = 1;
        while (i <= 5) {
            q.get();
            try {
                Thread.sleep(800); // simulate time to consume
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            i++;
        }
    }
}

// Main class
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}