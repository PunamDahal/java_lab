import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

interface Calculator extends Remote {
    public double add(double num1, double num2) throws RemoteException;
    public double subtract(double num1, double num2) throws RemoteException;
    public double multiply(double num1, double num2) throws RemoteException;
    public double divide(double num1, double num2) throws RemoteException;
}

class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {
        super();
    }

    public double add(double num1, double num2) throws RemoteException {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) throws RemoteException {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) throws RemoteException {
        return num1 * num2;
    }

    public double divide(double num1, double num2) throws RemoteException {
        if (num2 == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}

public class RMIExample {

    public static void startServer() {
        try {
            CalculatorImpl calc = new CalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1099); 

            registry.rebind("CalculatorService", calc);

            System.out.println("Calculator RMI server is running...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static void startClient() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");

            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            double num1 = 10;
            double num2 = 5;

            System.out.println("Addition: " + calculator.add(num1, num2));
            System.out.println("Subtraction: " + calculator.subtract(num1, num2));
            System.out.println("Multiplication: " + calculator.multiply(num1, num2));
            System.out.println("Division: " + calculator.divide(num1, num2));
        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> startServer()).start();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        startClient();
    }
}
