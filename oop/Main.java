public class Main {
    public static void main(String[] args) {

        Resep[] arrayResep = {
            new Resep("Espresso Double", 18, 0, 60),
            new Resep("Cappuccino", 18, 120, 180),
            new Resep("Caffè Latte", 18, 180, 240)
        };

        MesinKopi mesinKopi = new MesinKopi(100, 100, 1000, 5000, 6);

        // Buat pesanan kopi susu dengna gula sedang

        Pesanan pesananKopiSusu = new Pesanan(arrayResep[0], 25);

        boolean statusPesananSukses = mesinKopi.buatKopi(pesananKopiSusu);

        if(statusPesananSukses == true){
            System.out.println("Pesanan sudah siap");
            System.out.println("Silahkan dinikmati");
        }
    }
}
