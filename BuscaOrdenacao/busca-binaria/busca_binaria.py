def busca_binaria(lista, chave, inicio, final):
    while inicio <= final:
        meio = (inicio + final)//2
        if lista[meio] == chave:
            return meio
        elif lista[meio] < chave:
            inicio = meio + 1
        else:
            final = meio - 1
    return -1
