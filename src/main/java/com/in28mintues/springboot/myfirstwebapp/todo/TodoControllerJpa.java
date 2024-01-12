package com.in28mintues.springboot.myfirstwebapp.todo;


import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedinUsername(model);
        todoRepository.deleteById(1001);
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    // Function to retrieve username from authentication system
    private static String getLoggedinUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    //GET, POST
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        // Setting default values for the new to-do form
        String username = getLoggedinUsername(model);
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }


    // Need to import Spring form tag library in JSP
    // @Valid annotation is used to trigger the validation in the bean
    // Binding result attribute is used to redirect if there is a validation error or show any validation errors to the user
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        // go back to the to-do page if there is an error
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedinUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        // todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        // Delete to-do
        todoRepository.deleteById(id);
        // todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET )
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        // go back to the to-do page if there is an error
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedinUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        // todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}
