package com.josh.graphql;

import com.josh.graphql.configuration.ElideConfiguration;
import com.yahoo.elide.standalone.ElideStandalone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Application.class, args);


        //If JDBC_DATABASE_URL is not set, we'll run with H2 in memory.
        boolean inMemory = (System.getenv("JDBC_DATABASE_URL") == null);

        ElideConfiguration settings = new ElideConfiguration(inMemory) {};

        ElideStandalone elide = new ElideStandalone(settings);

        settings.runLiquibaseMigrations();

        elide.start();

    }
}
