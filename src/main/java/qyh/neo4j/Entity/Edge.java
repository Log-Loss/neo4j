package qyh.neo4j.Entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "Edge")
public class Edge {
    @Id
    @GeneratedValue
    public Long id;

    @StartNode
    public Vertex start;

    @EndNode
    public Vertex end;

    public String type;
}
