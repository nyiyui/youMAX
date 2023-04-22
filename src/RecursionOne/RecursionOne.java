package RecursionOne;

public class RecursionOne {
	int sum(int a) {
		int res = 0;
		for (int i = 1; i <= a; i ++)
			res += i;
		return res;
	}
	int sumR(int n, int accum) {
		if (n == 0) return accum;
		return sumR(n-1, n+accum);
	}
	int sumR(int n) {
		return sumR(n, 0);
	}

	int timeTable(int b, int e) {
		int res = 1; // identity
		for (int i = 1; i <= e; i ++)
			res *= b;
		return res;
	}
	int timeTableR(int b, int e, int accum) {
		if (e == 1) return b*accum;
		return timeTableR(b, e-1, b*accum);
	}
	int timeTableR(int b, int e) {
		return timeTableR(b, e, 1);
	}

	void test() {
		System.out.printf("sum(10) = %d\n", sum(10));
		System.out.printf("sumR(10) = %d\n", sumR(10));
		System.out.printf("timeTable(12, 3) = %d\n", timeTable(12, 3));
		System.out.printf("timeTableR(12, 3) = %d\n", timeTableR(12, 3));
	}
}
