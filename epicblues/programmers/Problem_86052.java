import java.util.*;

class Problem_86052 {
    char[][] charGrid;

    public int[] solution(String[] grid) {
        charGrid = new char[grid.length][grid[0].length()];
        Path.charGrid = charGrid;
        for (int i = 0; i < grid.length; i++) {
            var line = grid[i];
            charGrid[i] = line.toCharArray();
        }

        var pathSet = new HashSet<Path>();

        var answerList = new ArrayList<Integer>();

        for (int x = 0; x < charGrid.length; x++) {
            for (int y = 0; y < charGrid[0].length; y++) {
                var entryDot = new Dot(x, y);
                for (int i = 0; i < 4; i++) {

                    var path = new Path(entryDot.x, entryDot.y, i, 1);
                    if (pathSet.contains(path)) {
                        continue;
                    }
                    // 유효한 path이므로 탐색 시작
                    Queue<Path> queue = new LinkedList<>();

                    queue.add(path);
                    pathSet.add(path);
                    while (!queue.isEmpty()) {
                        var targetPath = queue.poll();
                        var targetDot = new Dot(targetPath.toX, targetPath.toY);

                        var direction = charGrid[targetDot.x][targetDot.y];
                        Path nextPath = targetPath.rotate(direction);
                        if (pathSet.contains(nextPath)) {
                            answerList.add(nextPath.cycleCount - 1);
                            continue;
                        }
                        pathSet.add(nextPath);
                        queue.add(nextPath);

                    }

                }

            }
        }

        return answerList.stream().sorted().mapToInt(i -> i).toArray();
    }

    static class Dot {
        int x;
        int y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Dot))
                return false;
            Dot dot = (Dot)o;
            return x == dot.x && y == dot.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Path {
        private static final int[] dx = {-1, 0, 1, 0};
        private static final int[] dy = {0, -1, 0, 1};
        static char[][] charGrid;
        int fromX;
        int fromY;
        int toX;
        int toY;
        int cycleCount;
        int position;

        Path(int fromX, int fromY, int position, int cycleCount) {
            toX = fromX + dx[position];
            if (toX == charGrid.length) {
                toX = 0;
            } else if (toX == -1) {
                toX = charGrid.length - 1;
            }

            toY = fromY + dy[position];
            if (toY == charGrid[0].length) {
                toY = 0;
            } else if (toY == -1) {
                toY = charGrid[0].length - 1;
            }
            this.fromX = fromX;
            this.fromY = fromY;
            this.cycleCount = cycleCount;
            this.position = position;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Path))
                return false;
            Path path = (Path)o;
            return fromX == path.fromX && fromY == path.fromY && position == path.position;
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromX, fromY, position);
        }

        Path rotate(char direction) {
            int newPosition;
            if (direction == 'L') {

                newPosition = position == 0 ? 3 : position - 1;

            } else if (direction == 'R') {

                newPosition = position == 3 ? 0 : position + 1;
            } else {
                newPosition = position;
            }
            return new Path(toX, toY, newPosition, cycleCount + 1);

        }
    }
}
