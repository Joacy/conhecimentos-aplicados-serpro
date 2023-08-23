def selection_sort(A):
    for i in range(len(A) - 1):
        min_index = i
        for j in range(i + 1, len(A)):
            if (A[j] < A[min_index]):
                min_index = j
        A[i], A[min_index] = A[min_index], A[i]
        print(A)
    return A