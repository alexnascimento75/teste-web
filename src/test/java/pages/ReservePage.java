package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage extends Base{
// Construtor
    public ReservePage(WebDriver driver) {
        super(driver);
    }
// Mapeamento dos Elementos
// Apenas a frase que diz a origem e o destino
    public By byCabecalhoListaDeVoos = By.cssSelector("div.container h3");
// Ação
    public String lerCabecalhoListaDeVoos(){
        return driver.findElement(byCabecalhoListaDeVoos).getText();
    }
// Título da Guia Reserve
    public String lerTituloGuia(){
        return driver.getTitle();

    }
}
