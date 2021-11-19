import java.util.Scanner;
public class Demonstracao_Cafeteira {

    // problema 1 - pode nao digitar um int
    // problema 2 index out of bounds3

    public static void main(String[] args) {
        

        System.out.println("Cafeteira em Java! ");
        Cafeteira cafeteira = new Cafeteira();
        Scanner teclado = new Scanner(System.in);
        while(true){
            
            System.out.println("Menu:");
            System.out.println(("1 - Ligar ou desligar a cafeteira"));
            System.out.println("2 - Adicionar Água");
            System.out.println("3 - Selecionar o sabor");
            System.out.println("4 - Selecionar o tamanho do cafe");
            System.out.println("5 - Fazer Café");
            System.out.println("6 - Sair");
            
            is_it_Int(teclado);
            int opcao = teclado.nextInt();

            if(opcao == 1){
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligando Cafeteira...\n");
                }
                else{
                    System.out.println("Desligando Cafeteira...\n");
                }
                cafeteira.on_off();
            }
            else if(opcao == 2){
                System.out.print("Digite o quanto de agua deseja adicionar (em ml): ");
                is_it_Int(teclado);
                int agua_adicionada = teclado.nextInt();
                System.out.printf("O repositório tem %dml\n",cafeteira.adiciona_Agua(agua_adicionada));
            }
            else if(opcao == 3){
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligue a cafeteira primeiro!");
                    continue;
                }

                String[] sabores = cafeteira.getSabores();
                System.out.println("Sabores:");
                for(int i = 0; i < sabores.length; i++){
                    System.out.printf("%d - %s\n", i+1 , sabores[i]);
                }

                // Checa se o usuario digitou um inteiro
                is_it_Int(teclado);
                // Checa se esse inteiro tem índice váldo
                int index_sabor = teclado.nextInt();
                while(index_sabor > sabores.length || index_sabor <= 0){
                    System.out.print("Digite um índice válido:");
                    is_it_Int(teclado);
                    index_sabor = teclado.nextInt();
                }
                
                String sabor = sabores[index_sabor - 1];
                cafeteira.seleciona_sabor(sabor);
                System.out.printf("Sabor selecionado: %s\n",sabor);
            }
            else if(opcao == 4){
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligue a cafeteira primeiro!");
                    continue;
                }
                int[] niveis_cafe = cafeteira.getNiveisCafe();
                System.out.println("Porções:");
                for(int i = 0; i < niveis_cafe.length;i++){
                    System.out.printf("%d - %d ml. \n",i + 1,niveis_cafe[i]);
                }
                System.out.print("Digite o tamanho da porção:");
                // Checa se o usuario digitou um inteiro
                is_it_Int(teclado);
                // Checa se esse inteiro tem índice váldo
                int index_nivel = teclado.nextInt();
                while(index_nivel > niveis_cafe.length || index_nivel <= 0){
                    System.out.print("Digite um índice válido:");
                    is_it_Int(teclado);
                    index_nivel = teclado.nextInt();
                }
                cafeteira.seleciona_nivel_cafe(index_nivel - 1);
                System.out.printf("Tamanho selecionado : %d ml\n",niveis_cafe[index_nivel - 1]);

            }
            else if(opcao == 5){
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligue a cafeteira primeiro!");
                    continue;
                }
                if(cafeteira.getSaborEscolhido() == null){
                    System.out.println("Selecione um sabor para fazer o cafe!");
                    continue;
                }
                if(cafeteira.getquantidadeAguaCafe() == 0){
                    System.out.println("Selecione o tamanho do café!");
                    continue;
                }
            
                System.out.println(cafeteira.fazer_café());
            }
            else if(opcao == 6){
                System.out.println("Fechando o programa...\n");
                break;
            }
            else{
                System.out.println("Opcao nao encontrada...\n");
            }

        }
        
    }
    public static void is_it_Int(Scanner teclado){
        while(!teclado.hasNextInt()){
            System.out.print("Digite um inteiro válido: ");
            teclado.next();
        }
    }
    
    
}
