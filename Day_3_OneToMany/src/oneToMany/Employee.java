package oneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="employee2")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="Emp_id")
	private int id;
	private String email;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="acc_pk")
	private Set<Account> account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAccount(Set<Account> acc)
	{
		account = acc;
	}
	
	public Set<Account> getAccount()
	{
		return account;
	}
	
	
	
}
