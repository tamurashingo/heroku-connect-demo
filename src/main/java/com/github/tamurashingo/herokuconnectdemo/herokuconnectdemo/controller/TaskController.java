package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller;


import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper.TaskMapper;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.Task;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getAllTasks(Model model) {
        model.addAttribute("page", taskService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        return "form";
    }

    @PostMapping("/process")
    public String process(@Validated @ModelAttribute Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }

        taskService.save(task);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));

        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return "redirect:/";
    }
}
