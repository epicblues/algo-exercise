
import java.util.*;

class Problem_87377 {
    public String[] solution(int[][] line) {

        var dots = new HashSet<Dot>();

        // 각 직선 별로 교점들을 찾는다.(brute force)
        for(int i = 0; i < line.length; i++) {
            int[] line1= line[i];

            for(int j = i + 1; j < line.length; j++) {
                int[] line2 =line[j];
                double parent = (1.0)*line1[0] * line2[1] - (1.0)*line1[1] * line2[0];
                if(parent == 0) {
                    // 평행이므로 교점이 존재하지 않음
                    continue;
                }
                double x = ((1.0)*line1[1] * line2[2] - ((1.0)*line1[2] * line2[1])) / parent;
                double y = ((1.0)*line1[2] * line2[0] - ((1.0)*line1[0] * line2[2])) / parent;
                if(x % 1 != 0 || y % 1 != 0) {
                    // 정수가 아니므로 배제
                    continue;
                }
        // 교점이 중복될 수 있으므로, HashSet으로 보관한다.

                dots.add(new Dot((long)x, (long)y));
            }
        }


        // 교점들을 모아 놓으면 x최대(배열 n),  x최소(배열 0), y 최대(배열 세로 m), y최소 값(배열 세로 m)들을 모아 놓은다.
        // offset을 구한 다음에 배열에 맞춘다.
        var xMin = Long.MAX_VALUE;
        var xMax = Long.MIN_VALUE;
        var yMax = Long.MIN_VALUE;
        var yMin = Long.MAX_VALUE;

        for(Dot dot : dots) {
            var x = dot.x;
            var y = dot.y;
            xMin = Math.min(xMin, x);
            xMax = Math.max(xMax, x);
            yMin = Math.min(yMin, y);
            yMax = Math.max(yMax, y);
        }

        var xOffset = xMin;
        var yOffset = yMax;

        var buffer = new boolean[(int)(yMax - yMin + 1)][(int)(xMax - xMin + 1)];

        for(Dot dot : dots) {
            buffer[(int)(yOffset - dot.y)][(int)(dot.x - xOffset)] = true;
        }
        var answer = new String[buffer.length];
        for(int i = 0; i < buffer.length; i++) {
            var builder = new StringBuilder();
            for(boolean b : buffer[i]) {
                builder.append(b ? "*" : ".");
            }
            answer[i] = builder.toString();
        }


        return answer;
    }

    static class Dot {
        long x;
        long y;
        Dot(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object target) {
            Dot parsed = (Dot)target;
            return x == parsed.x && y == parsed.y;
        }

        @Override
        public int hashCode() {
            return (int)((x + y) / 31);
        }
    }
}