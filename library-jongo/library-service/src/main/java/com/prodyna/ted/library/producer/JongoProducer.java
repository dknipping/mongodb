package com.prodyna.ted.library.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.jongo.Jongo;

import com.mongodb.MongoClient;

@ApplicationScoped
public class JongoProducer {

	@Inject
	private MongoClient mongoClient;
	
	@Produces
	public Jongo produceMongoDatabase(InjectionPoint injectionPoint) {
		return new Jongo(mongoClient.getDB(MongoDatabaseProducer.LIBRARY_DATABASE));
	}
}
