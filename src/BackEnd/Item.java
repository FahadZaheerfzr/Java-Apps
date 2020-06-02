package BackEnd;

import java.io.Serializable;

public class Item implements Serializable {
    // Attributes of item. Names are self explanatory
    private String ItemName;
    private float ItemPrice;
    private int ItemQuantity;

    // Constructor to initialize a method name
    public Item(String itemName, float itemPrice, int itemQuantity) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemQuantity = itemQuantity;
    }

    // Getter for Item Price
    public float getItemPrice() {
        return ItemPrice;
    }

    // Setter for Item Price
    public void setItemPrice(float itemPrice) {
        ItemPrice = itemPrice;
    }

    // Getter for Item Quantity
    public int getItemQuantity() {
        return ItemQuantity;
    }

    // Setter for Item Quantity
    public void setItemQuantity(int itemQuantity) {
        ItemQuantity = itemQuantity;
    }

    // Getter for Item Name
    public String getItemName() {
        return ItemName;
    }

    // Setter for Item Name
    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    // toString of item
    @Override
    public String toString() {
        // Displaying the attributes of item in custom format
        return getItemName() + "\t" + getItemPrice() + "\t" + getItemQuantity() + "\n";
    }
}
