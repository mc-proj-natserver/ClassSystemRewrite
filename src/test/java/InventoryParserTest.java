import me.eyrim.natserver.classsystemrewrite.inventoryparse.InventoryParser;
import me.eyrim.natserver.classsystemrewrite.inventoryparse.SkillTreeInventory;
import org.junit.jupiter.api.Test;

public class InventoryParserTest {
    @Test
    public void givenFilePath_whenSerializeInventory_thenCorrectInventoryObject() {
        SkillTreeInventory inv = InventoryParser.serializeInventory("C:\\Users\\gamin\\Desktop\\natserver\\ClassSystemRewrite\\src\\main\\resources\\testInventory.json");

        System.out.println("a");
    }
}
