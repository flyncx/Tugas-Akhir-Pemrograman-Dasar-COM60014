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
    
    double beratTotalGram = 0;
    
    for(int i=0; i<jml; i++){
      int nomor = i + 1;
      System.out.print("berat cucian ke "+nomor+" (gram): ");
      double berat = scanner.nextDouble();
      if(berat>0 == false){
        i--; // AGAR BERAT KE-i DITANYAKAN ULANG
        System.out.printf("Berat cucian ke-%d invalid!\n");
      }else{
        beratTotalGram += berat;  
      }
    }
    double beratTotalKilogram = beratTotalGram / 1000;
    // JIKA x berada di 0<x<1 bulatkan ke 1
    if(beratTotalKilogram<1 && beratTotalKilogram>0){
      beratTotalKilogram=1;
    } 
    if(beratTotalKilogram>0 == false){
      System.out.println("berat tidak valid");
      return;
    }

    // Berat dibulatkan ke atas
    double harga = Math.ceil(beratTotalKilogram) * 8000; 

    double pembayaranPertama = scanner.nextDouble();
    double kurang = 0;

    // uang pas
    if(harga - pembayaranPertama == 0){
      System.out.println("Pembayaran berhasil");
      cetakStruk(nama, beratTotalKilogram, harga, 0); 
    }
    // uang kelebihan
    else if(harga-pembayaranPertama > 0){
      System.out.println("Pembayaran berhasil");
      cetakStruk(nama, beratTotalKilogram, harga, harga-pembayaranPertama);
    }
    // uang kurang 
    // NOTE: diberi kesempatan kedua untuk membayar uang yang kurang
    else {
      kurang = harga-pembayaranPertama;
      System.out.println("Pembayaran gagal");
      System.out.printf("Uang diberikan kurang Rp%d\n", (int)kurang);
      System.out.print("Silahkan masukkan uang (lagi): ");     
      
      // Jika masih kurang, keluar program.
      if(harga-pembayaranPertama+kurang < 0){
        System.out.println("Pembayaran masih kurang, program terhenti");
        return;
      }
    }
  }

  private static void cetakStruk(String nama, double beratTotal, double harga, double kembalian){
    System.out.println("Atas nama : "+nama);
    System.out.println("Total berat : "+beratTotal+"kg");
    System.out.println("Total harga : Rp"+harga);
    System.out.println("Kembalian : Rp"+kembalian);
  }
}