package lt.akademija.exam.client;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author ggrazevicius
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllClients", query = "select client from Client client") })
@Table(name="clients")
public class Client {

	@Id
	@GeneratedValue
	private Long id;

//	@NotNull
	private String firstName;

//	@NotNull
	private String lastName;

//	@NotNull
	private String birthDate;

//	@NotNull
	private String phoneNumber;

//	@NotNull
	private String clientType;

	public Client() {
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
