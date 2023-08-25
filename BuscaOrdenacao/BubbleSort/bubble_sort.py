def bubble_sort(A):
    troca = 0
    for i in range(len(A)-1, 0, -1):
        for j in range(0, i):
            if (A[j+1] < A[j]):
                troca += 1
                A[j], A[j+1] = A[j+1], A[j]
        print(A)
    return A