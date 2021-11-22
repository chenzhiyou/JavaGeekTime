package remoteLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

public class ServiceBrowser {
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;

    public void buildGUI(){
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        Object[] services = getServicesList();

        frame.getContentPane().add(BorderLayout.NORTH, serviceList);

        serviceList.addActionListener(new MyListListner());

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void loadService(Object serviceSelection){
        try {
            Service svc = server.getService(serviceSelection);

            mainPanel.removeAll();
            mainPanel.add(svc.gerGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Object[] getServicesList(){
        Object obj = null;
        Object[] services = null;

        try {
            obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        server = (ServiceServer) obj;

        try {
            services = server.getServiceList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return services;
    }

    public class MyListListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object selection = serviceList.getSelectedItem();
            loadService(selection);
        }
    }

    public static void main(String[] args) {
        new ServiceBrowser().buildGUI();
    }
}
