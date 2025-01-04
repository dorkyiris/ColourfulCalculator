import javax.swing.*;

// Entry point of the application (follows Single Responsibility Principle)
public class ColorfulCalculator {
    public static void main(String[] args) {
        // Launch the calculator GUI on the Event Dispatch Thread (Thread Safety)
        SwingUtilities.invokeLater(() -> {
            CalculatorFrame calculatorFrame = new CalculatorFrame();
            calculatorFrame.setVisible(true); // Show the main frame
        });
    }
}