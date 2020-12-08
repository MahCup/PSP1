package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SistemaCompeticoes {

	private Integer nParticipantes;
	private Integer nClassificados;
	private Double pontuacao;
	private List<Double> pontuacoes = new ArrayList<Double>();
	private Integer nVencedores = 0;

	public SistemaCompeticoes() {
		readData();
	}
	
	public SistemaCompeticoes(int nParticipantes, int nClassificados, List<Double> pontuacoes) {
		this.nParticipantes = nParticipantes;
		this.nClassificados = nClassificados;
		this.pontuacoes = pontuacoes;
		this.nVencedores = classified();
	}
	
	public Integer getVencedores() {
		return nVencedores;
	}

	public void readData() {
		Scanner scanner = new Scanner(System.in);
		nParticipantes = Integer.parseInt(scanner.nextLine());
		nClassificados = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < nParticipantes; i++) {
			pontuacao = Double.parseDouble(scanner.nextLine());
			pontuacoes.add(pontuacao);
		}
		nVencedores = classified();
		relatorio();
	}

	public void relatorio() {
		// número de classificados
		System.out.println(classified());
		// desvio padrão
		System.out.println(String.format(Locale.US, "%.2f", standardDeviation(nVencedores)));
		// media aritmetica classificados
		System.out.println(String.format(Locale.US, "%.2f", arithmeticAverage(nVencedores)));
		// desvio padrão geral
		System.out.println(String.format(Locale.US, "%.2f", standardDeviation()));
		// media aritmetica geral
		System.out.println(String.format(Locale.US, "%.2f", arithmeticAverage()));
	}
	
	public int classified() {
		int nVencedores = nClassificados;
		Collections.sort(pontuacoes);
		for (int i = nClassificados - 1; i < nParticipantes - 1; i++) {
			if (pontuacoes.get(nClassificados - 1).equals(pontuacoes.get(i + 1))) {
				nVencedores++;
			}
		}
		return nVencedores;
	}

	public double arithmeticAverage(int pos2) {
		Double sum = 0.0;
		for (int i = 0; i < pos2; i++) {
			sum += pontuacoes.get(i);
		}
		return sum / (double) pos2;
	}
	
	public double arithmeticAverage() {
		Double sum = 0.0;
		for (int i = 0; i < pontuacoes.size(); i++) {
			sum += pontuacoes.get(i);
		}
		return sum / (double) pontuacoes.size();
	}

	public double standardDeviation(int pos2) {
		Double standardDeviation = 0.0;
		Double mean = arithmeticAverage(pos2);
		for (int i = 0; i < pos2; i++) {
			standardDeviation = standardDeviation + Math.pow((pontuacoes.get(i) - mean), 2);
		}
		return Math.sqrt(standardDeviation / pos2);
	}
	
	public double standardDeviation() {
		Double standardDeviation = 0.0;
		Double mean = arithmeticAverage(pontuacoes.size());
		for (int i = 0; i < pontuacoes.size(); i++) {
			standardDeviation = standardDeviation + Math.pow((pontuacoes.get(i) - mean), 2);
		}
		return Math.sqrt(standardDeviation / pontuacoes.size());
	}
}
