package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Datas {
	
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadasDoRio = LocalDate.of(2016, Month.JUNE, 5);

		int anos = olimpiadasDoRio.getYear() - hoje.getYear();
		System.out.println(anos);
		Period periodo = Period.between(hoje, olimpiadasDoRio);
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		LocalDate proximasOlimpiadas = olimpiadasDoRio.plusYears(4);
		System.out.println(proximasOlimpiadas);
		System.out.println(ChronoUnit.DAYS.between(hoje, olimpiadasDoRio));
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = proximasOlimpiadas.format(formatador);
		System.out.println(valorFormatado);
		
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss");
		System.out.println(formatadorComHoras.format(agora));
		
		YearMonth anoMes = YearMonth.of(2015,Month.JANUARY);
		LocalTime almoco = LocalTime.of(15, 30);
		System.out.println(almoco);
		
		LocalDate dataEspecifica = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(dataEspecifica);
		LocalDate hoje2 = LocalDate.now();
		Period periodo2 = Period.between(hoje2, dataEspecifica);
		System.out.println(periodo2);
		
		
		DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatador2.format(hoje));
		
		System.out.println("--*");
		
		LocalDate inicioFerias = LocalDate.of(2015, 12, 13);
		System.out.println(inicioFerias.plusDays(30));
		
	}
	
}
