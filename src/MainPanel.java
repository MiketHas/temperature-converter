import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MainPanel extends JPanel implements ChangeListener {
    final int PANEL_WIDTH = 600;
    final int PANEL_HEIGHT = 400;

    JSlider celsuiusSlider, fahrSlider;
    JLabel celsuiusLabel, fahrenheitLabel;
    int tempCelsius, tempFahr;
    ImageIcon background;
    Image bcgImage;

    MainPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);
        this.setOpaque(false);

        background = new ImageIcon(getClass().getClassLoader().getResource("cloudsBcg.jpg"));
        bcgImage = background.getImage();

        //------------- SLIDERS
        celsuiusSlider = new JSlider(0,-40,100,0);
        celsuiusSlider.setBounds(20, 250, 350, 50);
        celsuiusSlider.setOpaque(false);
        celsuiusSlider.setMajorTickSpacing(20);
        celsuiusSlider.setMinorTickSpacing(5);
        celsuiusSlider.setPaintLabels(true);
        celsuiusSlider.setPaintTicks(true);
        celsuiusSlider.addChangeListener(this);
        this.add(celsuiusSlider);

        fahrSlider = new JSlider(0,-40,212,32);
        fahrSlider.setBounds(20, 310, 350, 50);
        fahrSlider.setOpaque(false);
        fahrSlider.setMajorTickSpacing(25);
        fahrSlider.setMinorTickSpacing(5);
        fahrSlider.setPaintLabels(true);
        fahrSlider.setPaintTicks(true);
        fahrSlider.addChangeListener(this);
        this.add(fahrSlider);

        //------------- LABELS
        celsuiusLabel = new JLabel("Celsius: 0°");
        celsuiusLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        celsuiusLabel.setBounds(390, 250, 200, 50);
        celsuiusLabel.setForeground(Color.BLACK);
        this.add(celsuiusLabel);
        fahrenheitLabel = new JLabel("Fahrenheit: 32°");
        fahrenheitLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        fahrenheitLabel.setBounds(390, 310, 200, 50);
        fahrenheitLabel.setForeground(Color.BLACK);
        this.add(fahrenheitLabel);
    }

    @Override
    public void paintComponent(Graphics g) { // background Image
        super.paintComponent(g);
        g.drawImage(bcgImage, 0,0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object source = e.getSource();

        if (source == celsuiusSlider) {
            tempCelsius = celsuiusSlider.getValue();
            tempFahr = (int) Math.round(32.0 + (9.0 / 5) * tempCelsius);
            celsuiusLabel.setText("Celsius: " + tempCelsius + "°");
            fahrenheitLabel.setText("Fahrenheit: " + tempFahr + "°");
            fahrSlider.setValue(tempFahr);
        } else if (source == fahrSlider) {
            tempFahr = fahrSlider.getValue();
            tempCelsius = (int) Math.round((tempFahr - 32.0) * (5.0 / 9.0));
            fahrenheitLabel.setText("Fahrenheit: " + tempFahr + "°");
            celsuiusLabel.setText("Celsius: " + tempCelsius + "°");
            celsuiusSlider.setValue(tempCelsius);
        }
    }
}
