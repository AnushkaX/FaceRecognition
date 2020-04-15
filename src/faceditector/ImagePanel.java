/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faceditector;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Anushka
 */

public class ImagePanel extends JPanel{
    
    public static final long serialVersionUID = 1L;
    private JLabel imglbl;
    private ImageIcon transformedImageIcon;
    
    public ImagePanel()
    {
        this.imglbl = new JLabel();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(Constants.IMAGE_LABEL_BORDER, Constants.IMAGE_LABEL_BORDER, Constants.IMAGE_LABEL_BORDER, Constants.IMAGE_LABEL_BORDER));
        add(imglbl,BorderLayout.CENTER);                        
    }

    void updateImage(final Image image) {
    
        imglbl.setIcon(new ImageIcon(scaleImage(image)));
    }
    
    public Image scaleImage(Image image)
    {
        return image.getScaledInstance(700,500,Image.SCALE_SMOOTH);
        
    }
    
    public void loadImage(File file)
    {
        this.transformedImageIcon = new ImageIcon(file.getAbsolutePath());
        Image image = transformedImageIcon.getImage();
        updateImage(image);
    }
}


