package com.ecom.homedecorfrontend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartItem implements Serializable {

    @Id
    @SequenceGenerator(name = "cartitem_seq", sequenceName = "cartitem_seq")
   	@GeneratedValue(strategy=GenerationType.AUTO,generator = "cartitem_seq")
    private int cartItemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    @JsonIgnore//will not affect for this field
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId")
    private Product item;

    private int quantity;
    private double totalPrice;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
   /* @Override
	public String toString() {
		return "{cartItemId:'"+cartItemId+"',cart:'"+cart+"',item:'"+item+"',quantity:'"+quantity+"',totalPrice:'"+totalPrice+"'}";
	}*/
	

} // The End of Class;
