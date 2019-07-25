package jp.groovegear;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
}
