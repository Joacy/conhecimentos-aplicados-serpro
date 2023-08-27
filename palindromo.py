import re

def palindromo(palavra):
  nao_alfanumericos = "[\W_]"
  palavra = palavra.lower()
  palavra = re.sub(nao_alfanumericos, "", palavra)
  palavra = palavra.replace(" ", "")

  final = len(palavra)
  for inicio in range(len(palavra)//2):
    final -= 1
    if palavra[inicio] != palavra[final]:
      return False
  return True

import unittest

class PalindromoTest(unittest.TestCase):
  def test_palindromo(self):
    self.assertEqual(True, palindromo("A man, a plan, a canal. Panama"))
    
  def test_nao_palindromo(self):
    self.assertNotEqual(True, palindromo("A man, a plan, aaajerrnaaic a canal. Panama"))

if __name__ == "__main__":
  unittest.main()
  # unittest.main(argv=['first-arg-is-ignored'], exit=False)
