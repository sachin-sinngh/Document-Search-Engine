import javax.swing.*;
import java.awt.*;

/**
 * Created by SachinChauhan on 14-Sep-17.
 */
public class ProcessingScreen {
    private JPanel SearchingPanel;
    private JTextArea searchingTextArea;
    public JProgressBar progressBar;
    public JFrame frame;

    public ProcessingScreen() {
        frame= new JFrame();
        frame.setContentPane(SearchingPanel);
        frame.getContentPane().setPreferredSize(new Dimension(700, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
