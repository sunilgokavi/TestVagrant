package rcb;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Player;
import pojo.Team;
import util.FileReader;
import java.io.IOException;
import java.util.List;

public class Solution2UsingPojoClasses {
    String        userDir           = System.getProperty( "user.dir" );
    String        jsonFilePath      = userDir+"/src/test/resources/data";
    String        jsonFileName      ="TeamRCB.json";
    String        jsonString;
    Team          team;
    List<Player>  playerList;
    @Test(priority = 1)
    public void assertFourForeignPlayers() throws IOException {
        jsonString= FileReader.readFileFromSystem(jsonFileName,jsonFilePath);
        Gson gson = new Gson();
        team =gson.fromJson(jsonString,Team.class);
        playerList= team.getPlayer();
        int count=0;
        for(Player p:playerList){
           if(!p.getCountry().equals("India")){
               count++;
           }
        }
        Assert.assertEquals(count,4,"Four players are not their in team");
        System.out.println("Four players are their in team");
    }
    @Test(priority = 2)
    public void assertOneWicketKeeper(){
        int count=0;
        for(Player p:playerList){
            if(p.getRole().equals("Wicket-keeper")){
                count++;
            }
        }
        Assert.assertTrue(count>=1,"At least one wicket keeper not their in team");
        System.out.println("At least one wicket keeper their in team");
    }
}
