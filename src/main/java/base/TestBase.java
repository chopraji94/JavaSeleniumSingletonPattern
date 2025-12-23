package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    protected WebDriver driver;
    public Properties properties;

    @BeforeClass
    public void launch() throws IOException {
        driver = DriverManager.getInstance().getDriver();

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/test.properties");
        properties = new Properties();
        properties.load(fs);

    }

    @BeforeMethod
    public void beforeMethod(Method method){
        long threadId = Thread.currentThread().getId();
        System.out.println("[Thread-" + threadId + "] Starting Method -> " + method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method){
        long threadId = Thread.currentThread().getId();
        System.out.println("[Thread-" + threadId + "] Finished Method -> " + method.getName());
    }

    @AfterClass
    public void close(){
        DriverManager.quitDriver();
    }
}
