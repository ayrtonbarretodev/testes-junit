import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar(){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ayrton", LocalDate.now(),new BigDecimal("1000.00"));
        reajusteService.concederReajusteAnual(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoForBom(){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ayrton", LocalDate.now(),new BigDecimal("1000.00"));
        reajusteService.concederReajusteAnual(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoForOtimo(){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ayrton", LocalDate.now(),new BigDecimal("1000.00"));
        reajusteService.concederReajusteAnual(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
}
