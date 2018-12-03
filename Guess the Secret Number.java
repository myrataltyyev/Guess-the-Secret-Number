import java.util.Scanner;
import java.util.Random;
public class Homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int n=0, generate, gdig1, gdig2, gdig3;
		int point, hint, attempt, guess, position;
		int ndig1, ndig2, ndig3;
		char c='Y';
		
		while (c=='Y'){
			point=100; hint=2; attempt=1;
			generate = r.nextInt(900)+100;
			gdig1=generate/100;
			gdig2=generate/10%10;
			gdig3=generate%10;
			while (gdig1==gdig2 || gdig2==gdig3 || gdig1==gdig3){
				generate = r.nextInt(900)+100;
				gdig1=generate/100;
				gdig2=generate/10%10;
				gdig3=generate%10;
			}
			switch (c){
			case 'Y': 		
		do {
			System.out.print("Enter your guess (-1 to get a hint): ");
			n=s.nextInt();
			point-=10; guess=0; position=0;
			if (n==-1 && hint==2){
				System.out.printf("%d**\n",gdig1);
				hint--;
				point-=20;
			}
			else if (n==-1 && hint==1){
				System.out.printf("%d%d*\n",gdig1,gdig2);
				hint--;
				point-=20;
			}
			else if (n==-1 && hint==0)
				System.out.println("You don't have a hint!");
			ndig1=n/100;
			ndig2=n/10%10;
			ndig3=n%10;
			if (ndig1==gdig1 || ndig1==gdig2 || ndig1==gdig3){
				guess++;
				point+=5;
			}	
			if (ndig2==gdig1 || ndig2==gdig2 || ndig2==gdig3){
				guess++;
				point+=5;
			}	
			if (ndig3==gdig1 || ndig3==gdig2 || ndig3==gdig3){
				guess++;
				point+=5;
			}	
			
			if (ndig1==gdig1){
				position++;
				if (hint!=1)
					point+=10;
			}
			if (ndig2==gdig2){
				position++;
				if (hint!=0)
					point+=10;
			}	
			if (ndig3==gdig3){
				position++;
				point+=10;
			}	
			
			if (hint==2 && guess==0)
				point-=15;
			else if (hint==1 && guess==0 && n!=-1)
				point-=10;
			else if (hint==0 && guess==0 && n!=-1)
				point-=5;
			
			if ((n<100 || n>1000 || ndig1==ndig2 || ndig2==ndig3 || ndig1==ndig3) && n!=-1)
				System.out.println("Please, enter a valid number!");
			else {
				System.out.println("\tGuessed\tPositioned\tHints\tAttempts\tPoints");
				System.out.printf("%15d%11d%11d%11d%14d\n",guess,position,hint,attempt,point);
			}
			if (n!=generate)
				attempt++;
		} while (n!=generate && attempt<=10 && point>0);
		
		if (n==generate){
			System.out.printf("%d is the correct number!\n",generate);
			System.out.printf("Congratulations! You won %d points in %d attempts.\n",point,attempt);
			System.out.print("Do you want to play? Enter Y (=Yes) or N (=No): ");
			c=s.next().charAt(0);
			System.out.println();
		}
		else if (attempt>10){
			System.out.println("No more attempts left.");
			System.out.printf("%d was the correct number!\n",generate);
			System.out.println("Sorry! You lost the game...");
			c='N';
		} 
		else {
			System.out.println("No more points left.");
			System.out.printf("%d was the correct number!\n",generate);
			System.out.println("Sorry! You lost the game...");
			c='N';
		}
			break;
			case 'N': break;
			}
		}
		s.close();
	}
}
