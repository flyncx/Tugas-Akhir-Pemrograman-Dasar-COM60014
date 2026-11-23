public class Pesanan {
    private Resep resep; 

    private int GRAM_GULA_PER_LEVEL = 5;
    private int levelGula;

    public Pesanan(Resep resep, int levelGula){
        this.resep = resep;
        this.levelGula = levelGula;
    }

    public Resep getResep(){
        return this.resep;
    }
    public int getJumlahGulaGram(){
        return GRAM_GULA_PER_LEVEL * this.levelGula;
    } 

    public static boolean cekLevelGulaValid(int level) {
        if(1<=level && level<=5) return true;
        return false;
    }
}
