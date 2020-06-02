package GUI;

import javax.swing.*;
import java.awt.*;

public class ManageShop {

    public static JLabel ManageLabel(){
        // Creating an image icon to set the background image of the JFrame and
        // Resizing the ImageBackground using a self defined function Resize
        ImageIcon Image_Background = GUISetup.ResizeImage(new ImageIcon("src\\Images\\ManageShop.jpg"),
                790, 790);

        // Setting the background of JFrame using self defined function

        JLabel label =  GUISetup.setBackground(Image_Background,800,800);

        Font f2 = new Font("Georgia", Font.ITALIC|Font.BOLD, 25);

        JLabel label_for_name = new JLabel();
        label_for_name.setText("Shop Name");
        label_for_name.setSize(375,80);
        label_for_name.setBounds(300,150,200,70);
        label_for_name.setFont(f2);

        JButton btn1 = new JButton("Add Item");
        btn1.setForeground(Color.CYAN);
        btn1.setBackground(new Color(95,162,202));
        btn1.setBounds(200,280,375,60);
        btn1.setFont(f2);

        JButton btn2 = new JButton("Remove Item");
        btn2.setForeground(Color.CYAN);
        btn2.setBackground(new Color(95,162,202));
        btn2.setBounds(200,360,375,60);
        btn2.setFont(f2);

        JButton btn3 = new JButton("Current Balance");
        btn3.setForeground(Color.CYAN);
        btn3.setBackground(new Color(95,162,202));
        btn3.setBounds(200,440,375,60);
        btn3.setFont(f2);

        JButton btn4 = new JButton("View Inventory");
        btn4.setForeground(Color.CYAN);
        btn4.setBackground(new Color(95,162,202));
        btn4.setBounds(200,520,375,60);
        btn4.setFont(f2);

        JButton btn5 = new JButton("Withdraw Amount");
        btn5.setForeground(Color.CYAN);
        btn5.setBackground(new Color(95,162,202));
        btn5.setBounds(200,600,375,60);
        btn5.setFont(f2);

        JButton btn6 = new JButton("Sale");
        btn6.setForeground(Color.CYAN);
        btn6.setBackground(new Color(95,162,202));
        btn6.setBounds(200,680,375,60);
        btn6.setFont(f2);

        label.add(label_for_name);
        label.add(btn1);
        label.add(btn2);
        label.add(btn3);
        label.add(btn4);
        label.add(btn5);
        label.add(btn6);

        return label;
    }
}