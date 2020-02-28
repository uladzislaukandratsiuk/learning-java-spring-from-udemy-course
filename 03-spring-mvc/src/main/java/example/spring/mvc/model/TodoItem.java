package example.spring.mvc.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

    private int id;
    private String title;
    private String details;
    private LocalDate deadLine;

    public TodoItem(String title, String details, LocalDate deadLine) {
        this.title = title;
        this.details = details;
        this.deadLine = deadLine;
    }
}