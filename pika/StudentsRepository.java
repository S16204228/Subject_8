package Web.Subject.Reository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import Web.Subject.domain.Students;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;



@Mapper
public interface StudentsRepository {
	
	@Results(id="studentMap", value={ 
    @Result(property = "student_id", column = "student_id",  jdbcType=JdbcType.INTEGER), 
    @Result(property = "student_phone", column = "student_phone"),
    @Result(property = "student_name", column = "student_name")
	})

	@Select("select * from students") 
	public List<Students> findAll();
	
	@Select("select * from students where student_id=#{id} and student_password=md5(#{password})")
	@ResultMap(value="studentMap")
	public Students validStudents(@Param("id")String account,@Param("password")String password);
	
	@Select("select * from students where student_name like concat('%',#{name},'%')")
	@ResultMap(value="studentMap")			
	public List<Students> findByName(@Param("name")String name);
	
}