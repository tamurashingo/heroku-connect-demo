package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("SELECT id, name, done FROM task")
    List<Task> selectAll();


    @Select(
        " SELECT id, name, done FROM task "
      + " WHERE id = #{id} "
    )
    Task selectByPrimaryKey(Long id);

    @Insert(
        " INSERT INTO task(name, done, created_at, updated_at) "
      + " VALUES(#{name}, #{done}, now(), now()) "
    )
    int insert(Task task);

    @Update(
        " UPDATE task "
      + " SET name = #{name}, done = #{done}, updated_at = now() "
      + " WHERE id = #{id} "
    )
    int updateByPrimaryKey(Task task);

    @Delete(
        " DELETE FROM task "
      + " WHERE id = #{id} "
    )
    int deleteByPrimaryKey(Long id);
}
