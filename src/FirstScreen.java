

import javafx.scene.effect.DropShadow;

import javax.naming.Context;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by SachinChauhan on 14-Sep-17.
 */
public class FirstScreen {
    private JButton selectFilesButton;
    private JPanel MainPanel;
    private JButton AddMoreFilesButton;
    private JButton nextButton;
    private JTextArea wordSearchTextArea;
    private JTextArea searchesOccurencesOfATextArea;
    File[] infiles;

    public FirstScreen(){
        JFrame frame=new JFrame();
        frame.setContentPane(MainPanel);
        frame.getContentPane().setPreferredSize(new Dimension(700,400));
        AddMoreFilesButton.setVisible(false);
        nextButton.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Select Files");
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Text File","txt");
        fileChooser.setFileFilter(filter);

        selectFilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result=fileChooser.showOpenDialog(frame);
                if(result==JFileChooser.CANCEL_OPTION)
                    System.exit(2);
               infiles=fileChooser.getSelectedFiles();
                for(int i=0;i<infiles.length;i++)
                    System.out.println(infiles[i].getName());
                selectFilesButton.setVisible(false);
                AddMoreFilesButton.setVisible(true);
                nextButton.setVisible(true);
            }
        });
        AddMoreFilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result=fileChooser.showOpenDialog(frame);
                if(result==JFileChooser.CANCEL_OPTION)
                    System.exit(2);
                File[] files=fileChooser.getSelectedFiles();
                int len=infiles.length;
                int length=files.length;
                File[] newFiles=new File[len+length];
                for(int i=0;i<len;i++)
                    newFiles[i]=infiles[i];
                for(int i=0;i<length;i++) {
                    newFiles[i + len] = files[i];
                    System.out.println(files[i].getName());
                }
                infiles=newFiles;
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setVisible(false);
                    new Dictionary(infiles,new IndexingScreen());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        new FirstScreen();
    }
}
