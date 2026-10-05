package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Main {

    public static void main(String[] args) {

        // Connect to MongoDB on localhost port 27000
        MongoClient mongoClient = new MongoClient("localhost", 27000);

        MongoDatabase database = mongoClient.getDatabase("mydb");

        MongoCollection<Document> collection =
                database.getCollection("test");

        Document doc = new Document("name", "Janarthan")
                .append("class", "Software Engineering")
                .append("year", "2026")
                .append("result",
                        new Document("CW", 95)
                                .append("EX", 85));

        collection.insertOne(doc);

        Document myDoc = collection.find().first();

        System.out.println(myDoc.toJson());

        mongoClient.close();
    }
}
