package manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

import com.sun.xml.bind.v2.runtime.Name;

@Entity(name="ReaderEntity")
public class ReaderEntity {

	@Id
	@GeneratedValue
	private int readerId;
	private String name;
	private String email;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="subscription")
	private Set<SubscriptionEntity> subcription;

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
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

	public Set<SubscriptionEntity> getSubcription() {
		return subcription;
	}

	public void setSubcription(Set<SubscriptionEntity> subcription) {
		this.subcription = subcription;
	}
	
	
	
	
}
