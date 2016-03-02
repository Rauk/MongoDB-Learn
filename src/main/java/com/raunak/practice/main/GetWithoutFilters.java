package com.raunak.practice.main;


import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class GetWithoutFilters {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");

        FindIterable<Document> iterable = db.getCollection("restaurants").find();
        //        iterable = db.getCollection("restaurants").find(new Document("borough", "Manhattan"));
        iterable = db.getCollection("restaurants").find(new Document("address.zipcode", "10075"));
        iterable = db.getCollection("restaurants").find(Filters.eq("address.zipcode", "10075"));
        iterable = db.getCollection("restaurants").find(new Document("grades.grade", "B"));
        iterable = db.getCollection("restaurants").find(Filters.eq("grades.grade", "B"));
        iterable = db.getCollection("restaurants").find(new Document("grades.score", new Document("$gt", 30)));
        iterable = db.getCollection("restaurants").find(Filters.gt("grades.score", 30));
        iterable = db.getCollection("restaurants").find(
            new Document("cuisine", "Italian").append("address.zipcode", "10075"));
        iterable = db.getCollection("restaurants").find(
            new Document("$or", Arrays.asList(new Document("cuisine", "Italian"),
                new Document("address.zipcode", "10075"))));
        iterable = db.getCollection("restaurants").find(Filters.or(Filters.eq("cuisine", "Italian"),
            Filters.eq("address.zipcode", "10075")));

        iterable.forEach(new Block<Document>() {
            //            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
