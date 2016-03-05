class Solution {
  public static void allCombinations(Character[] s) {
    List<String> strs = new ArrayList<String>();
    allCombinations(s, strs, s.length - 1);
  }

  public static void allCombinations(Character[] s, List<String> strs, int reach) {
    int curSize = strs.size();
    for (int i = 0; i < curSize; i++) {
        String ns = s[reach] + strs.get(i);
        strs.add(ns);
    }

    strs.add("" + s[reach]);

    if (reach == 0) {
        for (int i = reach; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
    } else {
        allCombinations(s, strs, reach - 1);
    }
  }
  
  public static void printAllPermutations(Character[] s) {
    Character[] sc = new Character[s.length];
    printAllPermutations(s, sc, 0, new HashSet<Character>());
  }

  public static void printAllPermutations(Character[] s, Character[] sc, int reach, Set<Character> used) {
    if (reach == s.length) {
        for (int i = 0; i < sc.length; i++) {
            System.out.print(sc[i]);
        }
        System.out.println();
        return;
    }
    for (int i = 0; i < s.length; i++) {
        if (used.contains(s[i])) {
            continue;
        }
        used.add(s[i]);
        sc[reach] = s[i];
        printAllPermutations(s, sc, reach + 1, used);
        used.remove(s[i]);
    }
  }
    
  public static void exchange(char[] s, int i1, int i2) {
    char tmp = s[i1];
    s[i1] = s[i2];
    s[i2] = tmp;
  }

  public static char[] quickSortPartition(char[] s) {
    int i = 1;
    int j = s.length - 1;
    char tmp;

    while(i < j) {
      if (s[i] < s[0]) {
        i++;
      }

      if (s[j] > s[0]) {
        j--;
      }

      if (s[i] > s[0] && s[j] < s[0]) {
        exchange(s, i, j);
      }
    }

    exchange(s, 0, i);
    return s;
  }

  public static void insertionSortWithLimits(char[] s, int l, int h) {
    for (int i = l; i < h; i++) {
      for (int j = i; j > 0; j--) {
        if (s[j - 1] > s[j]) {
          char tmp = s[j - 1];
          s[j - 1] = s[j];
          s[j] = tmp;
        }
      }
    }
  }

  public static void quickSort(char[] s) {
    // TODO: shuffle incoming array;
    int p = quickSortPartition(s);
    insertionSortWithLimits(s, 0, p - 1);
    insertionSortWithLimits(s, p, s.length);
  }

  public static char[] mergeSort(char[] l, char[] r) {
    l = insertionSort(l);
    r = insertionSort(r);

    int li = 0;
    int ri = 0;
    char[] aux = new char[l.length + r.length];

    for (int k = 0; k < aux.length; k++) {
      if (li < l.length && (ri == r.length || l[li] <= r[ri])) {
        aux[k] = l[li++];
      } else if (ri < r.length && (li == l.length || l[li] > r[ri])) {
        aux[k] = r[ri++];
      }
    }

    return aux;
  }

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
