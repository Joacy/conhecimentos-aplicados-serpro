import unittest


def pre_processamento(n=10000):
    fibonaccis = []
    fibonaccis.append(0)
    fibonaccis.append(1)

    for i in range(2, n + 1):
        fibonaccis.append(fibonaccis[i - 2] + fibonaccis[i - 1])

    return fibonaccis


def fibonacci(n):
    fibonaccis = pre_processamento(n)
    return fibonaccis[n]


class FibonacciTest(unittest.TestCase):
    def test_fibonacci(self):
        self.assertEqual(5, fibonacci(5))

    def test_fibonacci_fail(self):
        self.assertNotEqual(50, fibonacci(10))


if __name__ == "__main__":
    unittest.main()
