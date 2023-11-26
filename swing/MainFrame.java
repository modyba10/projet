import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

public class MainFrame extends JFrame {
    public MainFrame() throws UnknownHostException, IOException {
        setTitle("Media Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600)); // Dimensions de la fenêtre
        getContentPane().setBackground(Color.GRAY); // Fond de la fenêtre en noir
        setLayout(new BorderLayout());

        // Création du contrôleur
        Controller controller = new Controller();

        // Redimensionnement automatique du contrôleur pour occuper la majeure partie de la fenêtre
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.6);
        int height = (int) (screenSize.getHeight() * 0.6);
        controller.setPreferredSize(new Dimension(width, height));
        

        add(controller, BorderLayout.CENTER);
        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    



    public static void main(String[] args) throws UnknownHostException {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainFrame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
        
    
}
