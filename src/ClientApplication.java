import java.net.InetAddress;
import java.rmi.Naming;

public class ClientApplication {
    public static void main(String[] args) {
        try {
            RemoteInterface remoteInterface = (RemoteInterface) Naming.lookup("//" + InetAddress.getLocalHost().getHostAddress() + ":" + "5000" + "/RemoteServer");
            for (int i = 0; i < remoteInterface.getLength(); i++) {
                remoteInterface.printMessage();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
