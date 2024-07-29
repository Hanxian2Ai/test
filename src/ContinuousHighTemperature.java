import java.util.Stack;

public class ContinuousHighTemperature {
    public static int[] calculateHighTemperatureDurations(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && t[i] <= t[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = n - i;
            } else {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] t = {59, 62, 66, 68, 69, 68, 67, 66, 67, 65};
        int[] ans = calculateHighTemperatureDurations(t);
        for (int duration : ans) {
            System.out.print(duration + " ");
        }
    }
}
