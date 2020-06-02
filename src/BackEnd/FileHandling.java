package BackEnd;

import java.io.*;
import java.util.ArrayList;

public class FileHandling {

    // Method to save the object of shop class using serialization
    public static void SaveShopData(Shop UD, String name){
        try {
            // Creating a file or looking for a file with particular file name
            FileOutputStream fileOut =
                    new FileOutputStream("ShopData" + name +  ".ser");
            // Creating an object of ObjectOutputStream executing on the File to be output
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Writing the object of shop in ObjectOutputStream
            out.writeObject(UD);
            // Closing the ObjectOutputStream
            out.close();
            // Closing the file
            fileOut.close();
        } catch (IOException i) {
            // Printing in case of exception
            System.out.println(i);
        }
    }

    // This method reads the serialized object from a file and return that back as an object
    public static Shop ReadShopData(String f) {
        // An instance variable to return the object
        Shop e = null;
        try {
            // A file input stream on a path f
            FileInputStream fileIn = new FileInputStream(f);
            // ObjectInputStream to read the object from the file
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // Reading the serialized object and casting it back to Shop Object
            e = (Shop) in.readObject();
            // Closing the ObjectInputStream
            in.close();
            // Closing the file
            fileIn.close();
        } catch (IOException i) {
            // Looking for exception trace
            System.out.println("Shop class not found");
        } catch (ClassNotFoundException c) {
            // Looking for exception trace
            System.out.println("Shop class not found");
        }
        // Returning the object
        return e;
    }

    /*
     * This method receives a directory and search for files ending
     * with .ser extension and pass that file to another method.
     * The method returns ArrayList of all the files ending with .ser
     * extension
     */
    public static ArrayList<Shop> loadAllFilesinFolder(File folder){
        // An instance variable ArrayList
        ArrayList<Shop> ShopList = new ArrayList<>();

        // Going through all the files in the folder
        for(File file: folder.listFiles()){
            // If the file path name endsWith .ser extension pass that file to another method
            if (file.getAbsolutePath().endsWith(".ser"))
                // Adding the return Shop from the method to the Instance Variable
                ShopList.add(loadFile(file));
        }
        // Returning the instance variable
        return ShopList;
    }

    // This method loads a single file
    public static Shop loadFile(File f){
        // Calling the ReadShopData method to return the object.
        Shop s = ReadShopData(f.getAbsolutePath());
        // Returning the object
        return s;
    }

}