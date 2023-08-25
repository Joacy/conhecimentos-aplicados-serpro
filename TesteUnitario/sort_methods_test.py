import unittest

# Bubble sort method
def bubble_sort(A):
    troca = 0
    for i in range(len(A)-1, 0, -1):
        for j in range(0, i):
            if (A[j+1] < A[j]):
                troca += 1
                A[j], A[j+1] = A[j+1], A[j]
    return A


# Insertion sort method
def insertion_sort(A):
    for i in range(1, len(A)):
        j = i
        while (j > 0 and A[j] < A[j-1]):
            A[j], A[j-1] = A[j-1], A[j]
            j = j - 1
    return A


# Selection sort method
def selection_sort(A):
    for i in range(len(A) - 1):
        min_index = i
        for j in range(i + 1, len(A)):
            if (A[j] < A[min_index]):
                min_index = j
        A[i], A[min_index] = A[min_index], A[i]
    return A


# Merge function, for Merge sort method
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


# Merge sort method
def merge_sort(A):
    if (len(A) > 1):
        L = A[:(len(A)//2)]
        R = A[(len(A)//2):]
        merge_sort(L)
        merge_sort(R)
        merge(A, L, R)
    return A


# Quicksort method
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


class TestSortMethods(unittest.TestCase):
    def test_bubble_sort(self):
        self.assertListEqual(sorted([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]),
                             bubble_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

        self.assertNotEqual([1, 2, 3, 4, 6, 7, 5, 8, 9, 10],
                            bubble_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

    def test_insertion_sort(self):
        self.assertEqual(sorted([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]),
                         insertion_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

        self.assertNotEqual([1, 2, 3, 4, 6, 7, 5, 8, 9, 10],
                            insertion_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

    def test_selection_sort(self):
        self.assertEqual(sorted([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]),
                         selection_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

        self.assertNotEqual([1, 2, 3, 4, 6, 7, 5, 8, 9, 10],
                            selection_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

    def test_merge_sort(self):
        self.assertEqual(sorted([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]),
                         merge_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

        self.assertNotEqual([1, 2, 3, 4, 6, 7, 5, 8, 9, 10],
                            merge_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]))

    def test_quick_sort(self):
        self.assertEqual(sorted([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]),
                         quick_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3], 0, len([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]) - 1))

        self.assertNotEqual([1, 2, 3, 4, 6, 7, 5, 8, 9, 10],
                            quick_sort([10, 7, 2, 5, 1, 4, 6, 9, 8, 3], 0, len([10, 7, 2, 5, 1, 4, 6, 9, 8, 3]) - 1))


if __name__ == '__main__':
    unittest.main()
