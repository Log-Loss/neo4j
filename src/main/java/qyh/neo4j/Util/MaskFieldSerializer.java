package qyh.neo4j.Util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import qyh.neo4j.Entity.Vertex;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class MaskFieldSerializer extends JsonSerializer<Vertex> {
    @Override
    public void serialize(Vertex value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        Map<String, Object> m= new HashMap<>();
        m.put("id",value.id);
        m.put("type",value.type);
        m.put("name",value.name);
        jgen.writeObject(m);
    }
}