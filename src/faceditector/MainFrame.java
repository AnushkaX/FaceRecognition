/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faceditector;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Anushka
 */
public class MainFrame extends JFrame{
    
    private static final long serialVersionUIC = 1L;
    private ImagePanel imagePanel;
    private JFileChooser fileChooser;
    private Detection faceDetection;
    private File file;
    
    public MainFrame()
    {
        super(Constants.APPLICATION_NAME);
        
        JMenuBar mb = createMenuBar();
        this.setJMenuBar(mb);
        
        this.imagePanel = new ImagePanel();
        this.fileChooser = new JFileChooser();
        this.faceDetection = new Detection(); 
        
        add(imagePanel,BorderLayout.CENTER);
        
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(this);
        
    }

    private JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load Menu");
        JMenuItem detectMenuItem = new JMenuItem("Detect");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(loadMenuItem);
        fileMenu.add(detectMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        
        loadMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                {
                    MainFrame.this.file = fileChooser.getSelectedFile();
                    System.out.println(MainFrame.this.file);
                    MainFrame.this.imagePanel.loadImage(MainFrame.this.file);
                    System.out.println("Uploading");
                }
                
            }
        });
        System.out.println("Uploaded");
        detectMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.faceDetection.detectFace(MainFrame.this.file, MainFrame.this.imagePanel);
            }
        });
        
        exitMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                int action = JOptionPane.showConfirmDialog(MainFrame.this, Constants.EXIT_WARNING, "Confirmation", WIDTH);
                
                if(action == JOptionPane.OK_OPTION)
                {
                    System.gc();
                    System.exit(0);
                }  
            }
        });
        
        
        return menuBar;
        
    }
    
    
    
}
