import java.util.ArrayList;
import java.util.List;

class Problem_92335 {
    public int solution(int n, int k) {

        String parsed = Long.toString(n, k);

        List<String> chunk = new ArrayList<>();

        StringBuilder candidate = null;
        for (int i = 0; i < parsed.length(); i++) {
            var c = parsed.charAt(i);
            if (c != '0') {
                if (candidate == null) {
                    candidate = new StringBuilder();
                }
                candidate.append(c);
                continue;
            }
            if (candidate != null) {
                chunk.add(candidate.toString());
                candidate = null;
            }

        }

        if (candidate != null) {
            chunk.add(candidate.toString());
        }

        var count = 0;
        loop:
        for (String num : chunk) {
            var m = Long.parseLong(num);
            if(m == 1) continue;

            for (long i = 2; i <= Math.floor(Math.sqrt(m)); i++) {
                if (m % i == 0) {
                    continue loop;
                }
            }
            count++;
        }


        return count;
    }
}
