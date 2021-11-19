/**
 * Classe que simula um vetor
 * author Thomas Mello thomasmelison@hotmail.com
 */

public class VetorInt {
    
    int[] vetor;
    
    
    /**
     * Construtor que inicializa um vetor com 10 posições
     */
    public VetorInt(){
        vetor = new int[10];
    }
    /**
     * Construtor que inicializa com um vetor de n posições
     * @param n numero de posições que o vetor sera inicializado
     */
    public VetorInt(int n){
        vetor = new int[n];
    }

    /**
     * Insere um valor i em um vetor, se tiver espaço vazio (elementos com valor 0), preenchendo-o
     * da esquerda para a direita
     * @param i é o valor a ser inserido no vetor
     */
    public void insere(int i){
        for(int j = 0; j < vetor.length; j++){
            if(vetor[j] == 0){
                vetor[j] = i;
                break;
            }
            if(j == vetor.length - 1){
                System.out.println("Capacidade máxima atingida.");
            }
        }
    }

    /**
     * Remove um valor i do vetor, se este existir no vetor, e desloca todos os elementos
     * do vetor que estão a direita do valor removido uma casa para a esquerda
     * @param i valor a ser removido do vetor
     */

    public void remove(int i){
        int j = 0;
        while(j < vetor.length){
            if(i == vetor[j]){
                vetor[j] = 0;
                break;
            }
            j++;
        }
        while(j < vetor.length - 1){
            vetor[j] = vetor[ j + 1 ];
            vetor[j + 1] = 0;
            j++;
        }
    }
    /**
     * Imprime o vetor no seguinte formato "[1,2,....,13]"
     */
    public void imprime(){
        System.out.print("[");
        int j = 0;
        while(j < vetor.length){
            if(j == vetor.length - 1){
                System.out.printf("%d]\n",vetor[j]);
                break;
            }
            System.out.printf("%d,",vetor[j]);
            j++;
        }
    }

    /**
     * Adiciona um valor i a todos os elementos do vetor
     * @param i valor a ser somado em todos os elementos
     */
    public void adiciona(int i){
        for(int j = 0 ; j < vetor.length; j++){
            vetor[j] = vetor[j] + i;
        }
    }
    /**
     * Multiplica todos os valores do vetor por um valor i.
     * @param i valor que todos elementos serão multiplicados.
     */
    public void multiplica(int i){
        for(int j = 0 ; j < vetor.length; j++){
            vetor[j] = vetor[j]*i;
        }
    }
    /**
     * Calcula o somatório(soma de todos elementos) do vetor e retorna para o usuario.
     * @return retorna o valor do somátorio do vetor.
     */
    public int somatorio(){
        int soma = 0;
        for(int j = 0; j < vetor.length; j ++){
            soma = soma + vetor[j];
        }
        return soma;
    }
    /**
     * Calcula o produtório(multiplicação entre todos os elementos do vetor) de todos 
     * os valores do vetor e retorna para o usuário
     * @return retorna o valor so produtório.
     */
    public int produtorio(){
        int produtorio = 1;
        for(int j = 0; j < vetor.length; j ++){
            produtorio = produtorio*vetor[j];
        }
        return produtorio;
    }
    /**
     * Calcula o tamanho já o ocupado no vetor ( valores diferentes de 0).
     * @return numero de elementos nao nulos no vetor(elementos já adicionados).
     */
    public int tamanho(){
        int elementos_inseridos = 0;
        for(int j = 0 ; j < vetor.length ; j++){
            if(vetor[j] != 0){
                elementos_inseridos++;
            }
        }
        return elementos_inseridos;
    }

    /**
     * Calcula a capacidade máxima do vetor (numero maximo de elementos que o vetor suporta).
     * @return o numero da capacidade máxima do vetor.
     */
    public int capacidade(){
        return vetor.length;
    }


    /**
     * Procura um elemento em determinada posição e retorna para o usuário (caso esteja dentro dos limites do vetor).
     * @param pos indice do elemento que o metodo irá acessar.
     * @return numero que se encontra no índice "pos" 
     */
    public int acessaInt(int pos){
        if(pos >= vetor.length || pos < 0){
            System.out.println("Indice Invalido");
            return 0;
        }
        return vetor[pos];
    }


}
