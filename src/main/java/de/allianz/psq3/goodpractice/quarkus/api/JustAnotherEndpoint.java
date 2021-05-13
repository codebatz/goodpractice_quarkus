package de.allianz.psq3.goodpractice.quarkus.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("configproperty")
public class JustAnotherEndpoint {

  @Inject
  @ConfigProperty(name = "answer")
  int answer;

  @GET
  @Path("answer")
  public int getAnswer() {
    return this.answer;
  }
}
