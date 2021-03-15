package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("SELECT id, name, done FROM task")
    List<Task> selectAll();
}
