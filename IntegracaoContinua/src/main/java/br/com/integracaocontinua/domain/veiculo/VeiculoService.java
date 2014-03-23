package br.com.integracaocontinua.domain.veiculo;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author rafael
 */
@Stateless
public class VeiculoService implements Serializable {
    
    @Inject
    private TodosVeiculos todosVeiculos;
    
    public Veiculo salvar(Veiculo veiculo) {
        return todosVeiculos.salvar(veiculo);
    }
    
    public List<Veiculo> buscarTodos() {
        return todosVeiculos.buscarTodos(Veiculo.class, "id");
    }
    
    
}
