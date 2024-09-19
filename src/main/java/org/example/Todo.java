package org.example;

import static org.example.Config.DEFAULT_BUTTON_SIZE;
import static org.example.Config.DEFAULT_FONT;

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
    JTextField text;
    JCheckBox check;
    JButton remove;
    JButton edit;

    Todo(String todoString) {
        text = new JTextField(todoString, 10);
        check = new JCheckBox("");
        edit = new JButton("Edit");
        remove = new JButton("Remove");

        text.setEditable(false);
        check.setName("done");

        check.setPreferredSize(DEFAULT_BUTTON_SIZE);
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

        // set Background of panel
        setBackground(Color.gray);

        // set size
        setPreferredSize(new Dimension(400, 135));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Todo -> Button press -> getActionCommand=" + e.getActionCommand());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox item = (JCheckBox) e.getItem();
        System.out.println("Todo -> Checkbox change -> getName=" + item.getName());
        System.out.println("Todo -> Checkbox change -> getStateChange=" + e.getStateChange());
    }
}
