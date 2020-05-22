package GUI;

import javax.swing.*;
import java.awt.*;

public class Resizing {


    /**
     * This function is fed with an image icon and it
     * resizes that image icon to the desired width &
     * height.
     * @return Image
     */
    public static Image ResizeImage(ImageIcon i, int width, int height){
        // A temporary Image is created which get the image from image icon
        Image i_temp = i.getImage();
        // The image is then scaled to another temporary image to the particular size
        Image temp = i_temp.getScaledInstance(width,height,Image.SCALE_SMOOTH);
         // The scaled image is returned
        return temp;
    }


}
