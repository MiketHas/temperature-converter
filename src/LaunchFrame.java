import javax.swing.*;

public class LaunchFrame extends JFrame {

    MainPanel myPanel;

    public LaunchFrame() {
        this.setTitle("Temperature Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        myPanel = new MainPanel();
        this.add(myPanel);

        this.pack();
        this.setLocationRelativeTo(null); // This will center the GUI_app on a screen
        this.setVisible(true);
    }
}
