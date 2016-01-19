package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {
	private String nome;
	private int alunos;
	
	public int getAlunos() {
		return alunos;
	}
	
	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}
	
}

public class Teste {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online"); // 12
		palavras.add("casa do codigo"); // 14
		palavras.add("caelum"); // 6

		palavras.sort(String.CASE_INSENSITIVE_ORDER);

		palavras.forEach(System.out::println);

		//new Thread(()->System.out.println("Executando um Runnable")).start();
		
		System.out.println("--");
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Java Script", 150));
		cursos.add(new Curso("Java 8", 113));
		//cursos.add(new Curso("Java 7", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream().map(Curso::getNome).forEach(System.out::println);
		
		cursos.stream().mapToInt(Curso::getAlunos).distinct().forEach(System.out::println);
		
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.mapToInt(Curso::getAlunos)
			.sum();
		System.out.println(sum);
		
		Optional<Curso> optional = cursos.stream()
				.filter(c -> c.getAlunos() > 1000)
				.findAny();
		
		optional.ifPresent(c -> System.out.print(c.getNome()));
				
		cursos.stream()
		.filter(c -> c.getAlunos() > 1000)
		.findAny()
		.ifPresent(c -> System.out.println(c.getNome()));
				
		List<Curso> resultado = cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toList());
		System.out.println(resultado);
		
		System.out.println("--");
		
		Map<String, Integer> mapa = cursos.stream()
		.filter(c -> c.getAlunos() > 100)
		.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		System.out.println(mapa);
		
		Curso curso = cursos.stream().findFirst().orElse(null);
		System.out.println(curso);
		
		cursos.stream().mapToInt(c -> c.getAlunos()).average().ifPresent(System.out::println);
		List<Curso> listaCursos = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
		System.out.println(listaCursos);
		
		
		
	}

}

class ComparadorDeStringPorTamanho implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o2.length() - o1.length();
	}
}

class ConsumidorDeStrings implements Consumer<String> {
	@Override
	public void accept(String palavra) {
		System.out.println(palavra);
	}

}
