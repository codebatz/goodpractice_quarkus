package de.allianz.psq3.goodpractice.quarkus.api;

import de.allianz.psq3.goodpractice.quarkus.entity.Planet;
import de.allianz.psq3.goodpractice.quarkus.service.PlanetService;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;

@ApplicationScoped
@Path("planet")
@Produces(MediaType.APPLICATION_JSON)
public class PlanetEndpoint {

  @Inject
  PlanetService planetService;

  @GET
  @Counted
  public List<Planet> getAllPlanets() {
    List<Planet> planets = this.planetService.getAllPlanets();
    System.out.println(planets.toString());
    return planets;
  }

  @GET
  @Path("{id1}-{id2}")
  public double getGravity(@PathParam("id1") Integer id1, @PathParam("id2") Integer id2) {
    return this.planetService.getGravity(id1, id2);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void persistPlanet(String planetData) {
    this.planetService.persistPlanet(planetData);
  }

}
