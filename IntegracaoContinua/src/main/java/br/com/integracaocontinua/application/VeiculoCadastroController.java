package br.com.integracaocontinua.application;

import br.com.integracaocontinua.domain.veiculo.Veiculo;
import br.com.integracaocontinua.domain.veiculo.VeiculoService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rafael
 */
@Named
@ViewScoped
public class VeiculoCadastroController implements Serializable {
    
    @Inject
    private VeiculoService veiculoService;
    
    private Veiculo veiculo;

    
    @PostConstruct
    public void construir() {
        veiculo = new Veiculo();
    }
    
    public void salvar() {
        veiculoService.salvar(veiculo);
        Mensagem.adicionarInformacao("Veiculo salvo com sucesso", "");
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
}
