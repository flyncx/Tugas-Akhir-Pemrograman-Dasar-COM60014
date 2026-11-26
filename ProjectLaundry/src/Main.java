import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    
    int pilihanOpsi = 0;

    do {
      cetakMenu();
      System.out.print("Masukkan pilihan Anda: ");
      pilihanOpsi = scanner.nextInt();
      scanner.nextLine(); 
      System.out.println();

      switch(pilihanOpsi){
        case 0:
          break;
        case 1:
          lakukanTransaksiBaru(scanner);
          break;
        default:
          System.out.println("Pilihan tidak valid");
          break;
      }
      System.out.println();

    }while(pilihanOpsi!=0);
  }

  private static void cetakMenu(){
    System.out.println("===[Menu Program]===");
    System.out.println("1. Lakukan transaksi baru");
    System.out.println("0. Keluar program");
  }

  private static void lakukanTransaksiBaru(Scanner scanner){
    System.out.print("Masukkan nama pelanggan: ");
    String nama = scanner.nextLine();
    
    System.out.print("Masukkan jumlah cucian : ");
    int jml = scanner.nextInt();
    
    if(jml<1){
      System.out.println("jumlah tidak valid");
      return;
    }
    
    int beratTotalGram = 0;
    
    int indexCucian = 0;
    while(indexCucian<jml){
      int nomor = indexCucian + 1;
      System.out.print("berat cucian ke "+nomor+" (gram): ");
      double berat = scanner.nextDouble();
      if(berat>0 == false){
        System.out.printf("Berat cucian ke-%d invalid!\n", nomor);
      }else{
        beratTotalGram += berat;
        indexCucian++;  
      }
    }
    
    double beratTotalKilogram = bulatkanGramKeKilogram(beratTotalGram);

    // Berat dibulatkan ke atas
    double harga = Math.ceil(beratTotalKilogram) * 8000; 

    System.out.printf("Harga yang perlu dibayar: %d\n", (int)harga);

    System.out.print("Masukkan uang: ");
    double pembayaranPertama = scanner.nextDouble();

    if(pembayaranPertama <= 0){
      System.out.println("Jumlah uang invalid");
      return;
    }

    double kurang = 0;

    // uang pas atau lebih
    if(harga - pembayaranPertama <= 0){
      System.out.println("Pembayaran berhasil");
      cetakStruk(nama, beratTotalKilogram, harga, pembayaranPertama-harga);
    }
    // uang kurang 
    // NOTE: diberi kesempatan kedua untuk membayar uang yang kurang
    else {
      kurang = harga-pembayaranPertama;
      System.out.println("Pembayaran gagal");
      System.out.printf("Uang diberikan kurang Rp%d\n", (int)kurang);
      System.out.print("Silahkan masukkan uang (lagi): ");     
      double tambahan = scanner.nextDouble(); 

      if(tambahan <= 0){
        System.out.println("Jumlah uang invalid");
        return;
      }

      // Jika masih kurang, keluar prosedur.
      if(tambahan-kurang < 0){
        System.out.println("Pembayaran masih kurang, silahkan lakukan transaksi ulang!");
        return;
      }

      cetakStruk(nama, beratTotalKilogram, harga, kurang-tambahan);
    }
  }
  
  private static int bulatkanGramKeKilogram(int gram){
    double hasilMungkinPecahan = gram / 1000d;
    // JIKA berat 0.1 kg bulatkan ke 1
    int hasil = (int) Math.ceil(hasilMungkinPecahan);
    return hasil;
  }

  private static void cetakStruk(String nama, double beratTotal, double harga, double kembalian){
    System.out.printf("|=====================|\n");
    System.out.printf("|     Terima kasih    |\n");
    System.out.printf("|=====================|\n");
    System.out.printf("|Atas nama   : %s\n", nama);
    System.out.printf("|Total berat : %.2f kg\n",beratTotal);
    System.out.printf("|Total harga : Rp%.2f \n", harga);
    System.out.printf("|Kembalian   : Rp%.2f \n", kembalian);
    System.out.printf("|=====================|\n");
  }
}