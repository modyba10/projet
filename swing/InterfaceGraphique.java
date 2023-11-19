import javax.swing.*;
import java.awt.*;

public class InterfaceGraphique extends JFrame {
    private static final long serialVersionUID = 1L;

    public InterfaceGraphique() {
        super("Fenêtre principale");

        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton button1 = new JButton("Bouton 1");
        JButton button2 = new JButton("Bouton 2");
        JButton exitButton = new JButton("Quitter");

        button1.addActionListener(e -> textArea.append("Texte du bouton 1\n"));
        button2.addActionListener(e -> textArea.append("Texte du bouton 2\n"));
        exitButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(exitButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceGraphique());
    }
}
