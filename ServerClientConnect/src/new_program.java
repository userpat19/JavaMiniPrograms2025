import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class new_program extends JFrame implements ActionListener {

    private JTextField smallDisplay;   // shows operation: 1 × 2
    private JTextField mainDisplay;    // shows final number: 2

    private double num1 = 0, num2 = 0, result = 0;
    private char operator = ' ';
    private boolean waitingForSecond = false;

    public new_program() {

        setTitle("Calculator");
        setSize(300, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // TOP small display (operation preview)
        smallDisplay = new JTextField();
        smallDisplay.setFont(new Font("Arial", Font.PLAIN, 16));
        smallDisplay.setEditable(false);
        smallDisplay.setHorizontalAlignment(JTextField.RIGHT);

        // Main display
        mainDisplay = new JTextField();
        mainDisplay.setFont(new Font("Arial", Font.BOLD, 28));
        mainDisplay.setEditable(false);
        mainDisplay.setHorizontalAlignment(JTextField.RIGHT);

        // Combine both displays
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 1));
        displayPanel.add(smallDisplay);
        displayPanel.add(mainDisplay);

        add(displayPanel, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // DIGITS
        if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
            if (waitingForSecond) {
                mainDisplay.setText("");
                waitingForSecond = false;
            }
            mainDisplay.setText(mainDisplay.getText() + command);
            return;
        }

        // CLEAR
        if (command.equals("C")) {
            smallDisplay.setText("");
            mainDisplay.setText("");
            num1 = num2 = result = 0;
            operator = ' ';
            return;
        }

        // OPERATOR (+ - × ÷)
        if ("+-*/".contains(command)) {
            num1 = Double.parseDouble(mainDisplay.getText());
            operator = command.charAt(0);
            smallDisplay.setText(num1 + " " + operator);
            waitingForSecond = true;
            return;
        }

        // EQUAL
        if (command.equals("=")) {
            num2 = Double.parseDouble(mainDisplay.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        mainDisplay.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            // show "1 × 2 =" on top
            smallDisplay.setText(num1 + " " + operator + " " + num2 + " =");

            // show result in big display
            mainDisplay.setText("" + result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new new_program());
    }
}