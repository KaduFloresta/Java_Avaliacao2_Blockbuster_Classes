import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class Locacao {
	// Atributos
	int idLoc = 0;
	Cliente cliente;
	String dataLoc;
	String dataDevolucao;
	Double valorTotal;

	List<Filme> filmes = new ArrayList<>();
	Calendar dataX = Calendar.getInstance();

	// Construtor
	Locacao(int idLoc, Cliente cliente) {

		this.idLoc = idLoc;
		this.cliente = cliente;

		this.cliente.adicionarLocacao(this);
	}

	// Lista de Filmes
	void AdicFilme(Filme filme) {
		this.filmes.add(filme);
	}

	// Método com o Valor total das locações (Preço)
	double PrecoTotal() {
		double total = 0;
		for (Filme filme : filmes) {
			total += filme.valorLoc;
		}
		return total;
	}

	// Método com a quantidade de filmes locados
	int QtdeFilmesLoc() {
		return this.filmes.size();
	}

	// A data de devolução deverá ser calculada com base na Data de Locação
	// e a quantidade de dias para Devolução que o cliente tem disponível
	// na locadora.
	String calculoData() {
		Date dataAtual = new Date();
		dataX.setTime(dataAtual);
		dataX.add(Calendar.DATE, cliente.diaDev);

		// Formatando a impressão da data
		DateFormat dataEdit = DateFormat.getDateInstance(DateFormat.SHORT);

		return dataEdit.format(dataX.getTime());
	}
}