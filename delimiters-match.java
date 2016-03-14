class Solution {
  private static boolean match(char l, char r) {
    if (l == '[' && r == ']') return true;
    if (l == '{' && r == '}') return true;
    if (l == '(' && r == ')') return true;
    return false;
  }
    
  private static boolean delimiters(char[] str) {
    LinkedList<Character> s = new LinkedList<Character>();
    for (int i = 0; i < str.length; i++) {
      if (str[i] == '{' || str[i] == '[' || str[i] == '(') {
        s.add(str[i]);
      } else if (str[i] == '}' || str[i] == ']' || str[i] == ')') {
        if (match(s.removeLast(), str[i]) == false) {
          return false;
        }
      }
    }
    return s.size() == 0;
  }
  
  public static void main(String[] args) {
    System.out.println(delimiters(new char[] { '{', '(', 'a', 'b', 'c', ')', '2', '2', '}', '[', '1', '4', '(', 'x', 'y', 'z', ')', '2', ']' } ));
  }
}
