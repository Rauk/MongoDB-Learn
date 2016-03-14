package com.raunak.practice.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;

/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class RemoveData {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
//        The following operation removes all documents that match the specified condition.
        db.getCollection("restaurants").deleteMany(new Document("borough", "Manhattan"));

//        To remove all documents from a collection, pass an empty conditions document {} to the deleteMany method.
        db.getCollection("restaurants").deleteMany(new Document());
//        This removes all the documents as well as all the indexing stuff
        db.getCollection("restaurants").drop();

    }
}
