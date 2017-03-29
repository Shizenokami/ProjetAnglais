package core;

import java.util.ArrayList;
import java.util.Collection;

public class Memory {
	
	private int[] table;
	private String[] cartes;
	private int[] selected = { 0 , 0 };
	
	public void Memory() {
		this.table = new int[16];
		for (int i=0 ; i<16 ; i++) {
			table[i]=i+1;
		}
	}
	
	public void shuffle() {
		table=shuffle(table);
	}
	
	public static int[] shuffle(int[] array) {
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
	
	public boolean find() {
		return (Math.abs(selected[0]-selected[1])==1 && selected[0]%2==0);
	}
	
	public String text(int i) {
		return cartes[table[i]-1];
	}
	
	public int getCard(int i) {
		return table[i];
	}
	
	

}
