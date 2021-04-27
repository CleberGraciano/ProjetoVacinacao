package com.vacinacao.socket;

import com.vacinacao.dao.CentroVacinacaoDao;
import com.vacinacao.model.CentroVacinacao;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;



  public class Server {
    public static final int PORT = 4000;
    private ServerSocket serverSocket;
    private final List<ClientSocket> clients = new LinkedList<>();


    
   public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor Iniciado!!!");
        clientConnectionLoop();
    }


   private void clientConnectionLoop() throws IOException {
        while (true) {
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            clients.add(clientSocket);
            new Thread(() -> {
                try {
                    clientMessageLoop(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    private void clientMessageLoop(ClientSocket clientSocket) throws IOException {
        String msg;
        try {
            while ((msg = clientSocket.getMessage()) != null) {

                switch (Character.toString(msg.charAt(0))) {
                    case "1" :
                        System.out.printf("Mensagem recebida ", clientSocket.getRemoteSocketAddress(), msg);
                        sendMessageToClient(clientSocket, " Deu certo");
                        break;
                    case "2":
                        CentroVacinacaoDao centroVacinacaoDao = new CentroVacinacaoDao();
                        CentroVacinacao centroVacinacao = centroVacinacaoDao.getByNome(msg.substring(1,msg.length()));
                        System.out.println(centroVacinacao.toString());
                        sendMessageToClient(clientSocket, centroVacinacao.toString());

                        break;
                    case "0" :
                        return;
                    default:
                        System.out.println("Opcao Invalida");
                }

            }
        } finally {
            clientSocket.close();
        }
    }

    //Metodo usado para enviar mensagem para o clientes
    private void sendMessageToClient(ClientSocket sender, String msg) {

               sender.sendMsgServer(msg);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o Servidor" + e.getMessage());
        }

    }
}
