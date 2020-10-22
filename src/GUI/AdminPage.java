package GUI;

import javax.swing.*;
import java.awt.*;


public class AdminPage {

    private JTextField Login_Name;
    private JPasswordField Password;


    public JLabel AdminLabel() {
        /*
         * Creating an image icon to set the background image of the JFrame and
         * Resizing the ImageBackground using a self defined function Resize
         */
        ImageIcon Image_Background = GUISetup.ResizeImage(new ImageIcon(getClass().getResource("/Images/china_market_lights.jpg")),
                790, 790);

        // Setting the background of JFrame using self defined function
        JLabel label = GUISetup.setBackground(Image_Background, 800, 800);

        Font f = new Font("Times New Roman", Font.BOLD, 48);
        JLabel text = new JLabel("Welcome to Market Place!");
        text.setFont(f);
        text.setForeground(Color.yellow);
        text.setBounds(120, 40, 650, 70);

        JPanel form = new JPanel();
        form.setLayout(null);
        form.setBounds(140, 180, 500, 400);
        form.setBackground(new Color(0, 0, 0, 80));

        Font f1 = new Font("Times New Roman", Font.BOLD, 24);

        JLabel Name_Prompt = new JLabel("Username");
        Name_Prompt.setBounds(80, 150, 180, 30);
        Name_Prompt.setForeground(Color.yellow);
        Name_Prompt.setFont(f1);
        form.add(Name_Prompt);


        Login_Name = new JTextField();
        Login_Name.setBounds(190, 150, 180, 30);
        form.add(Login_Name);

        JLabel Password_Prompt = new JLabel("Password");
        Password_Prompt.setBounds(80, 200, 180, 30);
        Password_Prompt.setForeground(Color.yellow);
        Password_Prompt.setFont(f1);
        form.add(Password_Prompt);

        Password = new JPasswordField();
        Password.setBounds(190, 200, 180, 30);
        form.add(Password);


        label.add(text);
        label.add(form);
        return label;
    }

    public JTextField getLogin_Name() {
        return Login_Name;
    }

    public JPasswordField getPassword() {
        return Password;
    }

}
