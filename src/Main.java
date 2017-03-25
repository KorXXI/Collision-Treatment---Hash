
class Main
{
	private static int[][] content = new int[13][2];
	private static int[][] header = new int[13][2];
	private static int total = 0;
	public static void main (String[] args)
	{
		//Prime = 13		
		for(int i = 0; i < 13; i++)
		{
			header[i][1] = -1;  //no address
			header[i][0] = -1;
			content[i][1] = -2; //empty
		}
		insert(17);
		insert(28);
		insert(23);
		insert(33);
		insert(46);
		insert(13);
		insert(15);
		insert(16);
		insert(5);
		insert(41);
		insert(11);
		System.out.println("Header");
		System.out.println("------------------------");
		System.out.println("1: Tonico " + header[0][0] + " Ramona " + header[0][1]);
		System.out.println("2: Tonico " + header[1][0] + " Ramona " + header[1][1]);
		System.out.println("3: Tonico " + header[2][0] + " Ramona " + header[2][1]);
		System.out.println("4: Tonico " + header[3][0] + " Ramona " + header[3][1]);
		System.out.println("5: Tonico " + header[4][0] + " Ramona " + header[4][1]);
		System.out.println("6: Tonico " + header[5][0] + " Ramona " + header[5][1]);
		System.out.println("7: Tonico " + header[6][0] + " Ramona " + header[6][1]);
		System.out.println("8: Tonico " + header[7][0] + " Ramona " + header[7][1]);
		System.out.println("9: Tonico " + header[8][0] + " Ramona " + header[8][1]);
		System.out.println("10: Tonico " + header[9][0] + " Ramona " + header[9][1]);
		System.out.println("11: Tonico " + header[10][0] + " Ramona " + header[10][1]);
		System.out.println("12: Tonico " + header[11][0] + " Ramona " + header[11][1]);
		System.out.println("13: Tonico " + header[12][0] + " Ramona " + header[12][1]);
		System.out.println("------------------------");
		System.out.println("Table");
		System.out.println("------------------------");
		System.out.println("1: Chave " + content[0][0] + " Ponteiro " + content[0][1]);
		System.out.println("2: Chave " + content[1][0] + " Ponteiro " + content[1][1]);
		System.out.println("3: Chave " + content[2][0] + " Ponteiro " + content[2][1]);
		System.out.println("4: Chave " + content[3][0] + " Ponteiro " + content[3][1]);
		System.out.println("5: Chave " + content[4][0] + " Ponteiro " + content[4][1]);
		System.out.println("6: Chave " + content[5][0] + " Ponteiro " + content[5][1]);
		System.out.println("7: Chave " + content[6][0] + " Ponteiro " + content[6][1]);
		System.out.println("8: Chave " + content[7][0] + " Ponteiro " + content[7][1]);
		System.out.println("9: Chave " + content[8][0] + " Ponteiro " + content[8][1]);
		System.out.println("10: Chave " + content[9][0] + " Ponteiro " + content[9][1]);
		System.out.println("11: Chave " + content[10][0] + " Ponteiro " + content[10][1]);
		System.out.println("12: Chave " + content[11][0] + " Ponteiro " + content[11][1]);
		System.out.println("13: Chave " + content[12][0] + " Ponteiro " + content[12][1]);
		System.out.println("------------------------");
		select(41);
		select(17);
		select(28);
		select(11);
		select(99);
		select(44);

		
		
	}
	public static void insert(int x)
	{
		int placement = x%13;
		int index = -1;
		if(total == 12)
		{
			System.out.println("A tabela está cheia! Não é possível inserir mais elementos.");
		}
		else
		{
			for(int i = 0; i < 12; i++) 	//finds the next empty spot
			{								
											
				if(content[i][1] == -2)     //puts value into table
				{
					content[i][0] = x;
					index = i; 				//keeps location of last value
					content[i][1] = -1;
					total++;
					break;
				}
			}
			if(header[placement][1] != -1)  //adjusts header
			{
				if(header[placement][0] != header[placement][1])//has two or more on the spot
				{
					content[header[placement][1]][1] = index;
					header[placement][1] = index;
				}
				if(header[placement][0] == header[placement][1])//only has one value on the spot
				{
					content[header[placement][0]][1] = index;
					header[placement][1] = index;
				}
			} else
			{
				header[placement][0] = index;
				header[placement][1] = index;
			}		
		}		
	}
	
	public static boolean rec_select(int key, int search){
		
		int current = content[key][0];
		int index = content[key][1];
		
		if(search == current){
			System.out.println("Achei rec");
			return true;
		}
		else if(index == -1 || index == -2)
		{
			System.out.println("Não achei");
			return false;
		}else
		{
			return rec_select(index, search);
		}
		
	}	
	public static boolean select(int x)
	{
		int placement = (x % 13);
		int index = 0;
		if(content[header[placement][0]][0] == x)
		{
			System.out.println("Achei de primeira");
			return true;
		}	
		index = header[placement][0];
		return rec_select(index,x);
	}			
	public static void remove(int x)
	{
		if(select(x))
		{
			
		}
		
		
	}
} 