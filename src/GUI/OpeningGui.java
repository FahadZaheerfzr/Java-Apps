package GUI;

import javax.swing.*;

public class OpeningGui {

    // Class Attributes
    protected JFrame OpeningJFrame = new JFrame(); // A JFrame so it can be accessed anywhere in the file

    public void ShowOpeningGUI() {



        OpeningJFrame.setTitle("Online Mart"); // Setting the title of JFrame
        OpeningJFrame.setResizable(false); // Turning off the resizing of JFrame
        OpeningJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminating the program if cross button is pressed
        OpeningJFrame.setSize(800, 800); // Setting the size of the JFrame


        // Creating an image icon to set the background image of the JFrame
        // Resizing the ImageBackground using a self defined function Resize
        ImageIcon Image_Background = GUISetup.ResizeImage(new ImageIcon(getClass().getResource("/Images/aesthetic.jpg")),
                790,790);


        // Setting the background of JFrame using self defined function
        JLabel label = GUISetup.setBackground(Image_Background,800,800);


        OpeningJFrame.add(label); // Adding the JLabel in JFrame
        OpeningJFrame.setLocationRelativeTo(null); // Making sure the JFrame is visible in the center of the screen
        OpeningJFrame.setVisible(true); // Setting the JFrame visible


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OpeningJFrame.setVisible(false);
    }


    public static void main(String[] args) {
        OpeningGui O1 = new OpeningGui();
        O1.ShowOpeningGUI();
        Home_Page H = new Home_Page();
        H.ShowHome_Page();
    }
}