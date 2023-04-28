package it.prova.raccoltafilm.web.servlet.utente;

import java.util.List;

import it.prova.raccoltafilm.model.Utente;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.service.UtenteService;
import it.prova.raccoltafilm.utility.UtilityForm;

public class TTT {

	public static void main(String[] args) {
		
		 UtenteService utenteService = MyServiceFactory.getUtenteServiceInstance();;
		
		 
		
		
		String usernameParam = "n";
		String nomeParam = "a";;
		String cognomeParam = "s";
		String dataCreazioneParam = "";
	
	
		Utente example = UtilityForm.createUtenteFromParams(usernameParam, nomeParam, cognomeParam, dataCreazioneParam);

	System.out.println(example.getNome());
	System.out.println(example.getCognome());

	System.out.println(example.getUsername());

	System.out.println(example.getDateCreated());
	
	try {
		List<Utente> a = utenteService.findByExample(example);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
