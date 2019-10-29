package com.kpi.senin.lab1.dao;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;

public abstract class AbstractDao {
    protected Bucket entries = CouchbaseCluster.create("127.0.0.1")
            .authenticate("database", "root")
            .openBucket("notation");
}
