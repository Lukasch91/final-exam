package lt.akademija.exam.item;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQueries({ @NamedQuery(name = "findAllItems", query = "select item from Item item") })
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	private String itemTitle;

	@NotNull
	private BigDecimal itemWeight;

	@Min(1)
	@Max(40)
	private Integer sector;

	@NotBlank
	private String insertDate;
	
	private Integer clientId;
	
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public BigDecimal getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(BigDecimal itemWeight) {
		this.itemWeight = itemWeight;
	}

	public Integer getSector() {
		return sector;
	}

	public void setSector(Integer sector) {
		this.sector = sector;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}