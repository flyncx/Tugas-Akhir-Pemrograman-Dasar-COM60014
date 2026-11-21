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
      System.out.println("");

      switch(pilihanOpsi){
        case 0:
          break;
        case 1:
          lakukanTransaksiBaru(scanner);
      }
      System.out.println("");

    }while(pilihanOpsi!=0);
  }

  private static void cetakMenu(){
    System.out.println("===[Menu Program]===");
    System.out.println("1. Lakukan transaksi baru");
    System.out.println("0. Keluar program");
    
  }

  private static void lakukanTransaksiBaru(Scanner scanner){
    double berat;
    double beratTotal = 0;
    int nomor;
    System.out.print("Masukkan nama pelanggan: ");
    String nama = scanner.nextLine();
    System.out.print("Masukkan jumlah cucian : ");
    int jml = scanner.nextInt();
    for(int i=0; i<jml; i++){
      nomor = i+1;
      System.out.print("berat cucian ke "+nomor+" (gram): ");
      berat = scanner.nextDouble();
      beratTotal += berat;
    }
    beratTotal/=1000;
    if(beratTotal<1 && beratTotal>0){
      beratTotal=1;
    } 
    if(beratTotal<=0){
      System.out.println("berat tidak valid");
      return;
    }

    double harga = beratTotal*8000;
    System.out.println("Total harga adalah Rp"+harga);
    System.out.print("Silahkan masukkan uang : ");
    double bayar = scanner.nextDouble();
    double selisih=0;
    boolean gagal = bayar < harga;
    if (gagal){
      do{
        selisih=harga-bayar;
        System.out.println("");
        System.out.println("Uang diberikan kurang Rp"+selisih);
        System.out.print("Silahkan masukkan uang (lagi): ");
        bayar += scanner.nextDouble();
      }while(bayar<harga);
    }
    selisih = bayar-harga;
    System.out.println("Pembayaran berhasil");
    System.out.println("Atas nama : "+nama);
    System.out.println("Total berat : "+beratTotal+"kg");
    System.out.println("Total harga : Rp"+harga);
    System.out.println("Kembalian : Rp"+selisih);
  }
}