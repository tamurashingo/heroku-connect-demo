package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(Long id);

    void save(Task task);

    void deleteById(Long id);
}
