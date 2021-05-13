package de.allianz.psq3.goodpractice.quarkus.persistence;

import de.allianz.psq3.goodpractice.quarkus.entity.Planet;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PlanetRepository {

  @Inject
  EntityManager entityManager;

  public List<Planet> findAll() {
    return this.entityManager.createQuery("select x from Planet x", Planet.class).getResultList();
  }

  public Planet findById(String id) {
    return this.entityManager.find(Planet.class, id);
  }

  @Transactional
  public void persistPlanet(Planet planet) {
    this.entityManager.persist(planet);
    System.out.println("Safed Planet " + planet.getName() + " with ID " + planet.getId() + " in Database!");
  }

}
