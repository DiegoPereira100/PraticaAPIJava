import com.google.gson.Gson;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

import java.util.Scanner;

public class Main {
    static Endereco endereco = new Endereco();
    static CepDao cepDao = new CepDao();
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("-------Opções do Menu-------");
            System.out.println("1 - Consultar Cep");
            System.out.println("2 - Listar Ceps consultados");
            System.out.println("3 - Sair");

            System.out.println("Entre com sua opção: ");
            int op = scan.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Entre com o CEP: ");
                    String cep = scan.next();

                    try {
                        Gson gson = new Gson();
                        BuscaEndere.ConsomeApi api = new BuscaEndere.ConsomeApi();
                        String resultado = api.retornaEnd(Integer.parseInt(cep));
                        Endereco endereco = gson.fromJson(resultado, Endereco.class);

                        cepDao.saveEndereco(endereco);

                        String dataHora = api.retornaHorario();
                        DataHora dataHoraObj = gson.fromJson(dataHora, DataHora.class);


                        try {
                            FileWriter escrita = new FileWriter("enderecos.txt", true);
                            escrita.write(endereco.toString() + " / " + dataHoraObj.toString() + "\n");
                            System.out.println("Cep Consultado com sucesso!");
                            escrita.close();
                        } catch (Exception e) {
                            System.out.println("Erro ao consultar cep: " + e.getMessage());
                        }

                        FileReader leitura = new FileReader("enderecos.txt");
                        BufferedReader leituraReader = new BufferedReader(leitura);
                        String linha;
                        while ((linha = leituraReader.readLine()) != null) {
                            System.out.println(linha);
                        }
                        leituraReader.close();
                        leitura.close();
                    } catch (IOException e) {
                        System.out.println("Erro ao consultar o CEP)");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    cepDao.listEnderecos();
                    break;
                case 3:
                    System.out.println("Saindo da aplicação...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }

    }
}