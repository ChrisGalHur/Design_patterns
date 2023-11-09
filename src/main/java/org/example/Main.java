package org.example;

import org.example.command.*;

public class Main {
    public static void main(String[] args) {

        // Command

        /*Command permite encapsular una solicitud como un objeto, permitiendo parametrizar a los clientes con operaciones, encolar solicitudes o registrar su historial,
        así como admitir operaciones reversibles.
        Ejemplo:
        - La interfaz Command con su método execute será implementará las clases concretas de comandos.
        - La clase Device representa un dispositivo con métodos turnOn y turnOff.
        - La clase RemoteControl actúa como un invocador.
        - Las clases TurnOnCommand y TurnOffCommand son comandos concretos que implementan la interfaz Command y encapsulan las operaciones de encendido y apagado.
        */

        //Creamos un dispositivo, los comandos y un control remoto, asignamos comandos al control remoto y luego usamos el control remoto para invocar los comandos.
        // Paso 1: Crear un dispositivo (creamos una luz)
        Device light = new Device();

        // Paso 2: Crear comandos concretos y asignarles el dispositivo
        Command turnOnCommand = new TurnOnCommand(light);
        Command turnOffCommand = new TurnOffCommand(light);

        // Paso 3: Crear un control remoto y asignar comandos
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOnCommand); // Asignar encendido
        remoteControl.pressButton(); // Presionar el botón para encender
        remoteControl.setCommand(turnOffCommand); // Asignar apagado
        remoteControl.pressButton(); // Presionar el botón para apagar
    }
}