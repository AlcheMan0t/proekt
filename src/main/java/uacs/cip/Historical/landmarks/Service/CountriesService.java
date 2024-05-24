package uacs.cip.Historical.landmarks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacs.cip.Historical.landmarks.dao.*;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService {

    @Autowired
    CountriesRepo countriesRepository;


    @Autowired
    HistoricalLandmarksRepo historicalLandmarksRepo;


    public CountriesService(CountriesRepo countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    public List<Countries> getAllCountries() {
        return countriesRepository.findAll();
    }

    public Optional<Countries> getCountryById(Long id) {
        return countriesRepository.findById(id);
    }

    public Countries saveCountry(Countries country) {
        return countriesRepository.save(country);
    }

    public void deleteCountry(Long id) {
        countriesRepository.deleteById(id);
    }

    public Countries findCountryById(Long id) {
        return countriesRepository.findCountryById(id);
    }

    public List<Countries> findCountriesByName(String name) {
        return countriesRepository.findCountriesByName(name);
    }

    public List<Countries> findCountriesByCapital(String capital) {
        return countriesRepository.findCountriesByCapital(capital);
    }

    public List<Countries> findCountriesByNameAndCapital(String name, String capital) {
        return countriesRepository.findCountriesByNameAndCapital(name, capital);
    }

    public Historical_Landmarks addHLToCountry(Long countriesId, Historical_Landmarks historicalLandmarks) {
     Countries countries = countriesRepository.findById(countriesId).orElseThrow(()-> new IllegalArgumentException("cannot find country"));
     historicalLandmarks.setCountry(countries);
     return historicalLandmarksRepo.save(historicalLandmarks);
    }
}


