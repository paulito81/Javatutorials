package no.phasfjo.guistuff;

import javax.swing.*;
import java.awt.*;

public class JavaGui {

    public JavaGui(int width, int height, String title){
        javaStuff(width, height,title);
    }

    private void javaStuff(int width, int height, String title){
        JFrame app = createDisplay(width, height, title);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    private JFrame createDisplay(int x, int y, String title) {
        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(x, y));

        JButton convertButton = new JButton("Convert");
        JLabel output = new JLabel();
        output.setPreferredSize(new Dimension(x, y));

        //convertButton.addActionListener(e -> output.setText(input.getText()));
        convertButton.addActionListener(e -> output.setText(TitleConverter.createNewTitle(input.getText())));
        return createTitle(title, input, convertButton, output);
    }

    private JFrame createTitle(String title, JTextField input, JButton convertButton, JLabel output){
        JFrame gui = new JFrame(title);
        gui.setLayout(new FlowLayout());
        gui.add(input);
        gui.add(convertButton);
        gui.add(output);
        gui.pack();
        gui.setLocationRelativeTo(null);

        return gui;
    }

}
