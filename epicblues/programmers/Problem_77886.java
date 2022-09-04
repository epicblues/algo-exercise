public class Problem_77886 {

  public String[] solution(String[] s) {

    for (int i = 0; i < s.length; i++) {
      s[i] = sort(s[i]);
    }

    return s;
  }

  public String sort(String target) {

    var countOf110 = 0;
    var countOf1 = 0;

    var answerBuffer = new StringBuilder(target.length());

    for (int i = 0; i < target.length(); i++) {
      char ch = target.charAt(i);
      if (ch == '1') {
        countOf1++;
        continue;
      }

      if (countOf1 < 2) {
        answerBuffer.append(countOf1 == 1 ? "10" : "0");
        countOf1 = 0;
        continue;
      }

      countOf1 -= 2;
      countOf110++;
    }

    for (int i = 0; i < countOf110; i++) {
      answerBuffer.append("110");
    }

    for (int i = 0; i < countOf1; i++) {
      answerBuffer.append('1');
    }

    return answerBuffer.toString();
  }

}
