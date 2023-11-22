import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

public class Controller extends JPanel {
    private JTextField textField;
    private JLabel label; // Utilisation d'un JLabel à la place de JTextArea
    private Client client;
    private PlayButton playButton;
    private BrowseButton browseButton;
    private ExitButton exitButton;

    public Controller() throws UnknownHostException, IOException {
        setLayout(new GridLayout(1, 3)); // Disposition en grille pour les boutons

        // Initialisation des composants
        textField = new JTextField();
        label = new JLabel("", SwingConstants.CENTER); // JLabel centré
        label.setVerticalAlignment(SwingConstants.TOP); // Alignement vertical en haut
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Bordure pour la visibilité
        client = new Client(); // Initialisez votre client comme nécessaire

        // Ajout du textField et du label dans le panel
        add(textField);
        add(label);

        // Création des boutons avec les couleurs spécifiées
        playButton = new PlayButton(client, textField, label); // Envoyer le JLabel au lieu de JTextArea
        playButton.setBackground(Color.RED);
        playButton.setForeground(Color.RED);

        browseButton = new BrowseButton(client, label); // Envoyer le JLabel au lieu de JTextArea
        browseButton.setBackground(Color.GREEN); // Couleur pour le bouton Browse
        browseButton.setForeground(Color.GREEN);

        exitButton = new ExitButton();
        exitButton.setBackground(Color.BLUE); // Couleur pour le bouton Exit
        exitButton.setForeground(Color.BLUE);

        // Ajout des boutons dans le panel
        add(playButton);
        add(browseButton);
        add(exitButton);
    }
}
