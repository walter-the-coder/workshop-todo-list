package org.example.service;

import java.util.HashMap;
import java.util.Map;

public class TodoService {
    private Map<String, Boolean> todos = new HashMap<>();

    public void addTodo(String todo) {
        todos.put(todo, false);
    }

    public void flipTodo(String todo) {
        todos.replace(todo, !todos.get(todo));
    }

    public void editTodo(String todo, String newTodo) {
        boolean isDone = todos.get(todo);
        todos.remove(todo);
        todos.put(newTodo, isDone);
    }
}
