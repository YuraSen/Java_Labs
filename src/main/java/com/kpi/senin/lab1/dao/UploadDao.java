package com.kpi.senin.lab1.dao;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.kpi.senin.lab1.model.EntryModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UploadDao extends AbstractDao {
    public void addEntry(EntryModel entry){
        Map<String, Object> json = new HashMap<>();
        json.put("name", entry.getName());
        json.put("count", entry.getCount());
        JsonDocument document = JsonDocument.create(UUID.randomUUID().toString(), JsonObject.from(json));
        this.entries.insert(document);
    }
}
