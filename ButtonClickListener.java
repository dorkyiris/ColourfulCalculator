import java.awt.event.*;
import javax.swing.*;

// Handles button click events (Observer Pattern)
public class ButtonClickListener implements ActionListener {
    private final CalculatorFrame calculatorFrame; // Composition: Listener interacts with the Frame

    public ButtonClickListener(CalculatorFrame frame) {
        this.calculatorFrame = frame; // Reference to the main frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource(); // Identify the clicked button
        String label = source.getText();         // Get the button's label

        // Handle actions based on the button label
        if (label.matches("\\d")) { // If the label is a digit (0-9)
            String updatedInput = calculatorFrame.getCurrentInput() + label; // Append to current input
            calculatorFrame.setCurrentInput(updatedInput);                   // Update current input
            calculatorFrame.updateDisplay(updatedInput);                     // Update the display
        } else if (label.equals("C")) { // Clear button
            calculatorFrame.clearDisplay(); // Reset the display and state
        } else if (label.equals("=")) { // Equals button
            calculatorFrame.calculateResult(); // Perform the calculation
        } else { // Operator buttons (+, -, *, /)
            calculatorFrame.setOperator(label); // Set the operator
        }
    }
}