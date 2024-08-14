import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {



    public static void main(String[] args) {
        final String ARQUIVO = "C:\\Users\\lukel\\IdeaProjects\\DIO\\TestePerformance3PB\\Arquivo.csv";

        File arq = new File(ARQUIVO);
        List<CadastroUsuarios> usuarios = lerArquivo(arq);


        for (CadastroUsuarios usuario : usuarios) {
            System.out.println(usuario);
        }


        CadastroUsuarios novoUsuario = preencherFormulario();
        usuarios.add(novoUsuario);

        gravarArquivo(arq, usuarios);

        System.out.println("\nTodos os usuários:");
        for (CadastroUsuarios usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public static CadastroUsuarios preencherFormulario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nNome Completo: ");
        String nomeCompleto = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        String idUsuario = nomeCompleto.replaceAll(" ", "").toLowerCase();

        return new CadastroUsuarios(idUsuario, nomeCompleto, email, senha, dataNascimento, genero);
    }

    public static List<CadastroUsuarios> lerArquivo(File arq) {
        List<CadastroUsuarios> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String linha = br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] vetor = linha.split(",");

                String idUsuario = vetor[0];
                String nomeCompleto = vetor[1];
                String email = vetor[2];
                String senha = vetor[3];
                String dataNascimento = vetor[4];
                String genero = vetor[5];

                CadastroUsuarios usuario = new CadastroUsuarios(idUsuario, nomeCompleto, email, senha, dataNascimento, genero );
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return usuarios;
    }


    public static void gravarArquivo(File arq, List<CadastroUsuarios> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arq))) {
            bw.write("");
            bw.newLine();

            for (CadastroUsuarios usuario : usuarios) {
                bw.write(usuario.toString());
                bw.newLine();
            }

            System.out.println("Arquivo gravado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }
}