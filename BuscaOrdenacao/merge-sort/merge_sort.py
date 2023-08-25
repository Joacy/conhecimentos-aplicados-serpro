def merge(D, L, R):
    li, ri = 0, 0
    for i in range(len(D)):
        if (li >= len(L)):
            D[i] = R[ri]
            ri = ri + 1
        elif (ri >= len(R)):
            D[i] = L[li]
            li = li + 1
        else:
            if (L[li] < R[ri]):
                D[i] = L[li]
                li = li + 1
            else:
                D[i] = R[ri]
                ri = ri + 1
    return D

def merge_sort(A):
    if (len(A) > 1):
        L = A[:(len(A)//2)]
        R = A[(len(A)//2):]
        merge_sort(L)
        merge_sort(R)
        merge(A, L, R)
    return A
