package Tut02;
public class TicTacToe {
    public static String bewerten(char[][]spielfeld) {
        //Überprüfung auf 3-er Reihen
        /* Die Variable gewonnen wird im Laufe der Bewertung auf wahr gesetzt,
        falls midestens eine Dreierreihe gefunden wurde. Daraufhin wird im String Gewinner der char, des Spielers, der
        eine Dreierreihe erzielte gespeichert.
        Es werden die mäglichen Kombinationen in der Reihenfolge vertikal-horizintal-senkrecht abgefragt.
         */
        boolean gewonnen = false;                                           //gewonnen = true bei min. einer 3-er Reihe
        String gewinner = "";


        //vertikal
        for (int i = 0; i < 3; i++) {
            char abgleich = spielfeld[0][i];
            boolean gleich = true;                                          //bez. auf aktuelle Reihe
            for (int j = 0; j < 3; j++) {
                if (abgleich != spielfeld[j][i]) {                          //Abgleich horizontaler Reihen mit dem je
                    gleich = false;                                         //im Spielfeld obersten char (s. abgleich)
                }
                if (j == 2 && gleich && (abgleich != ' ')) {                //3-er Reihe gefunden
                    if (!gewonnen){
                        gewonnen = true;
                        gewinner = String.valueOf(abgleich);
                    }
                    else {
                        return("Ungültieg Eingabe: mehrere 3-er Reihen!");
                    }
                }
            }
        }

        //horizontal
        for (int j = 0; j < 3; j++) {
            char abgleich = spielfeld[j][0];
            boolean gleich = true;                                          //bez. auf aktuelle Reihe
            for (int i = 0; i < 3; i++) {
                if (abgleich != spielfeld[j][i]) {                          //Abgleich horizontaler Reihen mit dem je
                    gleich = false;                                         //im Spielfeld obersten char (s. abgleich)
                }
                if (i == 2 && gleich && (abgleich != ' ')) {                //3-er Reihe gefunden
                    if (!gewonnen){
                        gewonnen = true;
                        gewinner = String.valueOf(abgleich);
                    }
                    else {
                        return("Ungültieg Eingabe: mehrere 3-er Reihen!");
                    }
                }
            }
        }

        //senkrecht /
        char abgleich = spielfeld[2][0];
        if((abgleich == spielfeld[1][1]) && (abgleich == spielfeld[0][2])  && (abgleich != ' ')) {
            if (!gewonnen) {
                gewonnen = true;
                gewinner = String.valueOf(abgleich);
            }
            else {
                return("Ungültieg Eingabe: mehrere 3-er Reihen!");
            }
        }

        //senkrecht \
        abgleich = spielfeld[0][0];
        if((abgleich == spielfeld[1][1]) && (abgleich == spielfeld[2][2]) && (abgleich != ' ')) {
            if (!gewonnen) {
                gewonnen = true;
                gewinner = String.valueOf(abgleich);
            }
            else {
                return ("Ungültieg Eingabe: mehrere 3-er Reihen!");
            }
        }


        if (!gewonnen) {
            return "Kein Spieler hat bisher gewonnen.";
        }
        return "Spieler " + gewinner + " hat gewonnen.";
    }

    public static void main(String[] args){
        //Hier Spielfeld befüllen
        char[][] spielfeld = {                      //erst mit y-, dann mit x-Koordinate addressierbar
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        //Test, ob nur gültige chars genutzt wurden:
        boolean gueltigeChars = true;
        for (int y = 0; y < spielfeld.length; y++) {
            for (int x = 0; x < spielfeld.length; x++) {
                if (!(spielfeld[x][y] == ' ' || spielfeld[x][y] == 'x' || spielfeld[x][y] == 'o')){
                    gueltigeChars = false;
                }
            }
        }

        if(gueltigeChars) {
            //Ausgabe des Spielfeldes
            for (int y = 0; y < spielfeld.length; y++) {
                for (int x = 0; x < spielfeld.length; x++) {
                    System.out.print(spielfeld[y][x]);
                    if (x < 2) {
                        System.out.print("|");
                    }
                }
                if (y < 2) {
                    System.out.println("\n-+-+-");
                }
            }
            System.out.println("\n\n");

            //Ausgabe der Bewertung
            System.out.println(bewerten(spielfeld));
        }
        else {
            System.out.println("Dies ist kein gültiges Spielfeld!");
        }
    }
}