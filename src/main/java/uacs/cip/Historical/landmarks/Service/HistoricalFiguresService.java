package uacs.cip.Historical.landmarks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacs.cip.Historical.landmarks.dao.Historical_Landmarks;
import uacs.cip.Historical.landmarks.dao.Historical_figures;
import uacs.cip.Historical.landmarks.dao.HistoricalFiguresRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricalFiguresService {

    private final HistoricalFiguresRepo historicalFiguresRepo;

    @Autowired
    public HistoricalFiguresService(HistoricalFiguresRepo historicalFiguresRepo) {
        this.historicalFiguresRepo = historicalFiguresRepo;
    }

    public List<Historical_figures> getAllFigures() {
        return historicalFiguresRepo.findAll();
    }

    public Optional<Historical_figures> getFigureById(Long id) {
        return historicalFiguresRepo.findById(id);
    }

    public Historical_figures saveFigure(Historical_figures figure) {
        return historicalFiguresRepo.save(figure);
    }

    public void deleteFigure(Long id) {
        historicalFiguresRepo.deleteById(id);
    }

    public List<Historical_figures> findFiguresByLandmark(Historical_Landmarks landmark) {
        return historicalFiguresRepo.findHistoricalFiguresByLandmark(landmark);
    }

    public List<Historical_figures> findFiguresByName(String name) {
        return historicalFiguresRepo.findHistoricalFiguresByName(name);
    }

    public Historical_figures findFigureById(Long id) {
        return historicalFiguresRepo.findHistoricalFiguresById(id);
    }
}

