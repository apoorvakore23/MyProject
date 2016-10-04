package com.ecom.homedecorfrontend.models;

import javax.persistence.*;


import java.io.Serializable;

@Entity
public class CustomerOrder implements Serializable{
	@Id
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "order_seq")
    private int orderId;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private Customer usersDetail;

	
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shipId")
    private ShippingAddress shippingAddress;

    public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int userOrderId) {
		this.orderId = userOrderId;
	}

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }



    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public Customer getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(Customer usersDetail) {
		this.usersDetail = usersDetail;
	}
	@Override
	public String toString() {
		return "{orderId:'"+orderId+"',cart:'"+cart+"',usersDetail:'"+usersDetail+"',shippingAddress:'"+shippingAddress+"',usersDetail:'"+usersDetail+"'}";
	}
} // The End of Class;
