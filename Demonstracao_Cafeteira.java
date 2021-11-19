import java.util.Scanner;
public class Demonstracao_Cafeteira {

    /**
     * Função main que demonstra a classe cafeteira
     * 
     */
    public static void main(String[] args) {
        
        //Cria a cafeteira e o scanner
        System.out.println("Cafeteira em Java! ");
        Cafeteira cafeteira = new Cafeteira();
        Scanner teclado = new Scanner(System.in);

        // Loop de funcionamento do programa com o menu de opções
        while(true){
            
            System.out.println("Menu:");
            System.out.println(("1 - Ligar ou desligar a cafeteira"));
            System.out.println("2 - Adicionar Água");
            System.out.println("3 - Selecionar o sabor");
            System.out.println("4 - Selecionar o tamanho do cafe");
            System.out.println("5 - Fazer Café");
            System.out.println("6 - Sair");
            
            // Checa se o usuário digitou um valor inteiro e o guarda no inteiro opcao.
            is_it_Int(teclado);
            int opcao = teclado.nextInt();

            //Opção 1 Liga ou desliga a cafeiteira dependendo de seu estado inicial
            if(opcao == 1){
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligando Cafeteira...\n");
                }
                else{
                    System.out.println("Desligando Cafeteira...\n");
                }
                cafeteira.on_off();
            }

            //Opção 2 Adiciona água ao reservatório da cafeteira
            else if(opcao == 2){
                System.out.print("Digite o quanto de agua deseja adicionar (em ml): ");
                is_it_Int(teclado);
                int agua_adicionada = teclado.nextInt();
                System.out.printf("O repositório tem %dml\n",cafeteira.adiciona_Agua(agua_adicionada));
            }

            // Opção 3 Seleciona o sabor do café a ser feito
            else if(opcao == 3){
                // Checa se a cafeteira está desligada
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligue a cafeteira primeiro!");
                    continue;
                }
                // Apresenta ao usuario os sabores da cafeteira
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
                //Usa a função seleciona_sabor para guardar a informação do sabor na classe
                String sabor = sabores[index_sabor - 1];
                cafeteira.seleciona_sabor(sabor);
                System.out.printf("Sabor selecionado: %s\n",sabor);
            }

            // Opção 4 Seleciona o tamanho da porção do café a ser feito
            else if(opcao == 4){
                //Checa se a cafeteira está ligada
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligue a cafeteira primeiro!");
                    continue;
                }

                //Pega os niveis de café disponíveis e os apresenta na tela
                int[] niveis_cafe = cafeteira.getNiveisCafe();
                System.out.println("Porções:");
                for(int i = 0; i < niveis_cafe.length;i++){
                    System.out.printf("%d - %d ml. \n",i + 1,niveis_cafe[i]);
                }

                // Pede o input do usuario
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
                // Seleciona o nivel e guarda na classe essa informação
                cafeteira.seleciona_nivel_cafe(index_nivel - 1);
                System.out.printf("Tamanho selecionado : %d ml\n",niveis_cafe[index_nivel - 1]);

            }
            // Opção 5 Faz o café
            else if(opcao == 5){
                // Checa se o usuário ligou a cafeteira
                if(!cafeteira.get_on_off()){
                    System.out.println("Ligue a cafeteira primeiro!");
                    continue;
                }
                // Checa se o usuário escolheu um sabor
                if(cafeteira.getSaborEscolhido() == null){
                    System.out.println("Selecione um sabor para fazer o cafe!");
                    continue;
                }
                // Checa se o usuário escolheu um tamanho do café
                if(cafeteira.getquantidadeAguaCafe() == 0){
                    System.out.println("Selecione o tamanho do café!");
                    continue;
                }
                // Faz o café
                System.out.println(cafeteira.fazer_café());
            }

            // Opção 6 Fecha o programa
            else if(opcao == 6){
                System.out.println("Fechando o programa...\n");
                break;
            }
            // Qualquer outro inteiro será considerado como opção não encontrada
            else{
                System.out.println("Opcao nao encontrada...\n");
            }

        }
        
    }
    /**
     * Metodo que checa se usuário está digitando valores inteiros e 
     * fica em loop enquanto o usuário não digitar um valor inteiro.
     * @param teclado usa o scanner aberto no metodo main para pedir outras entradas do usuario
     */
    public static void is_it_Int(Scanner teclado){
        while(!teclado.hasNextInt()){
            System.out.print("Digite um inteiro válido: ");
            teclado.next();
        }
    }
    
}
