package uacs.cip.Historical.landmarks.dao;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String capital;

    @OneToMany(mappedBy = "country", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Historical_Landmarks> landmarks = new ArrayList<>();



    public Countries() {
    }

    public Countries(String name, String capital, List<Historical_Landmarks> landmarks) {
        this.name = name;
        this.capital = capital;
        this.landmarks = landmarks;
    }

    public Countries(Long id, String name, String capital, List<Historical_Landmarks> landmarks) {
        this.Id = id;
        this.name = name;
        this.capital = capital;
        this.landmarks = landmarks;
    }

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
                ", location='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", landmarks=" + landmarks +
                '}';
    }
}
