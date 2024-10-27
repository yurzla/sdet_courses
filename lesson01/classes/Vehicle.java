package lesson01.classes;

import lesson01.enums.CarClass;
import lesson01.enums.TruckTrailer;
import lesson01.interfaces.IVehicle;

/*
 * Как минимум один абстрактный класс.
 * Каждый класс должен содержать не менее 2 полей.
 * Должна быть реализация хотя бы одного параметризованного конструктора.
 * Реализация инкапсуляции включая разграничение с модификаторами доступа.
 */

public abstract class Vehicle implements IVehicle {
    private String owner = ""; // какая-то идентицикационная информация о хозяине
    private String manufacturer = ""; // информация об изготовителе

    // Наличие статических полей и методов
    private static int totalVehiclesNumber = 0;

    public static int getTotalVehiclesNumber() {
        return totalVehiclesNumber;
    }
    private static void setTotalVehiclesNumber(int value) {
        totalVehiclesNumber = value;
    }

    private String stateNumber = ""; // регистрационный номер
    public String getStateNumber() {
        return stateNumber;
    }
    public void setStateNumber(String value) {
        stateNumber = value;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String value) {
        owner = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String value) {
        manufacturer = value;
    }

    public String toString() {
        return String.format("%s, %s, %s", stateNumber, owner, manufacturer);
    }

    // конструктор по умолчанию
    protected Vehicle() {
    }
    // Должна быть реализация хотя бы одного параметризованного конструктора.
    protected Vehicle(String stateNumber, String owner, String manufacturer) {
        // обращение череp this изза совпадения имен в сигнатуре и классе
        this.stateNumber = stateNumber;
        this.owner = owner;
        this.manufacturer = manufacturer;
    }

    public static IVehicle CreateCar(String stateNumber, String owner, 
                                        String manufacturer, int passengerNumber,
                                        CarClass carClass) {
        Vehicle.setTotalVehiclesNumber(Vehicle.getTotalVehiclesNumber() + 1);
        return Car.create(stateNumber, owner, manufacturer, 
                            passengerNumber, carClass);
    }

    public static IVehicle CreateTruck(String stateNumber, String owner, 
                                        String manufacturer, 
                                        TruckTrailer trailer, 
                                        int loadCapasityKG) {
        Vehicle.setTotalVehiclesNumber(Vehicle.getTotalVehiclesNumber() + 1);
        return Truck.create(stateNumber, owner, manufacturer, trailer, 
                                                        loadCapasityKG);
    }
}
