package de.allianz.psq3.goodpractice.quarkus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Planet {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;
  private double mass;

  public Planet(String name, double mass) {
    this.name = name;
    this.mass = mass;
  }

  protected Planet() {
  }
}
