import javax.swing.*;
import java.awt.*;

/**
 * Created by SachinChauhan on 14-Sep-17.
 */
public class IndexingScreen {
    private JPanel IndexingPanel;
    private JTextArea indexingFilesTextArea;
    public JProgressBar indexProgressBar;
    public JFrame frame;

    public IndexingScreen() {
        frame = new JFrame();
        frame.setContentPane(IndexingPanel);
        frame.getContentPane().setPreferredSize(new Dimension(700, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
