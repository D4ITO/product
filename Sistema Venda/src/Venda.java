import java.util.ArrayList;

public class Venda {
    private float vlrTotal;
    private ArrayList<Produto> listaprodutos = new ArrayList<>();

    public Venda() {
    }

    public void adicionarItemVenda(Produto prod) {

        if (prod.verificarEstoque(prod)) {
            listaprodutos.add(new Produto(prod.getNome(), prod.getPreco(), prod.getQuantidadeEstoque()));
            this.vlrTotal += prod.getPreco();
            System.out.println("Produto " + prod.getNome() + " adicionado.");
        } else {
            System.out.println("Não foi possível adicionar o produto " + prod.getNome() + " pois seu estoque está zerado.");
        }
        System.out.println("________________");
    }

    public void visualizarVenda() {
        System.out.println("________________");
        System.out.println("ITENS DA VENDA:");
        for (int cont = 0; cont < listaprodutos.size(); cont++) {
            System.out.println("Produto: " + listaprodutos.get(cont).getNome() + " - R$ " + listaprodutos.get(cont).getPreco());
        }
        System.out.println("________________");
    }

    public void concluirVenda(Pagamento pag) {
        System.out.println("________________");
        System.out.println("Valor total da venda: " + this.vlrTotal);
        pag.realizarPagamento(pag);
        listaprodutos.clear();
        System.out.println("________________");
    }

    public float getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(float vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public ArrayList<Produto> getListaprodutos() {
        return listaprodutos;
    }

    public void setListaprodutos(ArrayList<Produto> listaprodutos) {
        this.listaprodutos = listaprodutos;
    }
}
