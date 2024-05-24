package uacs.cip.Historical.landmarks.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String location;
    private String capital;

    @OneToMany(mappedBy = "country", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Historical_Landmarks> landmarks = new ArrayList<>();



    public Countries() {
    }

    public Countries(String location, String capital, List<Historical_Landmarks> landmarks) {
        this.location = location;
        this.capital = capital;
        this.landmarks = landmarks;
    }

    public Countries(Long id, String location, String capital, List<Historical_Landmarks> landmarks) {
        this.Id = id;
        this.location = location;
        this.capital = capital;
        this.landmarks = landmarks;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<Historical_Landmarks> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<Historical_Landmarks> landmarks) {
        this.landmarks = landmarks;
    }


    @Override
    public String toString() {
        return "Countries{" +
                "Id=" + Id +
                ", location='" + location + '\'' +
                ", capital='" + capital + '\'' +
                ", landmarks=" + landmarks +
                '}';
    }
}
