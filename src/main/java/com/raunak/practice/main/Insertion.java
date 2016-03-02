package com.raunak.practice.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import com.mongodb.client.model.Filters;
//import com.mongodb.client.model.Filters.*;
//import static java.util.Arrays.asList;


/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class Insertion {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
        //        Using a certain Date format to insert data
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

        //        Insert
        db.getCollection("restaurants").insertOne(new Document("address",
                new Document().append("street", "2 Avenue").append("zipcode", "10075")
                    .append("building", "1480").append("coord", Arrays.asList(-73.9557413, 40.7720266)))
                    .append("borough", "Manhattan").append("cuisine", "Italian").append("grades", Arrays.asList(
                        new Document().append("date", format.parse("2014-10-01T00:00:00Z"))
                            .append("grade", "A").append("score", 11),
                        new Document().append("date", format.parse("2014-01-16T00:00:00Z"))
                            .append("grade", "B").append("score", 17))).append("name", "Vella")
                .append("restaurant_id", "41704620"));
    }
}
