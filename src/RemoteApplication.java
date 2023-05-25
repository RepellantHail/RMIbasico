import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;

public class RemoteApplication extends UnicastRemoteObject implements RemoteInterface {

    public RemoteApplication() throws java.rmi.RemoteException {
        super();
    }

    public void printMessage() throws java.rmi.RemoteException {
        System.out.println("Estoy en miMetodo1()");
    }
    public static void main(String[] args)  {
        try {
            final int port = 5000;
            LocateRegistry.createRegistry(port);
            RemoteInterface remoteApplication = new RemoteApplication();
            Naming.rebind("//" + InetAddress.getLocalHost().getHostAddress() + ":" + port + "/RemoteServer", remoteApplication);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getLength() throws java.rmi.RemoteException {
        // Aquí ponemos el código que queramos
        return 5;
    }
}
