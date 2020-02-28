package example.spring.mvc.service;

import example.spring.mvc.model.TodoData;
import example.spring.mvc.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemListImpl implements TodoItemService {

    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem item) {
        data.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem item) {
        data.updateItem(item);
    }

    @Override
    public TodoData getData() {
        return data;
    }
}