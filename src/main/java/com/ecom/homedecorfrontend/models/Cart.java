package com.ecom.homedecorfrontend.models;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Cart implements Serializable{
	@Id
	@SequenceGenerator(name = "cart_seq", sequenceName = "cart_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "cart_seq")
	@Column(name="CartId")
	private int cartId;	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;
	
	 	@OneToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "custId")
	    @JsonIgnore
	    private Customer usersDetail;
	
		private double grandTotal;

	    public int getCartId() {
	        return cartId;
	    }

	    public void setCartId(int cartId) {
	        this.cartId = cartId;
	    }

	    public List<CartItem> getCartItems() {
	        return cartItems;
	    }

	    public void setCartItems(List<CartItem> cartItems) {
	        this.cartItems = cartItems;
	    }

	    public double getGrandTotal() {
	        return grandTotal;
	    }

	    public void setGrandTotal(double grandTotal) {
	        this.grandTotal = grandTotal;
	    }
	    
	    public Customer getUsersDetail() {
			return usersDetail;
		}

		public void setUsersDetail(Customer usersDetail) {
			this.usersDetail = usersDetail;
		}

} // The End of Class;
