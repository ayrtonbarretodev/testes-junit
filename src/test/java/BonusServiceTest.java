import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        Funcionario funcionario = new Funcionario("Ayrton", LocalDate.now(), new BigDecimal("25000"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);
        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        Funcionario funcionario = new Funcionario("Ayrton", LocalDate.now(), new BigDecimal("2500"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        Funcionario funcionario = new Funcionario("Ayrton", LocalDate.now(), new BigDecimal("10000"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);
        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
