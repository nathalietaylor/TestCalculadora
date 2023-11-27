import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class CalculadoraOnlineSomaTest {
    private WebDriver driver;
    private final int waitTime = 1500;

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
        WebElement inputNumero = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSoma = driver.findElement(By.xpath("//input[@value='+']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 1 + 1
        inputNumero.sendKeys("1");
        botaoSoma.click();
        inputNumero.sendKeys("1");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
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
        WebElement inputNumero = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSoma = driver.findElement(By.xpath("//input[@value='+']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 9 + 0 
        inputNumero.sendKeys("9");
        botaoSoma.click();
        inputNumero.sendKeys("0");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("9", resultado.getAttribute("value"));
    }

    @Test
    public void somaNegativosTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSoma = driver.findElement(By.xpath("//input[@value='+']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));
        WebElement botaoNegativo = driver.findElement(By.xpath("//input[@value='±']"));

        // Executando a operação -2 + -2
        inputNumero.sendKeys("2");
        botaoNegativo.click();
        botaoSoma.click();
        inputNumero.sendKeys("2");
        botaoNegativo.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("-4", resultado.getAttribute("value"));
    }

    @Test
    public void somaFloatTest() {
        // Localizando os elementos de entrada e botões
        WebElement botaoNumero1 = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement botaoPontoDecimal = driver.findElement(By.xpath("//input[@value=',']"));
        WebElement botaoNumero5 = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement botaoSoma = driver.findElement(By.xpath("//input[@value='+']"));
        WebElement botaoNumero2 = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));
        WebElement botaoNumero6 = driver.findElement(By.xpath("//input[@value='6']"));
        // Executando a operação: 1.5 + 2.6
        botaoNumero1.click();
        botaoPontoDecimal.click();
        botaoNumero5.click();
        botaoSoma.click();
        botaoNumero2.click();
        botaoPontoDecimal.click();
        botaoNumero6.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("4.1", resultado.getAttribute("value"));
    }

    @Test
    public void somaNumerosGrandesTest() {
        // Localizando os elementos de entrada e botões
        WebElement inputResultado = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoNumero9 = driver.findElement(By.xpath("//input[@value='9']"));
        WebElement botaoNumero7 = driver.findElement(By.xpath("//input[@value='7']"));
        WebElement botaoNumero8 = driver.findElement(By.xpath("//input[@value='8']"));
        WebElement botaoNumero5 = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement botaoSoma = driver.findElement(By.xpath("//input[@value='+']"));
        WebElement botaoNumero1 = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement botaoNumero2 = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement botaoNumero3 = driver.findElement(By.xpath("//input[@value='3']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação: 9785 + 123
        botaoNumero9.click();
        botaoNumero7.click();
        botaoNumero8.click();
        botaoNumero5.click();
        botaoSoma.click();
        botaoNumero1.click();
        botaoNumero2.click();
        botaoNumero3.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("9908", resultado.getAttribute("value"));
    }


    @After
    public void tearDown() {
        System.out.println("TearDown");
        // Fechando o navegador
        driver.quit();
    }

}
