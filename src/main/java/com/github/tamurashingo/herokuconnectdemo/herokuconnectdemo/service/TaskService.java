package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper.TaskMapper;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TaskService {

    private final TaskMapper taskMapper;

    public TaskService(final TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> findAll() {
        return taskMapper.selectAll();
    }

    public Task findById(Long id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    public void save(Task task) {
        if (task.getId() == null) {
            taskMapper.insert(task);
        } else {
            taskMapper.updateByPrimaryKey(task);
        }
    }

    public void deleteById(Long id) {
        taskMapper.deleteByPrimaryKey(id);
    }
}
