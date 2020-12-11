import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<>();
	private int numOfGuesses = 0;

    public static void main(String[] args) throws IOException {
	DotComBust game = new DotComBust();
	game.setUpGame();
	game.startPlaying();

    }

    public void setUpGame(){
    	DotCom one = new DotCom();
    	one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		System.out.println("Ваша цель потопить три сайта");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Попытайтесь их потопить за минимальное количество попыток");

		for(DotCom dotComToSet : dotComList){
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
    }

    public void startPlaying() throws IOException {
    	while (!dotComList.isEmpty()){
    		String userGuess = helper.getUserInput("Сделайте ход");
    		checkUserGuess(userGuess);
		}
    	finishGame();
	}
	public void checkUserGuess(String userGuess){
    	numOfGuesses++;
    	String result = "Miss";
    	for(DotCom dotComToTest : dotComList){
    		result = dotComToTest.checkYourself(userGuess);
    		if(result.equals("hit")){
    			break;
			}
    		if(result.equals("sunk")){
    			dotComList.remove(dotComToTest);
    			break;
			}
		}
		System.out.println(result);

	}
	public void finishGame(){
		System.out.println("Все сайты потоплены");
		if(numOfGuesses <= 18){
			System.out.println("Это заняло у вас всего" + numOfGuesses + " попыток.");
		} else {
			System.out.println("Это заняло у вас долгое время " + numOfGuesses);
		}
	}

}
