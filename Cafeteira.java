import java.util.Scanner;
/**
 * Cafeteira
 * A classe cafeteira é uma classe que simula uma cafeteira que utiliza capsulas;
 * O atributo liga_desliga diz se a cafeteira está ligada ou não
 * O atributo nivel_agua diz o nivel de água no reservatório da cafeteira
 * O atributo nivel café é o quanto de água o café vai usar (são determinado pelo usuário)
 * O atributo nivel_agua_max guarda a constante do nivel maximo de agua que a cafeteira suporta
 */
public class Cafeteira {

    boolean botao_on_off;
    double nivel_agua;
    final String sabores[] = {"EXPRESSO", "MOCCHA", "DESCAFEINADO", "CAPUCCINO"};
    int[] nivel_cafe = {25,50,75,100,125};
    String sabor_escolhido;
    int quantidade_agua_cafe;

    //inicia sem agua
    public Cafeteira(){
        System.out.println("Cafeteira Criada!");
        botao_on_off = true;
        nivel_agua = 0.0;
    }

    // inicia com agua
    public Cafeteira(double nivel_agua){
        System.out.println("Cafeteira Criada!");
        botao_on_off = true;
        if(nivel_agua > 500.0){
            nivel_agua = 500.0;
            System.out.println("Repositorio de Agua Cheio!");
        }
        this.nivel_agua = nivel_agua ;
    }

    public void on_off(){
        botao_on_off = !botao_on_off;
    }

    // pode nao digitar um int
    public void seleciona_nivel_café(){
        System.out.println("Selecione o nível do café:");
        for(int i = 1; i <= nivel_cafe.length ; i++){
            System.out.printf("Nivel %d : %dml\n", i , nivel_cafe[i-1] );
        }
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nível: ");
        int nivel_escolhido = teclado.nextInt();
        quantidade_agua_cafe = nivel_cafe[nivel_escolhido];
    }

    public void adiciona_Agua(double agua_adicionada){
        if(nivel_agua + agua_adicionada > 500){
            System.out.println("Repositório de Agua Cheio!");
            nivel_agua = 500;
            return;
        }
        nivel_agua = nivel_agua + agua_adicionada;
    }

    public void fazer_café(Double sabor_escolhido,int nivel_cafe_escolhido ){
        
        if(nivel_cafe_escolhido < 0){
            System.out.println("Agua insuficiente para fazer o café!");
            nivel_agua = nivel_agua + nivel_cafe_escolhido*20;
            return;
        }


        
    }

}