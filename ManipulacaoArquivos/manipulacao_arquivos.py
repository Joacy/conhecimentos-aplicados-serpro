entrada = "./dados/entrada/lista.txt"
arquivo = open(entrada, "r")
conteudo = arquivo.read().split("\n")

lista = []
for line in conteudo:
    lista.append(int(line))

arquivo.close()

saida = open("./dados/saida/lista_ordenada.txt", "w")
for numero in sorted(lista):
    saida.write(str(numero) + "\n")
saida.close()
