package oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "Employee" )
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int empid;
	private String name;
	private String email;
	@PrimaryKeyJoinColumn
	@OneToOne(targetEntity=Address.class, cascade=CascadeType.ALL)
	private Address address;
	
	public int getEmpid() {
		return empid;
	}
	public Employee(int empid, String name, String email, Address address) {

		this.empid = empid;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public Employee() {
		
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
