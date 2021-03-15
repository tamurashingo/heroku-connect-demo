package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller;


import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper.TaskMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    private final TaskMapper taskMapper;

    public TaskController(final TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @GetMapping("/")
    public String getAllTasks(Model model) {
        model.addAttribute("page", taskMapper.selectAll());

        return "list";
    }
}
