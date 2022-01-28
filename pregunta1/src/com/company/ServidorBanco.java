/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/**
 *
 * @author Carlos
 */
public class ServidorBanco {
    int cantidad;
    String monedaOrigen;
    String monedaDestino;
    public static void main(String[] args) {
        int port = 5010;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");

            Socket client;
            PrintStream toClient;
            //while (true) {
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String origen=fromClient.readLine();
                String destino = fromClient.readLine();

                double cantidad =Integer.parseInt(fromClient.readLine());

                

                System.out.println("Cliente se conecto");
          //  }

            ICotizador cotizar;

            try {
                cotizar=(ICotizador) Naming.lookup("rmi://localhost/Cotizador");
                double c=cotizar.calculoCotizacion(origen,destino);
                System.out.println(c);
                System.out.println(cantidad);
                double resultado = cantidad * c;
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resultado);



            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
