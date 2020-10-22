package GUI;

import BackEnd.Item;
import BackEnd.Shop;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ShopsGUI {

        static JFrame shops;
        public static void ShopsGUI(Shop s){


            shops= new JFrame("Shop");
        shops.setTitle("Online Mart"); // Setting the title of JFrame
        shops.setResizable(false); // Turning off the resizing of JFrame
        shops.setSize(800, 800); // Setting the size of the JFrame

        JPanel panel = new JPanel();
        ImageIcon Image_Background = GUISetup.ResizeImage(new ImageIcon(ShopsGUI.class.getResource("/Images/galal-garwan-rEh1cHyHn-o-unsplash.jpg")),
                790,790);

        Font f = new Font("Georgia", Font.BOLD,20);


        // Setting the background of JFrame using self defined function
        JLabel label = GUISetup.setBackground(Image_Background,800,800);

            SimpleDigitalClock displayTime = new SimpleDigitalClock();
            displayTime.setBackground(Color.black);
            displayTime.setBounds(600,20,180,40);
            shops.add(displayTime);




        Font f1 = new Font("Times New Roman", Font.PLAIN, 16);
        final int[] num = {0};
        JTextField t = new JTextField(""+ num[0]);
        t.setEditable(false);
        t.setBounds(560,510,25,35);
        t.setFont(f1);
        label.add(t);

        BasicArrowButton increment = new BasicArrowButton(BasicArrowButton.NORTH);
        increment.setBounds(585,510,20,18);
        label.add(increment);
        increment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num[0] +=  1;
                t.setText("" + num[0]);
            }
        });

        BasicArrowButton decrement = new BasicArrowButton(BasicArrowButton.SOUTH);
        decrement.setBounds(585,528,20,18);
        label.add(decrement);
        decrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num[0] > 0) {
                    num[0] -= 1;
                    t.setText("" + num[0]);
                }
            }
        });

        JTextArea display = new JTextArea ( 16,40);
        display.setEditable ( false );
        display.setBackground(new Color(0,0,0,80));
        display.setBounds(20,20,200,40);
        display.setForeground(Color.ORANGE);
        display.setFont(f);
        display.setText(s.getName());

        JPanel p = new JPanel();
        p.setBounds(200,250,400,150);
        p.setLayout(null);
        p.setBackground(Color.black);

        JLabel ItemDescription = new JLabel("Item Name: ");
        ItemDescription.setBounds(50,40,400,20);
        ItemDescription.setForeground(Color.ORANGE);
        ItemDescription.setFont(f);
        p.add(ItemDescription);



        JLabel ItemDescription1 = new JLabel("Item Price: ");
        ItemDescription1.setBounds(50,80,400,20);
        ItemDescription1.setForeground(Color.ORANGE);
        ItemDescription1.setFont(f);
        p.add(ItemDescription1);

        label.add(p);

        Font f2 = new Font("Georgia", Font.ITALIC|Font.BOLD, 25);

        JLabel comboPrompt = new JLabel("Please Select any Option");
        comboPrompt.setFont(f2);
        comboPrompt.setBounds(250,450,400,30);
        comboPrompt.setForeground(new Color(204,255,255));
        comboPrompt.setSize(400,35);



        JComboBox combo = new JComboBox(s.ItemList_toArray());
        combo.setBounds(250,510,300,35);
        combo.setBackground(Color.black);
        combo.setForeground(Color.ORANGE);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item i = s.ReturnItemName(combo.getSelectedItem().toString());
                ItemDescription.setText("Item Name: " + i.getItemName());
                ItemDescription1.setText("Item Price: " + i.getItemPrice());
            }
        });
        combo.setFont(f);


        JButton toCart = new JButton("Add to Cart");
        toCart.setBounds(330,550,150,50);
        toCart.setFont(f1);
        label.add(toCart);
        toCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item i = s.ReturnItemName(combo.getSelectedItem().toString());
                s.AddtoCart(i,num);
            }
        });


        ImageIcon A = GUISetup.ResizeImage(new ImageIcon(ShopsGUI.class.getResource("/Images/CartIcon.png")), 50, 50);
        JButton Cart = new JButton(A);
        Cart.setBounds(680,680,50,50);
        Cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num[0] == 0 || s.getShoppingCart().isEmpty())
                    JOptionPane.showMessageDialog(null, "Cart is empty!");
                else {
                    JPanel p = new JPanel();
                    JLabel jLabel = CartPage.CartLabel(s,shops);
                    p.add(jLabel);
                    shops.setContentPane(p);
                    shops.pack();
                }
            }
        });
        label.add(Cart);

        label.add(comboPrompt);
        label.add(combo);
        label.add(display);
        label.add(displayTime);

        panel.add(label);


        shops.setContentPane(panel);
        shops.pack();
        shops.setLocationRelativeTo(null); // Making sure the JFrame is visible in the center of the screen
        shops.setVisible(true); // Setting the JFrame visible

        shops.setVisible(true);
    }

    public void HideJFrame(){
       shops.setVisible(false);
    }

    static class SimpleDigitalClock extends JPanel {
        String stringTime;
        int hour, minute, second;
        String aHour = "";
        String bMinute = "";
        String cSecond = "";
        public void setStringTime(String abc) {
            this.stringTime = abc;
        }
        public int Number(int a, int b) {
            return (a <= b) ? a : b;
        }
        SimpleDigitalClock() {
            Timer t = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            t.start();
        }
        @Override
        public void paintComponent(Graphics v) {
            super.paintComponent(v);
            Calendar rite = Calendar.getInstance();
            hour = rite.get(Calendar.HOUR_OF_DAY);
            minute = rite.get(Calendar.MINUTE);
            second = rite.get(Calendar.SECOND);
            if (hour < 10) {
                this.aHour = "0";
            }
            if (hour >= 10) {
                this.aHour = "";
            }
            if (minute < 10) {
                this.bMinute = "0";
            }
            if (minute >= 10) {
                this.bMinute = "";
            }
            if (second < 10) {
                this.cSecond = "0";
            }
            if (second >= 10) {
                this.cSecond = "";
            }
            setStringTime(aHour + hour + ":" + bMinute + minute + ":" + cSecond + second);

            int length = Number(this.getWidth(), this.getHeight());
            Font Font1 = new Font("Times New Roman", Font.BOLD, 22);
            v.setFont(Font1);
            v.setColor(Color.orange);
            v.drawString(stringTime, (int) length / 6, length / 2);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(180, 40);
        }
    }
}