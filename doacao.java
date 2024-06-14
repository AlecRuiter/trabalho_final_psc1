import java.io.IOException;
import java.util.Scanner;


public class doacao {
    static Scanner scanner = new Scanner(System.in);
    
    // coloquei o scanner como estatico pois apenas membros estaticos conseguem acessar outros estaticos diretamente

    public static int totalDeDoacoes = 0;
    static servicos servico  = new servicos();


    public static void main(String[] args) throws IOException{
        boolean continuar = true;
     
        while(continuar){
        System.out.println("|SEJA BEM VINDO! Digite o número correspondente ao tipo da sua doação:|");
        System.out.println("1. Alimentos");
        System.out.println("2. Roupas");
        System.out.println("3. Medicamentos");
        System.out.println("4. Dinheiro");

        int escolha = scanner.nextInt();


        try {
            switch (escolha) {
                case 1:
                    servicos.doarAlimentos();
                    break;
                case 2:
                    servicos.doarRoupas();
                    break;
                case 3:
                    servicos.doarMedicamentos();
                    break;
                case 4:
                    servicos.doarDinheiro();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar a doação: " + e.getMessage());
        }

            System.out.println("Deseja fazer outra doação?(s/n)");
            String respostaContinuar = scanner.next();

            if(respostaContinuar.equalsIgnoreCase("n")) continuar = false;
            System.out.println("Agradecemos! O total de doacoes foi: " + totalDeDoacoes);
        }
    }
}