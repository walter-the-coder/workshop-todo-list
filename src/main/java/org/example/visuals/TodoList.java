package org.example.visuals;

import static org.example.visuals.Config.DEFAULT_BUTTON_SIZE;
import static org.example.visuals.Config.DEFAULT_FONT;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.example.service.TodoService;

public class TodoList extends JFrame implements ActionListener {
    private TodoService todoService = new TodoService();

    public JFrame frame;
    public JPanel panel;

    public JTextField textField;
    public JButton add;

    public List<Todo> todos = new ArrayList<>(); // Store Todo objects

    public TodoList() {
        // Create frame
        frame = new JFrame("Todo List");

        // Create panel
        panel = new JPanel();

        // Create a textfield
        textField = new JTextField(15);

        // Set the textfield size
        textField.setPreferredSize(new Dimension(300, 40));
        textField.setFont(DEFAULT_FONT);

        // Add button
        add = new JButton("Add todo");
        add.setPreferredSize(DEFAULT_BUTTON_SIZE);
        add.setFont(DEFAULT_FONT);
        add.addActionListener(this);

        // Add components to panel
        panel.add(textField);
        panel.add(add);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String todoText = textField.getText().trim();

            if (!todoText.isEmpty()) {
                addTodo(todoText);
                textField.setText(""); // Clear text field
            }
        }
    }

    public void addTodo(String todoText) {
        Todo newTodo = new Todo(todoText, this); // Pass this instance of TodoList
        todos.add(newTodo);
        panel.add(newTodo);

        panel.revalidate();
        panel.repaint();
    }

    public void removeTodo(Todo todo) {
        todos.remove(todo);
        panel.remove(todo);
        panel.revalidate();
        panel.repaint();
    }
}
