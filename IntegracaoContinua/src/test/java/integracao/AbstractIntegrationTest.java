package integracao;




import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

/**
 *
 * @author rafael
 */
@RunWith(Arquillian.class)
public abstract class AbstractIntegrationTest {
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                        .addPackages(true, "br.com")
                        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                        .addAsResource("META-INF/persistence.xml");
    }
}
