import java.util.Scanner;

public class tugasRO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Masukkan koefisien biaya Makanan A: ");
        int biayaA = scanner.nextInt();
        System.out.print("Masukkan koefisien biaya Makanan B: ");
        int biayaB = scanner.nextInt();
        System.out.print("Masukkan koefisien protein Makanan A: ");
        int proteinA = scanner.nextInt();
        System.out.print("Masukkan koefisien protein Makanan B: ");
        int proteinB = scanner.nextInt();
        System.out.print("Masukkan koefisien vitamin Makanan A: ");
        int vitaminA = scanner.nextInt();
        System.out.print("Masukkan koefisien vitamin Makanan B: ");
        int vitaminB = scanner.nextInt();
        System.out.print("Masukkan kebutuhan minimum protein: ");
        int proteinMin = scanner.nextInt();
        System.out.print("Masukkan kebutuhan minimum vitamin: ");
        int vitaminMin = scanner.nextInt();

        
        boolean adaSolusiOptimal = false;
        int biayaOptimal = Integer.MAX_VALUE;
        int xOptimal = 0;
        int yOptimal = 0;
        
        double[][] sudut = {{1.5, 2}, {2.167, 0.667}, {3, 0}};

        System.out.println("\n\nNilai optimasi makanan dan biaya : \n");

        for (double[] sudutKoordinat : sudut) {
            double x = sudutKoordinat[0];
            double y = sudutKoordinat[1];

            
            x = Math.round(x);
            y = Math.round(y);
            
            System.out.printf("Makanan A: %d\n", (int) x);
            System.out.printf("Makanan B: %d\n", (int) y);
            int biayaProduksi = (int) (x * biayaA + y * biayaB);
            System.out.printf("Biaya: Rp%d\n\n", biayaProduksi);
            

            if (biayaProduksi >= 560 && x * proteinA + y * proteinB >= proteinMin && x * vitaminA + y * vitaminB >= vitaminMin) {
                adaSolusiOptimal = true;
                if (biayaProduksi < biayaOptimal) {
                    biayaOptimal = biayaProduksi;
                    xOptimal = (int) x;
                    yOptimal = (int) y;
                }
            }
        }


        

        System.out.println("\n\nHasil dari linier programing(kasus minimum) : \n");
        if (!adaSolusiOptimal) {
            
            System.out.println("Tidak ada solusi optimal karena produksi kurang dari minimum (Makanan A 4 Unit, Makanan B 2 Unit dengan Biaya Rp560.) atau sudut tidak memenuhi kebutuhan minimum vitamin/protein.");
        } else {
            System.out.printf("Dari perhitungan titik sudut yang ada, maka mendapat bahwa makanan A sebanyak %d unit dan Makanan B sebanyak %d unit dengan harga Rp%d menjadi nilai optimum.\n", xOptimal, yOptimal, biayaOptimal);
        }

        
        scanner.close();
    }
}
