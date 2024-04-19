package ru.martinov.connector.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebeziumConnectorConfig {
    @Value("${datasource.user.host}")
    private String userDBHost;

    @Value("${datasource.user.database-name}")
    private String userDBName;

    @Value("${datasource.user.port}")
    private String userDBPort;

    @Value("${datasource.user.username}")
    private String userDBUserName;

    @Value("${datasource.user.password}")
    private String userDBPassword;

    @Value("${datasource.user.table-name}")
    public String userTableName;

    @Bean
    public io.debezium.config.Configuration studentConnector() {
        return io.debezium.config.Configuration.create()
                .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
                .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", "/home/user/data/user-offset.dat")
                .with("offset.flush.interval.ms", 1000)
                .with("plugin.name", "pgoutput")
                .with("name", "user-postgres-connector")
                .with("database.server.name", userDBHost + "-" + userDBName)
                .with("database.hostname", userDBHost)
                .with("database.port", userDBPort)
                .with("database.user", userDBUserName)
                .with("database.password", userDBPassword)
                .with("database.dbname", userDBName)
                .with("table.whitelist", userTableName).build();
    }
}
