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

        //MUESTRO CABECERA INICIAL
        mostrarCabecera();

        //CREO EL GAME LOOP
        while (gameRunning) {

            //MUESTRO ESTADO DEL MUNDO (POR TURNOS)
            mostrarEstadoMundo(turn,resonance,desync,currentZone);
            //MUESTRO MENÚ DE ZONA
            mostrarMenu(currentZone);
            //PIDO LECTURA DE OPCIÓN DE MENÚ
            System.out.println("Escoge una opción: ");
            int option = scan.nextInt();
            boolean moveSuccess = false;
            boolean actionConsumesTurn = false;

            //CREO LAS CONSECUENCIAS DEL RESULTADO DE LA ELECCION DEL JUGADOR
            switch (option) {
                case 1:
                    System.out.println("Has decidido esperar...");
                    actionConsumesTurn = true;
                    break;
                case 2:
                    if(currentZone.equals("Hogar")) {
                        System.out.println("Dejas atrás el hogar...");
                        System.out.println();
                        currentZone = "Bosque";
                        actionConsumesTurn = true;
                    } else if(currentZone.equals("Bosque")) {
                        System.out.println("Sales del bosque...");
                        System.out.println();
                        currentZone = "Hogar";
                        actionConsumesTurn = true;
                    }
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
    /**
     * MUESTRA LA CABEZERA DE BIENVENIDA DEL JUEGO.
     */
    static void mostrarCabecera() {
        System.out.println("=========================");
        System.out.println("|      ASH & BLOOM      |");
        System.out.println("|      BIENVENIDO       |");
        System.out.println("=========================");
        System.out.println();
    }
    /**
     * MUESTRA EL MENU DE OPCIONES SEGÚN LA ZONA ACTUAL DEL JUGADOR
     * @param zonaActual ZONA EN LA QUE SE ENCUENTRA EL JUGADOR.
     */
    static void mostrarMenu(String zonaActual) {
        if (zonaActual.equals("Hogar")) {
            System.out.println("# HOGAR #");
            System.out.println("1) ESPERAR");
            System.out.println("2) BOSQUE");
            System.out.println("0) SALIR");
        } else if (zonaActual.equals("Bosque")) {
            System.out.println("# BOSQUE #");
            System.out.println("1) ESPERAR");
            System.out.println("2) HOGAR");
            System.out.println("0) SALIR");
        }
    }
    /**
     * MUESTRA EL ESTADO DEL MUNDO.
     * @param turn REFIERE AL TURNO QUE LLEVAMOS
     * @param resonance VALOR GLOBAL DEL MUNDO - REFIERE AL EQUILIBRIO DEL MUNDO (QUE TAN RESTAURADO ESTA).
     * @param desync VALOR DEL PERSONAJE - REFIERE A LA DESINCRONIZACIÓN CON LA RED NATURAL
     * @param currentZone ZONA EN LA QUE SE ENCUENTRA EL PJ.
     */
    static void mostrarEstadoMundo(int turn, int resonance, int desync, String currentZone) {
        System.out.println("=== ESTADO DEL MUNDO ===");
        System.out.println("TURNO: " + turn);
        System.out.println("ZONA: " + currentZone);
        System.out.println("RESONANCE: " + resonance);
        System.out.println("DESYNC: " + desync);
        System.out.println("=== ================ ===");
        System.out.println();
    }
}
