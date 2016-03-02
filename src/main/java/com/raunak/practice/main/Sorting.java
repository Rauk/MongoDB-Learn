package com.raunak.practice.main;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.text.ParseException;

/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class Sorting {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");

        FindIterable<Document> iterable = db.getCollection("restaurants").find()
            .sort(new Document("borough", 1).append("address.zipcode", 1));
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
        System.out.println("\n\n\n");
        iterable = db.getCollection("restaurants").find().sort(
            Sorts.ascending("borough", "address.zipcode"));
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
