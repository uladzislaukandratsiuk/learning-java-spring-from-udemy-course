package example.spring.mvc.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    public static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        addItem(new TodoItem("first title", "first details", LocalDate.now()));
        addItem(new TodoItem("second title", "second details", LocalDate.now()));
        addItem(new TodoItem("third title", "third details", LocalDate.now()));
        addItem(new TodoItem("fourth title", "fourth details", LocalDate.now()));
        addItem(new TodoItem("fifth title", "fifth details", LocalDate.now()));
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem itemToAdd) {
        itemToAdd.setId(idValue);
        items.add(itemToAdd);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem itemToUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.equals(itemToUpdate)) {
                itemIterator.set(itemToUpdate);
                break;
            }
        }
    }
}