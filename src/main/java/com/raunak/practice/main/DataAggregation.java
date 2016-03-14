package com.raunak.practice.main;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class DataAggregation {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");

        AggregateIterable<Document> iterable = db.getCollection("restaurants").aggregate(Arrays.asList(
            new Document("$group",
                new Document("_id", "$borough").append("count", new Document("$sum", 1)))));
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        });

        iterable = db.getCollection("restaurants").aggregate(Arrays.asList(
            new Document("$match", new Document("borough", "Queens").append("cuisine", "Brazilian")),
            new Document("$group", new Document("_id", "$address.zipcode").append("count", new Document("$sum", 1)))));

        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        });
    }
}
