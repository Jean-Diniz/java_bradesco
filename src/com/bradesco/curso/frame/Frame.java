package com.bradesco.curso.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Frame extends JFrame implements ActionListener {

    private JTextArea textArea;

    public Frame() {

        super("Editor");

        Container container = getContentPane();

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton exit = new JButton("Exit");
        JButton save = new JButton("Save");
        textArea = new JTextArea();

        exit.addActionListener(this);
        save.addActionListener(this);

        btnPanel.add(save);
        btnPanel.add(exit);

        container.add(textArea);
        container.add(BorderLayout.SOUTH, btnPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Exit" -> dispose();
            case "Save" -> {
                try {
                    save(textArea.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void save(String text) throws IOException {
        createOutputDir();

        try (FileWriter fileWriter = new FileWriter("output/" + Timestamp.valueOf(LocalDateTime.now()) + ".txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createOutputDir() {
        File output = new File("output");
        if (!output.exists()) {
            output.mkdir();
        }
    }
}
