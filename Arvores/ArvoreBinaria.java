package Arvores;

public class ArvoreBinaria {

    No raiz;


    public ArvoreBinaria(){

        this.raiz = null; //fazendo isso, nao cria um 'Nó', nao existe nada ainda, ela so sera criada no 'inserir' tornando comparacoes possiveis
        //this.raiz = new No(null); // dessa forma nos criamos o 'Nó' porem o seu conteudo é vazio, inproprio para realizar comparacoes
    }


    //sao necessarios 2 metodos para usar a chamada recursiva, pois o " nó 'aux' " nao pode ser criado no metodo recursivo !!!
    /**
     *
     * @param noAtual serve para nao nos perdermos dentro da arvore
     * @param conteudo o conteudo do novo 'no' desejado
     * @return o 1 retorno criara o novo 'Nó'  ...  o 2 retorno cuida da volta/ nao deixa a gente perde os valores, quando as chamadas recursivas vao voltando elas vao se deparando com o
     * 'return noAtual' que vai 'setting the value' para o do 'Nó' que ele era por causo do 'noAtual.set ...algo '
     */
    public No inserirRecursivamente(No noAtual, Integer conteudo){ // 'noAtual': faz o papel do 'auxiliar'
        if(noAtual == null){

            return new No(conteudo); //cria o novo 'Nó'
        }

        if(noAtual.getConteudo() > conteudo){

            noAtual.setEsquerda(inserirRecursivamente( noAtual.getEsquerda(), conteudo)); //sempre lembrar de atualizar os 'apontamentos' dos nós, se nao o valor é perdido

        }else if (noAtual.getConteudo() < conteudo){
            noAtual.setDireita(inserirRecursivamente( noAtual.getDireita(), conteudo)); // seta o resultado disso = 'inserirRecursivamente( noAtual.getDireita(), conteudo)'
                // o qual tem retorno = a isso 'noAtual'
        }else{
            System.out.println("Nós com conteudos(" + noAtual.getConteudo() + ") iguais nao sao permitidos!");
        }
        return noAtual;
    }

    public void inserir(Integer conteudo){

        raiz = inserirRecursivamente( this.raiz, conteudo); //o valor da raiz é trocado, porem no fim ele acaba o mesmo por causado 'return noAtual'
    }


    private void exibirRecursivamente(No noAtual){

        if(noAtual == null){ //por que aqui deve ter so o produto
            return;
        }

        exibirRecursivamente(noAtual.getEsquerda());
        System.out.println(noAtual.getConteudo());
        exibirRecursivamente(noAtual.getDireita());

    }

    public void exibir(){

        No aux = this.raiz;

        if(!existeInicio()){
            return;
        }

        exibirRecursivamente(aux);
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