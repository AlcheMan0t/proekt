package uacs.cip.Historical.landmarks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountriesRepo extends JpaRepository<Countries, Long> {

    @Query("SELECT c FROM Countries c WHERE c.Id = :id")
    Countries findCountryById(@Param("id") Long id);

    @Query("SELECT c FROM Countries c WHERE c.name = :name")
    List<Countries> findCountriesByName(@Param("name") String name);

    @Query("SELECT c FROM Countries c WHERE c.capital = :capital")
    List<Countries> findCountriesByCapital(@Param("capital") String capital);

    @Query("SELECT c FROM Countries c WHERE c.name = :name AND c.capital = :capital")
    List<Countries> findCountriesByNameAndCapital(@Param("name") String name, @Param("capital") String capital);
}

