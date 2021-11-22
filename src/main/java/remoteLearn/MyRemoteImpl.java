package remoteLearn;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    // 需要实现接口的方法
    @Override
    public String sayHello() throws RemoteException {
        return "Server sya hey";
    }

    // 父类的构造函数声明了异常，所以必须写出构造函数，因为它代表你的构造函数会调用有风险的程序代码
    public MyRemoteImpl() throws RemoteException{}

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            // 创建出远程对象，然后使用静态的Naming rebind来产生关联，所注册的名称会供客户端查询
            Naming.rebind("Remote Hello", service);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
