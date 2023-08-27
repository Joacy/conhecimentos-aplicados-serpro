import java.util.HashMap;

public class algoritmos {
    	
    private static HashMap<Integer, Long> tabelaFibonacci = new HashMap<Integer, Long>();

	public static void main(String[] args) {

//		int numeroFibonacci = 92;
//		System.out.println(fibonacci(numeroFibonacci));
		
//		System.out.println(palindromo("ada"));
//		System.out.println(palindromo("teste"));
//		System.out.println(palindromo("A man, a plan, a canal. Panama"));

		
		int[] vetor = new int[] {1, 2, 7, 9, 100, 200, 300, 400};
		
		System.out.println(buscaBinaria(0, vetor));
		System.out.println(buscaBinaria(7, vetor));
		System.out.println(buscaBinaria(300, vetor));
		System.out.println(buscaBinaria(500, vetor));
		
		
	}
	
	public static long fibonacci(int numeroFibonacci) {
		if(numeroFibonacci <= 1)
			return numeroFibonacci;
		
		if(tabelaFibonacci.containsKey(numeroFibonacci))
			return tabelaFibonacci.get(numeroFibonacci);
		
		
		long calculoFibonacci = fibonacci(numeroFibonacci - 1) + fibonacci(numeroFibonacci - 2);
		
		tabelaFibonacci.put(numeroFibonacci, calculoFibonacci);
		
		return calculoFibonacci;
	}
	
	public static boolean palindromo(String palavraOriginal) {
		
        String naoAlfanumericos = "[^A-Za-z0-9_]";
        palavraOriginal  = palavraOriginal.replaceAll(naoAlfanumericos, "");
        palavraOriginal = palavraOriginal.replace(" ", "");

        //Método safe
//		StringBuilder palavraReversa = new StringBuilder();
//		
//		for(int i = palavraOriginal.length() - 1; i >= 0; i--) {
//			palavraReversa.append(palavraOriginal.charAt(i));
//		}		
//		return palavraOriginal.equalsIgnoreCase(palavraReversa.toString());
		
        //Método sênior kk
        return palavraOriginal.equalsIgnoreCase(new StringBuilder(palavraOriginal).reverse().toString());
	}
	
	public static boolean buscaBinaria(int buscado, int[] vetor) {
		
		int inicio = 0;
		int fim = vetor.length - 1;
		
		int meio;
		
		boolean achou = false;
		
		while(inicio <= fim) {
			meio =  (int) ((fim + inicio)/2);
			
			if(vetor[meio] == buscado) {
				achou = true;
				break;
			}else if(buscado > vetor[meio]) {
				
				inicio = meio + 1;
				
			}else {
				
				fim = meio - 1;
			}
		}
		
		return achou;
		
	}
}
