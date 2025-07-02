package com.example.todoapp.controller;

import com.example.todoapp.domain.ToDo;
import com.example.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<ToDo> todos = todoRepository.findAll();
        model.addAttribute("todos",todos);
        return "todos";
    }
    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        System.out.println(todo);

        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        todoRepository.save(toDo);
        //받아온 값을 데이터베이스에 저장하자
        return "redirect:/";
    }

}
