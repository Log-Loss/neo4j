package qyh.neo4j.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VertexController {

    @GetMapping
    public Object getEdge() {

        return "1";
    }


}
