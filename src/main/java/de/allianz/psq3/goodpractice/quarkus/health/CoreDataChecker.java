package de.allianz.psq3.goodpractice.quarkus.health;

import de.allianz.psq3.goodpractice.quarkus.persistence.PlanetRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
@Readiness
public class CoreDataChecker implements HealthCheck {

  @Inject
  PlanetRepository planetRepository;

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse
        .named("Core data available")
        .state(!this.planetRepository.findAll().isEmpty())
        .build();
  }

}
