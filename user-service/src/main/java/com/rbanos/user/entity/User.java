package com.rbanos.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`user`")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;
  private String firstName;
  private String lastName;
  private String email;
  private Long departmentId;
}
