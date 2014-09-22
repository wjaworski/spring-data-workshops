package com.payu.workshops;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public abstract class AbstractMongoTest {

    @Autowired
    Mongo mongo;

    @Before
    public void setUp() {
        DB database = mongo.getDB("workshops");
        DBCollection booksCollection = database.getCollection("book");
        booksCollection.drop();

        booksCollection.insert(

            new BasicDBObject("title", "Accounting 101")
                .append("author", "John Smith")
                .append("pages", 200)
                .append("prize", 123.00),

            new BasicDBObject("title", "Management 101")
                .append("author", "Anna McQueen")
                .append("pages", 159)
                .append("prize", 109.98),

            new BasicDBObject("title", "Fraud Cases")
                .append("author", "Neville Astley")
                .append("pages", 190)
                .append("prize", 179.99),

            new BasicDBObject("title", "CPA Review")
                .append("author", "James White")
                .append("pages", 65)
                .append("prize", 299.99),

            new BasicDBObject("title", "Peachtree for Dummies")
                .append("author", "James White")
                .append("pages", 322)
                .append("prize", 49.99),

            new BasicDBObject("title", "Financial Accounting")
                .append("author", "James White")
                .append("pages", 129)
                .append("prize", 164.99),

            new BasicDBObject("title", "Managerial Accounting")
                .append("author", "Mark Baker")
                .append("pages", 155)
                .append("prize", 114.99),

            new BasicDBObject("title", "cost accounting")
                .append("author", "Mark Baker")
                .append("pages", 122)
                .append("prize", 119.99),

            new BasicDBObject("title", "Intermediate Accounting")
                .append("author", "John Smith")
                .append("pages", 123)
                .append("prize", 164.99),

            new BasicDBObject("title", "XBRL in Nutshell")
                .append("author", "Mark Baker")
                .append("pages", 124)
                .append("prize", 109.99)
        );
    }
}
