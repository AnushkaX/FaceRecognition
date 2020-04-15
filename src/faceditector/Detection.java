/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faceditector;


import com.sun.javafx.iio.ImageFrame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Anushka
 */
public class Detection {
    
    private CascadeClassifier cascadeClassifier;
    
    public Detection()
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.cascadeClassifier = new CascadeClassifier(Constants.CASCADE_CLASSIFIER);
               
    }
    
    public void detectFace(File file, ImagePanel imagePanel) //wenas methana
    {
        Mat image = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);  //wenas methana
        MatOfRect facedetections = new MatOfRect();
        cascadeClassifier.detectMultiScale(image, facedetections);
        
        for(Rect rect : facedetections.toArray())
        {
            Imgproc.rectangle(image, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(100,100,250),10);
            
        }
        
        BufferedImage bufferedImage = ConvertMatToImage(image);
        imagePanel.updateImage(bufferedImage);
    }

    private BufferedImage ConvertMatToImage(Mat mat) {
        
        int type = BufferedImage.TYPE_BYTE_GRAY;
        
        if(mat.channels()>1)
        {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        
        int buffersize = mat.channels()*mat.cols()*mat.rows();
        byte[] bytes = new byte[buffersize];
        mat.get(0,0,bytes);
        BufferedImage img = new BufferedImage(mat.cols(),mat.rows(),type);
        final byte[] targetPixels = ((DataBufferByte)img.getRaster().getDataBuffer()).getData();
        System.arraycopy(bytes, 0, targetPixels, 0, bytes.length);
        
        return img;
    }
    
}
