package GUI;

import javax.swing.*;
import java.awt.*;

public class Home_Page {

    // Class Attributes
    protected JFrame HomeJFrame = new JFrame(); // A JFrame so it can be accessed anywhere in the file

    public void ShowHome_Page() {

        HomeJFrame.setTitle("Online Mart"); // Setting the title of JFrame
        HomeJFrame.setResizable(false); // Turning off the resizing of JFrame
        HomeJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminating the program if cross button is pressed
        HomeJFrame.setSize(800, 800); // Setting the size of the JFrame

        // Creating an image icon to set the background image of the JFrame
        ImageIcon Image_Background = new ImageIcon("Opening GUI.jpg");
        // Resizing the ImageBackground using a self defined function Resize
        Image_Background = new ImageIcon(Resizing.ResizeImage(Image_Background,790,790));


        // Creating another image icon to set the icon of the Customer Button
        ImageIcon C = new ImageIcon(Resizing.ResizeImage(new ImageIcon("CustomerIcon.png"), 100,100));
        JButton Customer = new JButton(C); // A customer button with icon
        Customer.setBounds(350,100,100,100); // Setting the bounds of the button

        // Creating another image icon and also resizing it to set the icon of the Admin Button
        ImageIcon A = new ImageIcon(Resizing.ResizeImage(new ImageIcon("AdminIcon.jpg"), 100,100));
        JButton Admin = new JButton(A); // An admin button with icon
        Admin.setBackground(Color.GRAY);
        // Setting the position of the text
        Admin.setVerticalTextPosition(AbstractButton.CENTER);
        Admin.setHorizontalTextPosition(AbstractButton.LEADING);
        Admin.setBounds(350,400,100,100); // Setting the bounds of the button



        JLabel label = new JLabel("", Image_Background, JLabel.CENTER); // A JLabel is used to add background image into it
        label.setBounds(0, 0, 800, 800); // Setting the bounds of JLabel
        label.add(Customer); // Adding the customer button to JLabel
        label.add(Admin); // Adding the admin button to JLabel

        HomeJFrame.add(label); // Adding the JLabel in JFrame
        HomeJFrame.setLocationRelativeTo(null); // Making sure the JFrame is visible in the center of the screen
        HomeJFrame.setVisible(true); // Setting the JFrame visible

    }

}
