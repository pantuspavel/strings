class Solution {
  public static char[] insertionSort(char[] s) {
    for (int i = 0; i < s.length; i++) {
      for (int j = i; j > 0; j--) {
        if (s[j - 1] > s[j]) {
          char tmp = s[j];
          s[j] = s[j - 1];
          s[j - 1] = tmp;
        }
      }
    }
    return s;
  }
    
  static void reverseInPlace(char[] s) {
    for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
      char c = s[i];
      s[i] = s[j];
      s[j] = c;
    }
  }

  private static int subsBruteForce(String t, String p) {   
    for (int i = 0; pml = 0; i < t.length(); i++) {
      if (t.charAt(i) == p.charAt(pml)) {
        pml++;
        if (p.length() == pml) {
          return i - pml + 1;
        }
      } else {
        pml = 0;
      }
    }
    
    return -1;
  }
  
  public static void main(String[] args) {
    System.out.println("Index = " + subsBruteForce("abcdef", "ef"));
  }
}
