package example.spring.mvc.controller;

import example.spring.mvc.model.TodoData;
import example.spring.mvc.util.Mappings;
import example.spring.mvc.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    @GetMapping(Mappings.ITEMS )
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}