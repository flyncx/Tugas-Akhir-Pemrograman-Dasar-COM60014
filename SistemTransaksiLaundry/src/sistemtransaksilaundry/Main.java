package sistemtransaksilaundry;

import java.util.Scanner;
/**
 * 
 * @author mimi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int MAX_PELANGGAN = 1024; // ini keterbatasan array fixed; bisa selain 1024
        int pelangganIndex = 0; // buat ngecek mana pelanggan yg keisi y
        
        String[] aOfKodeTransaksi = new String[MAX_PELANGGAN];
        String[] aOfNamaPelanggan = new String[MAX_PELANGGAN];
        int[]    aOfJumlahBaju    = new    int[MAX_PELANGGAN];
        int[]    aOfJumlahBerat   = new    int[MAX_PELANGGAN];
        int[] aOfJumlahPendapatan = new    int[MAX_PELANGGAN];
        
        int pilihan = 0;
        do {
            
            cetakPilihan();
            pilihan = tanyaPilihan(scanner);
            
            if(pilihan==0){
                System.out.printf("Program dihentikan....\n");
                break;
            }
            
            switch(pilihan){
                case 1:
                    tambahTransaksiBaru(aOfNamaPelanggan, aOfJumlahBaju, aOfJumlahBerat, aOfJumlahPendapatan);
                    System.out.printf("\n");
                    break;
                case 2:
                    //ubahTransaksi(aOfNamaPelanggan, aOfJumlahBaju, aOfJumlahBerat, aOfJumlahPendapatan, kode);
                    break;
                case 3:
                    //cetakTransaksi(aOfNamaPelanggan, aOfJumlahBaju, aOfJumlahBerat, aOfJumlahPendapatan, kode);
                    break;
                case 4: 
                    
                default:
                    System.out.printf("Opsi tidka dikenal :(\n\n");
                    break;
            }
            
        } while(pilihan != 0);
        
    }
    
    private static void cetakStruk(
            String namaPelanggan, String jumlahBaju,
            int jumlahBerat, int totalHarga, String kode
    ){
        System.out.printf("XXXXXXXXXXXXXXXXXXXXXX\n");
        System.out.printf("X        SiTeLa      X\n");
        System.out.printf("XXXXXXXXXXXXXXXXXXXXXX\n");
        System.out.printf("| Nama pelanggan: %s |\n", namaPelanggan);
        System.out.printf("| Total berat   : %d |\n", jumlahBerat);
        System.out.printf("| Harga akhir   : %d |\n", totalHarga);
        
        
    }
    
    private static void cetakStrukTransaksi(
            String[] aOfNamaPelanggan, int[] aOfJumlahBaju, 
            int[] aOfJumlahBerat, int [] aOfJumlahPendapatan,
            String kode
    ){
        // cari index buat dicetak struk y
        // trs panggil cetakStruk
    }
    
    private static void ubahTransaksi(
            String[] aOfNamaPelanggan, int[] aOfJumlahBaju, 
            int[] aOfJumlahBerat, int [] aOfJumlahPendapatan,
            String kode
    ){
        System.out.printf("Masukkan kode transaksi: ??\n");
        System.out.printf("Transaksi tidak ditemukan\n");
    }
    
    private static void tambahTransaksiBaru(
            String[] aOfNamaPelanggan, int[] aOfJumlahBaju, 
            int[] aOfJumlahBerat, int [] aOfJumlahPendapatan
    ){
      System.out.printf("[Transaksi: STL-%d]\n", 67);
      System.out.printf("Masukkan nama pelanggan: ...\n");
      System.out.printf("Masukkan jumlah baju   : ...\n");
      System.out.printf("Masukkan berat total   : ...\n");
      System.out.printf("Transaksi STL-%d berhasil ditambahkan...\n", 67);
    }
    
    private static int tanyaPilihan(Scanner scanner){
        System.out.printf("inp pilihan (int): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        return pilihan;
    } 
    
    private static void cetakPilihan(){
        System.out.printf("=== Selamat datang di SiTaLo ===\n");
        System.out.printf("1 -> Tambah transaksi baru\n");
        System.out.printf("2 -> Ubah transaksi\n");
        System.out.printf("3 -> Cetak struk transaksi\n");
        System.out.printf("4 -> Cetak Laporan\n");
        System.out.printf("0 -> Keluar program\n");
    }
    
}
