package PraktikumModulI;
import java.util.Scanner;

public class PRAK102_2410817210025_Helga {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan angka awal: ");
        int awal = scan.nextInt();

        int hit = 0;
        int bil = awal;

        while (hit <= 10) {
            if (bil % 5 == 0) {
                System.out.print((bil / 5 - 1));
            } else {
                System.out.print(bil);
            }

            if (hit <= 9) {
                System.out.print(", ");
            }

            bil++;
            hit++;
        }

        scan.close();

	}

}
