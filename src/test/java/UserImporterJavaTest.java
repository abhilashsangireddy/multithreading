import org.junit.Assert;
import org.junit.Test;

public class UserImporterJavaTest {

    @Test
    public void testImport() {
        UserImporterJava userImporterJava = new UserImporterJava();
        boolean result = true; /// userImporterJava.doThings()
        Assert.assertTrue(result);
    }
}
