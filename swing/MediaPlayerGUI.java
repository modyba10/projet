import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediaPlayerGUI extends JFrame {
    private JTextField textField;
    private JButton playButton, exitButton;
    private JPanel mediaPanel;
    private JTextArea textArea;
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 3331;
    private Client client;
    private JButton browseButton;

    public MediaPlayerGUI() {
        
        setTitle("Media Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK); // Fond de la fenêtre en noir

        textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); // Police du champ de texte

        playButton = new JButton("Play");
        playButton.setBackground(Color.RED);
        playButton.setForeground(Color.RED);
        playButton.setFocusPainted(false);

        browseButton = new JButton("Browse");
        browseButton.setBackground(Color.RED);
        browseButton.setForeground(Color.RED);
        browseButton.setFocusPainted(false);
        


        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.RED);
        exitButton.setFocusPainted(false);

        mediaPanel = new JPanel();
        mediaPanel.setBackground(Color.DARK_GRAY);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(textField, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(playButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(browseButton); // Ajout du bouton dans votre panneau de boutons
        add(buttonPanel, BorderLayout.CENTER);
        add(mediaPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Initialisation de la connexion au serveur dans le constructeur de votre GUI
        try {
            client = new Client(DEFAULT_HOST, DEFAULT_PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texteSaisi = textField.getText();

                // Envoi du texte au serveur via l'instance de Client
                String response = client.send(texteSaisi);
                System.out.println("Response from server: " + response);

                if (response == "false") {
                    textArea.append("ERORR LE MEDIA NE FAIS PAS PARTI DE VOTRE REPERTOIRE\n" );
                }
                else  {

                    textArea.append(response);

                }
            }
        });

        // Ajout de l'action associée au bouton Browse
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose a media file");
                
                // Afficher la fenêtre de sélection de fichiers
                int userSelection = fileChooser.showOpenDialog(MediaPlayerGUI.this);
                
                // Si un fichier est sélectionné, récupérer son chemin
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    String response = client.send(filePath);
                    textArea.append(response);

                }
                    
                }
            });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MediaPlayerGUI();
            }
        });
    }
}
