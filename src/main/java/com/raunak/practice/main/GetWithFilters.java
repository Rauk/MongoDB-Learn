package com.raunak.practice.main;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.text.ParseException;

/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class GetWithFilters {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");

        FindIterable<Document> iterable = db.getCollection("restaurants").find();
        iterable = db.getCollection("restaurants").find(Filters.eq("address.zipcode", "10075"));
        iterable = db.getCollection("restaurants").find(Filters.eq("grades.grade", "B"));
        iterable = db.getCollection("restaurants").find(Filters.gt("grades.score", 30));
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
