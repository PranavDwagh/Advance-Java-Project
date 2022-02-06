package groceryAssignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="grocery_product")
public class Grocery {

	@Id
	@Column(name="product_id")
	private int id;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_desc")
	private String desc;
	@Column(name = "unit")
	private String unit;
	@Column(name = "cost")
	private int cost;
	@Column(name = "Expiry_date")
	private String exDate;

	public Grocery(int id, String name, String desc, String unit, int cost, String exDate) {

		this.id = id;
		this.name = name;
		this.desc = desc;
		this.unit = unit;
		this.cost = cost;
		this.exDate = exDate;
	}

	public Grocery()
	{
		//
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getExDate() {
		return exDate;
	}

	public void setExDate(String exDate) {
		this.exDate = exDate;
	}

	@Override
	public String toString() {
		return "Grocery [id=" + id + ", name=" + name + ", desc=" + desc + ", unit=" + unit + ", cost=" + cost
				+ ", exDate=" + exDate + "]";
	}




}
