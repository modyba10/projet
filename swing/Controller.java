import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

public class Controller extends JPanel {
  
    private JLabel label; 
    private Client client;
    private PlayVideo playVideo;
    private PlayPhoto playPhoto;
    private BrowseButton browseButton;
    private ExitButton exitButton;

    public Controller() throws UnknownHostException, IOException {
        setLayout(new GridLayout(4, 1)); 
        label = new JLabel("", SwingConstants.CENTER); 
        label.setVerticalAlignment(SwingConstants.TOP); 
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        client = new Client(); 

        
       
        add(label);

        
        playVideo = new PlayVideo(); 
        playVideo.setBackground(Color.RED);
        playVideo.setForeground(Color.RED);

        playPhoto = new PlayPhoto(); 
        playPhoto.setBackground(Color.BLACK);
        playPhoto.setForeground(Color.BLACK);

        browseButton = new BrowseButton(client, label); 
        browseButton.setBackground(Color.GREEN); 
        browseButton.setForeground(Color.GREEN);

        exitButton = new ExitButton();
        exitButton.setBackground(Color.BLUE); 
        exitButton.setForeground(Color.BLUE);

        
        add(playVideo);
        add (playPhoto);
        add(browseButton);
        add(exitButton);
    }
}
