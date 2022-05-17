import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI extends JFrame {
    private JPanel title, r1, r2, r3, r4, r5;
    private JTextField a1, a2, a3, a4, a5;
    private JLabel c1, c2, c3, c4, c5, letter;
    private ArrayList<String> categories = new ArrayList<String>(Arrays.asList("Animals", "Food", "Country", "Color", "Movie", "Four Letter Word", "Fruit/Vegetable", "TV Show", "Girl's Name", "Boy's Name", "Body Part"));
    private JButton enter;

    public GUI() {
        setTitle("SCATTERGORIES");
        setJTextField();
//        setJLabel();
        setJPanel();
//        setJButton();
        addComponents();
//        setActionCommands();
//        addActionListeners();
        setLayout(new FlowLayout());
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(r5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setJTextField() {
        a1 = new JTextField(30); a2 = new JTextField(30);
        a3 = new JTextField(30); a4 = new JTextField(30);
        a5 = new JTextField(30);

        ArrayList<JTextField> textFields = new ArrayList<JTextField>(Arrays.asList(a1, a2, a3, a4, a5));
        for (JTextField textField: textFields) {
            textField.setBackground(Color.WHITE);
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3);
            textField.setBorder(border);
            textField.setFont(new Font("Helvetica", Font.BOLD, 14));
        }
    }

    public void setJPanel() {
        r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r1.setPreferredSize(new Dimension(1000,30));
        r1.setBackground(Color.DARK_GRAY.brighter());
        r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r2.setPreferredSize(new Dimension(1000,30));
        r2.setBackground(Color.DARK_GRAY.brighter());
        r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r3.setPreferredSize(new Dimension(1000,30));
        r3.setBackground(Color.DARK_GRAY.brighter());
        r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r4.setPreferredSize(new Dimension(1000,30));
        r4.setBackground(Color.DARK_GRAY.brighter());
        r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r5.setPreferredSize(new Dimension(1000,30));
        r5.setBackground(Color.DARK_GRAY.brighter());
    }

    private void addComponents() {
        r1.add(a1);
        r2.add(a2);
        r3.add(a3);
        r4.add(a4);
        r5.add(a5);
    }
}
