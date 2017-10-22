package tn.formation.boot.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
 
 @Column(nullable = false)
 private String firstName;
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
@Column(nullable = false)
 private String lastName;

 
 @Column(nullable = false)
 private String password;
 
 @Column(unique = true, nullable = false)
 private String login;
 
 
 public long getId() {
  return id;
 }
 public void setId(long id) {
  this.id = id;
 }
 public String getLogin() {
  return login;
 }
 public void setLogin(String login) {
  this.login = login;
 }
 public String getPassword() {
  return password;
 }
 public void setPassword(String password) {
  this.password = password;
 }

 
 
 
}
