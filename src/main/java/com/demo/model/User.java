package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users3")
@Getter
@Setter
@ToString
public class User implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "username")
   @NotEmpty(message = "Name should not be empty")
   @Size(min = 2, max = 30, message = "Name should be between 2 to 30")
   private String firstName;
   @Column(name = "password")
   @NotEmpty(message = "password should not be empty")
   private String password;

   @Column(name = "age")
   private int age;
   @Column(name = "name")
   @NotEmpty(message = "LastName should not be empty")
   private String lastName;

   @NotEmpty(message = "Email should not be empty")
   @Column(name = "email")
   private String username;



   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
           name = "users_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")
   )

   @ToString.Exclude
   private Set<Role> roles = new HashSet<>();

   public User() {

   }
   public User(String username, String password) {
      this.username = username;
      this.password = password;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return roles;
   }

   @Override
   public String getUsername() {
      return username;
   }
   @Override
   @JsonIgnore
   public boolean isAccountNonExpired() {
      return true;
   }
   @Override
   @JsonIgnore
   public boolean isAccountNonLocked() {
      return true;
   }
   @Override
   @JsonIgnore
   public boolean isCredentialsNonExpired() {
      return true;
   }
   @Override
   @JsonIgnore
   public boolean isEnabled() {
      return true;
   }

   public void setRole(Role role) {
      if(!(roles.contains(role))){
         roles.add(role);
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
      User user = (User) o;
      return id != null && Objects.equals(id, user.id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + username + '\'' +
              ", roleList=" + roles +
              '}';
   }
}
