package loancalculator;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author ctdecker2727
 */
public class LoanCalculator extends JFrame {

    /**
     * @param args the command line arguments
     */
    
    private JTextField jtfRate = new JTextField();
    private JTextField jtfAmount = new JTextField();
    private JTextField jtfYears = new JTextField();
    private JTextField jtfMonthlyPayment = new JTextField();
    private JTextField jtfTotalPayment = new JTextField();
    
    private JButton jbtComputeLoan = new JButton("Compute payment");
    
    public LoanCalculator(){
        JPanel p1 = new JPanel(new GridLayout(5, 2));
        jtfMonthlyPayment.setEditable(false);
        jtfTotalPayment.setEditable(false);
        
        p1.add(new JLabel("Annual Interest Rate: e.g., 5.0"));
        p1.add(jtfRate);
        p1.add(new JLabel("Number of years: e.g., 10"));
        p1.add(jtfYears);
        p1.add(new JLabel("Loan Amount: e.g., 10000"));
        p1.add(jtfAmount);
        p1.add(new JLabel("Monthly Payment: "));
        p1.add(jtfMonthlyPayment);
        p1.add(new JLabel("Total Payment: "));
        p1.add(jtfTotalPayment);
        p1.setBorder(new TitledBorder("Enter your loan amount, interest rate, and number of years"));
        
        JPanel p2 = new JPanel();
        p2.add(jbtComputeLoan);
        
        this.add(p1);
        add(p2, BorderLayout.SOUTH);
        
    }   
    public static void main(String[] args) {
        // TODO code application logic here
        LoanCalculator frame = new LoanCalculator();
        
        frame.setTitle("Loan Calculator");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            double amount = Double.parseDouble(jtfAmount.getText());
            double rate = Double.parseDouble(jtfRate.getText());
            int year = Integer.parseInt(jtfYears.getText());
        }
    }
}
