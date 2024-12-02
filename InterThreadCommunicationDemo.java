
package MultiThreading;



public class InterThreadCommunicationDemo {
    public static void main(String[] args) {
     
        final Customer c = new Customer();
        
        new Thread(){
            @Override
            public void run()
            {
               c.withdraw(25000);
            }
        }.start();
        
        
        new Thread(){
            @Override
            public void run()
            {
               c.deposite(10000);
            }
        }.start();
        
        new Thread(){
            @Override
            public void run()
            {
               c.deposite(10000);
            }
        }.start();
        
        
        
        
    }
    
}

class Customer
{
    int amount = 10000;
    
    
public synchronized void withdraw(int amount)
{
    System.out.println("Going to withdraw......");
    if(this.amount<amount)
    {
        System.out.println(" Less balance : waiting for deposite...  ".toUpperCase().trim());
       try{
          wait();             
        }
        catch(InterruptedException e){
            System.out.println("Error !! " + e);
    }  
       if(this.amount>=amount)
       {
         this.amount -= amount;
        System.out.println("Withdraw Completed....with remaining balance "+this.amount);
       }
       else{
            withdraw(amount);
       }
       
       
       
    }
    
    
}
public synchronized void deposite(int amount)
{
    System.out.println("Going to deposite....");
    this.amount += amount;
    System.out.println("Deposite completed ....");
    notify();    
}

}