package com.ll.todoappclone.repogitory;

import com.ll.todoappclone.dto.TodoDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.PathMatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepository {
    private final Map<Long, TodoDto> map = new HashMap<>();
    private Long nextNum = 1L;

    public TodoDto save(TodoDto todoDto) {
        if (todoDto.getId() == null) {
            todoDto.setId(nextNum++);
        }
        map.put(todoDto.getId(), todoDto);
        return todoDto;
    }

    public List<TodoDto> findAll() {
        return new ArrayList<>(map.values());
    }

    public TodoDto findById(Long id) {
        return map.get(id);
    }

    public void deleteById(Long id) {
        map.remove(id);
    }
}
