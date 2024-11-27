import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarteiraDigital carteira = new CarteiraDigital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = lerEntradaUsuario(scanner);

            switch (opcao) {
                case 1:
                    adicionarSaldo(carteira, scanner);
                    break;
                case 2:
                    realizarPagamento(carteira, scanner);
                    break;
                case 3:
                    System.out.printf("Seu saldo atual é: R$ %.2f%n", carteira.verificarSaldo());
                    break;
                case 4:
                    carteira.historicoTransacoes();
                    break;
                case 5:
                    System.out.println("Obrigado por usar a sua Carteira Digital!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nBem-vindo à sua Carteira Digital!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar Saldo");
        System.out.println("2 - Realizar Pagamento");
        System.out.println("3 - Verificar Saldo");
        System.out.println("4 - Ver Histórico de Transações");
        System.out.println("5 - Sair");
    }

    private static int lerEntradaUsuario(Scanner scanner) {
        System.out.print("Usuário: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número.");
            System.out.print("Usuário: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void adicionarSaldo(CarteiraDigital carteira, Scanner scanner) {
        System.out.print("Digite o valor para adicionar ao saldo: R$ ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Digite um valor numérico.");
            System.out.print("Digite o valor para adicionar ao saldo: R$ ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        carteira.adicionarSaldo(valor);
    }

    private static void realizarPagamento(CarteiraDigital carteira, Scanner scanner) {
        System.out.print("Digite o valor do pagamento: R$ ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Digite um valor numérico.");
            System.out.print("Digite o valor do pagamento: R$ ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        carteira.realizarPagamento(valor);
    }
}