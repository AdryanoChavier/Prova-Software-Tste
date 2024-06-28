package automatizados.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutosPO extends BasePO {

    public ProdutosPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn-adicionar")
    public WebElement btnAdicionar;

    @FindBy(id = "cadastro-produto")
    public WebElement modalCadastro;

    @FindBy(id = "btn-salvar")
    public WebElement btnSalvar;

    @FindBy(id = "btn-sair")
    public WebElement btnSair;

    @FindBy(css = ".alert-danger")
    public WebElement mensagemErro;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(css = "table tbody")
    public WebElement tabelaProdutos;

    public void Cadastro() {
        btnAdicionar.click();
    }

    public void fecharModalCadastro() {
        btnSair.click();
    }
    public boolean ProdutoNaTabela(String codigo) {
        return tabelaProdutos.getText().contains(codigo);
    }
  
    public void salvarProduto() {
        btnSalvar.click();
    }

    public String obterMensagemErro() {
        return this.mensagemErro.getText();
    }

    private void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
    public void Formulario(String codigo, String nome, String quantidade, String valor, String data) {
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);
    }
}
