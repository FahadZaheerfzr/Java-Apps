package BackEnd;

import GUI.Home_Page;
import Validation.MissingValueExceptions;

import java.io.Serializable;
import java.util.ArrayList;

// The class implements Serialization to save instances of class
public class Shop implements Serializable {
    // Attributes of Shop
    private String name; // Name of the Shop
    private String type; // Type of shop e.g General Store, Fruit Shop etc
    private String PhoneNumber; // Phone Number of the shop
    private int Balance; // The balance available in the shop
    private String username;  // Username of admin
    private String password; // Password of admin
    private ArrayList<Item> ItemList; // The list of items available in the shop.
    private ArrayList<Item> ShoppingCart; // Shopping Cart for customer
    private ArrayList<Item> RecentlySold; // Last 10 sold items of the shop.

    // Constructor of class
    public Shop(){
        // Initializing the item list for the shop
        ItemList = new ArrayList<>();
    }

    // Getter for username of the admin
    public String getUsername() {
        return username;
    }

    // Getter for the name of the shop
    public String getName() {
        return name;
    }

    // Setter for the name of the shop
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the phone number of the shop
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    // Setter for the phone number of the shop
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }


    // Creating Admin Login setting the username and password
    public void CreateAdminLogin(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Initializing items in the item list of the shop
    public void initializeItem(String name, String price, String quantity){
        // Creating a temporary item with respective attributes
        Item i = new Item(name,Float.parseFloat(price), Integer.parseInt(quantity));
        // Adding item in the ItemList
        ItemList.add(i);
    }

    public void ShoppingCart(){

    }

    //public double GenerateBill(){

    //}

    public void RecentlySold(){

    }

    // Getter for the type of the shop
    public String getType() {
        return type;
    }

    // Setter for the type of the shop
    public void setType(String type) {
        this.type = type;
    }

    // Method for removing the item from ItemList
    public void RemoveItem(String i){
        Item tobeRemoved = null;
        // Finding the item in the list
        for (Item a : ItemList){
            if (i.equals(a.getItemName())) {
                tobeRemoved = a; // setting the temporary item
                break;
            }
        }
        // Removing the item from the ItemList
        ItemList.remove(tobeRemoved);
    }

    // Getter for the balance of the shop
    public int getBalance() {
        return Balance;
    }

    // Setter for the balance of the shop
    public void setBalance(int balance) {
        Balance = balance;
    }

    // Finding item if it exist in the shopping list
    public void findItem(String s) throws MissingValueExceptions {
        // Boolean found set false. To be used later
        boolean found = false;
        // Searching for the item in ItemList
        for(Item a : ItemList){
            if(s.equals(a.getItemName())){
                found = true;
                break;
            }
        }
        // If item is found do nothing
        if (found);
        else // Else throw a missing value exception.
            throw new MissingValueExceptions();

    }

    // Displaying all the items available in the ItemList of the shop
    public String DisplayItems(){
        // A string which will contain all the items
        String Display = "";
        // Adding the toString of each item in the ItemList to the Display String
        for (Item i : ItemList){
            Display += i.toString();
        }
        // Returning the Display String
        return Display;
    }

    // This method does not allow more shops to be created
    public static void NoMoreShop() throws ArrayIndexOutOfBoundsException{
        // If marketplace is greater than 6 you can not have more shops
        if (Home_Page.MarketPlace.size() <= 6);
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    // Getter for the password of admin
    public String getPassword() {
        return password;
    }

}
