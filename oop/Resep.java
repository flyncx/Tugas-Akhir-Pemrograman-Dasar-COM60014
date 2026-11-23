public class Resep {
    private String nama;
    private int takaranKopiGram;
    private int takaranSusuMililiter;
    private int ukuranCangkirMililiter;


    public Resep(String nama, int kopiGram, int susuMililiter, int ukuranCangkirMililiter) {
        this.nama = nama;
        this.takaranKopiGram = kopiGram;
        this.takaranSusuMililiter = susuMililiter;
        this.ukuranCangkirMililiter = ukuranCangkirMililiter;
    }

    public String getNama() {
        return nama;
    }
    public int getKopiGram() {
        return this.takaranKopiGram;
    }
    public int getSusuMl() {
        return this.takaranSusuMililiter;
    }
    public int getUkuranCangkirMl() {
        return this.ukuranCangkirMililiter;
    }
    private int getKopiMililiter() {
        // Asumsinya ya 1 gram kopi = 1 mililiter kopi;
        return this.getKopiGram()*1;
    }
    public int getAirMililiter() {
        System.out.println(this.ukuranCangkirMililiter - this.getKopiMililiter() - this.getSusuMl());
        return this.ukuranCangkirMililiter - this.getKopiMililiter() - this.getSusuMl();
    }
}
