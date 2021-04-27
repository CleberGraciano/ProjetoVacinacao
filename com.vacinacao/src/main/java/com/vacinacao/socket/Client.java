package com.vacinacao.socket;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client implements Runnable {
    private static final String SERVER_ADDRESS="127.0.0.1";
    private ClientSocket clientSocket;
    private Scanner scanner;


    public Client (){
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        try {
            clientSocket = new ClientSocket(new Socket(SERVER_ADDRESS, Server.PORT));

            System.out.println("Cliente conectado ao servidor em " + SERVER_ADDRESS + ":" + Server.PORT);
            //Thread executa o método run desse objeto atual, pois a classe implementa runnable
            //Cria uma thread
            new Thread(this).start();
            messageLoop();
        }finally {
            clientSocket.close();
        }
    }

    //Recebe as mensagens de outros clientes mas em uma thread separada
    @Override
    public void run() {
        String msg;
        while((msg = clientSocket.getMessage()) !=null) {
            System.out.println(msg);

        }
    }

    private void messageLoop() throws IOException {
       String msg;

       do {
           clientSocket.exibirMenu();
           System.out.println("Opcao escolhida: ");
           msg = scanner.nextLine();
           lerDadosUsuario(msg);



       }while(!msg.equalsIgnoreCase("sair"));
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o Cliente"+e.getMessage());
        }
        System.out.println("Cliente finalizado!!");
    }

    public void lerDadosUsuario(String opcao){
        switch (opcao) {
            case "1" :
                System.out.println("Digite o nome do Centro: ");
                clientSocket.sendMsg(Optional.ofNullable(opcao), scanner.nextLine());
                break;
            case "2":
                System.out.println("Digite o nome do Centro de Vacinacao: ");
                clientSocket.sendMsg(Optional.ofNullable(opcao), scanner.nextLine());
                break;
            case "sair" :

            default:
                System.out.println("Opcao Invalida");
        }
    }


}
