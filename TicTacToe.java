import java.util.Scanner;
public class TicTacToe {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		FindWinner win = new FindWinner();
		int input = 0;
		//int flag = 0;
		int gameflag = 0; //used as the gameplay variable
		int computerflag = 0;
		int humanflag = 0;
		int i = 0; //general for loop variable
		int j =0; //general for loop variable
		int x = 0; //used in random generation of the computer's move
		int cnt = 0; //used to count the moves - odd will be computer move, even is the human move
		double n = 0.0; //used in random generation of the computer's move
		int row = 0; //used as the row variable for the array
		int col = 0; //used as the column variable for the array
		int w = 0; //used to see if we have a winner
		int [][] t = new int [4][4]; //the double subscripted array to represent the board
		String enter = ""; //general variable for our input from the user
		//Findwinner win = new Findwinner(); //new object for the class Findwinner
		//Note: Usually Classes start with Caps and methods start with lower case. 
		//row equation: (n-1)/3+1
		//column equation: ((n-1)%3+1)
		/* 
		 * 1	2	 3
		 * 4	5	 6
		 * 7	8	 9
		*/
		do
		{
			cls();
			for(i=0; i<=3; i++)
			{
				for(j=0; j<=3; j++)
				{
					t[i][j]=0;
				}
			}
			System.out.println("Tic Tac Toe");
			System.out.println("by Jenny Wang");
			System.out.println(" ");
			System.out.println("The board for the game: ");
			display(t);
			//System.out.printf("%5s %10s %10s\n", "1", "2", "3");
			//System.out.printf("%5s %10s %10s\n", "4", "5", "6");
			//System.out.printf("%5s %10s %10s\n", "7", "8", "9");
			System.out.println(" ");
			System.out.println("1. Play Tic Tac Toe");
			System.out.println("2. Quit");
			System.out.println(" ");
			System.out.print("Enter your option: ");
			enter= in.nextLine();
			try 
			{
				input = Integer.parseInt(enter);
			}
			catch(Exception err)
			{
				input = 3;
			}
			System.out.println(" ");
			switch (input)
			{
				case 1: //Play Tic Tac Toe
					gameflag = 0;
					cnt=0;
					do
					{
						cls();
						System.out.println("Play Tic Tac Toe");
						System.out.println("by Jenny Wang");
						System.out.println(" ");
						System.out.println("Computer will be playing first and 'X', while you will be 'O'");
						System.out.println(" ");
						computerflag = 0;
						humanflag = 0;
						//cnt=0;
						do 
						{
							if (cnt == 0) //first move
							{
								t[1][1]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if (cnt==2 && t[2][2]==0)// 1 -> 5
							{
								t[2][2]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if (cnt==2 && t[2][2]==1)// 1 -> 9 if 5=O
							{
								t[3][3]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if (cnt==4 && t[3][3]==0)// 1 -> 5 -> 9 
							{
								t[3][3]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if(cnt==4 && t[2][2]==1 && t[1][3]==1)
							{
								t[3][1]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if (cnt==4 && t[2][2]==1 && t[3][1]==1)
							{
								t[1][3]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if(cnt==6 && t[2][2]==1 && t[1][3]==1 &&t[3][2]==1 && t[3][1]==0)
							{
								t[3][1]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if(cnt==6 && t[2][2]==1 && t[2][3]==1 && t[3][1]==1)
							{
								t[1][3]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if(cnt==6 && t[2][2]==1 && t[2][1]==1 && t[1][3]==1 && t[3][1]==0)
							{
								t[3][1]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							if(cnt==6 && t[2][2]==1 && t[1][2]==1 && t[3][1]==1 && t[1][3]==0)
							{
								t[1][3]=-1;
								cnt++;
								computerflag=1;
								break;
							}
							//checking for winning move
							t[0][0]=-2;
							t[0][3]=0;
							w = win.winner(t);
							if(t[0][3]!=0)
							{
								row = (t[0][3]-1)/3+1;
								col = ((t[0][3]-1)%3+1);
								t[row][col]=-1;
								cnt++;
								computerflag = 1;
								break;
							}
							//checking for blocking move
							t[0][0]=2;
							t[0][3]=0;
							w=win.winner(t);
							if(t[0][3]!=0)
							{
								row = (t[0][3]-1)/3+1;
								col = ((t[0][3]-1)%3+1);
								t[row][col]=-1;
								cnt++;
								computerflag = 1;
								break;
							}
							//Make random move
							n = Math.random();
							x=(int)(n*9+1);
							row = (x-1)/3+1;
							col = ((x-1)%3+1);
							if (t[row][col]== 0)
							{
								t[row][col] = -1;
								cnt++;
								computerflag = 1;
								break;
							}
						} while (computerflag == 0);
						t[0][0]=-3;
						w = win.winner(t);
						if (w == -3)
						{
								System.out.println(" ");
								display(t);
								System.out.println(" ");
								System.out.println("I have won! Machine over man!");
								System.out.println(" ");
								System.out.print("Press enter to return to menu.");
								enter = in.nextLine();
								gameflag = 1;
								break;
							}
						display(t);
						System.out.println(" ");
						if (cnt == 9)
						{
							System.out.println("It's a tied game");
							gameflag = 1;
							System.out.println(" ");
							System.out.print("Press enter to return to menu.");
							enter = in.nextLine();
							break;
						}
						//System.out.print("Make your move: ");
						do 
						{
							System.out.print("Make your move: ");
							try 
							{
								enter= in.nextLine();
								x = Integer.parseInt(enter);	
							}
							catch(Exception err)
							{
								System.out.println("You made an error, press enter to try again");
								enter = in.nextLine();
								x =10;
							}
							if (x>=1 && x<=9)
							{
							 row = (x-1)/3+1;
							 col = ((x-1)%3+1);
								if (t[row][col]== 0)
								{
									t[row][col] = 1;
									cnt++;
									humanflag = 1;
									break;
								}
							}
						} while (humanflag == 0);	
						t[0][0]=3;
						w = win.winner(t);
						if (w == 3)
						{
							//System.out.println(" ");
							//display(t);
							System.out.println(" ");
							System.out.println("You (the human) won!");
							System.out.println(" ");
							System.out.print("Press enter to return to menu.");
							enter = in.nextLine();
							gameflag = 1;
							break;
						}
					} while (gameflag == 0);
					break;
				case 2: //Quit
					System.out.println("Thank you for using this program.");
					break;
				default:
					System.out.println("Choice must be 1 or 2.");
					System.out.println("Please enter to continue.");
					enter = in.nextLine();	
			} //switch
		} while (input != 2); //menu	
		in.close();
	}//main void
	public static void cls() 
	{
		for (int i=1; i<=50; i++)
		{
			System.out.println();
		}
	}
	public static void display(int[][]t)
	{
		//Display the board
		for (int i=1; i<=9; i++)
		{
			int row = (i-1)/3+1;
			int col = ((i-1)%3+1);
			if(t[row][col]==0)
			{
				System.out.printf("%10d",i);	
			}
			if(t[row][col]==-1)
			{
				System.out.printf("%10s","X");	
			}
			if(t[row][col]==1)
			{
				System.out.printf("%10s","O");	
			}
			if (i%3 == 0)
			{
				System.out.println(" ");
			}
		}
	}
}//TicTacToe