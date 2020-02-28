package example.spring.mvc.controller;

import example.spring.mvc.model.TodoData;
import example.spring.mvc.service.TodoItemService;
import example.spring.mvc.util.Mappings;
import example.spring.mvc.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
}