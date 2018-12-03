
import java.util.*;

public class gym {

    Scanner gym = new Scanner(System.in);
    double jarak, harga, fasilitas, luas, jamop;
    double totalbobot;
    double jarakbobot, hargabobot, fasilitasbobot, luasbobot, jamopbobot;
    double totalsi;
    double alt[][] = new double[20][5];
    double hasil[] = new double[20];
    double nilaivektor[] = new double[20];

    public gym() {
    }

    public void inisialisasibobot() {
        System.out.println("Input Jarak (Km): ");
        jarak = gym.nextDouble();
        System.out.println("Input Harga (rb): ");
        harga = gym.nextDouble();
        System.out.println("Input Fasilitas (1-10): ");
        fasilitas = gym.nextDouble();
        System.out.println("Input Luas (1-10): ");
        luas = gym.nextDouble();
        System.out.println("Input Jam Operasional(jam): ");
        jamop = gym.nextDouble();

        totalbobot = jarak + harga + fasilitas + luas + jamop;

        jarakbobot = jarak / totalbobot;
        hargabobot = harga / totalbobot;
        fasilitasbobot = fasilitas / totalbobot;
        luasbobot = luas / totalbobot;
        jamopbobot = jamop / totalbobot;
        System.out.println("=======================");
        System.out.println("Total Bobot");
        System.out.println(totalbobot);
        System.out.println("=======================");
        System.out.println("Tingkat Prioritas Bobot");
        System.out.println(jarakbobot);
        System.out.println(hargabobot);
        System.out.println(fasilitasbobot);
        System.out.println(luasbobot);
        System.out.println(jamopbobot);
    }

    public void hitungnilaialt() {
        System.out.println("================");
        System.out.println("Hitung Nilai Alt");

        double[][] data = {{1.1, 50, 6, 4, 14}, {6.7, 100, 7, 5, 15}, {4.3, 80, 5, 8, 14}, {2.6, 110, 10, 4, 14},
        {3.2, 85, 2, 7, 14}, {3.1, 55, 7, 10, 14}, {2.2, 50, 3, 9, 14}, {1.8, 60, 4, 6, 14},
        {1.8, 55, 9, 5, 12}, {5.5, 65, 3, 9, 11}, {3.1, 95, 3, 7, 14}, {4.7, 90, 4, 3, 14},
        {3.7, 100, 7, 8, 14}, {1.8, 70, 10, 3, 13}, {4.1, 75, 10, 8, 12}, {6.6, 90, 9, 4, 15},
        {2.8, 75, 8, 6, 12}, {3.7, 45, 4, 8, 14}, {3.5, 50, 2, 7, 12}, {8.2, 150, 6, 10, 16}};

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (j == 0) {
                    alt[i][j] = 1 / Math.pow(data[i][j], jarakbobot);
                } else if (j == 1) {
                    alt[i][j] = 1 / Math.pow(data[i][j], hargabobot);
                } else if (j == 2) {
                    alt[i][j] = Math.pow(data[i][j], fasilitasbobot);
                } else if (j == 3) {
                    alt[i][j] = Math.pow(data[i][j], luasbobot);
                } else if (j == 4) {
                    alt[i][j] = Math.pow(data[i][j], jamopbobot);
                }
            }
        }
        for (int i = 0; i < alt.length; i++) {
            for (int j = 0; j < alt[i].length; j++) {
                System.out.print(alt[i][j] + "     ");
            }
            System.out.println("");
        }
    }

    public void hitungnilaisi() {
        System.out.println("=============================");
        System.out.println("Nilai Total Si Dikali Kekanan");

        for (int i = 0; i < alt.length; i++) {

            {
                hasil[i] = alt[i][0] * alt[i][1] * alt[i][2] * alt[i][3] * alt[i][4];
            }

        }
        for (int i = 0; i < hasil.length; i++) {
            System.out.println(hasil[i] + " S" + (i + 1));
        }
    }

    public void hitungtotalsi() {
        System.out.println("==============");
        System.out.println("Total Nilai SI");
        for (int i = 0; i < hasil.length; i++) {
            totalsi += hasil[i];
        }
        System.out.println(totalsi);
    }

    public void hitungvektor() {
        System.out.println("===================");
        System.out.println("Hitung Nilai Vektor");
        for (int i = 0; i < alt.length; i++) {
            nilaivektor[i] = hasil[i] / totalsi;
        }
        for (int i = 0; i < nilaivektor.length; i++) {
            System.out.println(nilaivektor[i] + " V" + (i + 1));
        }
    }

    public void sort() {
        System.out.println("====================================================");
        System.out.println("Sorting dari besar ke kecil berdasarkan nilai Vektor");
        double temp;
        double[] sorted = new double[nilaivektor.length];
        for (int i = 0; i < nilaivektor.length; i++) {
            for (int j = i + 1; j < nilaivektor.length; j++) {
                if (nilaivektor[i] < nilaivektor[j]) {
                    temp = nilaivektor[i];
                    nilaivektor[i] = nilaivektor[j];
                    nilaivektor[j] = temp;
                }
            }
        }
        for (int i = 0; i < nilaivektor.length; i++) {
            System.out.println(nilaivektor[i] + " " + "(" + (i + 1) + ")");
        }
    }

    public static void main(String[] args) {
        gym gym = new gym();
        System.out.println("Sistem Pendukung Keputusan Tempat GYM Malang");
        System.out.println("============================================");
        gym.inisialisasibobot();
        gym.hitungnilaialt();
        gym.hitungnilaisi();
        gym.hitungtotalsi();
        gym.hitungvektor();
        gym.sort();
    }
}
