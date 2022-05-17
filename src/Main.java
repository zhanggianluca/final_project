import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setSize(600, 700);
        gui.getContentPane().setBackground(Color.DARK_GRAY.brighter());
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}
