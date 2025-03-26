package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoServiceTest {
    TodoService todoService = new TodoService();

    @Test
    void addTodo() {
        todoService.addTodo("Buy milk");
        Map.Entry<String, Boolean> todo = todoService.getTodos().entrySet().stream().findFirst().get();

        Assertions.assertAll(
            () -> assertEquals("Buy milk", todo.getKey()),
            () -> assertEquals(false, todo.getValue())
        );
    }

    @Test
    void flipTodo() {
        String todoText = "Buy milk";
        todoService.addTodo(todoText);

        Map.Entry<String, Boolean> todo = todoService.getTodos().entrySet().stream().findFirst().get();
        Assertions.assertFalse(todo.getValue());

        todoService.flipTodo(todoText);
        Assertions.assertTrue(todo.getValue());
    }

    @Test
    void editTodo() {
        String todoText = "Buy milk";
        todoService.addTodo(todoText);

        Map.Entry<String, Boolean> todo = todoService.getTodos().entrySet().stream().findFirst().get();
        Assertions.assertEquals(todoText, todo.getKey());

        String newTodoText = "Buy milk and bread";
        todoService.editTodo(todoText, newTodoText);
        Assertions.assertEquals(1, todoService.getTodos().size());
        Assertions.assertEquals(newTodoText, todoService.getTodos().entrySet().stream().findFirst().get().getKey());
    }
}
