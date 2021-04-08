package ButtonsAndListeners.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    public final int DEFAULT_WIDTH = 400;
    public final int DEFAULT_HEIGHT = 200;
    public final String DEFAULT_TITLE = "Calculator";
    public final int DEFAULT_FONT_SIZE = 30;
    public final Font DEFAULT_FONT = new Font("Serif", Font.BOLD, DEFAULT_FONT_SIZE);
    private double accumulator;
    private JLabel displayAccumulator;
    private JTextField calcInput;
    private JPanel buttonsPanel;
    private JButton clearButton;
    private JButton addButton;
    private JButton subButton;
    private JButton multiplyButton;
    private JButton divideButton;

    public Calculator(){
        accumulator = 0;
        displayAccumulator = new JLabel(String.valueOf(accumulator), JLabel.RIGHT);
        displayAccumulator.setFont(DEFAULT_FONT);

        calcInput = new JTextField();
        calcInput.setHorizontalAlignment(SwingConstants.RIGHT);
        calcInput.setFont(DEFAULT_FONT);

        clearButton = new JButton("CLR");
        clearButton.addActionListener(this);
        addButton = new JButton("+");
        addButton.addActionListener(this);
        subButton = new JButton("-");
        subButton.addActionListener(this);
        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        divideButton = new JButton("/");
        divideButton.addActionListener(this);

        buttonsPanel = new JPanel(new GridLayout(1, 5));
        buttonsPanel.add(clearButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(subButton);
        buttonsPanel.add(multiplyButton);
        buttonsPanel.add(divideButton);

        setLayout(new GridLayout(3, 1));
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle(DEFAULT_TITLE);
        add(displayAccumulator);
        add(calcInput);
        add(buttonsPanel);
    }

    public void startCalculator(){
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearButton){
            accumulator = 0;
        }else if(e.getSource() == addButton){
            accumulator += Double.parseDouble(calcInput.getText());
        }else if(e.getSource() == subButton){
            accumulator -= Double.parseDouble(calcInput.getText());
        }else if(e.getSource() == multiplyButton){
            accumulator *= Double.parseDouble(calcInput.getText());
        }else if(e.getSource() == divideButton){
            accumulator /= Double.parseDouble(calcInput.getText());
        }
        updateDisplay();
    }

    public void updateDisplay(){
        calcInput.setText("");
        displayAccumulator.setText(String.valueOf(accumulator));
        repaint();
        revalidate();
    }
}
