package GUI;

import BackEnd.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInterface {

    public static JLabel CustomerLabel(){
        ImageIcon C = GUISetup.ResizeImage(new ImageIcon(CustomerInterface.class.getResource("/Images/people.jpg")),790,790);
        JLabel label = GUISetup.setBackground(C,800,800);

        Font font = new Font("Georgia", Font.BOLD|Font.ITALIC, 24);

        int i = 30;
        int j = 30;
        for(Shop s :Home_Page.MarketPlace){
            JButton jb = s.getShopButton();
            jb.setBackground(Color.black);
            jb.setForeground(Color.yellow);
            jb.setFont(font);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ShopsGUI.ShopsGUI(s);
                }
            });
            jb.setBounds(i,j,300,200);
            label.add(jb);

            j += 250;
            if (j == 780){
                j = 30;
                i = 380;
            }
        }



        return label;
    }
}
