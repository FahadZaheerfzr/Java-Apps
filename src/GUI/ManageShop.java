package GUI;

import BackEnd.FileHandling;
import BackEnd.Shop;
import Validation.InputIncorrectException;
import Validation.MissingValueExceptions;
import Validation.Validator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageShop {

    private static Thread t;

    public static JLabel ManageLabel(Shop s){
        // Creating an image icon to set the background image of the JFrame and
        // Resizing the ImageBackground using a self defined function Resize
        ImageIcon Image_Background = GUISetup.ResizeImage(new ImageIcon(ManageShop.class.getResource("/Images/ManageShop.jpg")),
                790, 790);

        // Setting the background of JFrame using self defined function

        JLabel label =  GUISetup.setBackground(Image_Background,800,800);

        Font f2 = new Font("Georgia", Font.ITALIC|Font.BOLD, 25);

        JLabel label_for_name = new JLabel();
        label_for_name.setText(s.getName());
        label_for_name.setSize(375,80);
        label_for_name.setBounds(300,150,200,70);
        label_for_name.setFont(f2);

        JButton btn1 = new JButton("Add Item");
        btn1.setForeground(Color.CYAN);
        btn1.setBackground(new Color(95,162,202));
        btn1.setBounds(200,280,375,60);
        btn1.setFont(f2);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame SaveJFrame = new JFrame();
                SaveJFrame.setUndecorated(true);
                SaveJFrame.setSize(800, 800);
                SaveJFrame.setBackground(new Color(0, 0, 0, 80));

                JLabel jLabel = new JLabel();
                jLabel.setBackground(new Color(0, 0, 0, 255));
                jLabel.setBounds(0, 0, 800, 800);
                jLabel.setFocusable(true);

                Font font = new Font("Times New Roman", Font.BOLD, 24);

                JLabel ItemName = new JLabel("Item Name:");
                ItemName.setBounds(130, 220, 150, 50);
                ItemName.setForeground(Color.WHITE);
                ItemName.setFont(font);
                jLabel.add(ItemName);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(290, 220, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);

                JLabel ItemPrice = new JLabel("Item Price:");
                ItemPrice.setBounds(130, 320, 150, 50);
                ItemPrice.setForeground(Color.WHITE);
                ItemPrice.setFont(font);
                jLabel.add(ItemPrice);

                JTextField Price = new JTextField("");
                Price.setBounds(290, 320, 250, 50);
                Price.setFont(font);
                jLabel.add(Price);

                JLabel ItemQuantity = new JLabel("Quantity:");
                ItemQuantity.setBounds(130, 420, 150, 50);
                ItemQuantity.setForeground(Color.WHITE);
                ItemQuantity.setFont(font);
                jLabel.add(ItemQuantity);

                JTextField Quantity = new JTextField("");
                Quantity.setBounds(290, 420, 250, 50);
                Quantity.setFont(font);
                jLabel.add(Quantity);


                JButton Save = new JButton("Add");
                Save.setBounds(320, 550, 150, 50);
                Save.setFont(font);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Validator.UsernameCheck(Name1.getText());
                            Validator.Quantity_Check(Quantity.getText());
                            Validator.Balance_Check(Price.getText());

                            s.initializeItem(Name1.getText(),Price.getText(),Quantity.getText());
                            SaveJFrame.setVisible(false);
                            t = new Thread(()-> FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (InputIncorrectException | NumberFormatException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid Inputs");
                        }
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);
            }
        });

        JButton btn2 = new JButton("Remove Item");
        btn2.setForeground(Color.CYAN);
        btn2.setBackground(new Color(95,162,202));
        btn2.setBounds(200,360,375,60);
        btn2.setFont(f2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame SaveJFrame = new JFrame();
                SaveJFrame.setUndecorated(true);
                SaveJFrame.setSize(800, 800);
                SaveJFrame.setBackground(new Color(0, 0, 0, 80));

                JLabel jLabel = new JLabel("");
                jLabel.setBackground(new Color(0, 0, 0, 255));
                jLabel.setBounds(0, 0, 800, 800);
                jLabel.setFocusable(true);

                Font font = new Font("Times New Roman", Font.BOLD, 24);

                JLabel NamePrompt = new JLabel("Item Name:");
                NamePrompt.setBounds(200, 400, 150, 50);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(font);
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(360, 400, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);



                JButton Save = new JButton("Remove Item");
                Save.setBounds(320, 550, 250, 50);
                Save.setFont(font);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            s.findItem(Name1.getText());
                            s.RemoveItem(Name1.getText());

                            SaveJFrame.setVisible(false);
                            t = new Thread(()->FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (MissingValueExceptions inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"The items doesn't exist");
                            SaveJFrame.setVisible(false);
                        }
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);


            }
        });

        JButton btn3 = new JButton("Current Balance");
        btn3.setForeground(Color.CYAN);
        btn3.setBackground(new Color(95,162,202));
        btn3.setBounds(200,440,375,60);
        btn3.setFont(f2);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame SaveJFrame = new JFrame();
                SaveJFrame.setUndecorated(true);
                SaveJFrame.setSize(800, 800);
                SaveJFrame.setBackground(new Color(0, 0, 0, 80));

                JLabel jLabel = new JLabel("");
                jLabel.setBackground(new Color(0, 0, 0, 255));
                jLabel.setBounds(0, 0, 800, 800);
                jLabel.setFocusable(true);

                Font font = new Font("Times New Roman", Font.BOLD, 36);
                Font font1 = new Font("Times New Roman", Font.BOLD, 24);

                JLabel C_Balance = new JLabel();
                C_Balance.setText(""+s.getBalance()+".00 Rs");
                C_Balance.setForeground(Color.WHITE);
                C_Balance.setFont(font);
                C_Balance.setBounds(325,400,350,50);
                jLabel.add(C_Balance);


                JButton Save = new JButton("OK");
                Save.setBounds(325, 550, 150, 50);
                Save.setFont(font1);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SaveJFrame.setVisible(false);
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);



            }
        });

        JButton btn4 = new JButton("View Inventory");
        btn4.setForeground(Color.CYAN);
        btn4.setBackground(new Color(95,162,202));
        btn4.setBounds(200,520,375,60);
        btn4.setFont(f2);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel middlePanel = new JPanel ();
                middlePanel.setBorder ( new TitledBorder( new EtchedBorder(), "Inventory" ) );

                // create the middle panel components

                Font f = new Font("Times New Roman", Font.BOLD,24);

                JTextArea display = new JTextArea ( 16,40);
                display.setEditable ( false ); // set textArea non-editable
                display.setText(s.DisplayItems());
                display.setBackground(new Color(95,162,202));
                display.setForeground(Color.WHITE);
                display.setFont(f);
                JScrollPane scroll = new JScrollPane ( display );
                scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
                //Add Textarea in to middle panel
                middlePanel.add ( scroll );
                // My code
                JFrame frame = new JFrame ();
                frame.add ( middlePanel );
                frame.setResizable(false);
                frame.pack ();
                frame.setLocationRelativeTo ( null );
                frame.setVisible ( true );


            }
        });

        JButton btn5 = new JButton("Withdraw Amount");
        btn5.setForeground(Color.CYAN);
        btn5.setBackground(new Color(95,162,202));
        btn5.setBounds(200,600,375,60);
        btn5.setFont(f2);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame SaveJFrame = new JFrame();
                SaveJFrame.setUndecorated(true);
                SaveJFrame.setSize(800, 800);
                SaveJFrame.setBackground(new Color(0, 0, 0, 80));

                JLabel jLabel = new JLabel("");
                jLabel.setBackground(new Color(0, 0, 0, 255));
                jLabel.setBounds(0, 0, 800, 800);
                jLabel.setFocusable(true);

                Font font = new Font("Times New Roman", Font.BOLD, 24);

                JLabel NamePrompt = new JLabel("Enter Amount:");
                NamePrompt.setBounds(150, 400, 250, 50);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(font);
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(360, 400, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);



                JButton Save = new JButton("Withdraw Amount");
                Save.setBounds(320, 550, 250, 50);
                Save.setFont(font);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Validator.Balance_Update_Check(s.getBalance(),Integer.parseInt(Name1.getText()));
                            SaveJFrame.setVisible(false);
                            s.UpdateBalance(Integer.parseInt(Name1.getText()));
                            t = new Thread(()-> FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (InputIncorrectException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid Balance");
                        }
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);


            }
        });

        JButton btn6 = new JButton("Sale");
        btn6.setForeground(Color.CYAN);
        btn6.setBackground(new Color(95,162,202));
        btn6.setBounds(200,680,375,60);
        btn6.setFont(f2);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame SaveJFrame = new JFrame();
                SaveJFrame.setUndecorated(true);
                SaveJFrame.setSize(800, 800);
                SaveJFrame.setBackground(new Color(0, 0, 0, 80));

                JLabel jLabel = new JLabel("");
                jLabel.setBackground(new Color(0, 0, 0, 255));
                jLabel.setBounds(0, 0, 800, 800);
                jLabel.setFocusable(true);

                Font font = new Font("Times New Roman", Font.BOLD, 24);

                JLabel NamePrompt = new JLabel("Sale %:");
                NamePrompt.setBounds(200, 400, 150, 50);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(font);
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(360, 400, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);



                JButton Save = new JButton("Give Discount");
                Save.setBounds(320, 550, 250, 50);
                Save.setFont(font);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Validator.saleLimitcheck(Float.parseFloat(Name1.getText()));
                            s.Sale(Float.parseFloat(Name1.getText()));
                            SaveJFrame.setVisible(false);
                            t = new Thread(()-> FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (InputIncorrectException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid Entry");
                        }
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);


            }
        });

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