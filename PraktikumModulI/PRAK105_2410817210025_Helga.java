package PraktikumModulI;
import java.util.Scanner;

public class PRAK105_2410817210025_Helga {

	public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        final double PHI = 3.14;

	        System.out.print("Masukkan jari-jari: ");
	        double r = scan.nextDouble();

	        System.out.print("Masukkan tinggi: ");
	        double t = scan.nextDouble();

	        double volume = PHI * r * r * t;

	        System.out.println("Volume tabung dengan jari-jari " + r + " cm dan tinggi " + t + " cm adalah " + volume + " m3");

	        scan.close();
	}

}
