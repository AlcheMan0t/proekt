package uacs.cip.Historical.landmarks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoricalFiguresRepo extends JpaRepository<Historical_figures,Long> {

    List<Historical_figures> findHistoricalFiguresByLandmark(Historical_Landmarks landmark);


    @Query("select hf from Historical_figures hf where hf.name = :name")
    List<Historical_figures> findHistoricalFiguresByName(@Param("name") String name);

    @Query(value = "select * from Historical_figures hf where hf.Id = ?1", nativeQuery = true)
    Historical_figures findHistoricalFiguresById(Long id);

}

