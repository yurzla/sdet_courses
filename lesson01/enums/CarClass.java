package lesson01.enums;

/* класс л/а к которому принадлежит авто */ 

public enum CarClass {
    A, B, C, D, E;

    // Методы должны реализовать какую либо усложненную логику (ветвления, циклы).
    public static String toString(CarClass cc) {
        switch (cc) {
            case B:
                return "класс B";
            case C:
                return "класс C";
            case D:
                return "класс D";
            case E:
                return "класс E";
            default:
                return "класс A";
        }
    }
}
