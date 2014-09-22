package com.payu.workshops;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackages = "com.payu.workshops")
class ApplicationConfig extends AbstractMongoConfiguration {

    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new Mongo();
        mongo.setWriteConcern(WriteConcern.SAFE);
        return mongo;
    }

    @Override
    protected String getDatabaseName() {
        return "workshops";
    }
}
