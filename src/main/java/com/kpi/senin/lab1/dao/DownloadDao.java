package com.kpi.senin.lab1.dao;

import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.kpi.senin.lab1.model.EntryModel;
import org.springframework.stereotype.Component;

@Component
public class DownloadDao extends AbstractDao {
    public EntryModel getEntryJavaRX(int offset){
        String query = "SELECT * FROM entries LIMIT 1 OFFSET $1";
        N1qlQueryResult result = this.entries.query(N1qlQuery.parameterized(query, JsonArray.from(offset)));
        if(result.allRows() == null && result.allRows().isEmpty())
            return null;
        JsonObject json = (JsonObject) result.allRows().get(0).value().get("entries");
        return new EntryModel(json.getString("name"), json.getInt("count"));
    }

    public synchronized Integer getEntriesCount(){
        N1qlQueryResult result = this.entries.query(N1qlQuery.simple("SELECT count(*) FROM entries"));
        N1qlQueryRow row = result.allRows().get(0);
        JsonObject json = row.value();
        return (int)json.get("$1");
    }
}
