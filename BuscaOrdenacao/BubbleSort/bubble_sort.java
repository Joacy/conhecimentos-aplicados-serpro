package BuscaOrdenacao.BubbleSort;

class BubbleSort {
    public static void main(String[] args) {
        int[] v = { 5, 2, 4, 3, 10, 9, 7, 8, 1, 6 };
        BubbleSort bs = new BubbleSort();

        bs.ordenar(v);

        for (int num : v) {
            System.out.print(num + " ");
        }
    }

    public void ordenar(int[] v) {
        for (int i = v.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (v[j + 1] < v[j]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
    }
}