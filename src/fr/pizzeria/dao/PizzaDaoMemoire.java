package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoMemoire implements IPizzaDao {

	static private List<Pizza> pizzas;
	
	/**
	 * Initialise les pizzas originelles
	 */
	static public void initPizzas() {
		
		pizzas = new ArrayList<Pizza>();
		
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00));
		pizzas.add(new Pizza("REI", "LA Reine", 11.50));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00));
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		for(Pizza p : pizzas) {
			// On vérifie que le code n'existe pas déjà parmi les pizzas
			if(pizzas.get(p.getId()).getCode().equals(pizza.getCode())) {
				throw new SavePizzaException(("Erreur : Le code de la pizza existe déjà. Pizza non sauvée"));
			}
		}
		
		pizzas.add(pizza);
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		
		for(Pizza p : pizzas) {
			if(p.getCode().equals(codePizza)) {
				pizzas.get(p.getId()).setCode(pizza.getCode());
				pizzas.get(p.getId()).setNom(pizza.getNom());
				pizzas.get(p.getId()).setPrix(pizza.getPrix());
			}
		}
		
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		
		for(Pizza p : pizzas) {
			if(pizzas.get(p.getId()).getCode().equals(codePizza)) {
				pizzas.remove(p);
			}
		}
		
		return true;
	}
}
