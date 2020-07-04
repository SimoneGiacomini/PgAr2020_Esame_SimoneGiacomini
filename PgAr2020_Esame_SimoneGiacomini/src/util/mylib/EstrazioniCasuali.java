package util.mylib;

import java.util.*;
/**classe per fare delle estrazioni casuali*/
public class EstrazioniCasuali {
	private static Random rand = new Random();

	private EstrazioniCasuali() {}
	public static int estraiIntero(int min, int max) {
		int range = max + 1 - min;
		int casual = rand.nextInt(range);
		return casual + min;
	}
	public static double estraiDouble(double min, double max)
	{
	 double range = max - min;
	 double casual = rand.nextDouble();
	 
	 double posEstratto = range*casual;
	 
	 return posEstratto + min;
	}
}
