package GUI;

import BackEnd.FileHandling;
import BackEnd.Shop;
import Validation.InputIncorrectException;
import Validation.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartPage extends ShopsGUI{

    public static JLabel CartLabel(Shop s, JFrame jFrame){
        ImageIcon C = GUISetup.ResizeImage(new ImageIcon(CartPage.class.getResource("/Images/galal-garwan-rEh1cHyHn-o-unsplash.jpg")), 790,790);
        JLabel label = GUISetup.setBackground(C,800,800);

        JLabel IName = new JLabel("Item Name");
        IName.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC, 30));
        IName.setBounds(50,70,150,30);
        IName.setForeground(Color.ORANGE);
        label.add(IName);

        JLabel IPrice = new JLabel("Item Price");
        IPrice.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC, 30));
        IPrice.setForeground(Color.ORANGE);
        IPrice.setBounds(285,70,150,30);
        label.add(IPrice);
    

        JLabel I_Q = new JLabel("Quantity");
        I_Q.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC, 30));
        I_Q.setForeground(Color.ORANGE);
        I_Q.setBounds(520,70,150,30);
        label.add(I_Q);



        String[] columnNames = new String[] {
                "Item Name","Item Price","Quantity"
        };
        Object[][] Data;
        Data = s.ShoppingCart_toArray();
        JTable J = new JTable(Data,columnNames){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        J.setBounds(50,100,680,600);
        J.setFont(new Font("Times New Roman",Font.BOLD, 24));
        J.setForeground(Color.WHITE);
        J.setFillsViewportHeight(true);
        J.setBackground(new Color(0,0,0,80));
        J.setRowHeight(40);
        label.add(J);


        JLabel total = new JLabel("Total Bill: " + s.GenerateBill());
        total.setBounds(50,720,250,50);
        total.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC, 30));
        total.setForeground(Color.orange);
        label.add(total);

        JButton Payment = new JButton("Pay Now!");
        Payment.setBounds(550,720,150,50);
        Payment.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        Payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel p = new JPanel();
                p.add(BillPayment(s));
                jFrame.setContentPane(p);
                jFrame.pack();
            }
        });
        label.add(Payment);

        return label;
    }

    public static JLabel BillPayment(Shop s){
        ImageIcon C = GUISetup.ResizeImage(new ImageIcon(CartPage.class.getResource("/Images/galal-garwan-rEh1cHyHn-o-unsplash.jpg")), 790,790);
        JLabel label = GUISetup.setBackground(C,800,800);

        ButtonGroup B1 = new ButtonGroup();

        JRadioButton Online = new JRadioButton("Online");
        Online.setBounds(30,30,100,20);
        Online.setForeground(Color.orange);
        Online.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        Online.setBackground(new Color(0,0,0,80));



        JRadioButton Card = new JRadioButton("Card");
        Card.setBounds(140,30,100,20);
        Card.setForeground(Color.orange);
        Card.setBackground(new Color(0,0,0,80));
        Card.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        B1.add(Online);
        B1.add(Card);
        label.add(Card);
        label.add(Online);

        JPanel p = new JPanel();
        p.setVisible(false);
        p.setBounds(30,80,500,500);
        p.setBackground(new Color(0,0,0,80));
        p.setLayout(null);

        Font f = new Font("Times New Roman", Font.BOLD,24);

        JLabel Name = new JLabel("Name");
        Name.setBounds(10,20,100,30);
        Name.setForeground(Color.WHITE);
        Name.setFont(f);

        JTextField NamePrompt = new JTextField("");
        NamePrompt.setFont(f);
        NamePrompt.setBounds(110,20,300,30);
        p.add(NamePrompt);

        JLabel Address = new JLabel("Address");
        Address.setBounds(10,60,100,30);
        Address.setForeground(Color.WHITE);
        Address.setFont(f);

        JTextField AdPrompt = new JTextField("");
        AdPrompt.setFont(f);
        AdPrompt.setBounds(110,60,300,30);
        p.add(AdPrompt);


        JLabel Debit = new JLabel("Debit No");
        Debit.setBounds(10,100,100,30);
        Debit.setForeground(Color.WHITE);
        Debit.setFont(f);
        p.add(Debit);

        JTextField DebitCard = new JTextField("");
        DebitCard.setFont(f);
        DebitCard.setBounds(110,100,300,30);
        p.add(DebitCard);

        JButton Payment = new JButton("Payment");
        Payment.setBounds(320,400,150,50);
        Payment.setBackground(Color.BLACK);
        Payment.setForeground(Color.orange);
        Payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    performAction(NamePrompt.getText(),AdPrompt.getText(),DebitCard.getText(),s);

                    JFrame frame = new JFrame("Test");
                    frame.setUndecorated(true);
                    frame.setBackground(new Color(0,0,0,220));
                    frame.setSize(300, 120);
                    frame.setLocationRelativeTo(null);


                    ImageIcon loading = GUISetup.i;
                    JLabel jLabel = new JLabel("Paying.. ", loading, JLabel.CENTER);
                    jLabel.setForeground(Color.WHITE);
                    jLabel.setFont(f);
                    frame.add(jLabel);

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    Thread t1 = new Thread(()-> {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        FileHandling.SaveShopData(s,s.getUsername());
                         frame.dispose();
                        ShopsGUI s = new ShopsGUI();
                        s.HideJFrame();

                    });

                    t1.start();

                } catch (InputIncorrectException  inputIncorrectException) {
                    JOptionPane.showMessageDialog(null, "Please enter a 16 digit card number." +
                            "Invalid Inputs");
                }
            }
        });
        p.add(Payment);

        p.add(Name);
        p.add(Address);

        label.add(p);

        JPanel p1 = new JPanel();
        p1.setVisible(false);
        p1.setBounds(30,80,500,500);
        p1.setBackground(new Color(0,0,0,80));
        p1.setLayout(null);


        JLabel Name1 = new JLabel("Name");
        Name1.setBounds(10,20,100,30);
        Name1.setForeground(Color.WHITE);
        Name1.setFont(f);

        JTextField NamePrompt1 = new JTextField("");
        NamePrompt1.setFont(f);
        NamePrompt1.setBounds(110,20,300,30);
        p1.add( NamePrompt1);

        JLabel Address1 = new JLabel("Address");
        Address1.setBounds(10,60,100,30);
        Address1.setForeground(Color.WHITE);
        Address1.setFont(f);

        JTextField AdPrompt1 = new JTextField("");
        AdPrompt1.setFont(f);
        AdPrompt1.setBounds(110,60,300,30);
        p1.add(AdPrompt1);


        JLabel Credit = new JLabel("Credit Card");
        Credit.setBounds(10,100,150,30);
        Credit.setForeground(Color.WHITE);
        Credit.setFont(f);
        p1.add(Credit);

        JTextField CreditCard = new JTextField("");
        CreditCard.setFont(f);
        CreditCard.setBounds(160,100,300,30);
        p1.add(CreditCard);

        JButton Payment1 = new JButton("Payment");
        Payment1.setBounds(320,400,150,50);
        Payment1.setBackground(Color.BLACK);
        Payment1.setForeground(Color.orange);
        Payment1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    performAction(NamePrompt.getText(),AdPrompt.getText(),DebitCard.getText(),s);

                    JFrame frame = new JFrame("Test");
                    frame.setUndecorated(true);
                    frame.setBackground(new Color(0,0,0,220));
                    frame.setSize(300, 120);
                    frame.setLocationRelativeTo(null);


                    ImageIcon loading = GUISetup.i;
                    JLabel jLabel = new JLabel("Paying.. ", loading, JLabel.CENTER);
                    jLabel.setForeground(Color.WHITE);
                    jLabel.setFont(f);
                    frame.add(jLabel);

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    Thread t1 = new Thread(()-> {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        FileHandling.SaveShopData(s,s.getUsername());
                        frame.dispose();
                        ShopsGUI s = new ShopsGUI();
                        s.HideJFrame();

                    });

                    t1.start();
                } catch (InputIncorrectException inputIncorrectException) {
                    JOptionPane.showMessageDialog(null, "Please enter a 16 digit card number." +
                            "Invalid Inputs");
                }
            }
        });
        p1.add(Payment1);

        p1.add(Name1);
        p1.add(Address1);

        label.add(p1);

        Online.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p.setVisible(true);
            }
        });


        Card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                p1.setVisible(true);
            }
        });

        return label;
    }

    public static void performAction(String name, String Address, String CardNo, Shop shop) throws InputIncorrectException {
        Validator.Shop_nameCheck(name);
        Validator.UsernameCheck(Address);
        Validator.CreditCardcheck(CardNo);
        shop.SellItem();
    }

}