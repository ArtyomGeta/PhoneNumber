package com.artyomgeta.phonenumber;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class Chooser extends JFrame {
    private JPanel panel1;
    private JSlider slider;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JSlider slider1;
    private JLabel label3;
    int number;
    int lastNumber;
    String fullNumber;
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu exitMenu = new JMenu("Exit");
    private final JMenu informationMenu = new JMenu("Information");


    public Chooser() {
        setTitle("Phone number slider");
        setSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(panel1);

        setJMenuBar(menuBar);
        menuBar.add(informationMenu);
        menuBar.add(exitMenu);

        informationMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(null, "Choose your number. I had to make one slider, but made two: \none big int is long and JSlider doesn't like as MaximumValue any long values.\n\nMade by Artyom Geta.", "Information", JOptionPane.PLAIN_MESSAGE);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        exitMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.exit(0);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });


        slider.setValue(number);
        label.setText(100000000 + "");
        //slider.setMaximum(999999999 + 999000000 + 998001000 + 997002999 + 996005996 + 995009990 + 994014980);
        slider.setMaximum(Math.toIntExact(999999999L));
        slider.setMinimum(Math.toIntExact(100000000L));

        label1.setText("+");
        label2.setText(lastNumber + "");

        slider1.addChangeListener(e -> {
            lastNumber = slider1.getValue();
            label2.setText(lastNumber + "");
            fullNumber = number + "" + lastNumber + "";
            label3.setText("Your number: " + fullNumber);
        });

        slider1.setMinimum(10);
        slider1.setMaximum(99);

        slider1.setValue(slider1.getMinimum());

        slider.addChangeListener(e -> {
            number = slider.getValue();
            label.setText(number + "");
            fullNumber = number + "" + lastNumber + "";
            label3.setText("Your number: " + fullNumber);
        });
        fullNumber = label.getText() + label2.getText();
        label3.setText("Your number: " + fullNumber);
        label3.setFont(new Font("Arial", Font.BOLD, 30));
    }
}
