import java.util.Scanner;

public class ASHnBLOOM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //DECLARO VARIABLES DEL ESTADO INICIAL DEL MUNDO
        int turn = 1;
        int resonance = 0;
        int desync = 0;
        String currentZone = "Hogar";
        boolean gameRunning = true;


        mostrarCabecera();

        //CREO EL GAME LOOP
        while (gameRunning) {

            //MUESTRO ESTADO DEL MUNDO (POR TURNOS)
            System.out.println("=== ESTADO DEL MUNDO ===");
            System.out.println("TURNO: " + turn);
            System.out.println("ZONA: " + currentZone);
            System.out.println("RESONANCE: " + resonance);
            System.out.println("DESYNC: " + desync);
            System.out.println("=== ================ ===");
            System.out.println();
            //MUESTRO MENÚ + PEDIR LECTURA
            System.out.println("==== ASH & BLOOM ====");
            System.out.println("1) ESPERAR");
            System.out.println("2) BOSQUE ");
            System.out.println("0) SALIR");
            System.out.println("=====================");
            System.out.println();

            System.out.println("Escoge una opción: ");
            int option = scan.nextInt();

            boolean actionConsumesTurn = false;

            //CREO LAS CONSECUENCIAS DEL RESULTADO DE LA ELECCION DEL JUGADOR
            switch (option) {
                case 1:
                    System.out.println("Has decidido esperar...");
                    actionConsumesTurn = true;
                    break;
                case 2:
                    System.out.println("Dejas atrás el hogar...");
                    currentZone = "Bosque";
                    actionConsumesTurn = true;
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            // ACTUALIZACIÓN DE ESTADO
            if(actionConsumesTurn) {
                turn++;
                if(!currentZone.equals("Hogar")) {
                    desync++;
                }
            }
        }
    scan.close();
    }
    //CREAR METODO PARA MOSTRAR CABECERA:
    static void mostrarCabecera() {
        System.out.println("=========================");
        System.out.println("|      ASH & BLOOM      |");
        System.out.println("|      BIENVENIDO       |");
        System.out.println("=========================");
        System.out.println();
    }
}
