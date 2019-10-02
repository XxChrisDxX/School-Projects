package hwjframe;
import java.awt.GridLayout;
import javax.swing.*;

/*
 @author ctdecker2727
*/

public class HWJFrame extends JFrame {
    public HWJFrame() {
        // Set GridLayout, 3 rows, 2 columns, and gaps 5 between
        // components horizontally and vertically
        setLayout(new GridLayout(3, 2, 5, 5));

        // Add labels and text fields to the frame
        add(new JLabel("First Name"));
        add(new JTextField(8));
        add(new JLabel("MI"));
        add(new JTextField(1));
        add(new JLabel("Last Name"));
        add(new JTextField(8));
    }

    public static void main(String[] args) {
        HWJFrame frame = new HWJFrame();
        frame.setTitle("ShowGridLayout");
        frame.setSize(200, 125);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}