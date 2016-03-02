package com.raunak.practice.main;

/**
 * Created by raunak.agarwal on 01/03/16.
 */

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.text.ParseException;


public class MainClass {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");

//        UpdateResult updateResult = db.getCollection("restaurants").updateOne(new Document("name", "Juni"),
        UpdateResult updateResult = db.getCollection("restaurants").updateOne(new Document("nanbsjdkfkme", "Juni"),
            new Document("$set", new Document("cuisine", "American (New)"))
                .append("$currentDate", new Document("lastModified", true)));
        System.out.println(updateResult.getMatchedCount());
        System.out.println(updateResult.getModifiedCount());
        System.out.println(updateResult.getUpsertedId());
        System.out.println(updateResult.isModifiedCountAvailable());
        System.out.println(updateResult.wasAcknowledged());

//        db.getCollection("restaurants").updateOne(new Document("restaurant_id", "41156888"),
        db.getCollection("restaurants").updateOne(new Document("resthjlfhdskjhfkjsaurant_id", "41156888"),
            new Document("$set", new Document("address.street", "East 31st Street")));

        db.getCollection("restaurants").updateMany(
            new Document("address.zipcode", "10016").append("cuisine", "Other"),
            new Document("$set", new Document("cuisine", "Category To Be Determined"))
                .append("$currentDate", new Document("lastModified", true)));
    }
}
