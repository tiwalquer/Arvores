package Arvore;

public class Main {

    static void main(String[] args) {

        ArvoreBinaria executarArvore = new ArvoreBinaria();



        executarArvore.inserir(17);
        executarArvore.inserir(30);
        executarArvore.inserir(30);
        executarArvore.inserir(4);
        executarArvore.inserir(-2);
        executarArvore.inserir(678);
        executarArvore.inserir(0);
        executarArvore.inserir(5);

        executarArvore.remover(4);

        executarArvore.exibir();
    }

}
