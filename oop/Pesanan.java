public class Pesanan {
    private Resep resep; 
    private boolean selesai;

    private int jumlahGulaGram;

    public Pesanan(Resep resep, int gulaGram){
        this.resep = resep;
    }

    public Resep getResep(){
        return this.resep;
    }
    public boolean getStatusSelesai(){
        return this.selesai;
    }
    public int getJumlahGulaGram(){
        return this.jumlahGulaGram;
    } 



    public void setStatusSelesai(boolean status){
        this.selesai = status;
    }


    public static boolean cekLevelGulaValid(int level) {
        if(1<=level && level<=5) return true;
        return false;
    }
}
