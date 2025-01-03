

public class ThreadDemoExtendsThread {
    public static void main(String[] args) {
        A obj1 = new A();
        obj1.start();
      obj1.setPriority(Thread.MAX_PRIORITY);
         B obj2 = new B();
        obj2.start();
         C obj3 = new C();
        obj3.start();
        
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            System.out.println("Main Thread : "+ i);
            
        }
        System.out.println("Main Thread Finished !!!!!");
       
        
    }
}


class A extends Thread
{
  @Override
  public void run()
  {
      System.out.println("Starting Thread A..");  
      for (int i = 0; i < 100; i++) {
          System.out.println("Thread A : "+ i);
          try {
              Thread.sleep(1);
          } catch (InterruptedException ex) {
              System.out.println(ex);
          }
          
          }
      System.out.println("Thread A finished !!!"); 
  }
}


class B extends Thread
{
  @Override
  public void run()
  {
      System.out.println("Starting Threaad B.......");  
      for (int i = 0; i < 100; i++) {
          System.out.println("Thread B : "+ i);
          try {
              Thread.sleep(1);
          } catch (InterruptedException ex) {
              System.out.println(ex);
          }
                
      }
      System.out.println("Thread B finished !!!");
  }
}
    
class C extends Thread
{
  @Override
  public void run()
  {
      System.out.println("Starting Threaad C.");  
      for (int i = 0; i < 100; i++) {
          System.out.println("Thread C : "+ i);
          try {
              Thread.sleep(1);
          } catch (InterruptedException ex) {
              System.out.println(ex);
          }
             
          
      }
         System.out.println("Thread C finished !!!"); 
  }
}