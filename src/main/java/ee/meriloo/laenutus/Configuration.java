package ee.meriloo.laenutus;

import ee.meriloo.laenutus.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"ee.meriloo.laenutus"})
public class Configuration {

    public static void main(String[] args) {
        SpringApplication.run(Configuration.class, args);
    }
}
