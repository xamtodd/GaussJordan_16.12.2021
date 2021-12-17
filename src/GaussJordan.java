import java.util.Scanner;

public class GaussJordan {
    private static double[] zeile1;
    private static double[] zeile2;
    private static double[] zeile3;
    private static Scanner scanner;
    public static void main(String[] args) {
        zeile1 = new double[4];
        zeile2 = new double[4];
        zeile3 = new double[4];
        scanner = new Scanner(System.in);
        System.out.println("Geben die Parameter in das Koordinatensystem ein:");
        System.out.println("Zeile 1:");
        eingeben(zeile1);
        System.out.println("Zeile 2:");
        eingeben(zeile2);
        System.out.println("Zeile 3:");
        eingeben(zeile3);
        System.out.println("-----------");
        loesen();
    }
    public static void eingeben(double[] zeile){
        for(int i = 0; i <= 4 - 1; i++){
            if(i != 3){
                System.out.print("Paramerter " + (i + 1) + ":");
            }else {
                System.out.print("Lösung " + (i + 1) + ":");
            }
            int p = scanner.nextInt();
            zeile[i] = p;
        }
    }
    public static void loesen(){
        int stufe = 1;
        ausgeben();
        while (true){
            if(pruefen()){
                break;
            }
            stufeloesen(stufe);
            stufe++;
        }
    }
    public static void zeilenaddieren(int stufe){
        if(stufe == 1){
            for (int i = 0; i <= 4 - 1; i++){
                zeile3[i] = zeile3[i] + zeile2[i];
            }
        }
        if(stufe == 2){
            for (int i = 0; i <= 4 - 1; i++){
                zeile2[i] = zeile2[i] + zeile1[i];
            }
        }
        if(stufe == 3){
            for (int i = 0; i <= 4 - 1; i++){
                zeile3[i] = zeile3[i] + zeile2[i];
            }
        }
        if(stufe == 4){
            for (int i = 0; i <= 4 - 1; i++){
                zeile2[i] = zeile2[i] + zeile3[i];
            }
        }
        if(stufe == 5){
            for (int i = 0; i <= 4 - 1; i++){
                zeile1[i] = zeile1[i] + zeile3[i];
            }
        }
        if(stufe == 6){
            for (int i = 0; i <= 4 - 1; i++){
                zeile1[i] = zeile1[i] + zeile2[i];
            }
        }
    }
    public static void stufeloesen(int stufe){
        double wert;
        double wert2;
        double wert3;
        switch (stufe){
            case 1:
                wert = getWert(3,1);
                wert2 = getWert(2,1);
                if(wert != 0){
                    for (int i = 0; i <= 4 - 1; i++){
                        zeile3[i] = zeile3[i] * wert2;
                        zeile2[i] = zeile2[i] * (-wert);
                    }
                    ausgeben();
                    zeilenaddieren(1);
                    ausgeben();
                }
                break;
            case 2:
                wert = getWert(1,1);
                wert2 = getWert(2,1);
                if(wert != 0){
                    for (int i = 0; i <= 4 - 1; i++){
                        zeile1[i] = zeile1[i] * wert2;
                        zeile2[i] = zeile2[i] * (-wert);
                    }
                    ausgeben();
                    zeilenaddieren(2);
                    ausgeben();
                }
                break;
            case 3:
                wert = getWert(2,2);
                wert2 = getWert(3,2);
                if(wert != 0){
                    for (int i = 0; i <= 4 - 1; i++){
                        zeile2[i] = zeile2[i] * wert2;
                        zeile3[i] = zeile3[i] * (-wert);
                    }
                    ausgeben();
                    zeilenaddieren(3);
                    ausgeben();
                }
                break;
            case 4:
                wert = getWert(3,3);
                wert2 = getWert(2,3);
                if(wert != 0){
                    for (int i = 0; i <= 4 - 1; i++){
                        zeile2[i] = zeile2[i] * wert;
                        zeile3[i] = zeile3[i] * (-wert2);
                    }
                    ausgeben();
                    zeilenaddieren(4);
                    ausgeben();
                }
                break;
            case 5:
                wert = getWert(3,3);
                wert2 = getWert(1,3);
                if(wert != 0){
                    for (int i = 0; i <= 4 - 1; i++){
                        zeile1[i] = zeile1[i] * wert;
                        zeile3[i] = zeile3[i] * (- wert2);
                    }
                    ausgeben();
                    zeilenaddieren(5);
                    ausgeben();
                }
                break;
            case 6:
                wert = getWert(1,2);
                wert2 = getWert(2,2);
                if(wert != 0) {
                    for (int i = 0; i <= 4 - 1; i++) {
                        zeile2[i] = zeile2[i] * wert;
                        zeile1[i] = zeile1[i] * (-wert2);
                    }
                    ausgeben();
                    zeilenaddieren(6);
                    ausgeben();
                }
                break;
            case 7:
                wert = getWert(1,1);
                wert2 = getWert(2,2);
                wert3 = getWert(3,3);
                for(int i = 0; i <= 4 - 1; i++){
                    zeile1[i] = zeile1[i] / wert;
                    zeile2[i] = zeile2[i] / wert2;
                    zeile3[i] = zeile3[i] / wert3;
                }
                ausgeben();
                loesungsMengeAusgeben();
                break;
        }
    }
    public static double getWert(int zeile, int spalte){
        switch (zeile){
            case 1:
                if(spalte == 1) {
                    return zeile1[0];
                }
                if(spalte == 2){
                    return zeile1[1];
                }
                if(spalte == 3){
                    return zeile1[2];
                }
                if(spalte == 4){
                    return zeile1[3];
                }
            case 2:
                if(spalte == 1) {
                    return zeile2[0];
                }
                if(spalte == 2){
                    return zeile2[1];
                }
                if(spalte == 3){
                    return zeile2[2];
                }
                if(spalte == 4){
                    return zeile2[3];
                }
            case 3:
                if(spalte == 1) {
                    return zeile3[0];
                }
                if(spalte == 2){
                    return zeile3[1];
                }
                if(spalte == 3){
                    return zeile3[2];
                }
                if(spalte == 4) {
                    return zeile3[3];
                }
        }
        return 0.0;
    }
    public static void loesungsMengeAusgeben(){
            System.out.println("");
            System.out.println("Die Lösungsmenge betraegt L = {x = " + zeile1[3] + " | y = " + zeile2[3] +  " | z = " + zeile3[3] + "}");
    }
    public static boolean pruefen(){
        if((zeile3[0] == 0) && (zeile3[1] == 0) && (zeile3[2]== 1) &&
                (zeile2[0] == 0) && (zeile2[1] == 1) &&(zeile2[2]== 0) &&
                (zeile1[0] == 1) && (zeile1[1] == 0) && (zeile1[2] == 0)){
            return true;
        }else {
            return false;
        }
    }
    public static void unedlich(){
        System.out.println("Dieses LGS besitzt unendlich viele Lösungen!");
    }
    public static void ausgeben(){
        inKonsole(zeile1);
        inKonsole(zeile2);
        inKonsole(zeile3);
        System.out.println("-----------------------");
    }
    public static void inKonsole(double[] zeile){
        int i = 0;
        System.out.println(zeile[i] + "  " + zeile[i + 1] + "  " + zeile[i + 2] + " | " + zeile[i + 3]);
    }
}
