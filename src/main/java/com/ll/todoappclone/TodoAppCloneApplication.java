package com.ll.todoappclone;

import com.ll.todoappclone.dto.TodoDto;
import com.ll.todoappclone.repogitory.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@RequiredArgsConstructor
public class TodoAppCloneApplication {

    private final TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoAppCloneApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(TodoRepository todoRepository) {
        return args -> {
            todoRepository.save(new TodoDto(null, "h1", "h2",false));
            todoRepository.save(new TodoDto(null, "h2", "h4",true));
            todoRepository.save(new TodoDto(null, "h3", "h6",false));
            todoRepository.save(new TodoDto(null, "h4", "h8",true));
        };
    }

}
