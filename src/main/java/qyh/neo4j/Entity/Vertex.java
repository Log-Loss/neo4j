package qyh.neo4j.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@NodeEntity
public class Vertex {
    @Id
    @GeneratedValue
    public Long id;

    public String type;

    public String name;

    @Relationship(type = "Edge", direction = Relationship.INCOMING)
    public Set<Edge> incomings;

    @Relationship(type = "Edge", direction = Relationship.OUTGOING)
    public Set<Edge> outgoings;

//    @Relationship(type = "Edge", direction = Relationship.UNDIRECTED)
//    public Set<Edge> relations;
}

