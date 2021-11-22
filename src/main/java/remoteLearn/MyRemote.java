package remoteLearn;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    // 所有接口中的方法都必须声明RemoteException
    public String sayHello() throws RemoteException;
}
