public class ThreadDemoAnonymousInnerClass {
    public static void main(String[] args) {
        
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running.");
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 1: " + i);
                    try {
                        Thread.sleep(500); 
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                System.out.println("Thread 1 finished.");
            }
        };
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 is running.");
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2: " + i);
                    try {
                        Thread.sleep(500); 
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                System.out.println("Thread 2 finished.");
            }
        });
        thread1.start();
        thread2.start();
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
        System.out.println("Main thread finished.");
    }
}
