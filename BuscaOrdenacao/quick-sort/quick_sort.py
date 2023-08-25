def quick_sort(A, i=0, j=None):
    if i < j:
        l = i
        p = j
        r = j - 1
    while l <= r:
        while l <= r and A[l] < A[p]:
            l = l + 1
        while l <= r and A[r] > A[p]:
            r = r - 1
            if l <= r:
                A[l], A[r] = A[r], A[l] 
                l = l + 1
                r = r - 1
        A[l], A[p] = A[p], A[l]
        quick_sort(A, i, l-1)
        quick_sort(A, l+1, j)
    return A