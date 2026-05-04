package Arvores;

public class Main {

    public static void main(String[] args) {

        ArvoreBinaria executarArvore = new ArvoreBinaria();

        executarArvore.exibir();

        executarArvore.inserir(17);
        executarArvore.inserir(30);
        executarArvore.inserir(30);
        executarArvore.inserir(4);
        executarArvore.inserir(-2);
        executarArvore.inserir(678);
        executarArvore.exibir();

    }

}