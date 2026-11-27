public class MesinKopi {
    private int gulaGr; // max muat 1500
    private int susuMl; // max muat 790
    private int kopiGr; // max muat 1200
    private int airMl;  // max muat 1800
    private int siklusSebelumPerawatan; // max 10
    
    // constr
    public MesinKopi(int awalKopiGr, int awalSusuMl, int awalGulaGr, int awalAirMl, int awalSiklusSebelumPerawatan){
        setKopi(awalKopiGr);
        setSusu(awalSusuMl);
        setGula(awalGulaGr);
        setAir(awalAirMl);
        resetSiklusSebelumPerawatan();
    }

    // getter
    public int getGula(){
        return this.gulaGr;
    }
    public int getSusu(){
        return this.susuMl;
    }
    public int getAir(){
        return this.airMl;
    }
    public int getKopi(){
        return this.kopiGr;
    }
    public int getSiklusSebelumPerawatan(){
        return this.siklusSebelumPerawatan;
    }    
    public boolean perluMaintenance() {
        return this.siklusSebelumPerawatan <= 0;
    }
    
    // setter
    public void setGula(int gulaBaruGr){
        if(gulaBaruGr <= 0){
            System.out.println("Gula harus diatas nol");
            return;
        }

        if(gulaBaruGr > 1500){
            System.out.println("Gula tidak boleh melebihi kapasitas yaitu 1500 gr");
            return;
        }

        this.gulaGr = gulaBaruGr;
    }
    public void setSusu(int susuBaruMl){
        if(susuBaruMl <= 0){
            System.out.println("Susu harus diatas nol");
            return;
        }

        if(susuBaruMl > 790){
            System.out.println("Susu tidak boleh melebihi kapasitas yaitu 790 ml");
            return;
        }

        this.susuMl = susuBaruMl;
    }
    public void setAir(int airBaruMl){
        if(airBaruMl <= 0){
            System.out.println("Air harus diatas nol");
            return;
        }

        if(airBaruMl > 1800){
            System.out.println("Air tidak boleh melebihi kapasitas yaitu 1800 ml");
            return;
        }

        this.airMl = airBaruMl;
    }
    public void setKopi(int kopiBaruGr){
        if(kopiBaruGr <= 0){
            System.out.println("Air harus diatas nol");
            return;
        }

        if(kopiBaruGr > 1200){
            System.out.println("Air tidak boleh melebihi kapasitas yaitu 1200 gr");
            return;
        }

        this.kopiGr = kopiBaruGr;
    }
    public void resetSiklusSebelumPerawatan(){
        this.siklusSebelumPerawatan = 10;
    }
    
    private void kurangiSiklusSebelumPerawatan(){
        if(this.siklusSebelumPerawatan==0) return;
        this.siklusSebelumPerawatan--;
    }
    

    // BEHAVIOUR

    // Pake kode dah biar gampang
    // 0 -> kopi berhasil dibuat
    // 1 -> mesin perlu maintenance
    // 2 -> gula perlu direfil
    // 3 -> susu perlu direfil
    // 4 -> kopi perlu direfil
    // 5 -> air perlu direfill
    public int buatKopi(Pesanan pesanan){

        if(this.perluMaintenance()){
            return 1;
        }

        Resep resep = pesanan.getResep();

        if(this.getGula() < pesanan.getJumlahGulaGram()){
            return 2;
        }
        if(this.getSusu() < resep.getSusuMl()){
            return 3;
        }
        if(this.getKopi() < resep.getKopiGram()){
            return 4;
        }
        if(this.getAir() < resep.getAirMililiter()){
            return 5;
        }

        this.setGula(this.getGula()-pesanan.getJumlahGulaGram());
        this.setSusu(this.getSusu()-resep.getSusuMl());
        this.setKopi(this.getKopi()-resep.getKopiGram());
        this.setAir(this.getAir()-resep.getAirMililiter());
        
        this.kurangiSiklusSebelumPerawatan();

        return 0; // kopi berhasil dibuat
    }
}


