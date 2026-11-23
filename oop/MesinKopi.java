public class MesinKopi {
    private int sisaGulaGram;
    private int sisaSusuMililiter;
    private int sisaKopiGram;
    private int sisaAirMililiter;
    private int sisaSiklusPerawatan;

    private boolean ok = true; 
    
    public MesinKopi(int kopiGram, int susuMililiter, int gulaGram, int airMililiter, int siklusPerawatan){
        this.sisaGulaGram = gulaGram;
        this.sisaSusuMililiter = susuMililiter;
        this.sisaKopiGram = kopiGram;
        this.sisaAirMililiter = airMililiter;
        this.sisaSiklusPerawatan = siklusPerawatan;
    }

    public boolean buatKopi(Pesanan pesanan){
        System.out.println("DEBUG: Membuat kopi");
        Resep resep = pesanan.getResep();

        boolean airCukup = this.sisaAirMililiter-resep.getAirMililiter()>=0;
        boolean kopiCukup = this.sisaKopiGram-resep.getKopiGram()>=0;
        boolean gulaCukup = this.sisaGulaGram-pesanan.getJumlahGulaGram()>=0;  
        boolean susuCukup = this.sisaSusuMililiter-resep.getSusuMl()>=0;
        boolean siklusPerawatanAman = (this.sisaSiklusPerawatan-1) >= 0;

        System.out.printf("air=%b kopi=%b gula=%b susu=%b mbb=%b\n", airCukup, kopiCukup, gulaCukup, susuCukup, siklusPerawatanAman);

        if(airCukup && kopiCukup && gulaCukup && susuCukup && siklusPerawatanAman){
            this.sisaAirMililiter = this.sisaAirMililiter - resep.getAirMililiter();
            this.sisaKopiGram = this.sisaKopiGram - resep.getKopiGram();
            this.sisaGulaGram = this.sisaGulaGram - pesanan.getJumlahGulaGram();
            this.sisaSusuMililiter = this.sisaSusuMililiter - resep.getSusuMl();
            this.sisaSiklusPerawatan = this.sisaSiklusPerawatan - 1;
            return true;
        }
        this.ok = false;
        return false;
    }

    public boolean getOK() {
        return this.ok;
    }
}