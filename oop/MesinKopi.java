public class MesinKopi {
    private int sisaGulaGram;
    private int sisaSusuMililiter;
    private int sisaKopiGram;
    private int sisaKuotaSebelumMaintenance;
    
    public MesinKopi(int kopiGram, int susuMililiter, int gulaGram, int sisaKuotaSebelumMaintenance){
        this.sisaGulaGram = gulaGram;
        this.sisaSusuMililiter = susuMililiter;
        this.sisaKopiGram = kopiGram;
        this.sisaKuotaSebelumMaintenance = sisaKuotaSebelumMaintenance;
    }

    public boolean buatKopi(Pesanan pesanan){

        boolean kopiCukup = this.sisaKopiGram-pesanan.getJumlahKopi()<0;
        boolean gulaCukup = this.sisaGulaGram-pesanan.getJumlahGula()<0;  
        boolean susuCukup = this.sisaSusuMililiter-pesanan.getJumlahSusu()<0;
        boolean tidakMaintenance = (this.sisaKuotaSebelumMaintenance-1) < 0;

        if(kopiCukup && gulaCukup && susuCukup && tidakMaintenance){
            this.sisaKopiGram = this.sisaKopiGram - pesanan.getJumlahKopi();
            this.sisaGulaGram = this.sisaGulaGram - pesanan.getJumlahGula();
            this.sisaSusuMililiter = this.sisaSusuMililiter - pesanan.getJumlahSusu();
            this.sisaKuotaSebelumMaintenance = this.sisaKuotaSebelumMaintenance - 1;
            return true;
        }

        return false;
    }
}