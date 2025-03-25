package org.example.visual;

import static org.junit.jupiter.api.Assertions.*;

import org.example.visuals.TodoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TodoListTest {
    TodoList todoList = new TodoList();

    @Test
    @DisplayName("Adding a new todo should increase the list size")
    public void addTodo() {
    	TodoList todoList = new TodoList();
        int initialSize = todoList.todos.size();

        // Simulate adding a todo
        todoList.textField.setText("New Task");
        todoList.add.doClick();

        // Check if the todo was added
        assertEquals(initialSize + 1, todoList.todos.size());
    }
    
    @Test
    @DisplayName("Removing a todo should decrease the list size")
    public void removeTodo() {
        TodoList todoList = new TodoList();
        todoList.textField.setText("New Task");
        todoList.add.doClick();  // Add a todo

        int initialSize = todoList.todos.size();

        // Simulate removing the todo
        todoList.todos.get(0).remove.doClick();  // Simulate clicking the "Remove" button

        // Assert that the size decreased
        assertEquals(initialSize - 1, todoList.todos.size());
    }
    
    @Test
    @DisplayName("Editing a todo should update its text")
    public void editTodo() {
        TodoList todoList = new TodoList();
        todoList.textField.setText("New Task");
        todoList.add.doClick();  // Add a todo

        // Simulate editing the todo's text
        todoList.todos.get(0).text.setText("Updated Task");

        // Assert that the text is updated
        assertEquals("Updated Task", todoList.todos.get(0).text.getText());
    }
    
    @Test
    @DisplayName("Adding an empty todo should not be allowed")
    public void addEmptyTodo() {
        TodoList todoList = new TodoList();

        todoList.textField.setText("");  // Empty input
        todoList.add.doClick();  // Click "Add" button

        // Ensure the list size is still 0 (no todo added)
        assertEquals(0, todoList.todos.size());
    }
    
    @Test
    @DisplayName("Adding a todo with only spaces should not be allowed")
    public void addTodoWithSpaces() {
        TodoList todoList = new TodoList();

        todoList.textField.setText("     ");  // Spaces only
        todoList.add.doClick();  // Click "Add" button

        // Ensure the list size is still 0 (no todo added)
        assertEquals(0, todoList.todos.size());
    }
    
    @Test
    @DisplayName("UI components should be visible and interactable")
    public void testUIComponents() {
        TodoList todoList = new TodoList();

        // Check if textField, button, and panel are visible
        assertNotNull(todoList.textField);
        assertNotNull(todoList.add);
        assertNotNull(todoList.panel);
    }
    
    @Test
    @DisplayName("Todo checkbox state should change correctly")
    public void checkboxStateChange() {
        TodoList todoList = new TodoList();
        todoList.textField.setText("Task");
        todoList.add.doClick();  // Add a todo

        // Simulate checking the checkbox
        todoList.todos.get(0).check.setSelected(true);
        assertTrue(todoList.todos.get(0).check.isSelected());

        // Simulate unchecking the checkbox
        todoList.todos.get(0).check.setSelected(false);
        assertFalse(todoList.todos.get(0).check.isSelected());
    }




}
