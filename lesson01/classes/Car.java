package lesson01.classes;

import lesson01.enums.CarClass;
import lesson01.interfaces.ICar;

// Каждый класс должен содержать не менее 2 полей.
// Должна быть реализация хотя бы одного параметризованного конструктора.
// Реализация инкапсуляции включая разграничение с модификаторами доступа.
public class Car extends Vehicle implements ICar {
    private int passengerNumber = 5;
    public int getPassengerNumber() {
        return passengerNumber;
    }
    public void setPassengerNumber(int value) {
        passengerNumber = value;
    }

    private CarClass carClass;
    public CarClass getCarClass() {
        return carClass;
    }
    public void setCarClass(CarClass value) {
        carClass = value;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s", super.toString(), passengerNumber, CarClass.toString(carClass));
    }

    protected Car() {
    }
    protected Car(String stateNumber, String owner, String manufacturer, int passengerNumber, CarClass carClass)
    {
        super(stateNumber, owner, manufacturer); // позвали конструктор родительского класса
        this.passengerNumber = passengerNumber;
        this.carClass = carClass;
    }

    public static Car create(String stateNumber, String owner, String manufacturer, int passengerNumber, CarClass carClass) {
        return new Car(stateNumber, owner, manufacturer, passengerNumber, carClass);
    }
}
