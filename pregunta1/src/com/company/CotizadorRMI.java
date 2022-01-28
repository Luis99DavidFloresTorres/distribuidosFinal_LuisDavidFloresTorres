package com.company;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos
 */
public class CotizadorRMI extends UnicastRemoteObject
        implements ICotizador {

    public CotizadorRMI() throws RemoteException {
        super();
    }

    @Override
    public double calculoCotizacion(String origen, String destino) throws RemoteException {
        if(origen.equals("Bs") && destino.equals("US")){
            return 6.96;
        }else if(origen.equals("Bs") && destino.equals("R")){
            return 1.277;
        }else if(origen.equals("Bs") && destino.equals("Arg")){
            return 0.066;
        }
        if(origen.equals("US") && destino.equals("R")){
            return 0.192;
        }else if(origen.equals("US") && destino.equals("ARG")){
            return 0.066;
        }
        if(origen.equals("R") && destino.equals("Arg")){
            return 0.51;
        }
        return 0;
    }

    public static void main(String[] args) {
        CotizadorRMI servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor=new CotizadorRMI();
            Naming.bind("Cotizador", servidor);
            System.out.println("El servidor esta listo\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
