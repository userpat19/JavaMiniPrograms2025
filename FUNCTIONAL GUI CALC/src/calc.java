import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calc extends JFrame implements ActionListener {

    final JTextField display;
    final JPanel buttonPanel;
    private String currentInput = "";
    private double result = 0;
    private String lastOperator = "=";
    private boolean startNewNumber = true;

    public calc() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField("0", 10);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(calc::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            if (startNewNumber) {
                currentInput = command;
                startNewNumber = false;
            } else {
                currentInput += command;
            }
            display.setText(currentInput);
        } else if ("+-*/=".contains(command)) {
            double number = Double.parseDouble(currentInput);
            calculate(number);
            lastOperator = command;
            startNewNumber = true;
        }
    }

    private void calculate(double number) {
        switch (lastOperator) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                if (number == 0) {
                    display.setText("Error");
                    result = 0;
                    return;
                }
                result /= number;
                break;
            case "=":
                result = number;
                break;
        }
        display.setText(String.valueOf(result));
        currentInput = String.valueOf(result);
    }
}