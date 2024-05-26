package uacs.cip.Historical.landmarks.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacs.cip.Historical.landmarks.dao.Countries;
import uacs.cip.Historical.landmarks.dao.Historical_Landmarks;
import uacs.cip.Historical.landmarks.Service.HistoricalLandmarksService;
import uacs.cip.Historical.landmarks.dao.Historical_figures;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historical-landmarks")
public class HistoricalLandmarksController {

    private final HistoricalLandmarksService historicalLandmarksService;

    @Autowired
    public HistoricalLandmarksController(HistoricalLandmarksService historicalLandmarksService) {
        this.historicalLandmarksService = historicalLandmarksService;
    }

    @GetMapping
    public List<Historical_Landmarks> getAllLandmarks() {
        return historicalLandmarksService.getAllLandmarks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historical_Landmarks> getLandmarkById(@PathVariable Long id) {
        Optional<Historical_Landmarks> landmark = historicalLandmarksService.getLandmarkById(id);
        return landmark.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/searchByCountry")
    public ResponseEntity<List<Historical_Landmarks>> findLandmarksByCountry(@RequestParam Countries country) {
        List<Historical_Landmarks> landmarks = historicalLandmarksService.findLandmarksByCountry(country);
        return landmarks.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(landmarks);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Historical_Landmarks>> findLandmarksByName(@RequestParam String name) {
        List<Historical_Landmarks> landmarks = historicalLandmarksService.findLandmarksByName(name);
        return landmarks.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(landmarks);
    }

    @PostMapping
    public Historical_Landmarks createLandmark(@RequestBody Historical_Landmarks landmark) {
        return historicalLandmarksService.saveLandmark(landmark);
    }
    @PostMapping ("/{HLId}/add-historical-figure")
    Historical_Landmarks addHFToHL(@PathVariable Long HLId, @RequestBody Historical_figures historical_figures){
        return historicalLandmarksService.addHFToHL(HLId, historical_figures);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historical_Landmarks> updateLandmark(@PathVariable Long id, @RequestBody Historical_Landmarks landmarkDetails) {
        Optional<Historical_Landmarks> landmarkOptional = historicalLandmarksService.getLandmarkById(id);
        if (landmarkOptional.isPresent()) {
            Historical_Landmarks landmark = landmarkOptional.get();
            landmark.setName(landmarkDetails.getName());
            landmark.setHistory(landmarkDetails.getHistory());
            landmark.setVisitor_guides(landmarkDetails.getVisitor_guides());
            landmark.setPres_eff(landmarkDetails.getPres_eff());
            landmark.setCountry(landmarkDetails.getCountry());
            landmark.setHistoricalFigures(landmarkDetails.getHistoricalFigures());
            Historical_Landmarks updatedLandmark = historicalLandmarksService.saveLandmark(landmark);
            return ResponseEntity.ok(updatedLandmark);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLandmark(@PathVariable Long id) {
        if (historicalLandmarksService.getLandmarkById(id).isPresent()) {
            historicalLandmarksService.deleteLandmark(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{HLId}/add-historical-figure/{HFId}")
    public ResponseEntity<Historical_Landmarks> addHFToHL(@PathVariable Long HLId, @PathVariable Long HFId) {
        try {
            Historical_Landmarks updatedLandmark = historicalLandmarksService.addHFToHL(HLId, HFId);
            return ResponseEntity.ok(updatedLandmark);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


