package guru.springframework.springpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER) // by default anything that's a many relationship is going to be lazy initialized
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
               inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
