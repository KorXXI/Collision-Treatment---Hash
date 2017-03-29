import java.util.Scanner;

public class Manager {
	
	private static int total = 0;
	private static int[][] header = new int[13][2];
	private static Produto[] produtos = new Produto[13];

	public Manager(){;}
	
	Produto azul = new Produto("azul", 12, 45.00);
	Produto verde = new Produto("verde", 13, 33.50);
	Produto bicicleta = new Produto("bicicleta", 15, 20.00);
	
	Produto nil = new Produto();
	{
		for(int i = 0; i < 13; i++)
		{
			header[i][1] = -1;  //no address
			header[i][0] = -1;
			produtos[i] = nil;
		}
	}
	
	
	public static void insert(Produto x)
	{
		int placement = x.getCodigo() % 13;
		int index = -1;
		if(total != 13)
		{
			for(int i = 0; i < 12; i++) 	
			{//finds the next empty spot		
											
				if(produtos[i].getNext() == -2)     
				{//puts value into table
					produtos[i] = x;
					index = i;//keeps location of last value 				
					produtos[i].setNext(-1);
					total++;
					System.out.println("\nProduto inserido na tabela com código: " + produtos[i].getCodigo());
					break;
				}
			}
			if(header[placement][1] != -1)  
			{//adjusts header
				if(header[placement][0] != header[placement][1])
				{//has two or more on the spot
					produtos[header[placement][1]].setNext(index);
					header[placement][1] = index;
					System.out.println("\nHeader ajustado!");
				}
				if(header[placement][0] == header[placement][1])
				{//only has one value on the spot
					produtos[header[placement][0]].setNext(index);
					header[placement][1] = index;
					header[placement][0] = index; 
					System.out.println("\nHeader ajustado!");
				}
			} else
			{
				header[placement][0] = index;
				header[placement][1] = index;
				System.out.println("\nHeader ajustado!");
			}		
		}		
	}
	public static int rec_select(int x, int search)
	{ //searches others spots but first
		
		int placement = x % 13;
		int index = produtos[placement].getNext();
		
		if(search == x)
		{ //Found!
			System.out.println("\nProduto encontrado!");
			return placement;
		}
		else if(index == -1 || index == -2)
		{//Not found!
			System.out.println("\nProduto não encontrado!");
			return -1;
		}else
		{//Try again
			return rec_select(index, search);
		}
	}
	public static int select(int x)
	{
		int placement = (x % 13);
		int index = 0;
		if(header[placement][0] == -1) //makes sure invalid elements don't go OutOfBounds
		{//Not found!
			System.out.println("\nProduto não encontrado!");
				return -1;
		}
		if(produtos[header[placement][0]].getCodigo() == x) //searches first spot
		{//Found!
			System.out.println("\nProduto encontrado!");
			return placement;
		}	
		index = header[placement][0];
		return rec_select(index,x); 
	}
	public static void remove(int x)
	{
		if(select(x) != -3)
		{
			int placement = (x % 13);
			int index = 0;
			//first
			if(produtos[header[placement][0]].getCodigo() == x) //searches first spot
			{
				if(produtos[header[placement][0]].getNext() != -1) // first spot! Are there more?
				{
					index = produtos[header[placement][0]].getNext();
					int aux = produtos[index].getCodigo();
					int auxp = produtos[index].getNext();
					produtos[header[placement][0]].setNext(auxp);
					produtos[header[placement][0]].setCodigo(aux);
					produtos[index].setCodigo(0);
					produtos[index].setNext(-2);
					
					produtos[index].setNext(-2); //clears place
					//Removed!
					total--;
					System.out.println("\nProduto encontrado e removido!");
					
				} else 
				{
					produtos[header[placement][0]].setCodigo(-1);
					produtos[header[placement][0]].setNext(-2);
					header[placement][0] = -1;
					header[placement][1] = -1;
					//Removed!
					total--;
					System.out.println("\nProduto encontrado e removido!");
				}
			} else
			{
				//middle to final
				int key = select(x);
				if(produtos[key].getCodigo() == x) //searches key spot
				{
					if(produtos[key].getNext() != -1) // Key spot! Are there more?
					{
						index = produtos[header[placement][0]].getNext();
						int aux = produtos[index].getCodigo();
						int auxp = produtos[index].getNext();
						produtos[header[placement][0]].setNext(auxp);
						produtos[header[placement][0]].setCodigo(aux);
						
						produtos[index].setNext(-2); //clears place
						//Removed!
						total--;
						System.out.println("\nProduto encontrado e removido!");
						
					} else 
					{
						produtos[header[placement][0]].setCodigo(0);
						produtos[header[placement][0]].setNext(-2);
						header[placement][0] = -1;
						header[placement][1] = -1;
						//Removed!
						total--;
						System.out.println("\nProduto encontrado e removido!");
					}
				}
			}
		}
		
		
	}
	public void showTable()
	{
		System.out.println("Header");
		System.out.println("------------------------");
		System.out.println("0: Primeiro " + header[0][0] + " Último " + header[0][1]);
		System.out.println("1: Primeiro " + header[1][0] + " Último " + header[1][1]);
		System.out.println("2: Primeiro " + header[2][0] + " Último " + header[2][1]);
		System.out.println("3: Primeiro " + header[3][0] + " Último " + header[3][1]);
		System.out.println("4: Primeiro " + header[4][0] + " Último " + header[4][1]);
		System.out.println("5: Primeiro " + header[5][0] + " Último " + header[5][1]);
		System.out.println("6: Primeiro " + header[6][0] + " Último " + header[6][1]);
		System.out.println("7: Primeiro " + header[7][0] + " Último " + header[7][1]);
		System.out.println("8: Primeiro " + header[8][0] + " Último " + header[8][1]);
		System.out.println("9: Primeiro " + header[9][0] + " Último " + header[9][1]);
		System.out.println("10: Primeiro " + header[10][0] + " Último " + header[10][1]);
		System.out.println("11: Primeiro " + header[11][0] + " Último " + header[11][1]);
		System.out.println("12: Primeiro " + header[12][0] + " Último " + header[12][1]);
		System.out.println("------------------------");
		System.out.println("Table");
		System.out.println("------------------------");
		System.out.println("0: Chave " + produtos[0].getCodigo() + " Ponteiro " + produtos[0].getNext());
		System.out.println("1: Chave " + produtos[1].getCodigo() + " Ponteiro " + produtos[1].getNext());
		System.out.println("2: Chave " + produtos[2].getCodigo() + " Ponteiro " + produtos[2].getNext());
		System.out.println("3: Chave " + produtos[3].getCodigo() + " Ponteiro " + produtos[3].getNext());
		System.out.println("4: Chave " + produtos[4].getCodigo() + " Ponteiro " + produtos[4].getNext());
		System.out.println("5: Chave " + produtos[5].getCodigo() + " Ponteiro " + produtos[5].getNext());
		System.out.println("6: Chave " + produtos[6].getCodigo() + " Ponteiro " + produtos[6].getNext());
		System.out.println("7: Chave " + produtos[7].getCodigo() + " Ponteiro " + produtos[7].getNext());
		System.out.println("8: Chave " + produtos[8].getCodigo() + " Ponteiro " + produtos[8].getNext());
		System.out.println("9: Chave " + produtos[9].getCodigo() + " Ponteiro " + produtos[9].getNext());
		System.out.println("10: Chave " + produtos[10].getCodigo() + " Ponteiro " + produtos[10].getNext());
		System.out.println("11: Chave " + produtos[11].getCodigo() + " Ponteiro " + produtos[11].getNext());
		System.out.println("12: Chave " + produtos[12].getCodigo() + " Ponteiro " + produtos[12].getNext());
		System.out.println("------------------------");
	}
	public void menu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Trabalho de Algoritmos II - Encadeamento por Tabela de Header\n"
				+ "Aluno: Felipe Boff Nunes");
		boolean ativar = true;
		while(ativar)
		{
			int escolha = -1;
			do {
				switch(escolha)
				{
					default:System.out.println("\n"
							+ "--------------------\n"
							+ "1 - Inserir elemento.\n"
							+ "2 - Remover elemento.\n"
							+ "3 - Checar elemento por código.\n"
							+ "4 - Checar elemento por nome.\n"
							+ "5 - Listar todos elementos.\n"
							+ "6 - Produto mais barato.\n"
							+ "0 - Sair.\n\n\n"
							+ "Digite a opção desejada:");
							escolha = sc.nextInt();
							break;
							
					case 1: if(total == 12){System.out.println("A tabela está cheia! Não é possível inserir elementos.");escolha = -1;}
							System.out.println("Digite o nome do produto:"); 
							String nome = sc.next();
							System.out.println("\nDigite o setor do produto:");
							int setor = sc.nextInt();
							System.out.println("\nDigite o preço do produto:");
							double preco = sc.nextDouble();
							
							insert(new Produto(nome,setor,preco));
							System.out.println("\nPara voltar ao menu digite 0");
							String wait = sc.next();
							escolha = -1;
							break;
					
					case 2: System.out.println("\nDigite o código do produto que deseja remover:");
							//int codR = sc.nextInt();
							remove(sc.nextInt());
							System.out.println("\nPara voltar ao menu digite 0");
							wait = sc.next();
							escolha = -1;
							break;
					
					case 3:  System.out.println("\nDigite o código do produto que deseja consultar:");
							int codS = sc.nextInt();
							int placement = select(codS);
							if(placement != -1)
							{
								System.out.println("\nNome do produto: " + produtos[header[placement][0]].getNome());
								System.out.println("\nSetor do produto: " + produtos[header[placement][0]].getSetor());
								System.out.println("\nPreço do produto: " + produtos[header[placement][0]].getPreco());
								System.out.println("\nCódigo do produto: " + produtos[header[placement][0]].getCodigo());
								System.out.println("\nPara voltar ao menu digite 0");
								wait = sc.next();
								escolha = -1;
								break;
							}
							System.out.println("\nPara voltar ao menu digite 0");
							wait = sc.next();
							escolha = -1;
							break;
							
					case 4: System.out.println("\nNão implementado ainda!");
							System.out.println("\nPara voltar ao menu digite 0");
							wait = sc.next();
							escolha = -1;
							break;
							
					case 5: showTable();
							 System.out.println("\nPara voltar ao menu digite 0");
							 wait = sc.next();
							 escolha = -1;
							 break;
						
					case 8: escolha = 0;break;
				
				}
		} while (escolha != 0);
	}
}}

