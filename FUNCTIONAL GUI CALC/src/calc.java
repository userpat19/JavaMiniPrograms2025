import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calc extends JFrame implements ActionListener {

    final JTextField display;
    final JLabel ansLabel;

    private double firstNum = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public calc() {
        setTitle("Calculator");
        setSize(350, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(20, 20, 25));

        ansLabel = new JLabel("Ans: 0");
        ansLabel.setBounds(220, 0, 200, 30);
        ansLabel.setForeground(Color.WHITE);
        add(ansLabel);

        display = new JTextField("0");
        display.setBounds(20, 30, 300, 60);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 36));
        display.setBackground(new Color(210, 230, 210));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display);

        JPanel panel = new JPanel();
        panel.setBounds(20, 110, 300, 340);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(new Color(20, 20, 25));
        add(panel);

        String[] buttons = {
                "7", "8", "9", "÷",
                "4", "5", "6", "x",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String txt : buttons) {
            JButton b = getJButton(txt);

            b.addActionListener(this);
            panel.add(b);
        }

        setVisible(true);
    }

    private JButton getJButton(String txt) {
        JButton b = new JButton(txt);
        b.setFont(new Font("Arial", Font.BOLD, 22));

        if (txt.matches("[0-9.]")) {
            b.setBackground(new Color(50, 50, 55));
            b.setForeground(Color.WHITE);
        } else if (txt.equals("=")) {
            b.setBackground(new Color(255, 80, 70));
            b.setForeground(Color.WHITE);
        } else if (txt.equals("C")) {
            b.setBackground(new Color(255, 110, 110));
            b.setForeground(Color.WHITE);
        } else {
            b.setBackground(new Color(0, 180, 180));
            b.setForeground(Color.BLACK);
        }
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]") || cmd.equals(".")) {
            if (startNewNumber) {
                // avoid starting with multiple dots
                if (cmd.equals(".")) {
                    display.setText("0.");
                } else {
                    display.setText(cmd);
                }
                startNewNumber = false;
            } else {
                // prevent multiple dots
                if (cmd.equals(".") && display.getText().contains(".")) return;
                display.setText(display.getText() + cmd);
            }
            return;
        }

        if (cmd.equals("C")) {
            display.setText("0");
            firstNum = 0;
            operator = "";
            ansLabel.setText("Ans: 0");
            startNewNumber = true;
            return;
        }

        if (cmd.equals("=")) {
            calculate();
            return;
        }

        // operator pressed (+, -, x, ÷)
        try {
            firstNum = Double.parseDouble(display.getText());
        } catch (NumberFormatException ex) {
            display.setText("Error");
            return;
        }
        operator = cmd;
        ansLabel.setText("Ans: " + formatNumber(firstNum) + " " + operator);
        startNewNumber = true;
    }

    private void calculate() {
        double secondNum;
        try {
            secondNum = Double.parseDouble(display.getText());
        } catch (NumberFormatException ex) {
            display.setText("Error");
            return;
        }

        double result;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "x":
                result = firstNum * secondNum;
                break;
            case "÷":
                if (secondNum == 0) {
                    display.setText("Error");
                    ansLabel.setText("Ans: " + formatNumber(firstNum) + " ÷ " + formatNumber(secondNum) + " = Error");
                    startNewNumber = true;
                    return;
                }
                result = firstNum / secondNum;
                break;
            default:
                // if no operator, just show current display
                ansLabel.setText("Ans: " + formatNumber(secondNum));
                return;
        }

        String resStr = formatNumber(result);
        display.setText(resStr);
        ansLabel.setText("Ans: " + formatNumber(firstNum) + " " + operator + " " + formatNumber(secondNum) + " = " + resStr);
        startNewNumber = true;
        operator = "";
    }

    private String formatNumber(double v) {
        if (v == (long) v) return String.valueOf((long) v);
        return String.valueOf(v);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(calc::new);
    }
}
