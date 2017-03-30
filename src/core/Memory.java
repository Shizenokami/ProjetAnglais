package core;

import java.util.ArrayList;
import java.util.Collection;

public class Memory {
	
	private int[] table;
	private String[] cartes = {"perusal" , "a careful \nreading",
			"emblezze" , "diverting fund",
			"faze", "to disconcert",
			"snigger" , "snicker : a sly \nor disrespectful \nlaugh",
			"coarse" , "rude",
			"truculent" , "ready to fight; \ncruel" ,
			"rife" , "abundant or \nplentiful" ,
			"feral" , "Savage, wild" };
	
	public Memory() {
		this.table = new int[16];
		for (int i=0 ; i<16 ; i++) {
			table[i]=i;
		}
		shuffle();
	}
	
	public void shuffle() {
		table=shuffle(table);
	}
	
	public int[] shuffle(int[] array) {
	    int[] a = new int[array.length];
	    //convert int[] to ArrayList<Integer>
	    ArrayList<Integer> list = new ArrayList<>();
	    for (int i: array)
	        list.add(i);
	    //now shuffle:
	    for (int i=0; i<array.length; i++) {
	        int rand = (int)(Math.random()*list.size());
	        a[i] = list.remove(rand);
	    }
	    return a;
	}
	
	public boolean find(int i, int j) {
		int k,l;
		k=Math.min(table[j], table[i]);
		l=Math.max(table[j], table[i]);
		return ((l-k)==1 && k%2==0);
	}
	
	public String text(int i) {
		return cartes[table[i]];
	}
		

}
