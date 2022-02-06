package study.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name= "grocery123")
public class GroceryEntity {
	
	@Id
	private int id;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_cost")
	private int cost;
	@Column(name = "description")
	private String description;
	@Column(name = "unit")
	private String unit;
	@Column(name = "Expiry_date")
	private Date date;
	
	public GroceryEntity() {
		// TODO Auto-generated constructor stub
	}

	public GroceryEntity(int id, String name, int cost, String description, String unit, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.unit = unit;
		this.date = date;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GroceryEntity [id=" + id + ", name=" + name + ", cost=" + cost + ", description=" + description
				+ ", unit=" + unit + ", date=" + date + "]";
	}
	
	
	
	
	
	
}
