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

    // GETTER
    public String getNama(){
        return this.nama;
    }

    // SETTER
    public void setNama(String namaBaru){
        this.nama = namaBaru;
    }



    // Behaviour



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
        boolean pilihanMenuValid = 1<=pilihanMenu && pilihanMenu<=this.menu.length;

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

        System.out.println("Pesanan berhasil dibuat");
    }

    public void cetakAntrean(){
        if(this.indexAntreanTerbaru==-1){
            System.out.println("Antrean kosong");
            return;
        }
        
        System.out.printf("|---------------------------------|\n");
        System.out.printf("|-             Antrean           -|\n");
        System.out.printf("|---------------------------------|\n");
        System.out.printf("| No. | Nama pelanggan            |\n");
        

        for (int i = 0; i < antrean.length; i++) {
            Pesanan p = this.antrean[i];
            if(p==null) break;
            System.out.printf("| %3d | %-25s |\n", i, p.getNamaPelanggan());
        }
        System.out.printf("|---------------------------------|\n");
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

        boolean mkPerluMaintenance = mesinKopi.perluMaintenance();
        if(mkPerluMaintenance == true){
            System.out.println("Mesin kopi perlu dibersihkan!");
            return;
        }

        int statusKopi = mesinKopi.buatKopi(pesanan);
        System.out.printf("STATUS KOPI === %d\n", statusKopi);
        if(statusKopi !=0){
            String kosong = "";
            switch (statusKopi) {
                case 2:
                    kosong = "GULA";
                    break;
                case 3:
                    kosong = "SUSU";
                    break;
                case 4:
                    kosong = "KOPI";
                    break;
                case 5:
                    kosong = "AIR";
                    break;
            }
            System.out.printf("%s perlu diisi ulang!", kosong);
            return;
        }

        System.out.printf("      )  (      \n");
        System.out.printf("     (   ) )    \n");
        System.out.printf("      ) ( (     \n");
        System.out.printf("    _____)___   \n");
        System.out.printf("   |---------|  \n");
        System.out.printf("   |/-/-/-/-/|  \n");
        System.out.printf("   |/-/-/-/-/|  \n");
        System.out.printf("   |         |  \n");
        System.out.printf("   | . . . . |  \n");
        System.out.printf("   '_________'  \n");
        System.out.printf("    '-------'   \n");


        System.out.printf("Kopi %s milik %s sudah jadi!\n", pesanan.getResep().getNama(), pesanan.getNamaPelanggan());


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
