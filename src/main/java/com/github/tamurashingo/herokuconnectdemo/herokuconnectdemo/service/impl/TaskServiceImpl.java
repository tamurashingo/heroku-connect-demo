package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service.impl;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper.TaskMapper;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.Task;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;

    public TaskServiceImpl(final TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public List<Task> findAll() {
        return taskMapper.selectAll();
    }

    @Override
    public Task findById(Long id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Task task) {
        if (task.getId() == null) {
            taskMapper.insert(task);
        } else {
            taskMapper.updateByPrimaryKey(task);
        }
    }

    @Override
    public void deleteById(Long id) {
        taskMapper.deleteByPrimaryKey(id);
    }
}
