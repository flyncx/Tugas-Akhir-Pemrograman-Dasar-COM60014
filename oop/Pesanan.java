public class Pesanan {
    private int jumlahKopiGram;
    private int jumlahSusuMililiter;
    private int jumlahGulaGram;

    private boolean selesai;

    public Pesanan(int kopiGram, int gulaGram, int susuMililiter){
        this.jumlahKopiGram = kopiGram;
        this.jumlahGulaGram = gulaGram;
        this.jumlahSusuMililiter = susuMililiter;
    }

    public int getJumlahKopi(){
        return this.jumlahKopiGram;
    }
    public int getJumlahGula(){
        return this.jumlahGulaGram;
    }
    public int getJumlahSusu(){
        return this.jumlahSusuMililiter;
    }
    public boolean getStatusSelesai(){
        return this.selesai;
    }

    public void setStatusSelesai(boolean status){
        this.selesai = status;
    }
}
