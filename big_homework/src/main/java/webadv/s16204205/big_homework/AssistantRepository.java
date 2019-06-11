package webadv.s16204205.big_homework;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import webadv.s16204205.big_homework.Assistant;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

@Mapper
public interface AssistantRepository {
	
	@Results(id="AssistantMap", value={ 
    @Result(property = "Assistant_id", column = "Assistant_id",  jdbcType=JdbcType.INTEGER), 
    @Result(property = "Assistant_name", column = "Assistant_name"),
    @Result(property = "Assistant_phone", column = "Assistant_phone"),
	})

	@Select("select * from Assistants") 
	public List<Assistant> findAll();
	
	@Select("select * from Assistants where Assistant_id=#{id} and Assistant_password=md5(#{password})")
	@ResultMap(value="AssistantMap")
	public Assistant validAssistant(@Param("id")String account,@Param("password")String password);
	
	@Select("select * from Assistants where Assistant_name like concat('%',#{name},'%')")
	@ResultMap(value="AssistantMap")			
	public List<Assistant> findByName(@Param("name")String name);
	
}