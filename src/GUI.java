import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GUI extends JFrame implements ActionListener {
    private JPanel titlePanel, captionPanel, letterPanel, r1, r2, r3, r4, r5, z1, z2, z3, z4, z5;
    private JTextField a1, a2, a3, a4, a5;
    private JLabel c1, c2, c3, c4, c5, lettertitle, title, caption;
    private String letter;
    private ArrayList<String> categories, answers;
    private JButton enter;

    public GUI() {
        setTitle("SCATTERGORIES");
        randomLetter();
        randomCategories();
        setJTextField();
        setJLabel();
        setJPanel();
        setJButton();
        addComponents();
        setActionCommands();
        addActionListeners();
        setLayout(new FlowLayout());
        add(titlePanel);
        add(captionPanel);
        add(letterPanel);
        add(z1);
        add(r1);
        add(z2);
        add(r2);
        add(z3);
        add(r3);
        add(z4);
        add(r4);
        add(z5);
        add(r5);
        add(enter);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent click) {
        String actionCommand = click.getActionCommand();
        answers = new ArrayList<String>();
        switch (actionCommand) {
            case "enter":
                ArrayList<JTextField> textFields = new ArrayList<JTextField>(Arrays.asList(a1, a2, a3, a4, a5));
                for (JTextField textField: textFields) {
                    answers.add(textField.getText());
                }
                boolean[] colorWords = check();
                for (int i = 0; i < textFields.size(); i++) {
                    if (colorWords[i]) {
                        textFields.get(i).setForeground(Color.GREEN);
                    }
                    else {
                        textFields.get(i).setForeground(Color.RED);
                    }
                }
                break;
        }
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
            textField.setFont(new Font("Helvetica", Font.BOLD, 20));
        }
    }

    public void setJPanel() {
        r1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ArrayList<JPanel> panels = new ArrayList<JPanel>(Arrays.asList(r1, r2, r3, r4, r5));
        for (JPanel panel: panels) {
            panel.setPreferredSize(new Dimension(525, 40));
            panel.setBackground(new Color(3, 206,242));
        }

        titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(500, 45));
        titlePanel.setBackground(new Color(3, 206,242));

        captionPanel = new JPanel();
        captionPanel.setPreferredSize(new Dimension(500, 45));
        captionPanel.setBackground(new Color(3, 206,242));

        letterPanel = new JPanel();
        letterPanel.setPreferredSize(new Dimension(500, 45));
        letterPanel.setBackground(new Color(3, 206,242));

        z1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); z2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        z3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); z4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        z5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ArrayList<JPanel> zpanels = new ArrayList<JPanel>(Arrays.asList(z1, z2, z3, z4, z5));
        for (JPanel panel: zpanels) {
            panel.setPreferredSize(new Dimension(500, 30));
            panel.setBackground(new Color(3, 206,242));
        }
    }
    public void setJButton() {
        enter = new JButton("<html><font color = 0078FF>ENTER</font>");
        enter.setPreferredSize(new Dimension(100, 45));
        enter.setBackground(new Color(255, 189, 0));
        enter.setFont(new Font("Helvetica", Font.BOLD, 14));
        Border border = BorderFactory.createEmptyBorder();
        enter.setBorder(border);
    }

    public void randomLetter() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int num = (int) (Math.random()*25);
        letter = alphabet.substring(num, num+1).toUpperCase();
        System.out.println("Letter: " + letter);
    }

    public void setJLabel() {
        title = new JLabel("<html><font color = FFBD00>SCATTERGORIES</font>");
        title.setFont(new Font("Stencil", Font.BOLD, 54));
        caption = new JLabel("<html><font Color = 000000>A FUN CATEGORY WORD GAME</font>");
        caption.setFont(new Font("Stencil", Font.PLAIN, 20));
        lettertitle = new JLabel(String.format("<html><font color = 000000>Letter: </font><font color = FFE400>%s</font>", letter));
        lettertitle.setFont(new Font("Stencil", Font.BOLD, 25));

        //categories
        c1 = new JLabel(String.format("<html><font color = 000000>%s</font>", categories.get(0)));
        c2 = new JLabel(String.format("<html><font color = 000000>%s</font>", categories.get(1)));
        c3 = new JLabel(String.format("<html><font color = 000000>%s</font>", categories.get(2)));
        c4 = new JLabel(String.format("<html><font color = 000000>%s</font>", categories.get(3)));
        c5 = new JLabel(String.format("<html><font color = 000000>%s</font>", categories.get(4)));
        ArrayList<JLabel> category = new ArrayList<JLabel>(Arrays.asList(c1, c2, c3, c4, c5));
        for (JLabel cat: category) {
            cat.setFont(new Font("Bookman Old Style", Font.BOLD,20));
        }
    }

    private void addComponents() {
        r1.add(a1);
        r2.add(a2);
        r3.add(a3);
        r4.add(a4);
        r5.add(a5);
        z1.add(c1);
        z2.add(c2);
        z3.add(c3);
        z4.add(c4);
        z5.add(c5);
        titlePanel.add(title);
        captionPanel.add(caption);
        letterPanel.add(lettertitle);
    }

    private void setActionCommands() {
        enter.setActionCommand("enter");
    }

    private void addActionListeners() {
        enter.addActionListener(this);
    }

    private void randomCategories() {
        categories = new ArrayList<String>();
        ArrayList<String> allCategories = new ArrayList<String>(Arrays.asList("Mammals", "Fast Food Chains", "Country", "Color", "Four Letter Word", "Fruit/Vegetable", "Girl's Name", "Boy's Name", "Body Part"));
        for (int i = 0; i < 5; i++) {
            int randomNum = (int) (Math.random() * allCategories.size()-1);
            categories.add(allCategories.get(randomNum));
            allCategories.remove(randomNum);
        }
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(categories.get(i));
        }
    }

    public boolean[] check() {
        boolean[] validity = new boolean[answers.size()];
        int index = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (categories.get(i).equals("Mammals")) {
                String[] mammals = read("mammals.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Fast Food Chains")) {
                String[] mammals = read("fast_food.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Country")) {
                String[] mammals = read("countries.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Color")) {
                String[] mammals = read("colors.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Four Letter Word")) {
                String[] mammals = read("four_letter_words.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Fruit/Vegetable")) {
                String[] mammals = read("fruits.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Girl's Name")) {
                String[] mammals = read("girl_names.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Boy's Name")) {
                String[] mammals = read("boy_names.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
            if (categories.get(i).equals("Body Part")) {
                String[] mammals = read("body_parts.txt");
                boolean b = hasAnswer(answers.get(i), mammals);
                validity[index] = b;
                index++;
            }
        }
        return validity;
    }

    public boolean hasAnswer(String answer, String[] list) {
        for (String ans: list) {
            if (ans.toUpperCase().equals(answer.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public String[] read(String file) {
        String result = "";
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() <= 2) {
                    data = "";
                }
                result += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] answers = result.split("\n");
        return answers;
    }

}
