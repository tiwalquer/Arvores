package Arvore;

public class ArvoreBinaria {

    No raiz;


    public ArvoreBinaria(){

        this.raiz = new No(null);

    }


    public void inserir(Integer conteudo){

        No novoNo = new No(conteudo);

        if(existeInicio()){
            this.raiz = novoNo;

        }else if(this.raiz.getConteudo() > conteudo){ //esquerda

        }
    }

    public boolean existeInicio(){
        if(this.raiz != null){
            return true;
        }
        return false;
    }

    public boolean estaVazio(No no){
        if(no == null){

            return true;
        }
        return false;
    }


}
