package oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "address")
public class Address {

	@Id
	@Column(name= "AddressID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressid;
	private int pincode;
	@OneToOne(targetEntity=Employee.class)
	private Employee employee;
	
	public Address(int addressid, String city,  int pincode, Employee employee) {
	
		this.addressid = addressid;
		this.city = city;
	
		this.pincode = pincode;
		this.employee = employee;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address() {
		
	}

	private String city;
	
	

	
	
}
