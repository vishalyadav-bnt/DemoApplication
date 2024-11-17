package com.example.Demo;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class SonarQubeContainerTest {

    @Test
    public void testSonarQubeContainer() {
        try (@SuppressWarnings("resource")
        GenericContainer<?> sonarqube = new GenericContainer<>(DockerImageName.parse("sonarqube:community"))
                .withExposedPorts(9000)) {

            sonarqube.start();
            String sonarHost = "http://" + sonarqube.getHost() + ":" + sonarqube.getMappedPort(9000);

            System.out.println("SonarQube is running at: " + sonarHost);

            // You can assert something based on the SonarQube status here.
            assertTrue(sonarHost.contains("http"));
        }
    }
}
