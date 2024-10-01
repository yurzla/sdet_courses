package lesson01.interfaces;

import lesson01.enums.CarClass;

public interface ICar {
    // число пассажиров включая водителя
    int getPassengerNumber();
    void setPassengerNumber(int value);

    // класс л/а
    CarClass getCarClass();
    void setCarClass(CarClass value);
}