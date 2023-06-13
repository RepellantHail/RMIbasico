import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class RemoteApplication extends UnicastRemoteObject implements RemoteInterface {

    public RemoteApplication() throws RemoteException {
        super();
    }

    public void printMessage() throws RemoteException {
        System.out.println("Estoy en mi Metodo1()");
        System.out.println("Message printed successfully!");
    }
    public static void main(String[] args)  {
            try {
                System.out.println("Server is booting....");
                System.setProperty("java.rmi.server.hostname","192.168.84.12");
                LocateRegistry.createRegistry(9000);

                RemoteApplication obj = new RemoteApplication();

                Naming.rebind("rmi://localhost:9000/RemoteServer", obj);

                Registry registry = LocateRegistry.getRegistry("192.168.84.12", 9000);
                registry.rebind("RemoteServer", obj);
            } catch (Exception e) {
                System.err.println("Server error: " + e.toString());
                e.printStackTrace();
            }
    }

    public int getLength() throws java.rmi.RemoteException {
        return 5;
    }
}
