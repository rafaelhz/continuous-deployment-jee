package br.com.integracaocontinua.application;

import br.com.integracaocontinua.domain.veiculo.Veiculo;
import br.com.integracaocontinua.domain.veiculo.VeiculoService;
import java.io.Serializable;
import java.util.List;
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
public class VeiculoConsultaController implements Serializable {
    
    @Inject
    private VeiculoService veiculoService;
    
    private List<Veiculo> veiculoLista;

    
    @PostConstruct
    public void construir() {
        veiculoLista = veiculoService.buscarTodos();
    }

    public List<Veiculo> getVeiculoLista() {
        return veiculoLista;
    }
    
    
}
