package de.allianz.psq3.goodpractice.quarkus.service;

import com.google.gson.Gson;
import de.allianz.psq3.goodpractice.quarkus.persistence.PlanetRepository;
import de.allianz.psq3.goodpractice.quarkus.entity.Planet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PlanetService {

  @Inject
  PlanetRepository planetRepository;

  public List<Planet> getAllPlanets() {
    return this.planetRepository.findAll();
  }

  public double getGravity(String id1, String id2) {
    Planet planet1 = this.planetRepository.findById(id1);
    Planet planet2 = this.planetRepository.findById(id2);
    double distance = 42_000_000;
    double G = 6.674e-11;
    return G * planet1.getMass() * planet2.getMass() / distance / distance;
  }

  public void persistPlanet(String input) {
    Gson gson = new Gson();
    Planet planet = gson.fromJson(input, Planet.class);
    this.planetRepository.persistPlanet(planet);
  }

}
