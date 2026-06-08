ARVORE HEAP: 

* é uma arvore binaria com conceitos de ORDEM e FORMA.

   *ORDEM: o item de qualquer nó deve satisfazer uma relação de ordem com os nós filhos.
     *HEAP MAX: FILHOS >= FILHOS, sendo que a raiz é  o maior elemento.
     *HEAP MIN: PAI<= FILHOS, sendo que o pai é o menor elemento.

* FORMA: A arvore binaria tem seus nós folha, em nó maximo, em dois niveis( ou seja, somente o ultimo nivel pode estar incompleto)
  sendo quue as folhas devem estar o mais a esquerda possivel.

* FILA PRIORITARIA

  * ASSUME QUE:
     *O tamanho do heap(vetor) indica o numero de elementos no heap armazenado dentro do vetor.
      ou seja, embiora o [0...comprimento(A)-1] contenha numeros validos, nenhum elemento além de A[tamanhoDoVetor (A)-1]
    é um elemento do heap, sendo que tamanhoDoVetor(A) <= comprimento(A)

  * Complexidade:
     * Inserção em heap: O(log n) pois temos a ação nescessarioa de subir esse elemento, que vai no maximo até a raiz
        * Como é uma arvore bilaria a altura dela sempre vai ser log n na base doi. E essa altura define a complexidade de inserir
     * Inserção em lista linear ordenada 0(n).
     * inserção em lista linear não ordenada: O(1), mas a remoção exige 0(n)


  * Remoção:
     * No elemento de maior prioridade sempre vai buscar um elemento para substituir, sempre indicado pegar o ultimo elemento folha
       e depois reorganizar, fazendo a função descer comprando com os elementos da esquerda e a direita para fazer a troca ( na max damos prioridade pelo
       maior elemento e Min pelo menor) até que todas as regras sejam cumpridas
       * complexidade:
         * remoção em heap: O(log n)
         * Remoção em lista linear ordenada: O(1)
         * Remoção em lista linear não ordenada: O(n)
        
         * 
