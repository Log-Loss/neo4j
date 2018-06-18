package qyh.neo4j.Entity;

import org.neo4j.ogm.annotation.*;
import qyh.neo4j.Util.MaskField;

@RelationshipEntity(type = "Edge")
public class Edge {
    @Id
    @GeneratedValue
    public Long id;

    @StartNode
    @MaskField
    public Vertex start;

    @EndNode
    @MaskField
    public Vertex end;

    public String type;
}
