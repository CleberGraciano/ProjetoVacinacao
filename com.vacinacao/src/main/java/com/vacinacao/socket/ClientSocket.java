package com.vacinacao.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Optional;

public class ClientSocket {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
  

    public ClientSocket(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Cliente " + socket.getRemoteSocketAddress() + " conectou");
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar Socket " + e.getMessage());
        }
    }

    public String getMessage() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean sendMsg(Optional <String> opcao, String  msg) {

        out.println(opcao.get()+msg);
        return !out.checkError(); 
    }
    public boolean sendMsgServer(String  msg) {

        out.println(msg);
        return !out.checkError(); 
    }

    public void exibirMenu(){

        System.out.println("\n");
        System.out.println("+--------------------------------------+");
        System.out.println("|                 MENU                 |");
        System.out.println("+--------------------------------------+");
        System.out.println(
                  "| 1 - Consultar centros de vacinacao por Nome:  |\n"
                + "| 2 - Consultar Fila de Espera                  |\n"
                + "| 3 - Cadastro de vacinacao                     |\n"
                + "| 4 - Atualizar status de vacina                |\n"
                + "| 5 - Cadastro de vacinação                   |\n"
                + "| 6 - Reportar efeitos secundários             |\n"
                + "| 7 - Listar vacinados por tipo Vacina          |\n"
                + "| 0 - Sair                                      |" );
        System.out.println("+--------------------------------------+\n\n");

    }



}
