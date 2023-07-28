import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vacanza {
    private String destinazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine) throws IllegalArgumentException {
        if (destinazione == null || dataInizio == null || dataFine == null) {
            throw new IllegalArgumentException("Destinazione, data inizio e data fine non possono essere nulli.");
        }

        LocalDate oggi = LocalDate.now();
        if (dataInizio.isBefore(oggi)) {
            throw new IllegalArgumentException("La data di inizio non può essere precedente alla data odierna.");
        }

        if (dataFine.isBefore(dataInizio)) {
            throw new IllegalArgumentException("La data di fine non può essere precedente alla data di inizio.");
        }

        this.destinazione = destinazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public int calcolaDurata() {
        return (int) dataInizio.until(dataFine).getDays();
    }

    public String getDataInizioFormattata() {
        return dataInizio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getDataFineFormattata() {
        return dataFine.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getDestinazione() {
        return destinazione;
    }
}
