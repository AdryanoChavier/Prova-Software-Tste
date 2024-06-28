package automatizados.test;

import automatizados.pageObject.ProdutosPO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ProdutoTeste2{

    private WebDriver driver;
    private ProdutosPO produtosPO;
    private String PATH_DRIVE = "src/test/resources/chromedriver.exe";

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/36124872022.2n/Downloads/sistema/produtos.html#");
        produtosPO = PageFactory.initElements(driver, ProdutosPO.class);
    }
    
    @After
    public void tearDown2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void deveAdicionarProdutoNaTabela() {
        produtosPO.Cadastro();
        produtosPO.Cadastro();
        produtosPO.Formulario("1258", "Arroz com Bombom", "150", "1543.245", "2024-06-28");
        produtosPO.salvarProduto();
        Assert.assertTrue(produtosPO.ProdutoNaTabela("1258"));
    }
}
