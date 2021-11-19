import java.util.Scanner;
/** 
 * 
 * Cafeteira em Java
 * 
 * author Thomas Mello thomasmelison@hotmail.com
 * 
 * A classe cafeteira é uma classe que simula uma cafeteira 
 * O atributo botao_on_off diz se a cafeteira está ligada ou não
 * O atributo nivel_agua diz quanta água tem no reservatório
 * o atributo sabores tem uma lista de sabores possíveis para o café
 * O atributo nivel_café tem uma lista de tamanhos de porções de café
 * O atributo sabor_escolhido tem a string com o sabor escolhido
 * O atributo quantidade_agua_cafe é o nível escolhido para o tamanho do café
 */
public class Cafeteira {

    private boolean botao_on_off;
    private int nivel_agua;
    private final String sabores[] = {"EXPRESSO", "MOCCHA", "DESCAFEINADO", "CAPUCCINO"};
    private final int[] nivel_cafe = {25,50,75,100,125};
    private String sabor_escolhido;
    private int quantidade_agua_cafe;


    /**
     * Construtor que cria a cafeteira e seta algumas informações iniciais,
     *  como o nivel da água no reservatório.
     */
    public Cafeteira(){
        botao_on_off = true;
        nivel_agua = 0;
    }
    /**
     * Metodo que liga ou desliga a cafeteira.
     */
    public void on_off(){
        botao_on_off = !botao_on_off;
    }

    /**
     * Metodo que diz se a cafeteira está ligada ou desligada
     * @return valor booleano se a cafeteira está ligada (true) ou desligada (false)
     */
    public boolean get_on_off(){
        return botao_on_off;
    }

    /**
     * Metodo que adiciona água a cafeteira
     * @param agua_adicionada valor em ml da agua que será adicionada ao reservatorio
     * @return retorna o valor da quantidade de agua após a ação
     */
    public int adiciona_Agua(int agua_adicionada){
        if(nivel_agua + agua_adicionada > 500){
            System.out.println("Repositório de Agua Cheio!");
            nivel_agua = 500;
            return nivel_agua;
        }
        nivel_agua = nivel_agua + agua_adicionada;
        return nivel_agua;
    }

    /**
     * Metodo que retorna os valores das porções dos níveis do café
     * @return  retorna o vetor inteiro com todas as porções possíveis
     */
    public int[] getNiveisCafe(){
        return nivel_cafe;
    }

    /**
     * Seleciona uma porção para o café que será feito
     * @param nivel_cafe tem a informação do índice que corresponde a opção da porção
     * escolhida na lista nivel_cafe .
     */
    public void seleciona_nivel_cafe(int nivel_cafe){
        quantidade_agua_cafe = this.nivel_cafe[nivel_cafe];
    }

    /**
     * Retorna o valor da porção que foi escolhida
     * @return valor da porção até entao escolhida
     */
    public int getquantidadeAguaCafe(){
        return quantidade_agua_cafe;
    }

    /**
     * Retorna a lista de todos possíveis sabores a serem escolhidos
     * @return lista com a string de todos os sabores
     */
    public String[] getSabores(){
        return sabores;
    }
    
    /**
     * Retorna o sabor até entao escolhido
     * @return string com o sabor escolhido
     */
    public String getSaborEscolhido(){
        return sabor_escolhido;
    }

    /**
     * Seleciona o sabor escolhido com base na lista de sabores possíveis
     * @param sabor string com o nome do sabor
     */
    public void seleciona_sabor(String sabor){
        boolean sabor_valido = false;
        for(int i = 0 ; i < sabores.length; i++){
            if(sabor.equals( sabores[i] ) ){
                sabor_valido = true;
                break;
            }
        }
        if(sabor_valido == false){
            System.out.println("Sabor Inválido");
            return ;
        }
        sabor_escolhido = sabor;
        return ;
    }
    
    /**
     * Metodo que faz o café.
     * @return retorna uma string dizendo se foi possível fazer o café.
     */
    public String fazer_café(){
        if(nivel_agua - quantidade_agua_cafe < 0){
            System.out.println("Agua insuficiente para fazer o café!");
            return "Não foi possível fazer o café... tente adicionar mais água";
        }
        nivel_agua = nivel_agua - quantidade_agua_cafe;
        return "Café " + sabor_escolhido + " de " + quantidade_agua_cafe + " ml pronto!";
    }
   

}