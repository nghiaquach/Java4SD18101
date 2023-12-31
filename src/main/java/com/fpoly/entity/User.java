package com.fpoly.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries ({
	@NamedQuery(
		name="User.findByEmail", query = "SELECT o FROM User o WHERE o.email LIKE:email"	
	)
})


@Entity
@Table (name="Users")
public class User {
	
	@Id
	@Column(name = "id")
	String id;
	@Column(name = "fullname")
	String fullname;
	@Column(name = "email")
	String email;
	@Column(name = "password")
	String password;
	@Column(name = "admin")
	boolean admin;
	
	@OneToMany (mappedBy = "user")
	List<Favorite> favorites;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	
}
