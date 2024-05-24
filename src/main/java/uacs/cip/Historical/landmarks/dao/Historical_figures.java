package uacs.cip.Historical.landmarks.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Historical_figures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String biography;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="historicallandmark_id")
    private Historical_Landmarks landmark;



    public Historical_figures() {
    }

    public Historical_figures(Long id, String name, String biography, Historical_Landmarks landmark) {
        Id = id;
        this.name = name;
        this.biography = biography;
        this.landmark = landmark;
    }

    public Historical_figures(String name, String biography, Historical_Landmarks landmark) {
        this.name = name;
        this.biography = biography;
        this.landmark = landmark;
    }

    // Getters and setters
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Historical_Landmarks getLandmark() {
        return landmark;
    }

    public void setLandmark(Historical_Landmarks landmark) {
        this.landmark = landmark;
    }


    @Override
    public String toString() {
        return "Historical_figures{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                ", landmark=" + landmark +
                '}';
    }
}
