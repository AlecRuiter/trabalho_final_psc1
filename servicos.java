import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class servicos {

    static Scanner scanner = new Scanner(System.in);
    int total = doacao.totalDeDoacoes;


    public static void doarAlimentos() throws IOException {
        System.out.print("Qual alimento você deseja doar:");
        String tipo = scanner.next();
        System.out.println("Ok! Agora escreva a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
    
        salvarDoacoes.salvarDoacao(tipo, quantidade);
        atualizarTotalDeDoacoes(quantidade);
    }
    

// fiz sobrecarga de metodo

    public static void doarRoupas() throws IOException {

        System.out.print("Qual tipo de roupa você deseja doar?");
        String tipo = scanner.next();
        System.out.println("Ok! Agora escreva a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        salvarDoacoes.salvarDoacao(tipo, quantidade);
        atualizarTotalDeDoacoes(quantidade);
    }

    public static void doarMedicamentos() throws IOException {
        System.out.print("Qual medicamento você deseja doar: ");
        String tipo  = scanner.next();
        System.out.println("Ok! Agora escreva a quantidade: ");
        int quantidade = scanner.nextInt();

        salvarDoacoes.salvarDoacao(tipo, quantidade);
        atualizarTotalDeDoacoes(quantidade);
    }

    public static void doarDinheiro() throws IOException {
        String tipo = "Dinheiro";
        System.out.print("Escreva a quantia:");
        int quantidade = scanner.nextInt();

        salvarDoacoes.salvarDoacao(tipo, quantidade);
        atualizarTotalDeDoacoes(quantidade);
    }

    public static void atualizarTotalDeDoacoes(int quantidade) {
        doacao.totalDeDoacoes += quantidade;
    }



    public class salvarDoacoes {
        public static void salvarDoacao(String tipo, int quantidade) throws IOException {
            String[] doacao = {tipo, String.valueOf(quantidade)};
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("doacoes.txt", true))) {
                writer.write("Doação: " + doacao[0] + ", Quantidade: " + doacao[1]);
                writer.newLine();
            } catch (IOException e) {
                throw new IOException("Erro ao gravar o arquivo", e);
            }
            System.out.println("Doação feita, agradecemos!");
        }
    }

}
    

