package qyh.neo4j.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import qyh.neo4j.Entity.Edge;
import qyh.neo4j.Entity.Vertex;

@RepositoryRestResource
public interface EdgeRepository extends PagingAndSortingRepository<Edge, Long> {

    Page<Edge> findAllByType(String type, Pageable pageable);

    @Query("MATCH (n:Edge) RETURN n LIMIT 10")
    Object get();
}
