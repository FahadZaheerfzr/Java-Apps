package GUI;

import BackEnd.FileHandling;
import BackEnd.Shop;
import Validation.InputIncorrectException;
import Validation.UnequalException;
import Validation.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Home_Page extends OpeningGui{

    // Class Attributes
    protected JFrame HomeJFrame = new JFrame(); // A JFrame so it can be accessed anywhere in the file
    protected JPanel Panel = new JPanel(); // A JPanel so it can be accessed anywhere in the file

    public static ArrayList<Shop> MarketPlace;

    public static void SimultaneousLoading() {

        // Creating an image icon to set the background image of the JFrame and
        // Resizing the ImageBackground using a self defined function Resize
        ImageIcon Image_Background = GUISetup.ResizeImage(new ImageIcon(Home_Page.class.getResource("/Images/CreateStore.jpg")),
                790, 790);


        // Setting the background of JFrame using self defined function
        // Initializing a label sp it doesn't take time to load.
        GUISetup.label = GUISetup.setBackground(Image_Background, 800, 800);

        GUISetup.i = new ImageIcon(CartPage.class.getResource("/Images/Loader.gif"));


        File f = new File(System.getProperty("user.dir"));
        MarketPlace = FileHandling.loadAllFilesinFolder(f);
    }

    public void ShowHome_Page() {
        Thread t = new Thread(() -> {
            SimultaneousLoading();
        });
        t.start();

        HomeJFrame.setTitle("Online Mart"); // Setting the title of JFrame
        HomeJFrame.setResizable(false); // Turning off the resizing of JFrame
        HomeJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminating the program if cross button is pressed
        HomeJFrame.setSize(800, 800); // Setting the size of the JFrame

        Panel.setSize(800, 800);

        // Creating an image icon to set the background image of the JFrame
        ImageIcon Image_Background = new ImageIcon(getClass().getResource("/Images/dock-street-market.jpg"));
        // Resizing the ImageBackground using a self defined function Resize
        Image_Background = GUISetup.ResizeImage(Image_Background, 790, 790);

        // Creating font for the buttons
        Font F = new Font("Times New Roman", Font.BOLD|Font.ITALIC, 30);


        // Creating another image icon and also resizing it to set the icon of the Admin ButtonforName
        ImageIcon A = GUISetup.ResizeImage(new ImageIcon(getClass().getResource("/Images/AdminIcon.jpg")), 100, 100);
        JButton Admin = new JButton("Admin", A); // An admin button with icon
        Admin.setBackground(Color.BLACK); // Setting the button Background color
        Admin.setFont(F); // Setting Custom Font
        Admin.setForeground(new Color(158,199,252));
        // Setting the position of the text
        Admin.setVerticalTextPosition(AbstractButton.CENTER);
        Admin.setHorizontalTextPosition(AbstractButton.LEADING);
        Admin.setIconTextGap(20); // A gap bw icon and text
        Admin.setBounds(260, 200, 300, 100); // Setting the bounds of the button


        // Creating another image icon to set the icon of the Customer ButtonforName
        ImageIcon C = GUISetup.ResizeImage(new ImageIcon(getClass().getResource("/Images/CustomerIcon.png")), 100, 100);
        JButton Customer = new JButton("Customer", C); // A customer button with icon
        Customer.setBackground(Color.black); // Setting the button Background color
        Customer.setFont(F); // Setting Custom Font
        Customer.setForeground(new Color(158,199,252)); // Setting the color of the font
        // Setting the position of the text
        Customer.setVerticalTextPosition(AbstractButton.CENTER);
        Customer.setHorizontalTextPosition(AbstractButton.LEADING);
        Customer.setIconTextGap(20); // A gap bw icon and text
        Customer.setBounds(260, 400, 300, 100); // Setting the bounds of the button
        Customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel p = new JPanel();
                try {
                    JLabel s = CustomerInterface.CustomerLabel();
                    JButton Back = new JButton("Back");
                    Back.setBounds(70, 740, 150, 30);
                    Font f1 = new Font("Times New Roman", Font.BOLD, 18);
                    Back.setFont(f1);
                    Back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            HomeJFrame.setContentPane(Panel);
                            HomeJFrame.pack();

                        }
                    });
                    s.add(Back);
                    p.add(s);
                    HomeJFrame.setContentPane(p);
                    HomeJFrame.pack();
                } catch (NullPointerException nullPointerException){
                    JOptionPane.showMessageDialog(null,"No Shop Exist");
                }


            }
        });


        // Setting the background of JFrame using self defined function
        JLabel label = GUISetup.setBackground(Image_Background, 800, 800);
        label.add(Customer); // Adding the customer button to JLabel
        label.add(Admin); // Adding the admin button to JLabel

        // Adding the label to the panel
        Panel.add(label);

        HomeJFrame.setContentPane(Panel); // Adding the JLabel in JFrame
        HomeJFrame.setLocationRelativeTo(null); // Making sure the JFrame is visible in the center of the screen
        HomeJFrame.setVisible(true); // Setting the JFrame visible


        Admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Font f1 = new Font("Times New Roman", Font.BOLD, 24);
                JPanel P = new JPanel();
                AdminPage a = new AdminPage();
                JLabel frame2 = a.AdminLabel();
                JButton Login = new JButton("Login");
                Login.setBounds(450, 500, 180, 60);
                Login.setFont(f1);
                Login.setForeground(Color.yellow);
                Login.setBackground(new Color(0, 0, 0));
                frame2.add(Login);
                Login.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextField TemporaryUsername = a.getLogin_Name();
                        JPasswordField TemporaryPassword = a.getPassword();

                        try {
                            Validator.UsernameCheck(TemporaryUsername.getText());
                            Validator.PasswordValidator(TemporaryPassword.getText());
                            Shop temp = Validator.ShopVerification(TemporaryUsername.getText(),TemporaryPassword.getText());
                            JLabel labelx;
                            labelx = ManageShop.ManageLabel(temp);

                            JPanel panelx = new JPanel();
                            panelx.add(labelx);

                            HomeJFrame.setContentPane(panelx);
                            HomeJFrame.pack();

                        } catch (InputIncorrectException | UnequalException inputIncorrectException) {
                            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                        }
                    }
                });
                JButton Back = new JButton("Back");
                Back.setBounds(70, 680, 200, 55);
                Back.setFont(f1);
                Back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        HomeJFrame.setContentPane(Panel);
                        HomeJFrame.pack();

                    }
                });
                JButton NewShop = new JButton("Create Store");
                NewShop.setBounds(500, 680, 200, 55);
                NewShop.setFont(f1);
                NewShop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreatingShop c = new CreatingShop();


                        JLabel label1 = c.CreateShop();

                        Font f1 = new Font("Times New Roman", Font.BOLD, 18);
                        JButton Back = new JButton("Back");
                        Back.setBounds(160, 500, 120, 60);
                        Back.setBackground(Color.black);
                        Back.setForeground(new Color(255, 255, 0));
                        Back.setFont(f1);
                        Back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                HomeJFrame.setContentPane(P);
                                HomeJFrame.pack();


                            }
                        });
                        JButton SignUP = new JButton("Create");
                        SignUP.setBounds(510, 500, 120, 60);
                        SignUP.setBackground(Color.black);
                        SignUP.setForeground(new Color(255, 255, 0));
                        SignUP.setFont(f1);
                        SignUP.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CreatingShop C1 = new CreatingShop();
                                JTextField TemporaryUsername = c.getLogin_Name();
                                JPasswordField TemporaryPassword = c.getPassword();
                                JPasswordField TemporraryCwPassword = c.getC_Password();

                                try {
                                    Validator.UsernameCheck(TemporaryUsername.getText());
                                    Validator.PasswordValidator(TemporaryPassword.getText());
                                    Validator.PasswordEqual(TemporaryPassword.getText(), TemporraryCwPassword.getText());
                                    Validator.AlreadyExist(TemporaryUsername.getText());

                                    Shop shop = new Shop();
                                    shop.CreateAdminLogin(TemporaryUsername.getText(), TemporaryPassword.getText());
                                    Shop.NoMoreShop();
                                    C1.CustomizingShop(shop);
                                    HomeJFrame.setVisible(false);
                                } catch (InputIncorrectException inputIncorrectException) {
                                    JOptionPane.showMessageDialog(null, "Shop Already Exist or Invalid Username or Password");
                                } catch (UnequalException unequalException) {
                                    JOptionPane.showMessageDialog(null, "Password doesn't matches");
                                }catch (ArrayIndexOutOfBoundsException exception){
                                    JOptionPane.showMessageDialog(null, "Market Place is full");
                                }

                            }
                        });


                        label1.add(Back);
                        label1.add(SignUP);
                        JPanel P1 = new JPanel();
                        P1.add(label1);
                        HomeJFrame.setContentPane(P1);
                        HomeJFrame.pack();
                    }

                });

                frame2.add(NewShop);
                frame2.add(Back);

                P.add(frame2);
                HomeJFrame.setContentPane(P);
                HomeJFrame.pack();
            }
        });

    }
}