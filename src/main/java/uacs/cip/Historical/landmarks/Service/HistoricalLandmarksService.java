package uacs.cip.Historical.landmarks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacs.cip.Historical.landmarks.dao.*;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricalLandmarksService {
    @Autowired
    HistoricalLandmarksRepo historicalLandmarksRepo;
    @Autowired
    HistoricalFiguresRepo historicalFiguresRepo;


    public HistoricalLandmarksService(HistoricalLandmarksRepo historicalLandmarksRepo) {
        this.historicalLandmarksRepo = historicalLandmarksRepo;
    }

    public List<Historical_Landmarks> getAllLandmarks() {
        return historicalLandmarksRepo.findAll();
    }

    public Optional<Historical_Landmarks> getLandmarkById(Long id) {
        return historicalLandmarksRepo.findById(id);
    }

    public Historical_Landmarks saveLandmark(Historical_Landmarks landmark) {
        return historicalLandmarksRepo.save(landmark);
    }

    public void deleteLandmark(Long id) {
        historicalLandmarksRepo.deleteById(id);
    }

    public List<Historical_Landmarks> findLandmarksByCountry(Countries country) {
        return historicalLandmarksRepo.findHistoricalLandmarksByCountry(country);
    }

    public List<Historical_Landmarks> findLandmarksByName(String name) {
        return historicalLandmarksRepo.findHistoricalLandmarksByName(name);
    }

    public Historical_Landmarks findLandmarkById(Long id) {
        return historicalLandmarksRepo.findHistoricalLandmarksById(id);
    }

    public Historical_Landmarks addHFToHL(Long hlId, Historical_figures historicalFigures) {
        Historical_Landmarks historical_landmarks= historicalLandmarksRepo.findById(hlId).orElseThrow(()->new IllegalArgumentException("Cannot find landmark"));
        historicalFigures.setLandmark(historical_landmarks);
        return historicalFiguresRepo.save(historicalFigures).getLandmark();


    }
}

