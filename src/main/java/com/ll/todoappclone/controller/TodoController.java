package com.ll.todoappclone.controller;

import com.ll.todoappclone.dto.TodoDto;
import com.ll.todoappclone.repogitory.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TodoController {
    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<TodoDto> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "homePage";
    }

    @GetMapping("/newPage")
    public String newPage() {
        return "newPage";
    }

    @GetMapping("/create")
    public String createData(@RequestParam String title, @RequestParam String content, Model model) {
        TodoDto todoDto = new TodoDto(null, title, content, false);
        todoRepository.save(todoDto);
        model.addAttribute("todoDto", todoDto);

        return "create";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        TodoDto todo = todoRepository.findById(id);
        model.addAttribute("todo", todo);

        return "detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        todoRepository.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        TodoDto todo = todoRepository.findById(id);
        model.addAttribute("todo",todo);
        return "edit";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Long id, @RequestParam String title, @RequestParam String content,
     @RequestParam(defaultValue = "false") boolean complete) {

        TodoDto todoDto = todoRepository.findById(id);

        todoDto.setTitle(title);
        todoDto.setContent(content);
        todoDto.setComplete(complete);

        return "redirect:/";
    }
}
