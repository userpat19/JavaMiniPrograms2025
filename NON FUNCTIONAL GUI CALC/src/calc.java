import javax.swing.*;
import java.awt.*;

public class calc extends JFrame {

    public calc() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 420);
        setResizable(false);

        // **Set window icon here**
        ImageIcon icon = new ImageIcon("C:\\Users\\Pat's PC\\Downloads\\icons8-calculator-25.png"); // replace with your image path
        setIconImage(icon.getImage());

        // Menu bar (not functional)
        JMenuBar menu = new JMenuBar();
        menu.add(new JMenu("View"));
        menu.add(new JMenu("Edit"));
        menu.add(new JMenu("Help"));
        setJMenuBar(menu);

        // Display field
        JTextField display = new JTextField("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 5, 5, 5));

        String[] buttons = {
                "MC","MR","MS","M+","M-",
                "←","CE","C","±","√",
                "7","8","9","/","%",
                "4","5","6","*","1/x",
                "1","2","3","-","=",
                "0",".","+","",""
        };

        for (String txt : buttons) {
            if (txt.isEmpty()) {
                panel.add(new JLabel()); // placeholder
                continue;
            }
            JButton btn = new JButton(txt);
            btn.setEnabled(false); // non-functional
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new calc().setVisible(true));
    }
}
