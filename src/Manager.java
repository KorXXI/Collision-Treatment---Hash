
public class Manager {
	
	private static int total = 0;
	private static int[][] header = new int[13][2];
	private static Produto[] produtos = new Produto[13];

	
	
	Produto azul = new Produto("azul", 12, 45.00);
	Produto verde = new Produto("verde", 13, 33.50);
	Produto bicicleta = new Produto("bicicleta", 15, 20.00);
	
	
	{
	
		
	insert(azul);
	insert(verde);
	insert(bicicleta);
	
	
	}
	
	public static void insert(Produto x)
	{
		int placement = x.getCodigo() % 13;
		int index = -1;
		if(total == 12)
		{
			System.out.println("A tabela está cheia! Não é possível inserir mais elementos.");
		}
		else
		{
			for(int i = 0; i < 12; i++) 	
			{//finds the next empty spot		
											
				if(produtos[i].getNext() == -2)     
				{//puts value into table
					produtos[i] = x;
					index = i;//keeps location of last value 				
					produtos[i].setNext(-1);
					total++;
					break;
				}
			}
			if(header[placement][1] != -1)  
			{//adjusts header
				if(header[placement][0] != header[placement][1])
				{//has two or more on the spot
					produtos[header[placement][1]].setNext(index);
					header[placement][1] = index;
				}
				if(header[placement][0] == header[placement][1])
				{//only has one value on the spot
					produtos[header[placement][0]].setNext(index);
					header[placement][1] = index;
					header[placement][0] = index; 
				}
			} else
			{
				header[placement][0] = index;
				header[placement][1] = index;
			}		
		}		
	}
	public static int rec_select(int x, int search)
	{ //searches others spots but first
		
		int placement = x % 13;
		int index = produtos[placement].getNext();
		
		if(search == x)
		{ //Found!
			return placement;
		}
		else if(index == -1 || index == -2)
		{//Not found!
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
				return -1;
		}
		if(produtos[header[placement][0]].getCodigo() == x) //searches first spot
		{//Found!
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
					
				} else 
				{
					produtos[header[placement][0]].setCodigo(0);
					produtos[header[placement][0]].setNext(-2);
					header[placement][0] = -1;
					header[placement][1] = -1;
					//Removed!
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
						
					} else 
					{
						produtos[header[placement][0]].setCodigo(0);
						produtos[header[placement][0]].setNext(-2);
						header[placement][0] = -1;
						header[placement][1] = -1;
						//Removed!
					}
				}
			}
		}
		
		
	}
}

