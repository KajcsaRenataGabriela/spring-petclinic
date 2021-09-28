package guru.springframework.springpetclinic.services.map;

import guru.springframework.springpetclinic.model.Visit;
import guru.springframework.springpetclinic.services.VisitService;

import java.util.Set;

public class VisitServiceMapImpl extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null
                || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
