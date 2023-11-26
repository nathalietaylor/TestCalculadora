import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class CalculadoraOnlineSomaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Configurando o driver do Selenium
        System.out.println("SetUp");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        // Navegando até o site
        driver.get("https://calculadora-digital.com.br/");

    }

    @Test
    public void somaDoisInteirosTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSoma = driver.findElement(By.xpath("//input[@value='+']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 1 + 1
        inputNumero1.sendKeys("1");
        botaoSoma.click();
        inputNumero1.sendKeys("1");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("2", resultado.getAttribute("value"));
    }

    @Test
    public void somaZeroTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSoma = driver.findElement(By.xpath("//input[@value='+']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 1 + 1
        inputNumero1.sendKeys("9");
        botaoSoma.click();
        inputNumero1.sendKeys("0");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("9", resultado.getAttribute("value"));
    }


    @After
    public void tearDown() {
        System.out.println("TearDown");
        // Fechando o navegador
        driver.quit();
    }

}
