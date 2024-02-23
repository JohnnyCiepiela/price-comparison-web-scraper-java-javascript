package janciepiela;

import javax.persistence.*;

/**
 * 
 * @author Jan Ciepiela Creating Camera objects
 */
@Entity
@Table(name = "cameras")
public class Camera {

	// Mapping member variables to the appropriate database table contents
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private String price;

	@Column(name = "url")
	private String url;

	/**
	 * Constructor for Camera objects
	 * 
	 * @param id          set the id
	 * @param description set the description
	 * @param price       set the price
	 * @param url         set the url
	 */
	public Camera(int id, String description, String price, String url) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.url = url;
	}

	/**
	 * Empty constructor
	 */
	public Camera() {

	}

	/**
	 * id getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * description getter
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * price getter
	 * 
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * url getter
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * id setter
	 * 
	 * @param id set the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * description setter
	 * 
	 * @param description set the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * price setter
	 * 
	 * @param price set the price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * url setter
	 * 
	 * @param url set the url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}