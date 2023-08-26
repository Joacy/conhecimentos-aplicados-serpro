import unittest

# Binary search algorithm
def busca_binaria(lista_ordenada, chave, inicio, final):
    while inicio <= final:
        meio = (inicio + final)//2
        if lista_ordenada[meio] == chave:
            return meio
        elif lista_ordenada[meio] < chave:
            inicio = meio + 1
        else:
            final = meio - 1
    return -1


lista_ordenada = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]


class TestBuscaBinaria(unittest.TestCase):
    def test_busca_valor_existente(self):
        self.assertEqual(9, busca_binaria(
            lista_ordenada, 10, 0, len(lista_ordenada) - 1))

    def test_busca_valor_inexistente(self):
        self.assertEqual(-1, busca_binaria(
            lista_ordenada, 20, 0, len(lista_ordenada) - 1))


if __name__ == '__main__':
    unittest.main()
