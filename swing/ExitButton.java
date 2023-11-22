import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExitButton extends JButton implements ActionListener {
    public ExitButton() {
        super("Exit");
        setBackground(Color.RED);
        setForeground(Color.RED);
        setFocusPainted(false);
        addActionListener(this); // Ajout d'un auditeur d'action à ce bouton
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0); // Quitter l'application
    }
}
