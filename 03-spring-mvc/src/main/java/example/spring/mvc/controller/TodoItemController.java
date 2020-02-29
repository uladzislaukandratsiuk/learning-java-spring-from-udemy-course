package example.spring.mvc.controller;

import example.spring.mvc.model.TodoData;
import example.spring.mvc.model.TodoItem;
import example.spring.mvc.service.TodoItemService;
import example.spring.mvc.util.AttributeNames;
import example.spring.mvc.util.Mappings;
import example.spring.mvc.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private TodoItemService itemService;

    @Autowired
    public TodoItemController(TodoItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute
    public TodoData todoData() {
        return itemService.getData();
    }

    @GetMapping(Mappings.ITEMS )
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model) {
        log.info("editing item = {}", itemService.getItem(id));
        TodoItem todoItem = itemService.getItem(id);

        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);

        if (todoItem.getId() == 0) {
            itemService.addItem(todoItem);
        } else {
            itemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("deleting todoItem from form = {}, id = {}", itemService.getItem(id), id);
        itemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        TodoItem todoItem = itemService.getItem(id);
        log.info("view todoItem from form = {}", todoItem);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;
    }
}