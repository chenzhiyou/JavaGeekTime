package simpleMidiPlayer;

import javax.swing.*;
import java.awt.*;

public class Button1 {
    public static void main(String[] args) {
        Button1 button = new Button1();
        button.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        Font bigFont = new Font("serif", Font.BOLD, 28);
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
