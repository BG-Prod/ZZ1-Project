package zzavatar;

public class ZZoptimiseur {
	private int nbEch; 		// nombre d'echantillons pour moyennage
	private int cptEch;		// compteur d'echantillons
	private ZZfifo<ZZoint[]> positionsOptimisees;		// file des positions utilisables
	private ZZoint[] depart, arrivee;
	
	public ZZoptimiseur(int qtEch, ZZoint[] initial) {
   	 	/***************************************************************
   	 	 * 
   	 	 *  constructeur par d�faut
   	 	 * 
   	 	 ***************************************************************/
    	
		positionsOptimisees = new SimpleQueue<ZZoint[]>();
		nbEch = qtEch;
		cptEch = 0;
		depart = initial;
	}
	
	public void reset(int qtEch, ZZoint[] initial) {
   	 	/***************************************************************
   	 	 * 
   	 	 *  remet a zero l'optimiseur en economisant des allocations
   	 	 * 
   	 	 ***************************************************************/
    	
		positionsOptimisees = new SimpleQueue<ZZoint[]>();
		nbEch = qtEch;
		cptEch = 0;
		depart = initial;
	}
	
	public void addEch(ZZoint[] ech) {
   	 	/***************************************************************
   	 	 * 
   	 	 *  ajoute un echantillon a l'optimiseur
   	 	 * 
   	 	 ***************************************************************/
    	
		if (cptEch!=0) {
			ZZoint.add(ech, arrivee);		// TODO
		} else {
			arrivee = ech;
		}

		cptEch++;
		
		if (cptEch==nbEch) {	// si on a tous les echantillons
			cptEch = 0;
			arrivee = ZZoint.div(arrivee, nbEch);		// TODO
			for (int i = 1; i <= nbEch; i++) {
				positionsOptimisees.put(ZZoint.lerp(depart, arrivee, i/nbEch));	// interpolation des bonnes positions	TODO
			}
			depart = arrivee;	// verifier la copie TODO
		}
	}
	
	public ZZoint[] getOptimizedValue() {
   	 	/***************************************************************
   	 	 * 
   	 	 *  retourne une valeur optimisee
   	 	 * 
   	 	 ***************************************************************/
    	
		return positionsOptimisees.get();
	}
}