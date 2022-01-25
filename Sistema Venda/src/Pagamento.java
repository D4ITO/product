public class Pagamento {
    private int tipoPagamento;

    public Pagamento() {
    }

    public Pagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public boolean selecionarTipoPagamento(int tpag){
        if (tpag == 1 || tpag == 2 || tpag ==3){
            setTipoPagamento(tpag);
            return true;
        } else {
            System.out.println("OPÇÃO INVÁLIDA\nOPERAÇÃO CANCELADA");
            System.out.println("________________");
            return false;
        }
    }

    public void realizarPagamento(Pagamento pag) {
        if (pag.getTipoPagamento() == 1) {
            System.out.println("Pagamento realizado com dinheiro");
        }
        if (pag.getTipoPagamento() == 2) {
            System.out.println("Pagamento realizado com cheque");
        }
        if (pag.getTipoPagamento() == 3) {
            System.out.println("Pagamento realizado com cartão");
        }
    }

    public int getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
