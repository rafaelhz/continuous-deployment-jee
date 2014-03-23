package integracao;


import br.com.integracaocontinua.domain.veiculo.Veiculo;
import br.com.integracaocontinua.domain.veiculo.VeiculoService;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.transaction.UserTransaction;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rafael
 */
public class VeiculoServiceTest extends AbstractIntegrationTest {
    
    @EJB
    private VeiculoService veiculoService;
    
    @Resource
    private UserTransaction transacao;
    
    @Before
    public void inicializar() throws Exception {
        transacao.begin();
    }
    
    @After
    public void finalizar() throws Exception {
        transacao.rollback();
    }
    
    @Test
    public void deveSalvarUmVeiculo() {
        Veiculo veiculo = veiculoService.salvar(umVeiculo());
        assertNotNull(veiculo);
    }
    
    @Test
    public void deveEncontrarUmVeiculo() {
        veiculoService.salvar(umVeiculo());
        List<Veiculo> veiculoLista = veiculoService.buscarTodos();
        assertFalse(veiculoLista.isEmpty());
    }
    
    public Veiculo umVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("AAA-1111");
        return veiculo;
    }

    
}
