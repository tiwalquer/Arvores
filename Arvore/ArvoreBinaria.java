package Arvore;

public class ArvoreBinaria {

    No raiz;


    public ArvoreBinaria(){

        this.raiz = new No(null);

    }


    public void inserir(Integer conteudo){

        No novoNo = new No(conteudo);
        No aux = this.raiz;

        if(existeInicio()){
            this.raiz = novoNo;

        }

        if(novoNo.getConteudo() < aux.getConteudo()) {
//            if (aux == null) {
//
//            }

            cuEsquerdo(aux.getEsquerda());
            aux = novoNo;
        }

        if(novoNo.getConteudo() > aux.getConteudo()) {
//            if (aux == null) {
//
//            }

            cuDireito(aux.getDireita());
            aux = novoNo;
        }




    }

    public void exibir(){
        No aux = this.raiz;

        if(!existeInicio()){
            return;
        }

         do{
            cuEsquerdo(aux);
            System.out.println(aux.getConteudo());
        }while(aux.getEsquerda() != null);


        do {
            cuDireito(aux);
            System.out.println(aux.getConteudo());
        }while(aux.getDireita() != null);
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
        return false;
    }

    public boolean estaVazio(No no){
        if(no == null){

            return true;
        }
        return false;
    }


}
