import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class test {
    @Test
    public void test1() throws IOException {

        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage login = new LoginPage();

        login.passWord.sendKeys("test");

        System.out.println("login.passWord.getAttribute(\"password\") = " + login.passWord.getAttribute("type"));

        Assert.assertEquals("password",login.passWord.getAttribute("type"));

        File file = login.passWord.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File("src/test/resources/screenshot.png"));


    }

}
