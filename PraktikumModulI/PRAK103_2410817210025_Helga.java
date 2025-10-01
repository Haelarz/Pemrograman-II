package PraktikumModulI;
import java.util.Scanner;

public class PRAK103_2410817210025_Helga {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah N: ");
        int N = scan.nextInt();

        System.out.print("Masukkan angka awal: ");
        int bil = scan.nextInt();

        int count = 0;

        do {
            if (bil % 2 != 0) { 
                System.out.print(bil);
                count++;
                if (count < N) {
                    System.out.print(", ");
                }
            }
            bil++;
        } while (count < N);

        scan.close();

	}

}
