package com.shop.domain;

public class Cart {
    private String cartid;

    private Integer num;

    private Double total;

    private String Pid;
    
    private String Uid;
    
    private User user;
    
    private Product product;
    

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", num=" + num + ", total=" + total + ", Pid=" + Pid + ", Uid=" + Uid
				+ ", user=" + user + ", product=" + product + "]";
	}


	public String getPid() {
		return Pid;
	}


	public void setPid(String pid) {
		Pid = pid;
	}


	public String getUid() {
		return Uid;
	}


	public void setUid(String uid) {
		Uid = uid;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.Uid = user.getUid();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		this.Pid = product.getPid();
	}


	public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid == null ? null : cartid.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
