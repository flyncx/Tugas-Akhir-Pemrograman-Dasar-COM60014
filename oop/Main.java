public class Main {
    public static void main(String[] args) {
        MesinKopi mesinKopi = new MesinKopi(100, 100, 1000, 6);

        // Buat pesanan kopi susu dengna gula sedang

        Pesanan pesananKopiSusu = new Pesanan(50, 500, 50);

        boolean statusPesananSukses = mesinKopi.buatKopi(pesananKopiSusu);

        if(statusPesananSukses == true){
            System.out.println("Pesanan sudah siap");
            System.out.println("Silahkan dinikmati");
        }
    }
}
