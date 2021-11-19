import java.util.Scanner;
public class Demonstracao_Cafeteira {

    
    public static void main(String[] args) {
        

        System.out.println("Cafeteira em Java! ");
        Cafeteira cafeteira = new Cafeteira();
        Scanner teclado = new Scanner(System.in);
        while(true){
            
            System.out.println("Menu:");
            System.out.println(("1 - Ligar ou desligar a cafeteira"));
            System.out.println("2 - Adicionar Água:");
            System.out.println("3 - Selecionar o sabor");
            System.out.println("4 - Fazer Café");
            System.out.println("5 - Sair");
            
            
            int opcao = teclado.nextInt();

            if(opcao == 1){
                if(cafeteira.get_on_off()){
                    System.out.println("Ligando Cafeteira...");
                }
                else{
                    System.out.println("Desligando Cafeteira...");
                }
                cafeteira.on_off();
            }
            else if(opcao == 2){
                System.out.print("Digite o quanto de agua deseja adicionar (em ml): ");
                int agua_adicionada = teclado.nextInt();
                System.out.printf("O repositório tem %dml\n",cafeteira.adiciona_Agua(agua_adicionada));
            }
            else if(opcao == 3){

            }
            else if(opcao == 4){
                
            }
            else if(opcao == 5){
                System.out.println("Fechando o programa...");
                break;
            }
            else{
                System.out.println("Opcao nao encontrada...");
            }

        }
    }
    
}
