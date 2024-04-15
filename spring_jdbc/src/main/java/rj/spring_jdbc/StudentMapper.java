package rj.spring_jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student>{
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Student student = new Student();
	      student.setRoll(rs.getInt("roll"));
	      student.setName(rs.getString("name"));
	      return student;
	   }
}
