import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        String nome;
        double preco;
        int quantidadeEstoque;
        int tipoPagamento;

        int opcao;
        int cont;
        //Instância das classes
        Produto produto = new Produto();
        Venda venda = new Venda();
        Pagamento pag = new Pagamento();
        Scanner scan = new Scanner(System.in);

        //Loop para solicitar opção ao usuário
        opcao = 0;
        while (opcao != 4) {
            System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO");
            System.out.println("1 - Adicionar Produto\n2 - Visualizar Venda\n3 - Concluir Venda\n4 - Sair");
            opcao = scan.nextInt();

            //Laço condicional para realizar ações conforme opção escolhida pelo usuário
            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o nome produto que deseja adicionar na venda:");
                    nome = scan.next();
                    System.out.println("Digite o preço do produto que deseja adicionar na venda:");
                    preco = scan.nextDouble();
                    System.out.println("Digite a quantidade de estoque:");
                    quantidadeEstoque = scan.nextInt();
                    produto.cadastrarProduto(nome, preco, quantidadeEstoque);
                    venda.adicionarItemVenda(produto);
                }
                case 2 -> venda.visualizarVenda();

                case 3 -> {
                    if (venda.getListaprodutos().isEmpty()) {
                        System.out.println("Impossível concluir a venda pois não há nenhum produto adicionado!");
                    } else {
                        System.out.println("Qual é a forma de pagamento escolhida?:");
                        System.out.println("1 - Dinheiro\n2 - Cheque\n3 - Cartão");
                        tipoPagamento = scan.nextInt();
                        if (pag.selecionarTipoPagamento(tipoPagamento)) {
                            venda.concluirVenda(pag);
                        }
                    }
                }
                case 4 -> System.out.println("Finalizando sistema...");

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
