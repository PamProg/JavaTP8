package fr.pizzeria.ihm;

import fr.pizzeria.console.PizzeriaAdmin;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.PizzeriaUtil;

public class MettreAJourPizzaOptionMenu extends OptionMenu {

	private IPizzaDao dao;
	
	public MettreAJourPizzaOptionMenu(String libelle) {
		super(libelle);
	}

	@Override
	public boolean execute() {
		
		dao = new PizzaDaoMemoire();
		
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		System.out.println("(99 pour abandonner)");
		
		String codeChosen = PizzeriaAdmin.getInput().next();
		
		if(!codeChosen.equals("99")) {
		
			String codeString;
			String nomString;
			String prixString;
			
			codeString = PizzeriaUtil.askAndCheckCode();
			nomString = PizzeriaUtil.askAndCheckName();
			prixString = PizzeriaUtil.askAndCheckPrice();
			
			Pizza p = new Pizza(codeString, nomString, Double.parseDouble(prixString));
			dao.updatePizza(codeChosen, p);
		}
		
		return true;
	}

}
