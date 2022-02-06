package manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

@Entity(name="SubscriptionEntity")
public class SubscriptionEntity {

	@Id
	@GeneratedValue
	private int subscriptionId;
	private String subscriptionName;
	
	@ManyToMany(mappedBy="subcription")
	private Set<ReaderEntity> reader;

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public Set<ReaderEntity> getReader() {
		return reader;
	}

	public void setReader(Set<ReaderEntity> reader) {
		this.reader = reader;
	}
	
	
	
}
