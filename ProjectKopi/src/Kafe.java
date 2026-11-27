import java.util.Scanner;

public class Kafe {
    private String nama;

    private Resep[] menu;

    private Pesanan[] antrean;
    private int indexAntreanTerbaru = 0;
    
    private MesinKopi mesinKopi;

    public Kafe(String nama, MesinKopi mesinKopi, Resep[] menu){
        this.nama = nama;
        this.antrean = new Pesanan[20];
        this.mesinKopi = mesinKopi;
        this.menu = menu;
    }

    public void buatPesanan(Scanner scanner){
        System.out.printf("-------Buat Pesanan-----\n");

        System.out.printf("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        
        this.cetakMenu();

        System.out.printf("Masukkan menu: ");
        int pilihanMenu = scanner.nextInt();
        boolean pilihanMenuValid = 1<=pilihanMenu && pilihanMenu<this.menu.length;

        if(pilihanMenuValid != true) return;

        Resep resep = this.menu[pilihanMenu-1];
        
        System.out.printf("Masukkan level gula: ");
        int pilihanLevelGula = scanner.nextInt();
        boolean pilihanLevelGulaValid = 0 <= pilihanLevelGula && pilihanLevelGula <= 5;
        if(pilihanLevelGulaValid != true) return;

        scanner.nextLine();

        Pesanan pesanan = new Pesanan(resep, pilihanLevelGula, namaPelanggan);

        boolean masihAdaSlotAntrean = this.antrean[this.indexAntreanTerbaru]==null;
        if(masihAdaSlotAntrean != true) return;

        this.antrean[this.indexAntreanTerbaru] = pesanan;

        this.indexAntreanTerbaru++;

        System.out.print("Tekan Enter untuk kembali...      ");
        scanner.nextLine();
    }

    public void cetakAntrean(Scanner scanner){
        if(this.indexAntreanTerbaru==0){
            System.out.println("Antrean kosong");
            return;
        }

        for (int i = 0; i < antrean.length; i++) {
            Pesanan p = this.antrean[i];
            if(p==null) return;
            System.out.printf("%d, Pelanggan %s memesan %s\n", i+1, p.getNamaPelanggan(), p.getResep().getNama());
        }

        System.out.print("Tekan Enter untuk kembali...      ");
        scanner.nextLine();
    }

    private void cetakMenu(){
        for (int i = 0; i < menu.length; i++) {
            Resep r = menu[i];
            if(r==null) continue;
            System.out.printf("%d. %s\n", i+1, r.getNama());
        }        
    }

    public void buatKopi(){

    }

    public void cetakLaporan(){
// todo
    }
}
