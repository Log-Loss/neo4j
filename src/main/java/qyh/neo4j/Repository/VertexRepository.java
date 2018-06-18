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

    List<Vertex> findAllByName(String name, Pageable pageable);

    List<Vertex> findAllByType(String type, Pageable pageable);

    List<Vertex> findAllByNameAndType(String name, String type, Pageable pageable);

    @Query("MATCH (n:Vertex) RETURN n LIMIT {0}")
    List<Vertex> getRandom(int cnt);

    @Query("MATCH (n)--(m) WHERE id(n)= {0} RETURN m")
    List<Vertex> getRelatedById(Long id);

    @Query("MATCH p=shortestPath((m)-[*]-(n)) WHERE id(m)={0} AND id(n)={1} RETURN p")
    List<Vertex> getShortestPathById(Long id1, Long id2);

    @Query("MATCH (n1)-[r1]-(m)-[r2]-(n2) WHERE id(n1)={0} RETURN n2 AS Recommended, COUNT(*) AS Strength ORDER BY Strength DESC LIMIT 10")
    List<Map<String, Object>> getSimilarById(Long id);

    @Query("MATCH (n1)-[r1]-(m)-[r2]-(n2) WHERE id(n1)={0} AND n1.type=n2.type RETURN n2 AS similar, COUNT(*) AS weight ORDER BY weight DESC LIMIT 10")
    List<Map<String, Object>> getSimilarByIdOfSameType(Long id);

    @Query("MATCH (n) WHERE n.type = {0} RETURN count(n)")
    Integer getCountOfType(String type);

    @Query("MATCH (n) WHERE n.name = {0} RETURN count(n)")
    Integer getCountOfName(String type);

}
