import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class GUI extends JFrame {
    private JPanel titlePanel, captionPanel, letterPanel, r1, r2, r3, r4, r5;
    private JTextField a1, a2, a3, a4, a5;
    private JLabel c1, c2, c3, c4, c5, letterlabel, lettertitle, title, caption;
    private String letter;
    private ArrayList<String> categories;
    private JButton enter;

    public GUI() {
        setTitle("SCATTERGORIES");
        randomLetter();
        setJTextField();
        setJLabel();
        setJPanel();
//        setJButton();
        addComponents();
//        setActionCommands();
//        addActionListeners();
        setLayout(new FlowLayout());
        add(titlePanel);
        add(captionPanel);
        add(letterPanel);
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
        r1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ArrayList<JPanel> panels = new ArrayList<JPanel>(Arrays.asList(r1, r2, r3, r4, r5));
        for (JPanel panel: panels) {
            panel.setPreferredSize(new Dimension(500, 30));
            panel.setBackground(Color.MAGENTA.darker());
        }

        titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(500, 45));
        titlePanel.setBackground(Color.MAGENTA.darker());

        captionPanel = new JPanel();
        captionPanel.setPreferredSize(new Dimension(500, 45));
        captionPanel.setBackground(Color.MAGENTA.darker());

        letterPanel = new JPanel();
        letterPanel.setPreferredSize(new Dimension(500, 45));
        letterPanel.setBackground(Color.MAGENTA.darker());
    }

    public void randomLetter() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int num = (int) (Math.random()*25);
        letter = alphabet.substring(num, num+1).toUpperCase();
        System.out.println(letter);
    }

    public void setJLabel() {
        title = new JLabel("<html><font color = FFFFFF>SCATTERGORIES</font>");
        title.setFont(new Font("Stencil", Font.BOLD, 54));
        caption = new JLabel("<html><font Color = 000000>A FUN CATEGORY WORD GAME</font>");
        caption.setFont(new Font("Stencil", Font.PLAIN, 20));
        lettertitle = new JLabel("<html><font color = 000000>Letter: </font>");
        lettertitle.setFont(new Font("Stencil", Font.BOLD, 25));
        letterlabel = new JLabel(String.format("<html><font color = 2EDF51>%s</font>", letter));
        letterlabel.setFont(new Font("Courier New", Font.BOLD, 25));
    }

    private void addComponents() {
        r1.add(a1);
        r2.add(a2);
        r3.add(a3);
        r4.add(a4);
        r5.add(a5);
        titlePanel.add(title);
        captionPanel.add(caption);
        letterPanel.add(lettertitle);
        letterPanel.add(letterlabel);
    }

    private void randomCategories() {
        ArrayList<String> allCategories = new ArrayList<String>(Arrays.asList("Animals", "Food", "Country", "Color", "Movie", "Four Letter Word", "Fruit/Vegetable", "TV Show", "Girl's Name", "Boy's Name", "Body Part")
    }
}
