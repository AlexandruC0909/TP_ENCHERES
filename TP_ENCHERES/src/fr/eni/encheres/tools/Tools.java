package fr.eni.encheres.tools;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.messages.LecteurMessage;



public class Tools {
	public static List<String> getMessages(List<Integer> listeCodesErreur){
		List<String> messages = new ArrayList<String>();
		for(int codeErreur:listeCodesErreur)
		{
			messages.add(LecteurMessage.getMessageErreur(codeErreur));
		}
		return messages;
	}
}
