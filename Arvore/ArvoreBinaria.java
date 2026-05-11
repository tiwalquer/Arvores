package Arvore;

import java.util.Scanner;

public class ArvoreBinaria {

        No raiz;


        public ArvoreBinaria(){

            this.raiz = null; //fazendo isso, nao cria um 'Nó', nao existe nada ainda, ela so sera criada no 'inserir' tornando comparacoes possiveis
            //this.raiz = new No(null); // dessa forma nos criamos o 'Nó' porem o seu conteudo é vazio, inproprio para realizar comparacoes
        }


        //sao necessarios 2 metodos para usar a chamada recursiva, pois o " nó 'aux' " nao pode ser criado no metodo recursivo !!!
        /**
         * @param noAtual serve para nao nos perdermos dentro da arvore
         * @param conteudo o conteudo do novo 'no' desejado
         * @return o 1 retorno criara o novo 'Nó'  ...  o 2 retorno cuida da volta/ nao deixa a gente perde os valores, quando as chamadas recursivas vao voltando elas vao se deparando com o
         * 'return noAtual' que vai 'setting the value' para o do 'Nó' que ele era por causo do 'noAtual.set ...algo '
         */
        private No inserirRecursivamente(No noAtual, Integer conteudo){ // 'noAtual': faz o papel do 'auxiliar'
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


    private void exibirPosOrdemRecursivamente(No noAtual){
        if(noAtual == null){ //por que aqui deve ter so o produto
            return;
        }

        exibirPreOrdemRecursivamente(noAtual.getEsquerda());
        exibirPreOrdemRecursivamente(noAtual.getDireita());
        System.out.println(noAtual.getConteudo());
    }

        private void exibirPreOrdemRecursivamente(No noAtual){
            if(noAtual == null){ //por que aqui deve ter so o produto
                return;
            }

            System.out.println(noAtual.getConteudo());
            exibirPreOrdemRecursivamente(noAtual.getEsquerda());
            exibirPreOrdemRecursivamente(noAtual.getDireita());

        }

        private void exibirEmOrdemRecursivamente(No noAtual){ //em-ordem

            if(noAtual == null){ //por que aqui deve ter so o produto
                return;
            }

            exibirEmOrdemRecursivamente(noAtual.getEsquerda());
            System.out.println(noAtual.getConteudo());
            exibirEmOrdemRecursivamente(noAtual.getDireita());

        }

        public void exibir(){
            Scanner scan = new Scanner(System.in);
            int escolha;
            No aux = this.raiz;

            if(!existeInicio()){
                return;
            }
            System.out.println("escolhe o tipo da ordencao da sua arvore = 1: em-ordem ; 2: pre-ordem; 3: pos-ordem");
            escolha = scan.nextInt();

            switch (escolha){
                case 1: {
                    exibirEmOrdemRecursivamente(aux);
                    break;
                }

                case 2: {
                    exibirPreOrdemRecursivamente(aux);
                    break;
                }
                case 3: {
                    exibirPosOrdemRecursivamente(aux);
                }

            }

        }


        public void remover(Integer removido){


            No noAtual = this.raiz;

            removerRecursivo(noAtual, removido);
        }

        private No removerRecursivo(No noAtual, Integer removido){


            if(noAtual == null){
                return noAtual;
            }
            if(noAtual.getConteudo().equals(removido)){

                if(noAtual.getEsquerda() == null && noAtual.getDireita() == null){ //remocao de nó folha
                    System.out.println("Nó: " + noAtual.getConteudo() + " removido com sucesso");
                    return noAtual = null;   //new No(conteudo); //cria o novo 'Nó'
                }else if(noAtual.getDireita() != null && noAtual.getEsquerda() == null){ //remocao de nó com apenas um filho
                    System.out.println("Nó: " + noAtual.getConteudo() + " removido com sucesso");
                    return noAtual.getDireita();
                } else if (noAtual.getDireita() == null && noAtual.getEsquerda() != null) {//remocao de nó com apenas um filho
                    System.out.println("Nó: " + noAtual.getConteudo() + " removido com sucesso");
                    return noAtual.getEsquerda();

                }else{ //remocao de um no com dois filhos
                    System.out.println("Nó: " + noAtual.getConteudo() + " removido com sucesso");

                    noAtual.setConteudo(maiorDosMenores(noAtual.getEsquerda(), noAtual, noAtual).getConteudo());
                    return  noAtual;
                }

            }

            if(noAtual.getConteudo() > removido){
                noAtual.setEsquerda(removerRecursivo( noAtual.getEsquerda(), removido)); //sempre lembrar de atualizar os 'apontamentos' dos nós, se nao o valor é perdido

            }else if (noAtual.getConteudo() < removido){
                noAtual.setDireita(removerRecursivo( noAtual.getDireita(), removido)); // seta o resultado disso = 'inserirRecursivamente( noAtual.getDireita(), conteudo)'
                // o qual tem retorno = a isso 'noAtual'

            }

            return noAtual;
        }

        private No maiorDosMenores(No maior, No retirado, No pai){

            if(maior.getDireita() == null){ //condicao de parada é chegar no maior
                maior.setDireita(retirado.getDireita());
                pai.setDireita(null);
                return maior;
            }else{

                return maiorDosMenores(maior.getDireita(), retirado, maior);

            }

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

