package org.example;

import static org.example.Config.DEFAULT_BUTTON_SIZE;
import static org.example.Config.DEFAULT_FONT;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TodoList extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;

    JTextField textField;
    JButton add;

    List<JPanel> todos = new ArrayList<>();

    // default constructor
    TodoList() {
        // create frame
        frame = new JFrame("Todo List");

        // create panel
        panel = new JPanel();

        // create a textfield
        textField = new JTextField(10);

        // set the textfield size
        textField.setPreferredSize(new Dimension(600, 50));

        // set the textfield font
        textField.setFont(DEFAULT_FONT);

        // add buttons
        add = new JButton("Add todo");

        // set number buttons size and font
        add.setPreferredSize(DEFAULT_BUTTON_SIZE);

        add.setFont(DEFAULT_FONT);

        // add button action listeners
        add.addActionListener(this);

        // add elements to panel
        panel.add(textField);
        panel.add(add);

        todos.add(new Todo("TODO"));
        todos.forEach((it) -> panel.add(it));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputKey = e.getActionCommand();
        System.out.println("TodoList -> Button press -> inputKey=" + inputKey);
        System.out.println("TodoList -> textField=" + textField.getText());
    }
}
