package lesson01.classes;

import lesson01.enums.TruckTrailer;
import lesson01.interfaces.ITruck;

/*
 * Каждый класс должен содержать не менее 2 полей.
 * Должна быть реализация хотя бы одного параметризованного конструктора.
 * Реализация инкапсуляции включая разграничение с модификаторами доступа.
 */

public class Truck extends Vehicle implements ITruck {
    private TruckTrailer trailer = TruckTrailer.NONE;
    int loadCapasityKG = 1500; // 1.5T по умолчанию пусть так будет

    public TruckTrailer getTrailer() {
        return trailer;
    }
    public void setTrailer(TruckTrailer value) {
        trailer = value;
    }

    public int getLoadCapasityKG() {
        return loadCapasityKG;
    }

    public void setLoadCapasityKG(int value) {
        loadCapasityKG = value;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", super.toString(), 
                                    TruckTrailer.toString(trailer), 
                                    loadCapasityKG);
    }

    protected Truck() {
    }
    protected Truck(String stateNumber, String owner, String manufacturer, 
                    TruckTrailer trailer, int loadCapasityKG)
    {
        super(stateNumber, owner, manufacturer); // позвали конструктор родительского класса
        this.trailer = trailer;
        this.loadCapasityKG = loadCapasityKG;
    }
    public static Truck create(String stateNumber, String owner, 
                                String manufacturer, TruckTrailer trailer, 
                                int loadCapasityKG) {
        return new Truck(stateNumber, owner, manufacturer, 
                                      trailer, loadCapasityKG);
    }
}
