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
