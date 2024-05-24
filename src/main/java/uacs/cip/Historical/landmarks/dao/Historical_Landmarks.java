package uacs.cip.Historical.landmarks.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Historical_Landmarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String history;
    private String visitor_guides;
    private String pres_eff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "countries_id")
    private Countries country;

    @OneToMany(mappedBy = "landmark", orphanRemoval = true)
    @JsonManagedReference
    private List<Historical_figures> historicalFigures = new ArrayList<>();

    public Countries getCountry() {
        return country;
    }

    public List<Historical_figures> getHistoricalFigures() {
        return historicalFigures;
    }

    public void setHistoricalFigures(List<Historical_figures> historicalFigures) {
        this.historicalFigures = historicalFigures;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Historical_Landmarks() {
    }

    public Historical_Landmarks(Long id, String name, String history, String visitor_guides, String pres_eff, Countries country, List<Historical_figures> historicalFigures) {
        this.Id = id;
        this.name = name;
        this.history = history;
        this.visitor_guides = visitor_guides;
        this.pres_eff = pres_eff;
        this.country = country;
        this.historicalFigures = historicalFigures;
    }

    public Historical_Landmarks(String name, String history, String visitor_guides, String pres_eff, Countries country, List<Historical_figures> historicalFigures) {
        this.name = name;
        this.history = history;
        this.visitor_guides = visitor_guides;
        this.pres_eff = pres_eff;
        this.country = country;
        this.historicalFigures = historicalFigures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {this.Id= id;
    }


    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getVisitor_guides() {
        return visitor_guides;
    }

    public void setVisitor_guides(String visitor_guides) {
        this.visitor_guides = visitor_guides;
    }

    public String getPres_eff() {
        return pres_eff;
    }

    public void setPres_eff(String pres_eff) {
        this.pres_eff = pres_eff;
    }


    @Override
    public String toString() {
        return "Historical_Landmarks{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", history='" + history + '\'' +
                ", visitor_guides='" + visitor_guides + '\'' +
                ", pres_eff='" + pres_eff + '\'' +
                ", country=" + country +
                ", historicalFigures=" + historicalFigures +
                '}';
    }
}
