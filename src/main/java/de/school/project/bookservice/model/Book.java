package de.school.project.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    @Id
    private String id;

    private String title;

    private String author;
}
