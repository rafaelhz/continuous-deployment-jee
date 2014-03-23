package aceitacao.page;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author rafael
 */
public class VeiculoCadastroPage {
    
    private final String BASE_URL;

    private final WebDriver driver;

    public VeiculoCadastroPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.BASE_URL = baseUrl;
    }

    public void abre() {
        driver.get(BASE_URL + "veiculoCadastro.xhtml");
    }
    
    public void preencheFormulario(String placa) {
        WebElement form = form();
        form.findElement(By.id("placaIT")).sendKeys(placa);
        form.findElement(By.id("salvarBtn")).click();
    }
    
    public void deveMostrarSucesso(String mensagem) {
        WebElement mensagens = driver.findElement(By.className("ui-messages-info-summary"));

        assertThat(mensagens.getText(), containsString(mensagem));
    }
    
    private WebElement form() {
        return driver.findElement(By.id("cadastroForm"));
    }
}
