
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Vuoi inserire una nuova vacanza? (s/n)");
            String risposta = scanner.nextLine().toLowerCase();

            if (risposta.equals("n")) {
                System.out.println("Grazie per aver utilizzato il servizio di prenotazione. Arrivederci!");
                break;
            } else if (risposta.equals("s")) {
                try {
                    System.out.println("Inserisci la destinazione:");
                    String destinazione = scanner.nextLine();

                    System.out.println("Inserisci il giorno di partenza (formato gg):");
                    int giornoInizio = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci il mese di partenza (formato mm):");
                    int meseInizio = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci l'anno di partenza (formato yyyy):");
                    int annoInizio = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci il giorno di ritorno (formato gg):");
                    int giornoFine = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci il mese di ritorno (formato mm):");
                    int meseFine = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci l'anno di ritorno (formato yyyy):");
                    int annoFine = Integer.parseInt(scanner.nextLine());

                    LocalDate dataInizio = LocalDate.of(annoInizio, meseInizio, giornoInizio);
                    LocalDate dataFine = LocalDate.of(annoFine, meseFine, giornoFine);

                    Vacanza vacanza = new Vacanza(destinazione, dataInizio, dataFine);
                    System.out.println("Hai prenotato una vacanza di " + vacanza.calcolaDurata() + " giorni a " +
                            vacanza.getDestinazione() + " dal " + vacanza.getDataInizioFormattata() +
                            " al " + vacanza.getDataFineFormattata());
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                    System.out.println("Riprova l'inserimento.");
                } catch (DateTimeParseException e) {
                    System.out.println("Errore: Inserisci una data valida nel formato richiesto.");
                    System.out.println("Riprova l'inserimento.");
                }
            } else {
                System.out.println("Risposta non valida. Inserisci 's' per continuare o 'n' per uscire.");
            }
        }

        scanner.close();
    }
}
