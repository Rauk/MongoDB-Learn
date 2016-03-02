package com.raunak.practice.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.text.ParseException;

/**
 * Created by raunak.agarwal on 02/03/16.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
    }
}
