package lesson01.interfaces;

import lesson01.enums.TruckTrailer;

public interface ITruck {
    // информация о прицепе
    TruckTrailer getTrailer();
    void setTrailer(TruckTrailer value);

    // грузоподъемность
    int getLoadCapasityKG();
    void setLoadCapasityKG(int value);
}