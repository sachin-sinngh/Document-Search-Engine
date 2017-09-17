import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by SachinChauhan on 14-Sep-17.
 */
public class SecondScreen {
    private JPanel SecondPanel;
    private JTextArea enterWordTextArea;
    private JTextField wordTextField;

    public SecondScreen(Dictionary dictionaryInstance) {
        JFrame frame = new JFrame();
        frame.setContentPane(SecondPanel);
        frame.getContentPane().setPreferredSize(new Dimension(700, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        wordTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String searchWord=wordTextField.getText();
                    if(!searchWord.trim().isEmpty()) {
                        searchWord=searchWord.replaceAll("^\\s+", "");
                        frame.setVisible(false);
                        dictionaryInstance.search(searchWord, new ProcessingScreen());
                    }
                }
            }
        });
    }
}
