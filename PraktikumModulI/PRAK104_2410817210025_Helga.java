package PraktikumModulI;
import java.util.Scanner;

public class PRAK104_2410817210025_Helga {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


        String[] abu = new String[3];
        String[] bagas = new String[3];

        System.out.println("Tangan Abu: ");
        for (int i = 0; i < 3; i++) {
            abu[i] = scan.next(); 
        }

        System.out.println("Tangan Bagas: ");
        for (int i = 0; i < 3; i++) {
            bagas[i] = scan.next(); 
        }

        int skorAbu = 0;
        int skorBagas = 0;

        for (int i = 0; i < 3; i++) {
            if (abu[i].equals(bagas[i])) {
                
            } else if ((abu[i].equals("B") && bagas[i].equals("G")) ||
                       (abu[i].equals("G") && bagas[i].equals("K")) ||
                       (abu[i].equals("K") && bagas[i].equals("B"))) {
                skorAbu++;
            } else {
                skorBagas++;
            }
        }

        if (skorAbu > skorBagas) {
            System.out.println("Abu");
        } else if (skorBagas > skorAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

        scan.close();
	}

}
