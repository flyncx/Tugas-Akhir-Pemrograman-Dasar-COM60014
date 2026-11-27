public class Pesanan {

    private String namaPelanggan;

    private Resep resep; 

    private int GRAM_GULA_PER_LEVEL = 5;
    private int levelGula;

    public Pesanan(Resep resep, int levelGula, String namaPelanggan){
        this.resep = resep;
        this.levelGula = levelGula;
        this.namaPelanggan = namaPelanggan;
    }

    public int getHarga(){
        // dari sini bisa lebih menarik lagi nih
        // harga resep ditambah berdasarkan pilihan susu pelanggan
        return this.resep.getHargaRp();
    }

    public String getLevelGulaString(){
        if(this.levelGula == 1 || this.levelGula == 2){
            return "Sedikit";
        }
        if(this.levelGula == 4 || this.levelGula == 5){
            return "Banyak";
        }
        if(this.levelGula == 3){
            return "Sedang";
        }
        return "Tidak ada";
    }

    public String getNamaPelanggan(){
        return this.namaPelanggan;
    }
    public void setNamaPelanggan(String nama){
        this.namaPelanggan = nama;
    }

    public Resep getResep(){
        return this.resep;
    }
    public int getJumlahGulaGram(){
        return this.GRAM_GULA_PER_LEVEL * this.levelGula;
    } 

    public static boolean cekLevelGulaValid(int level) {
        if(1<=level && level<=5) return true;
        return false;
    }

    public int getAirMl(){
        return 1000; //tar diubah
    }
}
