package example.spring.mvc.service;

import example.spring.mvc.model.TodoData;
import example.spring.mvc.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem item);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem item);

    TodoData getData();
}