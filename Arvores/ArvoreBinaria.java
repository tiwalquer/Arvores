package Arvores;

public class ArvoreBinaria {

    No raiz;


    public ArvoreBinaria(){

        this.raiz = new No(null);

    }


    //sao necessarios 2 metodos para usar a chamada recursiva, pois o " nó 'aux' " nao pode ser criado no metodo recursivo !!!
    public No inserirRecursivamente(No noAtual, Integer conteudo){ // 'noAtual': faz o papel do 'auxiliar'
        if(noAtual == null){

            return new No(conteudo);
        }

        if(noAtual.getConteudo() > conteudo){
            return inserirRecursivamente( noAtual.getEsquerda(), conteudo);

        }else if (noAtual.getConteudo() < conteudo){
            return inserirRecursivamente( noAtual.getDireita(), conteudo);
        }
        System.out.println("Nós com conteudos iguais nao sao permitidos!");
        return null;
    }

    public void inserir(Integer conteudo){

        inserirRecursivamente( this.raiz, conteudo);
    }


    private void exibirRecursivamente(No noAtual){

        if(!existeInicio()){
            return;
            // return null;
        }

        exibirRecursivamente(noAtual.getEsquerda());
        System.out.println(noAtual.getConteudo());
        exibirRecursivamente(noAtual.getDireita());

    }

    public void exibir(){

        No aux = this.raiz;

        exibirRecursivamente(aux);
    }

    private void cuEsquerdo(No aux){

        if(aux == null){
            return ;
        }

        cuEsquerdo( aux.getEsquerda() );
        //return aux;
    }

    private No cuDireito(No aux){

        if(aux == null){
            return null;
        }

        cuDireito(  aux.getDireita() );
        return aux;
    }



    public boolean existeInicio(){
        if(this.raiz != null){
            return true;
        }
        System.out.println("A arvore nao existe");
        return false;
    }

    public boolean estaVazio(No no){
        if(no == null){

            return true;
        }
        return false;
    }


}