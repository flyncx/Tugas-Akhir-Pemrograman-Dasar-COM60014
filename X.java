import java.util.Scanner;;
public class X {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int jumlahDiInput = 3;
        double[] arrayBeratGram = new double[jumlahDiInput]
        
        boolean isValid = true;

        for (int i = 0; i < jumlahDiInput; i++) {
            double inp = s.nextDouble();
            arrayBeratGram[i] = inp;
            
            if((inp > 0) == false){
                isValid = false;
                break;
            }
        }

        if(isValid == false){
            System.out.println("Berat harus di atas nol gram");
            return; //hentikan eksekusi
        }
    }
}
