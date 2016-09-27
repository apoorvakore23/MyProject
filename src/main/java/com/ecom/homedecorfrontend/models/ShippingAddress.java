package com.ecom.homedecorfrontend.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;



import java.io.Serializable;


@Entity
public class ShippingAddress implements Serializable{
	@Id
	@SequenceGenerator(name = "ship_seq", sequenceName = "ship_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "ship_seq")
	@Column(name="ShipId")
	private int shipId;
	@NotBlank (message = "House no. Required")
	@Column(name="House_no")
	
	private String houseNumber;
	@NotBlank (message = "Adrress Required")
	@Column(name="addressLine1")
    private String addressLine1;
	@Column(name="addressLine2")
    private String addressLine2;
	@NotBlank (message = "City Required")
	@Column(name="city")
    private String city;
	@NotBlank (message = "State Required")
	@Column(name="state")
    private String state;
	@NotBlank (message = "Country Required")
	@Column(name="country")
    private String country;
	@NotBlank (message = "Zip Code Required")
	@Column(name="zipcode")
    private String zipCode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="custid")
    private Customer usersDetail;
    

	public int getShipId() {
        return shipId;
    }

    public void setShipId(int shippingAddressId) {
        this.shipId = shippingAddressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public Customer getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(Customer usersDetail) {
		this.usersDetail = usersDetail;
	}

	@Override
	public String toString() {
		return "ShippingAdd [shippingAddressId=" + shipId + ", houseNumber=" + houseNumber
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zipCode=" + zipCode + ", Customer=" + usersDetail + "]";
	} 


} // The End of Class;
