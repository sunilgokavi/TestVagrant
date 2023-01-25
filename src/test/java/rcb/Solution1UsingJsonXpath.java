package rcb;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.FileReader;
import java.io.IOException;
import java.util.List;

public class Solution1UsingJsonXpath {
    String        userDir           = System.getProperty( "user.dir" );
    String        jsonFilePath      = userDir+"/src/test/resources/data";
    String        jsonFileName      ="TeamRCB.json";
    String        jsonString;
    @Test(priority = 1)
    public void assertFourForeignPlayers() throws IOException {
        jsonString= FileReader.readFileFromSystem(jsonFileName,jsonFilePath);
        JsonPath jsonPath = new JsonPath(jsonString);
        List<String> playersListByCountry=jsonPath.get("player.country");
        int count=0;
        for(int i=0;i<playersListByCountry.size();i++){
            if(!playersListByCountry.get(i).equals("India")){
                count++;
            }
        }
        Assert.assertEquals(count,4,"Four players are not their in team");
        System.out.println("Four players are their in team");
    }
    @Test(priority = 2)
    public void assertOneWicketKeeper(){
        JsonPath jsonPath = new JsonPath(jsonString);
        List<String> playersListByRole=jsonPath.get("player.role");
        int count=0;
        for(int i=0;i<playersListByRole.size();i++){
            if(playersListByRole.get(i).equals("Wicket-keeper")){
                count++;
            }
        }
        Assert.assertTrue(count>=1,"At least one wicket keeper not their in team");
        System.out.println("At least one wicket keeper their in team");
    }
}
