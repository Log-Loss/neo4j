package qyh.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import qyh.neo4j.Entity.Edge;
import qyh.neo4j.Entity.Vertex;
import qyh.neo4j.Repository.EdgeRepository;
import qyh.neo4j.Repository.VertexRepository;

import java.util.Optional;
import java.util.logging.Logger;

@SpringBootApplication
public class Neo4jApplication {

    @Autowired
    VertexRepository vertexRepository;

    @Autowired
    EdgeRepository edgeRepository;

    private final static Logger log = Logger.getLogger("log");

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }

    @Bean
    CommandLineRunner demo() {
        return args -> {
//            log.info("11111111111");
//            Optional<Vertex> z = vertexRepository.findById(18L);
//
//            Optional<Edge> y = edgeRepository.findById(165371L);
//
//            log.info(y.toString());
//
//            Object x = vertexRepository.getRandom(10);
//            log.info("22222222");
//
//            Object a = vertexRepository.getRelatedById(1L);
//            log.info("333333");
//
//            Object b = vertexRepository.getShortestPathById(1L, 2L);
//            log.info("44444");
//
//            Object c = vertexRepository.getSimilarById(562L);
//            log.info(c.toString());
//            log.info("55555");

            Integer a = vertexRepository.getCountOfType("Vertex");
            log.info(a.toString());

            a = vertexRepository.getCountOfName("");
            log.info(a.toString());

        };
    }
}
