package ec.edu.espe.experiment.springrest.dao;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import ec.edu.espe.experiment.springrest.dto.Size;
import ec.edu.espe.experiment.springrest.model.DBSize;

@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Size> getAll(){

        return dao.getAll();
    }
public interface ISizeDAO{
    public List<Size> getAll();
    public Size get(Integer id);
    public Size put(Size entity);
    public Size post(Size entity);
    public Size toSize(DBSize dbSize);
}
