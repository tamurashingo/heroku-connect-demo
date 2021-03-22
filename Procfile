migrate: java -cp target/herokuconnectdemo-0.0.1-SNAPSHOT.jar.original:target/dependency/* com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.migration.Migrations
web: java -jar target/herokuconnectdemo-0.0.1-SNAPSHOT.jar --spring.profiles.active=heroku --server.port=$PORT
