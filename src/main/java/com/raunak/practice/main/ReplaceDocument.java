package com.raunak.practice.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class ReplaceDocument {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
        db.getCollection("restaurants").replaceOne(new Document("restaurant_id", "41704620"),
            new Document("address",
                new Document()
                    .append("street", "2 Avenue")
                    .append("zipcode", "10075")
                    .append("building", "1480")
                    .append("coord", Arrays.asList(-73.9557413, 40.7720266)))
                .append("name", "Vella 2"));
    }
}
