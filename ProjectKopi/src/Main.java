import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Resep[] arrayResep = {
            // nama, kopi (gr), susu (ml), ukuranCangkir
            new Resep("Espresso Double", 18, 0, 60),
            new Resep("Americano", 18, 0, 150),
            new Resep("Long Black", 20, 0, 200),
            new Resep("Cappuccino", 18, 120, 180),
            new Resep("Flat White", 18, 180, 200),
            new Resep("Cafee Latte", 20, 210, 300),
            new Resep("Macchiato", 20, 30, 90)
        };

        MesinKopi mesinKopi = new MesinKopi(
            300, // kopi gr
            2000, // susu gr 
            1000, // gula gr
            3000, // air gr
            10
        );

    
        int pilihanMenu = 0;

        do {

            if(mesinKopi.getOK() == false){
                System.out.println("Maaf, mesin kopi memerlukan maintenance");
                break;
            }

            cetakMenu(arrayResep);
            System.out.println();
            System.out.print("Pilih nomor: ");
            pilihanMenu = scanner.nextInt();
            System.out.println();
            
            if(pilihanMenu == 0){
                System.out.println("Program selesai");
                break;
            }

            if(1<=pilihanMenu && pilihanMenu <= arrayResep.length){
                Resep resep = arrayResep[pilihanMenu-1];
                System.out.printf("Memilih resep %s\n", resep.getNama());
                System.out.print("Masukkan level gula (1-5): ");
                int levelGula = scanner.nextInt();

                if(Pesanan.cekLevelGulaValid(levelGula)){
                    System.out.printf("Dengan level gula %d\n", levelGula);
                    
                }else{
                    System.out.println("Level gula tidak valid!");
                    break;
                }

                System.out.println();

                Pesanan pesanan = new Pesanan(resep, levelGula);
                boolean statusOK = mesinKopi.buatKopi(pesanan);

                System.out.println("[boongannya sfx mesin kopi]");

                if(statusOK) {

                    System.out.println("Pesanan sudah siap");
                    System.out.println("Silahkan dinikmati");
                }
                else {
                    System.out.println("Maaf, mesin kopi memerlukan maintenance");
                    break;
                }
                
            }else{
                System.out.println("Pilihan tidak valid!");
                System.out.println();
                
            }

        } while (pilihanMenu != 0);
    }
    
    private static void cetakMenu(Resep[] arrayResep){
        System.out.println("===[Pilihan Menu]===");
        for (int i = 0; i < arrayResep.length; i++) {
            Resep resep = arrayResep[i];
            System.out.printf("%d :: %s\n", i+1, resep.getNama());
        }
        System.out.println("0 :: Keluar Menu");
        System.out.println(".");
        
    }
}
