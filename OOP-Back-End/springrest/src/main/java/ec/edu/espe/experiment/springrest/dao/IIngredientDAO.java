package ec.edu.espe.experiment.springrest.dao;

import java.util.List;

import ec.edu.espe.experiment.springrest.dto.Ingredient;
import ec.edu.espe.experiment.springrest.model.DBIngredient;
import ec.edu.espe.experiment.springrest.model.DBOrder;


public interface IIngredientDAO{
    public List<Ingredient> getAll();
    public Ingredient get(Integer id);
    public Ingredient put(Ingredient entity);
    public Ingredient post(Ingredient entity);
    public Ingredient toIngredient(DBIngredient dbIngredient);
    public Ingredient get(DBOrder dbOrder);
    public Ingredient put(DBOrder dbOrder);
}