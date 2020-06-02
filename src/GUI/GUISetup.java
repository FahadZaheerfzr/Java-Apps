package GUI;

import javax.swing.*;
import java.awt.*;

public class GUISetup {
    public static JLabel label;


    /**
     * This function is fed with an image icon and it
     * resizes that image icon to the desired width &
     * height.
     * @return Image
     */
    public static ImageIcon ResizeImage(ImageIcon i, int width, int height){
        // A temporary Image is created which get the image from image icon
        Image i_temp = i.getImage();
        // The image is then scaled to another temporary image to the particular size
        Image temp = i_temp.getScaledInstance(width,height,Image.SCALE_SMOOTH);
         // The scaled image is returned
        ImageIcon returnable = new ImageIcon(temp);
        return returnable;
    }


    /**
     * This function is used to set the background image of a label
     * and return that label
     * @param Image_Background
     * @return
     */
    public static JLabel setBackground(ImageIcon Image_Background, int width, int height){
        // A JLabel is used to add background image into it
        JLabel nlabel = new JLabel("", Image_Background, JLabel.CENTER);
        // Setting the bounds of JLabel
        nlabel.setBounds(0, 0, width, height);
        return nlabel;
    }

}
