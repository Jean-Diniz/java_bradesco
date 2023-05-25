package com.bradesco.curso.frame;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {

        super("New frame");

        JButton button = new JButton("Click");

        getContentPane().add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }
}
