public class MesinKopi {
    private int sisaGulaGram;
    private int sisaSusuMililiter;
    private int sisaKopiGram;
    private int sisaAirMililiter;
    private int sisaKuotaSebelumMaintenance;
    
    public MesinKopi(int kopiGram, int susuMililiter, int gulaGram, int sisaAirMililiter, int sisaKuotaSebelumMaintenance){
        this.sisaGulaGram = gulaGram;
        this.sisaSusuMililiter = susuMililiter;
        this.sisaKopiGram = kopiGram;
        this.sisaAirMililiter = sisaSusuMililiter;
        this.sisaKuotaSebelumMaintenance = sisaKuotaSebelumMaintenance;
        
    }

    public boolean buatKopi(Pesanan pesanan){
        System.out.println("DEBUG: Membuat kopi");
        Resep resep = pesanan.getResep();

        boolean airCukup = this.sisaAirMililiter-resep.getAirMililiter()>=0;
        boolean kopiCukup = this.sisaKopiGram-resep.getKopiGram()>=0;
        boolean gulaCukup = this.sisaGulaGram-pesanan.getJumlahGulaGram()>=0;  
        boolean susuCukup = this.sisaSusuMililiter-resep.getSusuMl()>=0;
        boolean tidakMaintenance = (this.sisaKuotaSebelumMaintenance-1) >= 0;

        System.out.printf("DEBUG: %b %b %b %b %b\n", airCukup, kopiCukup, gulaCukup, susuCukup,tidakMaintenance);

        if(airCukup && kopiCukup && gulaCukup && susuCukup && tidakMaintenance){
            this.sisaAirMililiter = this.sisaAirMililiter - resep.getAirMililiter();
            this.sisaKopiGram = this.sisaKopiGram - resep.getKopiGram();
            this.sisaGulaGram = this.sisaGulaGram - pesanan.getJumlahGulaGram();
            this.sisaSusuMililiter = this.sisaSusuMililiter - resep.getSusuMl();
            this.sisaKuotaSebelumMaintenance = this.sisaKuotaSebelumMaintenance - 1;
            return true;
        }

        return false;
    }
}