package qyh.neo4j.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qyh.neo4j.Entity.Vertex;
import qyh.neo4j.Repository.VertexRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class VertexController {
    @Autowired
    VertexRepository vertexRepository;


    @GetMapping("vertices")
    List<Vertex> findAll(String type, String name, int page, int size) {
        if (name == null) {
            return vertexRepository.findAllByType(type, PageRequest.of(page, size));
        } else if (type == null) {
            return vertexRepository.findAllByName(name, PageRequest.of(page, size));
        }
        return vertexRepository.findAllByNameAndType(name, type, PageRequest.of(page, size));
    }

    @GetMapping("vertex")
    Optional<Vertex> findById(Long id) {
        return vertexRepository.findById(id);
    }

    @GetMapping("related")
    List<Vertex> getRelatedById(Long id) {
        return vertexRepository.getRelatedById(id);
    }

    @GetMapping("path")
    List<Vertex> getShortestPathById(Long id1, Long id2) {
        return vertexRepository.getShortestPathById(id1, id2);
    }

    @GetMapping("similar")
    List<Map<String, Object>> getSimilarById(Long id, Boolean sameType) {
        if (sameType != null && sameType)
            return vertexRepository.getSimilarByIdOfSameType(id);
        else
            return vertexRepository.getSimilarById(id);
    }

}
