package Modul3.prak301;
import java.util.Random;

public class Dadu {
	private int nilai;
	
	public Dadu() {
		acakDadu();
	}
	
	public void acakDadu() {
		Random acak = new Random();
		nilai = acak.nextInt(6) + 1;
	}
	
	public int getNilai() {
		return nilai;
	}
}
