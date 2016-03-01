package com.raunak.practice.main;

/**
 * Created by raunak.agarwal on 01/03/16.
 */

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import  com.mongodb.client.model.Filters;
//import com.mongodb.client.model.Filters.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.util.Arrays.asList;

import java.text.ParseException;


public class MainClass {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");

//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
//        db.getCollection("restaurants").insertOne(
//            new Document("address",
//                new Document()
//                    .append("street", "2 Avenue")
//                    .append("zipcode", "10075")
//                    .append("building", "1480")
//                    .append("coord", asList(-73.9557413, 40.7720266)))
//                .append("borough", "Manhattan")
//                .append("cuisine", "Italian")
//                .append("grades", asList(
//                    new Document()
//                        .append("date", format.parse("2014-10-01T00:00:00Z"))
//                        .append("grade", "A")
//                        .append("score", 11),
//                    new Document()
//                        .append("date", format.parse("2014-01-16T00:00:00Z"))
//                        .append("grade", "B")
//                        .append("score", 17)))
//                .append("name", "Vella")
//                .append("restaurant_id", "41704620"));

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
            new Document("$or", asList(new Document("cuisine", "Italian"), new Document("address.zipcode", "10075"))));
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
