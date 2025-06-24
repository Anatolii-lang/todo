package com.example.todo.controllers;

import com.example.todo.model.TodoItem;
import com.example.todo.repositories.TodoItemRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController implements CommandLineRunner {

    private final TodoItemRepositories todoItemRepositories;


    public TodoController(TodoItemRepositories todoItemRepositories) {
        this.todoItemRepositories = todoItemRepositories;
    }

    @GetMapping
    public String index(Model model)
    {

        List<TodoItem> allTodos = todoItemRepositories.findAll();
        model.addAttribute("allTodos", allTodos);
        model.addAttribute("newTodo", new TodoItem());

        return "index";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem todoItem){
        todoItemRepositories.save(todoItem);


        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        todoItemRepositories.deleteById(id);
        return "redirect:/";

    }
    @PostMapping("/removeAll")
    public String removeAll(){
        todoItemRepositories.deleteAll();
        return "redirect:/";
    }


    @PostMapping("/search")
    public String search(@RequestParam("searhTern") String searhTern, Model model){
        List<TodoItem> allItems = todoItemRepositories.findAll();
        List<TodoItem> searchResults = new ArrayList<>();
        for(TodoItem item:allItems){
            if (item.getTitle().toLowerCase().contains(searhTern.toLowerCase())){
                searchResults.add(item);
            }
        }

        model.addAttribute("allTodos", searchResults);
        model.addAttribute("newTodo", new TodoItem());
        model.addAttribute("searhTern", searhTern);


        return "index";
    }


    @Override
    public void run(String... args) throws Exception {
        todoItemRepositories.save(new TodoItem("Item 1"));
        todoItemRepositories.save(new TodoItem("Item 2"));


    }
}
