public class Resep {
    private String nama;
    private int kopiGr;
    private int susuMl;
    private int takaranSajiMl;

    private int hargaRp;

    // constr
    public Resep(String nama, int kopiGr, int susuMl, int takaranSajiMl, int hargaRp) {
        this.nama = nama;
        this.kopiGr = kopiGr;
        this.susuMl = susuMl;
        this.takaranSajiMl = takaranSajiMl;
        this.hargaRp = hargaRp;
    }

    // getter
    public String getNama() {
        return nama;
    }
    public int getKopiGr() {
        return this.kopiGr;
    }
    public int getSusuMl() {
        return this.susuMl;
    }
    public int getTakaranSajiMl() {
        return this.takaranSajiMl;
    }
    public int getHargaRp() {
        return this.hargaRp;
    }
    

    // setter
    public void setNama(String namaBaru) {
        this.nama = namaBaru;
    }
    public void setKopiGr(int kopiGrBaru) {
        this.kopiGr = kopiGrBaru;
    }
    public void setSusuMl(int susuGrBaru) {
        this.susuMl = susuGrBaru;
    }
    public void setTakaranSajiMl(int takaranSajiMlBaru) {
        this.takaranSajiMl = takaranSajiMlBaru;
    }
    public void setHargaRp(int hargaRpBaru){
        this.hargaRp = hargaRpBaru;
    }
}
