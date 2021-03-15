package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.migration;

import org.flywaydb.core.Flyway;

/**
 * heroku 上のデータベースをmigrationする仕組み
 */
public class Migrations {
    public static void main(String...args) throws Exception {
        Flyway flyway = Flyway.configure().dataSource(System.getenv("${JDBC_DATABASE_URL"),
                System.getenv("JDBC_DATABASE_USERNAME"),
                System.getenv("JDBC_DATABASE_PASSWORD")).load();

        // start the migration
        flyway.migrate();
    }
}
