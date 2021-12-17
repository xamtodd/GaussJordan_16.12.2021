import javax.swing.*;

public class GUI {
    private JPanel panel1;
    private JTextField gebenSieIhreParameterTextField;
    private JTextField yTextField1;
    private JTextField yTextField;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField zTextField;
    private JTextField xTextField1;
    private JTextField xTextField;
    private JButton nachsteGleichungButton;
    private JTextField zTextField1;
    private JTextField lösungTextField;
    private JTextField xTextField2;
    private JTextField zTextField2;
    private JTextField yTextField3;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;

    public GUI() {
        JFrame LGS = new JFrame("LGS - loesen");

        LGS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LGS.setSize(600, 300);
        LGS.setLocationRelativeTo(null);
        LGS.add(panel1);
        LGS.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
