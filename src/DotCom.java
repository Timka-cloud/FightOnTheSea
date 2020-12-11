import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    String checkYourself(String userInput){
        String result = "Miss";
       int index = locationCells.indexOf(userInput);
       if(index >= 0){
           locationCells.remove(index);
       }
       if(locationCells.isEmpty()){
           result = "sunk";
           System.out.println("Вы потопили " + name);
       } else{
           result = "hit";
       }

       return result;

}
    void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }
    public void setName(String n){
        name = n;
    }

}
