import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    ReajusteService reajusteService;
    Funcionario funcionario;

    @BeforeEach //Essa anotação faz com que o JUnit execute esse método antes de executar cada método de teste
    public void inicializar() {
        System.out.println("Antes de cada teste!");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Ayrton", LocalDate.now(), new BigDecimal("1000.00"));
    }


    @AfterEach //Essa anotação faz com que o JUnit execute esse método após o fim de cada um dos testes
    public void finalizar(){
        System.out.println("Após cada teste!");
    }
    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Antes de todos os testes");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Após todos os testes");
    }

    @Test
    public void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar() {
        reajusteService.concederReajusteAnual(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoForBom() {
        reajusteService.concederReajusteAnual(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoForOtimo() {
        reajusteService.concederReajusteAnual(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
