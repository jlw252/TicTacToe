
public class FindWinner {
	public int winner(int[][]t) 
	{
		int w = 0;
	//checking rows
	for (int j=1; j<=3; j++)
	{
		w = 0;
		for (int i=1; i<=3; i++)
		{
			w = w +t[j][i];
		}
		if (w==t[0][0])
		{
			for(int i=1; i<=3; i++)
			{
				if(t[j][i]==0)
				{
					t[0][3]=(j-1)*3+i; //Opposite of original equation
				}
			}
			return w;
		}
	} //for rows
	
	
	//checking columns
	for (int i=1; i<=3; i++)
	{
		w = 0;
		for (int j=1; j<=3; j++)
		{
			w = w +t[j][i];
		}
		if (w==t[0][0])
		{
			for(int j=1; j<=3; j++)
			{
				if(t[j][i]==0)
				{
					t[0][3]=(j-1)*3+i; //Opposite of original equation
				}
			}
			return w;
		}
	} //for columns
	
	
	//checking diagonal 3 5 7
	w = 0;
		for (int i=1; i<=3; i++)
		{
			w = w +t[i][4-i]; //t[1][3]
		}
		if (w==t[0][0])
		{
			return w;
		} 
	//checking diagonal 1 5 9
		w = t[1][1]+t[2][2]+t[3][3];
		if (w == t[0][0])
		{
			return w;
		}
	w=0;	
	return w;
	}
}