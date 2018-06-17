package qyh.neo4j.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import qyh.neo4j.Entity.Vertex;

import java.util.List;
import java.util.Map;

@RepositoryRestResource
public interface VertexRepository extends PagingAndSortingRepository<Vertex, Long> {

    Page<Vertex> findAllByName(String name, Pageable pageable);

    Page<Vertex> findAllByCategory(String category, Pageable pageable);

    Page<Vertex> findAllByNameAndCategory(String name, String category, Pageable pageable);

    @Query("MATCH (n:Vertex) RETURN n LIMIT 10")
    List<Vertex> get();

    @Query("MATCH (n)--(m) WHERE id(n)= {0} RETURN m")
    List<Vertex> getRelatedById(Long id);

    @Query("MATCH p=shortestPath((m)-[*]-(n)) WHERE id(m)={0} AND id(n)={1} RETURN p")
    List<Vertex> getShortestPathById(Long id1, Long id2);

    @Query("MATCH (n1)-[r1]-(m)-[r2]-(n2) WHERE id(n1)={0} RETURN n2.name AS Recommended, COUNT(*) AS Strength ORDER BY Strength DESC LIMIT 10")
    Iterable<Map<Vertex, Integer>> getSimilarById(Long id);
}
