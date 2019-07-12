import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.zensar.Address;
import com.zensar.Employee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class Test {

	public static void main(String[] args) {
		
		Address address = new Address();
		address.setArea("Hadapsar");
		address.setCity("Pune");
		
		Employee emp = new Employee();
		emp.setEmpId(105);
		emp.setName("Pick");
		emp.setSalary(50000);
		emp.setAddress(address);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		//session.save(emp);
		
		Query query=session.createQuery("from Employee");//select * from emp
		List<Employee> list=query.getResultList();
		session.getTransaction().commit();
		session.close();
		for(Employee e:list)
		{
		System.out.println(e);
		}
	}
}
//@Entity
//class Employee{
//	@Id
//	private int empId;
//	private String name;
//	private double salary;
//	public int getEmpId() {
//		return empId;
//	}
//	public void setEmpId(int empId) {
//		this.empId = empId;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public double getSalary() {
//		return salary;
//	}
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//	
//	
//}
