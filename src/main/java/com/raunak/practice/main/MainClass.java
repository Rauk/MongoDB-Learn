package com.raunak.practice.main;

/**
 * Created by raunak.agarwal on 01/03/16.
 */

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.text.ParseException;


public class MainClass {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
    }
}
