import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        MesinKopi mesinKopi = new MesinKopi(1500, 1500, 1500, 15000, 100);
        
        Resep[] resep = {
            new Resep("A", 100, 100, 300),
            new Resep("B", 100, 100, 300),
            new Resep("C", 100, 100, 300),
        };
        
        String namaKafe = "Cawan Pagi";
        Kafe kafe = new Kafe(namaKafe, mesinKopi, resep);

        int pilihan = 0;
        do {

            cetakPilihan(namaKafe);

            System.out.printf("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            if(pilihan==0){
                System.out.println("Program dihentikan.");
                break;
            }

            switch (pilihan) {
                case 1:
                    kafe.buatPesanan(scanner);
                    cetakKonfirmasi(scanner);
                    break;
                case 2:
                    kafe.cetakAntrean();
                    cetakKonfirmasi(scanner);
                    break;
                case 3:
                    kafe.buatKopi(scanner);
                    cetakKonfirmasi(scanner);
                    break;
                case 4:
                    kafe.cetakLaporan();
                    cetakKonfirmasi(scanner);
                default:
                    System.out.println("Pilihan tidak dikenal");
                    break;
            }

        } while (pilihan!=0);

        scanner.close();
    }

    private static void cetakPilihan(String namaKafe){
        System.out.printf("[=== Cafe %s ===]\n", namaKafe);
        System.out.printf("1. Buat Pesanan\n");
        System.out.printf("2. Cetak Antrean\n");
        System.out.printf("3. Buat Kopi\n");
    }

    private static void cetakKonfirmasi(Scanner scanner){
        System.out.printf("\nTekan Enter untuk kembali...      ");
        scanner.nextLine();
        System.out.printf("\n");
    }


    // public static void oldmain(String[] args) {

    //     Scanner scanner = new Scanner(System.in);

    //     Resep[] arrayResep = {
    //         // nama, kopi (gr), susu (ml), ukuranCangkir
    //         new Resep("Espresso Double", 18, 0, 60),
    //         new Resep("Americano", 18, 0, 150),
    //         new Resep("Long Black", 20, 0, 200),
    //         new Resep("Cappuccino", 18, 120, 180),
    //         new Resep("Flat White", 18, 180, 200),
    //         new Resep("Cafee Latte", 20, 210, 300),
    //         new Resep("Macchiato", 20, 30, 90)
    //     };

    //     MesinKopi mesinKopi = new MesinKopi(
    //         300, // kopi gr
    //         2000, // susu gr 
    //         1000, // gula gr
    //         3000, // air gr
    //         10
    //     );

    
    //     int pilihanMenu = 0;

    //     do {

    //         if(mesinKopi.getOK() == false){
    //             System.out.println("Maaf, mesin kopi memerlukan maintenance");
    //             break;
    //         }

    //         cetakMenu(arrayResep);
    //         System.out.println();
    //         System.out.print("Pilih nomor: ");
    //         pilihanMenu = scanner.nextInt();
    //         System.out.println();
            
    //         if(pilihanMenu == 0){
    //             System.out.println("Program selesai");
    //             break;
    //         }

    //         if(1<=pilihanMenu && pilihanMenu <= arrayResep.length){
    //             Resep resep = arrayResep[pilihanMenu-1];
    //             System.out.printf("Memilih resep %s\n", resep.getNama());
    //             System.out.print("Masukkan level gula (1-5): ");
    //             int levelGula = scanner.nextInt();

    //             if(Pesanan.cekLevelGulaValid(levelGula)){
    //                 System.out.printf("Dengan level gula %d\n", levelGula);
                    
    //             }else{
    //                 System.out.println("Level gula tidak valid!");
    //                 break;
    //             }

    //             System.out.println();

    //             Pesanan pesanan = new Pesanan(resep, levelGula);
    //             boolean statusOK = mesinKopi.buatKopi(pesanan);

    //             System.out.println("[boongannya sfx mesin kopi]");

    //             if(statusOK) {

    //                 System.out.println("Pesanan sudah siap");
    //                 System.out.println("Silahkan dinikmati");
    //             }
    //             else {
    //                 System.out.println("Maaf, mesin kopi memerlukan maintenance");
    //                 break;
    //             }
                
    //         }else{
    //             System.out.println("Pilihan tidak valid!");
    //             System.out.println();
                
    //         }

    //     } while (pilihanMenu != 0);
    // }
    
    // private static void cetakMenu(Resep[] arrayResep){
    //     System.out.println("===[Pilihan Menu]===");
    //     for (int i = 0; i < arrayResep.length; i++) {
    //         Resep resep = arrayResep[i];
    //         System.out.printf("%d :: %s\n", i+1, resep.getNama());
    //     }
    //     System.out.println("0 :: Keluar Menu");
    //     System.out.println(".");
        
    // }
}
