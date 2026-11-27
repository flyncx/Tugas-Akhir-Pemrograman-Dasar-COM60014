import java.util.Scanner;

public class Kafe {
    private String nama;

    private Resep[] menu;

    private int MAKSIMUM_ANTREAN = 20;
    private Pesanan[] antrean;
    private int indexAntreanTerbaru = -1;
    
    private int MAKSIMUM_PESANANSELESAI = 20;
    private Pesanan[] daftarPesananSelesai;
    private int indexPesananSelesaiTerbaru = -1;


    private MesinKopi mesinKopi;

    public Kafe(String nama, MesinKopi mesinKopi, Resep[] menu){
        this.nama = nama;
        this.antrean = new Pesanan[this.MAKSIMUM_ANTREAN];
        this.daftarPesananSelesai = new Pesanan[this.MAKSIMUM_PESANANSELESAI]; // 
        this.mesinKopi = mesinKopi;
        this.menu = menu;
    }

    public void buatPesanan(Scanner scanner){

        int indexAntreanPesanan = this.indexAntreanTerbaru + 1; 

        // jika antrian pesanan yang akan dibuat sama dengan atau melebihi
        // index maksimum antrean;; 
        if(indexAntreanPesanan >= this.antrean.length){
            System.out.printf("Maaf, antrean melebihi batas %d\n", this.MAKSIMUM_ANTREAN);
            System.out.println("Mohon pesanan sebelumnya diproses terlebih dahulu");
            return;
        }

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

        this.antrean[indexAntreanPesanan] = pesanan;
        this.indexAntreanTerbaru = indexAntreanPesanan;
    }

    public void cetakAntrean(Scanner scanner){
        if(this.indexAntreanTerbaru==-1){
            System.out.println("Antrean kosong");
            return;
        }

        for (int i = 0; i < antrean.length; i++) {
            Pesanan p = this.antrean[i];
            if(p==null) return;
            System.out.printf("%d, Pelanggan %s memesan %s\n", i+1, p.getNamaPelanggan(), p.getResep().getNama());
        }

        System.out.printf("\nTekan Enter untuk kembali...      ");
        scanner.nextLine();
    }

    private void cetakMenu(){
        for (int i = 0; i < menu.length; i++) {
            Resep r = menu[i];
            if(r==null) continue;
            System.out.printf("%d. %s\n", i+1, r.getNama());
        }        
    }

    // masih prototipe
    public void buatKopi(Scanner scanner){
        Pesanan pesanan = this.antrean[0];
        if(pesanan == null){
            System.out.println("Tidak ada antrean");
            return;
        }

        // todo proses kopi


        // misal sblm diproses antreannya itu [a,b,c,d]
        // terus setelah diproess antreannya jadi [b,c,d]

        Pesanan[] antreanBaru = new Pesanan[this.antrean.length-1];

        for (int i = 0; i < antreanBaru.length; i++) {
            if(i==0) continue; //SKIP antrian index ke-0; karena sudah diproses

            Pesanan p = this.antrean[i];
            antreanBaru[i-1] = p;
        }

        this.antrean = antreanBaru;
        this.indexAntreanTerbaru--;

        int indexPesananSelesai = this.indexPesananSelesaiTerbaru + 1;

        if(indexPesananSelesai >= this.daftarPesananSelesai.length){
            System.out.printf("Maaf, daftar pesanan selesai melebihi batas %d\n", this.MAKSIMUM_PESANANSELESAI);
            System.out.println("Mohon mulai ulang program");
            return;
        }

        this.daftarPesananSelesai[indexPesananSelesai] = pesanan;
        this.indexPesananSelesaiTerbaru = indexPesananSelesai;
    }

    public void cetakLaporan(){
        if(this.indexPesananSelesaiTerbaru==-1){
            System.out.println("Maaf tidak ada pesanan selesai");
            return;
        }

        for (int i = 0; i < this.daftarPesananSelesai.length; i++) {
            Pesanan p = this.daftarPesananSelesai[i];
            if(p==null) return;
            System.out.printf("%s\n", p.getNamaPelanggan());
        }
    }
}
