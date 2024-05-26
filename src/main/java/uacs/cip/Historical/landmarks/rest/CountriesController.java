package uacs.cip.Historical.landmarks.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacs.cip.Historical.landmarks.Service.CountriesService;
import uacs.cip.Historical.landmarks.dao.Countries;
import uacs.cip.Historical.landmarks.dao.Historical_Landmarks;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    private final CountriesService countriesService;
    @Autowired
    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping
    public List<Countries> getAllCountries() {
        return countriesService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Countries> getCountryById(@PathVariable long id) {
        Optional<Countries> country = countriesService.getCountryById(id);
        return country.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Countries>> findCountriesByName(@RequestParam String name) {
        List<Countries> countries = countriesService.findCountriesByName(name);
        return countries.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(countries);
    }

    @GetMapping("/searchByCapital")
    public ResponseEntity<List<Countries>> findCountriesByCapital(@RequestParam String capital) {
        List<Countries> countries = countriesService.findCountriesByCapital(capital);
        return countries.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(countries);
    }

    @GetMapping("/searchByNameAndCapital")
    public ResponseEntity<List<Countries>> findCountriesByNameAndCapital(@RequestParam String name, @RequestParam String capital) {
        List<Countries> countries = countriesService.findCountriesByNameAndCapital(name, capital);
        return countries.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(countries);
    }

    @PostMapping
    public Countries createCountry(@RequestBody Countries country) {
        return countriesService.saveCountry(country);
    }
    @PostMapping ("/{countriesId}/add-historical-landmark")
    Historical_Landmarks addHLToCountry(@PathVariable Long countriesId, @RequestBody Historical_Landmarks historical_landmarks){
        return countriesService.addHLToCountry(countriesId, historical_landmarks);
    }
    @PostMapping("/{countriesId}/add-historical-landmark/{historicalLandmarkId}")
    public ResponseEntity<Historical_Landmarks> addHLToCountryByIds(@PathVariable Long countriesId, @PathVariable Long historicalLandmarkId) {
        try {
            Historical_Landmarks addedHistoricalLandmark = countriesService.addHLToCountry(countriesId, historicalLandmarkId);
            return ResponseEntity.ok(addedHistoricalLandmark);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Countries> updateCountry(@PathVariable long id, @RequestBody Countries countryDetails) {
        Optional<Countries> countryOptional = countriesService.getCountryById(id);
        if (countryOptional.isPresent()) {
            Countries country = countryOptional.get();
            country.setName(countryDetails.getName());
            country.setCapital(countryDetails.getCapital());
            country.getLandmarks().clear();
            if (countryDetails.getLandmarks() != null) {
                country.getLandmarks().addAll(countryDetails.getLandmarks());
            }

            Countries updatedCountry = countriesService.saveCountry(country);
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable long id) {
        if (countriesService.getCountryById(id).isPresent()) {
            countriesService.deleteCountry(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


