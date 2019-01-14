package domain;

import org.springframework.util.AutoPopulatingList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
	@Id
	private int productId;
	private String name;
	private String description;
	private double price;
	private int number = 1;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Component> components = new ArrayList<Component>();

	public List<Component> getComponents(){
		return this.components;
	}

	public int getNumber() {
		number++;
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setComponents(List<Component> c){
		this.components = c;
	}

	public void addComponent(){
		Component c = new Component();
		components.add(c);
	}


	public void deleteComponent(Component c){
		if(components.contains(c)){
			components.remove(c);
		} else {
			throw new DomainException("Component does not exist");
		}
	}
	
	public Product() {
		addComponent();
	}
	
	public Product(int productId, String name, String description, double d, List<Component> c) {
		setProductId(productId);
		setName(name);
		setDescription(description);
		setPrice(d);
		setComponents(c);
	}
	public Product(String name, String description, double d) {
		setName(name);
		setDescription(description);
		setPrice(d);
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		if(productId == null || productId < 0) {
			throw new DomainException("Give a valid id: {0}");
		} else {
			this.productId = productId;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.isEmpty()) {
			throw new DomainException("No name given");
		}
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (description == null || description.isEmpty()) {
			throw new DomainException("No description given");
		}
		
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		if (price == null || price<0) {
			throw new DomainException("Give a valid price");
		}
		this.price = price;
	}
	public void setPrice(String price) {
		if (price == null || price.isEmpty()) {
			throw new DomainException("No price given");
		}
		setPrice(Double.valueOf(price));
	}
	
	@Override
	public String toString(){
		return getName() + ": " + getDescription() + " - " + getPrice();
	}
	
}
