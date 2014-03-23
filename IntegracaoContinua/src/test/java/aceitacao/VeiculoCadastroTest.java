package aceitacao;

import aceitacao.page.VeiculoCadastroPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author rafael
 */
public class VeiculoCadastroTest {
    
    public static String BASE_URL = "http://localhost:8080/IntegracaoContinua/";
    private static WebDriver browser;
    private VeiculoCadastroPage veiculoCadastroPage;
    
    @BeforeClass
    public static void abreBrowser() {
        browser = new FirefoxDriver();
    }

    @Before
    public void setUp() throws Exception {
        veiculoCadastroPage = new VeiculoCadastroPage(browser, BASE_URL);
    }

    @AfterClass
    public static void teardown() {
        browser.close();
    }
    
    @Test
    public void deveSalvarUmVeiculo() {
        veiculoCadastroPage.abre();
        veiculoCadastroPage.preencheFormulario("ABC-123");
        veiculoCadastroPage.deveMostrarSucesso("Veiculo salvo com sucesso");
        
    }
}
