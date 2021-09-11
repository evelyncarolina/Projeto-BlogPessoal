package turma29;

public class Nubank1 {

	public static void main(String[] args) {

		/*
		 * Formação do time com 3 pessoas
		 * 
		 * @author Evelyn Carolina
		 */
		int[] arrayPontuacao = { 14, 12, 10, 5, 20, 9, 30, 8, 15, 30 };
		int timeUm = 0;
		int timeDois = 0;
		int timeTres = 0;
		int somaTudo = 0;

		for (int x = 0; x < 4; x++) {
			if (arrayPontuacao[x] > timeUm) {
				timeUm = arrayPontuacao[x];
			}
		}

		for (int x = 6; x < 10; x++) {

			if (arrayPontuacao[x] > timeDois) {
				timeDois = arrayPontuacao[x];
			}
		}

		for (int x = 6; x < 10; x++) {

			if (arrayPontuacao[x] > timeTres) {
				timeTres = arrayPontuacao[x];
			}
		}

		somaTudo = timeUm + timeDois + timeTres;

		System.out.println("\nPotuação das pessoas selecionadas: " + somaTudo);

	}
}
