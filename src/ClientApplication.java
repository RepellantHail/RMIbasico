import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientApplication {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.10.11", 9000);
            RemoteInterface remoteInterface = (RemoteInterface) registry.lookup("RemoteServer");


            for (int i = 0; i < remoteInterface.getLength(); i++) {
                remoteInterface.printMessage();
            }
        } catch (Exception e) {
            System.out.println("Error in client side: " + e);
        }
    }
}
