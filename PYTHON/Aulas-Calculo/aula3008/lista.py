## LISTA
"""
Ao contrário das tuplas, as listas têm tamanho variável e seu conteúdo pode ser modificado diretamente no local. As lista são mutáveis você pode defini-las usando colchetes "[]" ou empregando a função de tipo "list".
"""

"""
Geralmente, função interna "list" é usada no processo de dados como uma maneira de materializar um iterador ou uma expressão geradora.
"""

a_list = [2, 3, 7, None]
print(a_list)

tup = ("foo", "bar", "baz")
b_list = list(tup)
print(b_list)

b_list[2] = "bass"
print(b_list)

## INCLUSÃO E REMOÇÃO DE ELEMENTOS
#  elementos podem ser acrescentados ao fim da lista com metodo "append". Podemos utilizar o metodo "insert" onde inserimos um elemento em um local especifico da lista.

# O indice de inserção deve estar entre 0 e o tamanho da lista, inclusive.

# Tome nota: "insert" é computacionalmente custoso se comparado com append, porque as referências dos elementos seguintes têm de ser deslocadas internamente para dar espaço para o novo elemento.

# A operação inversa a insert é "pop", que remove e retorna um elemento de um índice específico. Elementos também podem ser removidos pelo valor com "remove", que localiza a primeira ocorrência do valor e a remove da lista.

print()
c_list = ["foo", "bar", "baz"]
c_list.append("dwarf")
c_list.insert(1,'red')
print(c_list)

c_list.pop(2)

print(c_list)