package thread;

class threadDemo implements Runnable {
    private Thread t;
    private String threadName;

    threadDemo(String name) {
        threadName = name;
        System.out.println("In the process of "+threadName);
    }

    @Override
    public void run() {
        System.out.println("Running: "+ threadName);
        try {
            for (int i = 4; i > 0 ; i--) {
                System.out.println("Thread "+threadName + ", "+ i);
                //Sleep
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " has been interupted");
        }
        System.out.println("Thread "+ threadName+ " exitting");
    }
    public void start() {
        System.out.println("Starting "+ threadName);
        if (t==null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class mainThread {
    public static void main(String[] args) {
        threadDemo t1 = new threadDemo("Thread 1");
        t1.run();
        threadDemo t2 = new threadDemo("Thread 2");
        t2.run();
        t2.run();
    }
}


