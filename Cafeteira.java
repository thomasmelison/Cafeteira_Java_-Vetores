import java.util.Scanner;
/** O CERTOf
 * 
 * Cafeteira
 * A classe cafeteira é uma classe que simula uma cafeteira que utiliza capsulas;
 * O atributo liga_desliga diz se a cafeteira está ligada ou não
 * O atributo nivel_agua diz o nivel de água no reservatório da cafeteira
 * O atributo nivel café é o quanto de água o café vai usar (são determinado pelo usuário)
 * O atributo nivel_agua_max guarda a constante do nivel maximo de agua que a cafeteira suporta
 */
public class Cafeteira {

    boolean botao_on_off;
    int nivel_agua;
    final String sabores[] = {"EXPRESSO", "MOCCHA", "DESCAFEINADO", "CAPUCCINO"};
    int[] nivel_cafe = {25,50,75,100,125};
    String sabor_escolhido;
    int quantidade_agua_cafe;

    //CRIA A CAFETEIRA--------------------------------------------------
    public Cafeteira(){
        botao_on_off = true;
        nivel_agua = 0;
    }
    // LIGA E DESLIGA A CAFETEIRA---------------------------------------
    public void on_off(){
        botao_on_off = !botao_on_off;
    }

    public boolean get_on_off(){
        return botao_on_off;
    }

    // ADICIONA AGUA ---------------------------------------------------
    public int adiciona_Agua(int agua_adicionada){
        if(nivel_agua + agua_adicionada > 500){
            System.out.println("Repositório de Agua Cheio!");
            nivel_agua = 500;
            return nivel_agua;
        }
        nivel_agua = nivel_agua + agua_adicionada;
        return nivel_agua;
    }



    //MOVIMENTACAO DE NIVEIS DO CAFE ------------------------------------------
    public int[] getNiveisCafe(){
        return nivel_cafe;
    }

    public void seleciona_nivel_cafe(int nivel_cafe){
        quantidade_agua_cafe = this.nivel_cafe[nivel_cafe];
    }

    // movimentacao dos sabores --------------------------------------------------------
    public String[] getSabores(){
        return sabores;
    }
    public boolean seleciona_sabor(String sabor){
        boolean sabor_valido = false;
        for(int i = 0 ; i < sabores.length; i++){
            if(sabor.equals( sabores[i] ) ){
                sabor_valido = true;
                break;
            }
        }
        if(sabor_valido == false){
            System.out.println("Sabor Inválido");
            return false;
        }
        sabor_escolhido = sabor;
        return true;
    }
    
    //Faz o cafe
    public String fazer_café(){
        if(nivel_agua - quantidade_agua_cafe < 0){
            System.out.println("Agua insuficiente para fazer o café!");
            return "Não foi possível fazer o café... tente adicionar mais água";
        }
        nivel_agua = nivel_agua - quantidade_agua_cafe;
        return "Café " + sabor_escolhido + " de " + quantidade_agua_cafe + "ml pronto!";
    }

    // reseta a configuração
    public void resetConfig(){
        quantidade_agua_cafe = 0;
        sabor_escolhido = null;
    }

}