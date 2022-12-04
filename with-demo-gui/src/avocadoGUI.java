// Java program to create a blank text
// field of definite number of columns.
import java.awt.event.*;
import javax.swing.*;
class avocado extends JFrame implements ActionListener {
    // JTextField
    static JTextField t;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l;

    // default constructor
    avocado()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to store text field and button
        f = new JFrame("Avocado");

        // create a label to display text
        l = new JLabel("nothing entered");

        //l.setFont(new java.awt.Font("Arial", 0, 10));

        // create a new button
        b = new JButton("submit");

        // create a object of the text class
        avocado te = new avocado();

        // addActionListener to button
        b.addActionListener(te);

        // create a object of JTextField with 16 columns
        t = new JTextField(20);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(t);
        p.add(b);
        p.add(l);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(700,700);
        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            metric info = new metric();

            l.setText(info.passString(info.searchByCountry(t.getText())));


            // set the text of field to blank
            t.setText(" ");
        }
    }
}

