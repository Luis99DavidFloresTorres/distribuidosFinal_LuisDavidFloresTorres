package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICotizador extends Remote {
    double calculoCotizacion(String origen,String destino) throws RemoteException;
}
