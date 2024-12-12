package lesson01.enums;

/* виды прицепов грузовика: никакого, прицеп, полуприцеп */  
public enum TruckTrailer {
    NONE, TRAILER, SEMITRAILER;

    // Методы должны реализовать какую либо усложненную логику (ветвления, циклы).
    public static String toString(TruckTrailer tt) {
        switch (tt) {
            case TRAILER:
                return "прицеп";
            case SEMITRAILER:
                return "полу-прицеп";
            default:
                return "просто грузовик";
        }
    }
}
