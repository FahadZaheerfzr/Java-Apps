package GUI;

import BackEnd.FileHandling;
import Validation.InputIncorrectException;
import Validation.MissingValueExceptions;
import Validation.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatingShop {

    private JTextField Login_Name;
    private JPasswordField Password;
    private JPasswordField C_Password;
    private JFrame Shop = new JFrame("Store Customization");
    private Thread t;

    public JLabel CreateShop() {

        for(BackEnd.Shop s : Home_Page.MarketPlace){
            System.out.println(s.getUsername());
            System.out.println(s.getPassword());
            s.DisplayItems();
        }
        JLabel label = GUISetup.label;

        Font f = new Font("Times New Roman", Font.BOLD, 48);
        JLabel text = new JLabel("Sign Up!");
        text.setFont(f);
        text.setForeground(new Color(255, 255, 0));
        text.setBounds(170, 40, 650, 70);

        JPanel form = new JPanel();
        form.setLayout(null);
        form.setBounds(140, 180, 500, 400);
        form.setBackground(new Color(0, 0, 0, 80));
        form.add(text);

        Font f1 = new Font("Times New Roman", Font.BOLD, 20);


        JLabel Name_Prompt = new JLabel("Set Username");
        Name_Prompt.setBounds(70, 150, 180, 30);
        Name_Prompt.setForeground(new Color(255, 255, 0));
        Name_Prompt.setFont(f1);
        form.add(Name_Prompt);


        Login_Name = new JTextField();
        Login_Name.setBounds(190, 150, 180, 30);
        form.add(Login_Name);

        JLabel Password_Prompt = new JLabel("Set Password");
        Password_Prompt.setBounds(70, 200, 180, 30);
        Password_Prompt.setForeground(new Color(255, 255, 0));
        Password_Prompt.setFont(f1);
        form.add(Password_Prompt);

        Password = new JPasswordField();
        Password.setBounds(190, 200, 180, 30);
        form.add(Password);

        JLabel C_Password_Prompt = new JLabel("Confirm P.W");
        C_Password_Prompt.setBounds(70, 250, 180, 30);
        C_Password_Prompt.setForeground(new Color(255, 255, 0));
        C_Password_Prompt.setFont(f1);
        form.add(C_Password_Prompt);

        C_Password = new JPasswordField();
        C_Password.setBounds(190, 250, 180, 30);
        form.add(C_Password);

        label.add(form);

        return label;
    }

    public JTextField getLogin_Name() {
        return Login_Name;
    }

    public JPasswordField getPassword() {
        return Password;
    }

    public JPasswordField getC_Password() {
        return C_Password;
    }

    public void CustomizingShop(BackEnd.Shop s) {
        Font f2 = new Font("Georgia", Font.ITALIC | Font.BOLD, 25);
        Shop.setTitle("Shop Customization"); // Setting the title of JFrame
        Shop.setResizable(false); // Turning off the resizing of JFrame
        Shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminating the program if cross button is pressed
        Shop.setSize(800, 800); // Setting the size of the JFrame


        // Creating an image icon to set the background image of the JFrame
        // Resizing the ImageBackground using a self defined function Resize
        ImageIcon Image_Background = GUISetup.ResizeImage(new ImageIcon("src\\Images\\StoreInitialize.jpg"),
                790, 790);


        // Setting the background of JFrame using self defined function
        JLabel label = GUISetup.setBackground(Image_Background, 800, 800);

        JButton Name = new JButton("Set Name");
        Name.setFont(f2);
        Name.setForeground(Color.CYAN);
        Name.setBackground(new Color(95, 162, 202));
        Name.setBounds(200, 100, 375, 60);
        Name.addActionListener(new ActionListener() {
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

                JLabel NamePrompt = new JLabel("Shop Name:");
                NamePrompt.setBounds(200, 400, 150, 50);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(font);
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(360, 400, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);



                JButton Save = new JButton("Save Name");
                Save.setBounds(320, 550, 150, 50);
                Save.setFont(font);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Validator.Shop_nameCheck(Name1.getText());
                            s.setName(Name1.getText());
                            SaveJFrame.setVisible(false);
                            t = new Thread(()-> FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (InputIncorrectException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid Shop Name");
                        }
                    }
                });


                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);

            }
        });
        label.add(Name);

        JButton Type = new JButton("Shop Type");
        Type.setForeground(Color.CYAN);
        Type.setBackground(new Color(95, 162, 202));
        Type.setFont(f2);
        Type.setBounds(200, 200, 375, 60);
        Type.addActionListener(new ActionListener() {
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

                JLabel NamePrompt = new JLabel("Shop Type:");
                NamePrompt.setBounds(200, 400, 150, 50);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(font);
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(360, 400, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);


                JButton Save = new JButton("Save");
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
                            s.setType(Name1.getText());
                            SaveJFrame.setVisible(false);
                            t = new Thread(()-> FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (InputIncorrectException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid Shop Type");
                        }
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);

            }
        });
        label.add(Type);


        JButton AddItem = new JButton("Add Item");
        AddItem.setForeground(Color.CYAN);
        AddItem.setBackground(new Color(95, 162, 202));
        AddItem.setFont(f2);
        AddItem.setBounds(200, 300, 375, 60);
        AddItem.addActionListener(new ActionListener() {
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
                            t = new Thread(()->FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (InputIncorrectException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid Inputs");
                        }
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);
            }
        });
        label.add(AddItem);

        JButton AddPhone = new JButton("Phone No");
        AddPhone.setForeground(Color.CYAN);
        AddPhone.setBackground(new Color(95, 162, 202));
        AddPhone.setFont(f2);
        AddPhone.setBounds(200, 400, 375, 60);
        AddPhone.addActionListener(new ActionListener() {
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

                JLabel NamePrompt = new JLabel("Phone Number:");
                NamePrompt.setBounds(160, 400, 180, 50);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(font);
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(360, 400, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);


                JButton Save = new JButton("Save");
                Save.setBounds(320, 550, 150, 50);
                Save.setFont(font);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Validator.PhoneNumberValidator(Name1.getText());
                            s.setPhoneNumber(Name1.getText());
                            SaveJFrame.setVisible(false);
                            t = new Thread(()->FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        } catch (InputIncorrectException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid PhoneNumber");
                        }
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);

            }
        });
        label.add(AddPhone);

        JButton Remove = new JButton("Remove Item");
        Remove.setForeground(Color.CYAN);
        Remove.setBackground(new Color(95, 162, 202));
        Remove.setFont(f2);
        Remove.setBounds(200, 500, 375, 60);
        Remove.addActionListener(new ActionListener() {
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

                JLabel NamePrompt = new JLabel("Enter the item name to be removed");
                NamePrompt.setBounds(175, 340, 500, 60);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(new Font("Times New Roman", Font.BOLD, 30));
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(275, 420, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);

                JButton Save = new JButton("Remove");
                Save.setBounds(320, 500, 150, 50);
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
        label.add(Remove);

        JButton Balance = new JButton("Initial Balance");
        Balance.setForeground(Color.CYAN);
        Balance.setBackground(new Color(95, 162, 202));
        Balance.setFont(f2);
        Balance.setBounds(200, 600, 375, 60);
        Balance.addActionListener(new ActionListener() {
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

                JLabel NamePrompt = new JLabel("Initial Balance:");
                NamePrompt.setBounds(160, 400, 180, 50);
                NamePrompt.setForeground(Color.WHITE);
                NamePrompt.setFont(font);
                jLabel.add(NamePrompt);

                JTextField Name1 = new JTextField("");
                Name1.setBounds(360, 400, 250, 50);
                Name1.setFont(font);
                jLabel.add(Name1);


                JButton Save = new JButton("Save");
                Save.setBounds(320, 550, 150, 50);
                Save.setFont(font);
                Save.setBackground(Color.black);
                Save.setForeground(Color.WHITE);
                jLabel.add(Save);

                Save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Validator.Balance_Check(Name1.getText());
                            s.setBalance(Integer.parseInt(Name1.getText()));
                            SaveJFrame.setVisible(false);
                            t = new Thread(()->FileHandling.SaveShopData(s,s.getUsername()));
                            t.start();
                        }catch (InputIncorrectException inputIncorrectException){
                            JOptionPane.showMessageDialog(null,"Invalid Balance Entered");
                        }
                        System.out.println(s.getBalance());
                    }
                });

                SaveJFrame.add(jLabel);
                SaveJFrame.setLocationRelativeTo(null);
                SaveJFrame.setVisible(true);

            }
        });

        label.add(Balance);


        Shop.add(label); // Adding the JLabel in JFrame
        Shop.setLocationRelativeTo(null); // Making sure the JFrame is visible in the center of the screen
        Shop.setVisible(true); // Setting the JFrame visible
    }
}