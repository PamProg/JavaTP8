package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.PizzeriaUtil;

public class NouvellePizzaOptionMenu extends OptionMenu {

	private IPizzaDao dao;
	
	public NouvellePizzaOptionMenu(String libelle) {
		super(libelle);
	}

	@Override
	public boolean execute() {
		String codeString = null;
		String nomString = null;
		String prixString;
		
		dao = new PizzaDaoMemoire();
		
		codeString = PizzeriaUtil.askAndCheckCode();
		nomString = PizzeriaUtil.askAndCheckName();
		prixString = PizzeriaUtil.askAndCheckPrice();
		
		Pizza p = new Pizza(codeString, nomString, Double.parseDouble(prixString));
		try {
			dao.saveNewPizza(p);
		} catch (SavePizzaException e) {
			System.err.println(e.getMessage());
		}
		
		return true;
	}



}
