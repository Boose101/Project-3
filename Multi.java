import java.util.Random;
import java.util.Scanner;


public class Multi {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int bound = 15; // inclusive bound [1, bound]

        System.out.println("Supper fun math GAME!!!!!");

        System.out.println("Enter how many times you wan to be challenged!");
        int times = Integer.parseInt(scan.nextLine());

        Equation[] game = new Equation[times];
        int correct = 0;

        for (int i = 0; i < times; i++) {
            int m1 = rand.nextInt(bound) + 1;
            int m2 = rand.nextInt(bound) + 1;
            game[i] = new Equation(m1, m2, rand.nextInt(4), false);
            System.out.print(game[i].getEqi() + " = ");
            int userInput = Integer.parseInt(scan.nextLine());
            if(userInput == game[i].getAnswer()){
                game[i].getCorrect();
                correct++;
            }
            System.out.println("");

        }
        if(times != correct){
            System.out.println(correct + " out of " + times + " correct!");
            System.out.println("Please try again");
            for(int i = 0; i < times - correct;){
                if(!game[i].isCorrect()){
                    System.out.print(game[i].getEqi() + " = ");
                    int userInput = Integer.parseInt(scan.nextLine());
                    if(userInput == game[i].getAnswer()){
                        game[i].getCorrect();
                        correct++;
                    }
                    i++;
                }
            }
        }
        
        System.out.println(correct + " out of " + times + " correct!");
    }
    
}

class Equation{
    private String eqi;
    private int m1;
    private int m2;
    private int opp;
    private int ans;
    private boolean correct;

    public Equation(){
        eqi = "1 * 1";
        m1 = 1;
        m2 = 1;
        opp = 2;
        ans = 1;
        correct = false;
    }

    public Equation(int m1, int m2, int opp, boolean corr){
        String[] oppSort = {"+", "-", "*", "/"};
        eqi = m1 + " " + oppSort[opp] + " " + m2;
        this.m1 = m1;
        this.m2 = m2;
        this.opp = opp;
        correct = corr;

        if(opp == 0){
            ans = m1 + m2;
        }
        else if(opp == 1){
            ans = m1 - m2;
        }
        else if(opp == 2){
            ans = m1 * m2;
        }
        else if(opp == 3){
            ans = m1 / m2;
        }
    }

    public boolean isCorrect(){
        return correct;
    }

    public String getEqi() {
        return eqi;
    }

    public int getAnswer(){
        return ans;
    }

    public void getCorrect(){
        correct = true;
    }

}