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
        
    }
}
