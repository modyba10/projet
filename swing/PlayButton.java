import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayButton extends JButton implements ActionListener {
    private Client client;
    private JTextField textField;
    private JLabel displayLabel; // Utilisation d'un JLabel pour l'affichage des données

    public PlayButton(Client client, JTextField textField, JLabel displayLabel) {
        super("Play");
        this.client = client;
        this.textField = textField;
        this.displayLabel = displayLabel;

        setBackground(Color.RED);
        setForeground(Color.RED);
        setFocusPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texteSaisi = textField.getText();

        // Envoi du texte au serveur via l'instance de Client
        String response = client.send(texteSaisi);
        System.out.println("Response from server: " + response);

        if ("false".equals(response)) {
            displayLabel.setText("ERROR: LE MEDIA NE FAIT PAS PARTIE DE VOTRE REPERTOIRE");
        } else {
            displayLabel.setText(response);
        }
    }
}
