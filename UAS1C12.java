//Nama : Maulida Aprina Putri
//NIM : 244107060098
//Kelas : SIB 1C
//Absen: 12

import java.util.Scanner;

public class UAS1C12 {
    static Scanner sc12 = new Scanner(System.in);
    static int jumlahTim12 = (98 % 3) + 4;
    static String[] namaTim12 = new String[jumlahTim12];
    static int[][] skor12 = new int[jumlahTim12][2];
    static int[] totalSkor12 = new int[jumlahTim12];
    static int buff12 = 12;

    public static void main(String[] args) {
        boolean pilihan12 = true;

        while (pilihan12) {
            System.out.println("\n=== menu UTAMA ===");
            System.out.println("1. Input Data skor Tim");
            System.out.println("2. Tampilkan Tabel skor dan Total skor");
            System.out.println("3. Tentukan Juara Turnamen");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int menu12 = sc12.nextInt();
            sc12.nextLine();

            switch (menu12) {
                case 1: inputDataskor12(); break;
                case 2: tampilkanTabelskor12(); break;
                case 3: tentukanJuara(); break;
                case 4: pilihan12 = false; System.out.println("Terima kasih! Selamat kepada tim juara."); break;
                default: System.out.println("pilihan tidak valid!");
            }
        }
    }

    static void inputDataskor12() {
        for (int i = 0; i < jumlahTim12; i++) {
            System.out.print("\nMasukkan nama tim ke-" + (i + 1) + ": ");
            namaTim12[i] = sc12.nextLine();

            while (true) {
                System.out.print("Masukkan skor " + namaTim12[i] + " untuk Level 1: ");
                int inputskor12 = sc12.nextInt();
                if (inputskor12 < 0) {
                    System.out.println("skor tidak valid! skor harus positif atau nol.");
                } else if (inputskor12 < 35) {
                    System.out.println("skor Level 1 kurang dari 35, dianggap nol.");
                    skor12[i][0] = 0;
                    break;
                } else {
                    skor12[i][0] = inputskor12;
                    break;
                }
            }

            while (true) {
                System.out.print("Masukkan skor " + namaTim12[i] + " untuk Level 2: ");
                int inputskor12 = sc12.nextInt();
                if (inputskor12 < 0) {
                    System.out.println("skor tidak valid! skor harus positif atau nol.");
                } else {
                    skor12[i][1] = inputskor12;
                    break;
                }
            }
            sc12.nextLine();
            totalSkor12[i] = skor12[i][0] + skor12[i][1];
        }
    }

    static void tampilkanTabelskor12() {
        System.out.println("\nTabel skor Turnamen:");
        System.out.printf("%-10s %-7s %-7s %-7s%n", "Nama Tim", "Level 1", "Level 2", "Total skor");

        for (int i = 0; i < jumlahTim12; i++) {
            int bonus12 = (skor12[i][0] > 50 && skor12[i][1] > 50) ? buff12 : 0;
            int totalSkorAkhir12 = totalSkor12[i];
            if (totalSkorAkhir12 % 2 == 0) totalSkorAkhir12 -= 15;
            totalSkorAkhir12 += bonus12;
            totalSkor12[i] = totalSkorAkhir12;

            System.out.printf("%-10s %-7d %-7d %-7d%n", namaTim12[i], skor12[i][0], skor12[i][1], totalSkorAkhir12);
        }
    }

    static void tentukanJuara() {
        if (namaTim12[0] == null) {
            System.out.println("\nTidak ada data yang bisa ditampilkan.");
            return;
        }
    
        int skorTertinggi12 = totalSkor12[0];
        int skorTertinggiLevel212 = skor12[0][1];
        String juara12 = namaTim12[0];
        boolean seri12 = false;
    
        for (int i = 1; i < jumlahTim12; i++) {
            if (totalSkor12[i] > skorTertinggi12) {
                skorTertinggi12 = totalSkor12[i];
                skorTertinggiLevel212 = skor12[i][1];
                juara12 = namaTim12[i];
                seri12 = false;
            } else if (totalSkor12[i] == skorTertinggi12) {
                if (skor12[i][1] > skorTertinggiLevel212) {
                    skorTertinggiLevel212 = skor12[i][1];
                    juara12 = namaTim12[i];
                    seri12 = false;
                } else if (skor12[i][1] == skorTertinggiLevel212) {
                    seri12 = true;
                }
            }
        }
    
        if (seri12) {
            System.out.println("\nTurnamen berakhir seri. Tim terbaik adalah Muna.");
        } else {
            System.out.println("\nSelamat kepada Tim " + juara12 + " yang telah memenangkan kompetisi!");
        }
    }
}    