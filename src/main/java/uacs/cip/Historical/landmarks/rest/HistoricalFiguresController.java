package uacs.cip.Historical.landmarks.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacs.cip.Historical.landmarks.dao.Historical_Landmarks;
import uacs.cip.Historical.landmarks.dao.Historical_figures;
import uacs.cip.Historical.landmarks.Service.HistoricalFiguresService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historical-figures")
public class HistoricalFiguresController {

    private final HistoricalFiguresService historicalFiguresService;

    @Autowired
    public HistoricalFiguresController(HistoricalFiguresService historicalFiguresService) {
        this.historicalFiguresService = historicalFiguresService;
    }

    @GetMapping
    public List<Historical_figures> getAllFigures() {
        return historicalFiguresService.getAllFigures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historical_figures> getFigureById(@PathVariable Long id) {
        Optional<Historical_figures> figure = historicalFiguresService.getFigureById(id);
        return figure.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/searchByLandmark")
    public ResponseEntity<List<Historical_figures>> findFiguresByLandmark(@RequestParam Historical_Landmarks landmark) {
        List<Historical_figures> figures = historicalFiguresService.findFiguresByLandmark(landmark);
        return figures.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(figures);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Historical_figures>> findFiguresByName(@RequestParam String name) {
        List<Historical_figures> figures = historicalFiguresService.findFiguresByName(name);
        return figures.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(figures);
    }

    @PostMapping
    public Historical_figures createFigure(@RequestBody Historical_figures figure) {
        return historicalFiguresService.saveFigure(figure);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historical_figures> updateFigure(@PathVariable Long id, @RequestBody Historical_figures figureDetails) {
        Optional<Historical_figures> figureOptional = historicalFiguresService.getFigureById(id);
        if (figureOptional.isPresent()) {
            Historical_figures figure = figureOptional.get();
            figure.setName(figureDetails.getName());
            figure.setBiography(figureDetails.getBiography());
            figure.setLandmark(figureDetails.getLandmark());
            Historical_figures updatedFigure = historicalFiguresService.saveFigure(figure);
            return ResponseEntity.ok(updatedFigure);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFigure(@PathVariable Long id) {
        if (historicalFiguresService.getFigureById(id).isPresent()) {
            historicalFiguresService.deleteFigure(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

