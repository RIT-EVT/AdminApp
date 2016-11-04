package edu.evt.admin;


import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

import static com.mongodb.client.model.Filters.*;

/**
 * Created by wheeler on 11/3/16.
 */
public class CredentialProvider {
	// TODO: Implement this!

    public CredentialProvider(){
        App.db.createCollection("credentials");
    }

	public String get(String key){
        MongoCollection<Document> credentials = App.db.getCollection("credentials");
        Document doc = credentials.find(eq("key", key)).first();

        return doc.getString("value");
	}

	public void store(String key, String value){
        MongoCollection<Document> credentials = App.db.getCollection("credentials");
        Map<String, Object> doc = new HashMap<String, Object>(){{
            put("key", key);
            put("value", value);
        }};
        credentials.insertOne(new Document(doc));
    }
}
