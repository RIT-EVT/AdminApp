package edu.evt.admin;


import com.mongodb.client.MongoCollection;
import org.bson.Document;
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
        Document doc = credentials.find(eq("key", "wiki_password")).first();

        return doc.toJson();
	}
}
