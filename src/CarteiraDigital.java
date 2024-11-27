import java.util.ArrayList;
import java.util.List;

public class CarteiraDigital {
    private double saldo;
    private final List<String> historicoTransacoes;

    public CarteiraDigital() {
        this.saldo = 0.0;
        this.historicoTransacoes = new ArrayList<>();
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldo += valor;
            historicoTransacoes.add("Adicionado: R$ " + valor);
            System.out.println("Saldo adicionado com sucesso!");
        } else {
            System.out.println("Valor inválido. Tente novamente.");
        }
    }

    public void realizarPagamento(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historicoTransacoes.add("Pago: R$ " + valor);
            System.out.println("Pagamento realizado com sucesso!");
        } else if (valor <= 0) {
            System.out.println("Valor inválido para pagamento.");
        } else {
            System.out.println("Saldo insuficiente para realizar o pagamento.");
        }
    }

    public double verificarSaldo() {
        return saldo;
    }

    public void historicoTransacoes() {
        if (historicoTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            System.out.println("Histórico de Transações:");
            for (String transacao : historicoTransacoes) {
                System.out.println(transacao);
            }
        }
    }
}
