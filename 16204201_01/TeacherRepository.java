package Web.Subject.Reository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import Web.Subject.domain.Teacher;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;



@Mapper
public interface TeacherRepository {
	
	@Results(id="teacherMap", value={ 
    @Result(property = "id", column = "teacher_id",  jdbcType=JdbcType.INTEGER), 
    @Result(property = "name", column = "teacher_name")
	})

	@Select("select * from teacher") 
	public List<Teacher> findAll();
	
	@Select("select * from teacher where teacher_id like concat('%',#{id},'%') and teacher_password=md5(#{password})")
	@ResultMap(value="teacherMap")
	public Teacher validTeacher(@Param("id")String account,@Param("password")String password);
	
	@Select("select * from teacher where teacher_name like concat('%',#{name},'%')")
	@ResultMap(value="teacherMap")			
	public List<Teacher> findByName(@Param("name")String name);
	
}