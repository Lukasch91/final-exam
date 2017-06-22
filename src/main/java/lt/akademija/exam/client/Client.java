package lt.akademija.exam.client;

import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import lt.akademija.exam.item.Item;

/**
 * Client object
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllClients", query = "select client from Client client") })
public class Client {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String birthDate;

	@NotBlank
	private String phoneNumber;

	@NotBlank
	private String clientType;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itemList;

	public Client() {
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
