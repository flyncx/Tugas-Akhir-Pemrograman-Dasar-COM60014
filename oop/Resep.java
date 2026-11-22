public class Resep {
    private String namaMenu;
    private int takaranKopiGram;
    private int takaranSusuMililiter;
    private int ukuranCangkirMililiter;


    public Resep(String namaMenu, int kopiGram, int susuMililiter, int ukuranCangkirMililiter) {
        this.namaMenu = namaMenu;
        this.takaranKopiGram = kopiGram;
        this.takaranSusuMililiter = susuMililiter;
        this.ukuranCangkirMililiter = ukuranCangkirMililiter;
    }

    public String getNamaMenu() {
        return namaMenu;
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
}
