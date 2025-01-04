import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class CalculatorFrame extends JFrame {
    private final JTextField display; // Represents the calculator's display
    private String currentInput = ""; // Tracks user input for calculations
    private String operator = "";     // Stores the chosen operator (+, -, etc.)
    private double operand1 = 0;      // Holds the first operand for calculations

    public CalculatorFrame() {
        setTitle("Colorful Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.CYAN);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        panel.setBackground(Color.LIGHT_GRAY);

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setOpaque(true);
            button.setBackground(getButtonColor(label));
            button.setBorder(new LineBorder(Color.GRAY, 1));
            button.addActionListener(new ButtonClickListener(this));
            panel.add(button);
        }
        return panel;
    }

    private Color getButtonColor(String label) {
        return switch (label) {
            case "=" -> Color.GREEN;
            case "C" -> Color.RED;
            case "+", "-", "*", "/" -> Color.ORANGE;
            default -> Color.WHITE;
        };
    }

    public void updateDisplay(String text) {
        display.setText(text);
    }

    public void clearDisplay() {
        currentInput = "";
        operator = "";
        operand1 = 0;
        display.setText("");
    }

    public void calculateResult() {
        double operand2 = Double.parseDouble(currentInput);
        double result;

        result = switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        };

        display.setText(String.valueOf(result));
        currentInput = String.valueOf(result);
        operator = "";
    }

    public void setOperator(String op) {
        operand1 = Double.parseDouble(currentInput);
        operator = op;
        currentInput = "";
    }

    // Getter and Setter for currentInput (Encapsulation)
    public String getCurrentInput() {
        return currentInput;
    }

    public void setCurrentInput(String input) {
        this.currentInput = input;
    }
}