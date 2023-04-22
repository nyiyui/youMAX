package RecursionTwo;

public class RecursionTwo {
	int count(String line, char c, int accum) {
		if (line.length() == 0) return accum;
		return count(line.replaceAll("^.", ""), c, accum + (line.charAt(0) == c ? 1 : 0));
	}
	int count(String line, char c) {
		return count(line, c, 0);
	}
	int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	int search(int[][] map, int i, int j) {
		if (i < 0 || j > map.length - 1) return Integer.MAX_VALUE;
		if (i == 0 && j == map[0].length-1) return map[0][map.length-1];
		return map[i][j] + Math.min(search(map, i-1, j), search(map, i, j+1));
	}
	int search(int[][] map) {
		return search(map, map.length-1, 0);
	}
	void test() {
		System.out.printf("count(\"this is a test\", 't') = %d\n", count("test is a test", 't'));
		System.out.printf("gcd(175, 100) = %d\n", gcd(175, 100));
		int[][] dp = {
			{12, 10, 33, 21},
			{15, 20, 14, 24},
			{18, 15, 52, 5},
			{22, 21, 30, 41}
		};
		// assuming it means east and north
		System.out.printf("search(dp) = %d\n", search(dp));
	}
}
