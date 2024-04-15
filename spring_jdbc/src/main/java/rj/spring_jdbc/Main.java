package rj.spring_jdbc;

import java.util.Scanner;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
	public static void main(String[] args) {
		String configration = "rj/spring_jdbc/configratationfile.xml";
	    ApplicationContext context = new ClassPathXmlApplicationContext(configration);
	    JdbcTemplate template  = (JdbcTemplate)context.getBean("template");
	    Scanner scanner = new Scanner(System.in);
		while (!false) {
			System.out.println("\n1)Show All Students");
            System.out.println("2)Add Student");
            System.out.println("3)Edit Student");
            System.out.println("4)Delete Student");
            System.out.println("Select option- ");
            String option = scanner.nextLine();
            
            switch (option) {
			case "1":
				String sql1 = "select * from students";
				List <Student> students = template.query(sql1, new StudentMapper());
				for (Student record : students) {
			         System.out.print("\nRoll : " + record.getRoll() );
			         System.out.print(", Name : " + record.getName() );
			      } 
				break;
			case "2":
				System.out.println("Enter roll number - ");
				String roll = scanner.nextLine();
				System.out.println("Enter name - ");
				String name = scanner.nextLine();
				String sql2 = "insert into students values(?,?)";
				int response = template.update(sql2,roll,name);
				break;
			case "3":
				System.out.println("Enter roll number to edit- ");
				String roll_no = scanner.nextLine();
				System.out.println("Enter new name number- ");
				String new_name = scanner.nextLine();
				String sql3 = "update students set name=? where roll=?";
				int response1 = template.update(sql3,new_name,roll_no);
				break;
			case "4":
				System.out.println("Enter roll number to delete- ");
				String roll_num = scanner.nextLine();
				String sql4 = "delete from students where roll=?";
				int response2 = template.update(sql4,roll_num);
				break;

			}
		}
	}
}
