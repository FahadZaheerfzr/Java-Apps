package Validation;

import BackEnd.Shop;
import GUI.Home_Page;

public class Validator {

    public static boolean Username = true;
    public static boolean Fullname = true;
    public static boolean Password = true;
    public static boolean PhoneNumber = true;
    public static boolean Balance = true;
    public static boolean Quantity = true;

    public static void UsernameCheck(String username) throws InputIncorrectException {
        Username = true;
        if (username.isEmpty()) {
            Username = false;
            throw new InputIncorrectException();
        }
        if (username.startsWith(" ")) {
            Username = false;
            throw new InputIncorrectException();
        }
        for (char c : username.toCharArray()) {
            if (c == 32) {
                Username = true;
            } else if (c < 48 || c > 122) {
                Username = false;
                throw new InputIncorrectException();
            } else if (c > 48 && c < 57) {
                Username = true;
            } else if (c < 91 || c > 96) {
                Username = true;
            } else {
                Username = false;
                throw new InputIncorrectException();
            }
        }
    }

    public static void Shop_nameCheck(String name) throws InputIncorrectException {
        Fullname = true;
        if (name.isEmpty()) {
            Fullname = false;
            throw new InputIncorrectException();

        }
        if (name.startsWith(" ")) {
            Fullname = false;
            throw new InputIncorrectException();
        }
        for (char c : name.toCharArray()) {
            if (c == 32) {
                Fullname = true;
            } else if (c > 64 && c < 91) {
                Fullname = true;
            } else if (c > 96 && c < 123) {
                Fullname = true;
            } else {
                Fullname = false;
                throw new InputIncorrectException();
            }
        }
    }

    public static void PasswordValidator(String password) throws InputIncorrectException {
        Password = true;
        if (password.length() != 8) {
            Password = false;
            throw new InputIncorrectException();
        }
        if (password.isEmpty()) {
            Password = false;
            throw new InputIncorrectException();
        }
        for (char c : password.toCharArray()) {
            if (c == 32) {
                Password = true;
            } else if (c < 48 || c > 122) {
                Password = false;
                throw new InputIncorrectException();
            } else if (c > 48 && c < 57) {
                Password = true;
            } else if (c < 91 || c > 96) {
                Password = true;
            } else {
                Password = false;
                throw new InputIncorrectException();
            }
        }
    }

    public static void PhoneNumberValidator(String phonenumber) throws InputIncorrectException {
        PhoneNumber = true;
        if (phonenumber.length() != 11) {
            PhoneNumber = false;
            throw new InputIncorrectException();
        }
        for (char c : phonenumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                PhoneNumber = false;
                throw new InputIncorrectException();
            }
        }
    }

    public static void Balance_Check(String balance) throws InputIncorrectException {
        Balance = true;

        if (balance.isEmpty()) {
            Balance = false;
            throw new InputIncorrectException();
        }
        int b = Integer.parseInt(balance);
        if (b < 0 || b > 100000000) {
            Balance = false;
            throw new InputIncorrectException();

        }
    }

    public static void Quantity_Check(String quantity) throws InputIncorrectException {
        Quantity = true;

        if (quantity.isEmpty()) {
            Quantity = false;
            throw new InputIncorrectException();
        }
        int b = Integer.parseInt(quantity);
        if (b < 0 || b > 100000) {
            Quantity = false;
            throw new InputIncorrectException();
        }
    }

    public static void PasswordEqual(String a, String b) throws UnequalException {
        if (a.equals(b)) ;
        else
            throw new UnequalException();
    }

    public static void ShopVerification(String a, String b)throws UnequalException{
        boolean ShopFound =false;
        for (Shop s : Home_Page.MarketPlace){
            if(a.equals(s.getUsername()) && b.equals(s.getPassword())){
               ShopFound = true;
               break;
            }
        }
        if (ShopFound);
        else
            throw new UnequalException();
    }

    public static void AlreadyExist(String a) throws InputIncorrectException{
        boolean Exist = false;
        for (Shop s: Home_Page.MarketPlace){
            if(a.equals(s.getUsername())){
                Exist = true;
                break;
            }
        }
        if(Exist)
            throw new InputIncorrectException();
    }
}
