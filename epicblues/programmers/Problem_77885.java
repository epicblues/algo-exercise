class Problem_77885 {
     public long[] solution(long[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = translate(numbers[i]);
    }

    return numbers;
  }

  public long translate(long number) {
    String dec = Long.toString(number, 2);

    var chars = dec.toCharArray();

    char lastNum = chars[chars.length - 1];

    var buffer = new StringBuilder(chars.length);
    if (lastNum == '0') {
      chars[chars.length - 1] = '1';
      for (char ch : chars) {
        buffer.append(ch);
      }
      return Long.parseLong(buffer.toString(), 2);
    }

    for (int i = chars.length - 1; i > 1; i--) {
      char before = chars[i - 1];

      if (before == '1') {
        continue;
      }

      chars[i] = '0';
      chars[i - 1] = '1';

      for (char ch : chars) {
        buffer.append(ch);
      }
      return Long.parseLong(buffer.toString(), 2);

    }

    // 자리수 1 증가
    chars[0] = '0';
    buffer.append('1');
    for (char ch : chars) {
      buffer.append(ch);
    }
    return Long.parseLong(buffer.toString(), 2);

  }
}
