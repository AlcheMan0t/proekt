package uacs.cip.Historical.landmarks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoricalLandmarksRepo extends JpaRepository<Historical_Landmarks,Long> {
    List<Historical_Landmarks> findHistoricalLandmarksByCountry(Countries country);

    @Query("SELECT h FROM Historical_Landmarks h WHERE h.name = :name")
    List<Historical_Landmarks> findHistoricalLandmarksByName(@Param("name") String name);

    @Query(value = "select * from Historical_Landmarks h where h.Id = ?1", nativeQuery = true)
    Historical_Landmarks findHistoricalLandmarksById(Long id);

}
