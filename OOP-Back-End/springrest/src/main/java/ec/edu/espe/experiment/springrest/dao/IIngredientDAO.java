package ec.edu.espe.experiment.springrest.dao;

import java.util.List;

import ec.edu.espe.experiment.springrest.dto.Ingredient;
import ec.edu.espe.experiment.springrest.model.DBIngredient;


public interface IIngredientDAO{
    public List<Ingredient> getAll();
    public Ingredient get(Integer id);
    public Ingredient put(Ingredient entity);
    public Ingredient post(Ingredient ingredient);
    public Ingredient toIngredient(DBIngredient dbIngredient);
}