import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by SachinChauhan on 14-Sep-17.
 */
public class ResultScreen {
    private JPanel ResultPanel;
    private JTextArea resultTextArea;
    private JTextArea filesInAscendingOrderTextArea;
    private JButton searchAnotherWordButton;
    private JTable fileList;
    private JScrollPane tableScrollPane;

    public ResultScreen(File[] files,int[] occurrences,Dictionary dictionaryInstance) {
        JFrame frame = new JFrame();
        frame.setContentPane(ResultPanel);
        frame.getContentPane().setPreferredSize(new Dimension(700, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Object data[][]=new Object[files.length][2];
        String column[]={"File Name","Occurences"};
        for(int i=0;i<files.length;i++){
            data[i][0]=files[i].getName();
            data[i][1]=occurrences[i];
            System.out.println(data[i][0]+"   "+data[i][1]);
        }
        fileList.setModel(new DefaultTableModel(data,column));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        searchAnotherWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new SecondScreen(dictionaryInstance);
            }
        });
    }
}
