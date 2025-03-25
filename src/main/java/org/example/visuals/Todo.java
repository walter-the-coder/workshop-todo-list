package org.example.visuals;

import static org.example.visuals.Config.DEFAULT_BUTTON_SIZE;
import static org.example.visuals.Config.DEFAULT_FONT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Todo extends JPanel implements ActionListener, ItemListener {
    public JTextField text;
    public JCheckBox check;
    public JButton remove;
    JButton edit;

    public TodoList parent; // Reference to TodoList for UI updates

    Todo(String todoString, TodoList parent) {
        this.parent = parent;

        text = new JTextField(todoString, 15);
        check = new JCheckBox("");
        edit = new JButton("Edit");
        remove = new JButton("Remove");

        text.setEditable(false);
        check.setName("done");

        check.setPreferredSize(new Dimension(20, 20));
        edit.setPreferredSize(DEFAULT_BUTTON_SIZE);
        remove.setPreferredSize(DEFAULT_BUTTON_SIZE);

        text.setFont(DEFAULT_FONT);
        check.setFont(DEFAULT_FONT);
        edit.setFont(DEFAULT_FONT);
        remove.setFont(DEFAULT_FONT);

        check.addItemListener(this);
        edit.addActionListener(this);
        remove.addActionListener(this);

        add(text);
        add(check);
        add(edit);
        add(remove);

        // Set background color
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(350, 150));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Edit")) {
            text.setEditable(true);
            edit.setText("Save"); // Change button to "Save"
        } else if (command.equals("Save")) {
            text.setEditable(false);
            edit.setText("Edit"); // Change button back to "Edit"
        } else if (command.equals("Remove")) {
            parent.removeTodo(this);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox item = (JCheckBox) e.getItem();
        System.out.println("Todo -> Checkbox change -> getName=" + item.getName());
        System.out.println("Todo -> Checkbox change -> getStateChange=" + e.getStateChange());
    }
}
