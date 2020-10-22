package Validation;

import BackEnd.Shop;
import GUI.Home_Page;

public class Validator {

    public static void UsernameCheck(String username) throws InputIncorrectException {
        if (username.isEmpty()) {
            throw new InputIncorrectException();
        }
        if (username.startsWith(" ")) {
            throw new InputIncorrectException();
        }
        for (char c : username.toCharArray()) {
            if (c == 32) {
            } else if (c < 48 || c > 122) {
                throw new InputIncorrectException();
            } else if (c > 48 && c < 57) {
            } else if (c < 91 || c > 96) {
            } else {
                throw new InputIncorrectException();
            }
        }
    }

    public static void Shop_nameCheck(String name) throws InputIncorrectException {
        if (name.isEmpty()) {
            throw new InputIncorrectException();

        }
        if (name.startsWith(" ")) {
            throw new InputIncorrectException();
        }
        for (char c : name.toCharArray()) {
            if (c == 32) {
            } else if (c > 64 && c < 91) {
            } else if (c > 96 && c < 123) {
            } else {
                throw new InputIncorrectException();
            }
        }
    }

    public static void PasswordValidator(String password) throws InputIncorrectException {
        if (password.length() != 8) {
            throw new InputIncorrectException();
        }
        if (password.isEmpty()) {
            throw new InputIncorrectException();
        }
        for (char c : password.toCharArray()) {
            if (c == 32) {
            } else if (c < 48 || c > 122) {
                throw new InputIncorrectException();
            } else if (c > 48 && c < 57) {
            } else if (c < 91 || c > 96) {
            } else {
                throw new InputIncorrectException();
            }
        }
    }

    public static void PhoneNumberValidator(String phonenumber) throws InputIncorrectException {
        if (phonenumber.length() != 11) {
            throw new InputIncorrectException();
        }
        for (char c : phonenumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InputIncorrectException();
            }
        }
    }

    public static void Balance_Check(String balance) throws InputIncorrectException {

        if (balance.isEmpty()) {
            throw new InputIncorrectException();
        }
        for (char c : balance.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InputIncorrectException();
            }
        }
        int b = Integer.parseInt(balance);
        if (b < 0 || b > 100000000) {
            throw new InputIncorrectException();

        }
    }

    public static void Quantity_Check(String quantity) throws InputIncorrectException {

        if (quantity.isEmpty()) {
            throw new InputIncorrectException();
        }
        int b = Integer.parseInt(quantity);
        if (b < 0 || b > 100000) {
            throw new InputIncorrectException();
        }
    }

    public static void PasswordEqual(String a, String b) throws UnequalException {
        if (a.equals(b)) ;
        else
            throw new UnequalException();
    }

    public static Shop ShopVerification(String a, String b)throws UnequalException{
        Shop e = null;
        boolean ShopFound =false;
        for (Shop s : Home_Page.MarketPlace){
            if(a.equals(s.getUsername()) && b.equals(s.getPassword())){
                e = s;
               ShopFound = true;
               break;
            }
        }
        if (ShopFound)
            return e;
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

    public static void Balance_Update_Check(int balance, int updater) throws InputIncorrectException {
        if (updater > balance)
            throw new InputIncorrectException();
    }

    public static void saleLimitcheck(float s)throws InputIncorrectException{
        if(s < 0 || s > 100)
            throw new InputIncorrectException();
    }

    public static void CreditCardcheck(String c) throws InputIncorrectException{
        if (c.length() != 16) {
            throw new InputIncorrectException();
        }
        for (char c1 : c.toCharArray()) {
            if (!Character.isDigit(c1)) {
                throw new InputIncorrectException();
            }
        }

    }
}
