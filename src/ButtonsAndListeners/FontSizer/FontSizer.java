package ButtonsAndListeners.FontSizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizer extends JFrame implements ActionListener {
    public final int DEFAULT_WIDTH = 400;
    public final int DEFAULT_HEIGHT = 200;
    public final String DEFAULT_TITLE = "Font Sizer";
    public final int DEFAULT_FONT_SIZE = 18;
    public final Font DEFAULT_FONT = new Font("Serif", Font.BOLD, DEFAULT_FONT_SIZE);
    public final String DEFAULT_DISPLAY = "X";
    private int currentFont;
    private JLabel fontDisplay;
    private JLabel fontSizeDisplay;
    private JButton increaseButton;
    private JButton decreaseButton;

    public FontSizer(){
        currentFont = DEFAULT_FONT_SIZE;
        fontDisplay = new JLabel(DEFAULT_DISPLAY, JLabel.RIGHT);
        fontDisplay.setFont(DEFAULT_FONT);
        fontSizeDisplay = new JLabel(String.valueOf(currentFont), JLabel.LEFT);
        fontSizeDisplay.setFont(DEFAULT_FONT);

        increaseButton = new JButton("Increase Font");
        decreaseButton = new JButton("Decrease Font");
        increaseButton.addActionListener(this);
        decreaseButton.addActionListener(this);

        setLayout(new GridLayout(2, 2));
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle(DEFAULT_TITLE);
        add(fontDisplay);
        add(fontSizeDisplay);
        add(increaseButton);
        add(decreaseButton);
    }

    public void startFontSizer(){
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == increaseButton){
            currentFont++;
        }else if(e.getSource() == decreaseButton){
            if(currentFont > 0){
                currentFont--;
            }
        }
        updateFont();
    }

    public void updateFont(){
        fontDisplay.setFont(new Font("Serif", Font.BOLD, currentFont));
        fontSizeDisplay.setText(String.valueOf(currentFont));
        repaint();
        revalidate();
    }
}
