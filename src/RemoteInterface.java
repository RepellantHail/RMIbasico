public interface RemoteInterface extends java.rmi.Remote {
    public void printMessage() throws java.rmi.RemoteException;
    public int getLength() throws java.rmi.RemoteException;
}
