package fr.eni.encheres.controller;

public abstract class CodesResultatServlets {

	public static final int FORMAT_ID_LISTE_ERREUR=30000;
	
	//30000 erreurs saisir creation Utilisateur
	public static final Integer PSEUDO_OBLIGATOIRE = 30001;
	public static final Integer NOM_OBLIGATOIRE= 30002;
	public static final Integer PRENOM_OBLIGATOIRE= 30003;
	public static final Integer EMAIL_OBLIGATOIRE= 30004;
	public static final Integer TEL_OBLIGATOIRE= 30005;
	public static final Integer RUE_OBLIGATOIRE= 30006;
	public static final Integer CODE_POSTAL_OBLIGATOIRE= 30007;
	public static final Integer VILLE_OBLIGATOIRE= 30008;
	public static final Integer MOT_DE_PASSE_OBLIGATOIRE= 30009;
	public static final Integer MOT_DE_PASSE_IDENTIQUE= 30010;
	
	//30100 erreus saisir Article
	
	public static final Integer NOM_ARTICLE_OBLIGATOIRE= 30101;
	public static final Integer DESCRIPTION_OBLIGATOIRE= 30102;
	public static final Integer DATE_DEBUT_OBLIGATOIRE= 30103;
	public static final Integer DATE_FIN_OBLIGATOIRE= 30104;
	public static final Integer ETAT_OBLIGATOIRE= 30105;

}

