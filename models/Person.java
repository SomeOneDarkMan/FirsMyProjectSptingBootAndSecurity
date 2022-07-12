package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;
   @NotEmpty(message = "username should not be empty")
    @Column(name = "username")
   @Size(min = 5,max = 200,message = "username should not be more then 200 smv and username should not be more then 5 smv")
  // @Min(value = 5,message = "username should not be more then 5 smv") ограничение оп минимуму символом по дргому
    String username;

    @NotEmpty(message = "username should not be password")
    @Size(min = 5,max = 200,message = "password should not be more then 200 smv and Password should not be more then 5 smv")
    @Column(name = "password")
   // @Min(value = 5,message = "Password should not be more then 5 smv")
    String password;
    @Column(name = "role")
    String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person(){

    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
