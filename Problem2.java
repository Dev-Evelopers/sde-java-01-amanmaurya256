public class Problem2 {
    private static int foldsNeeded(int from, int to) {
        if (to > from) return Integer.MAX_VALUE; 
        int folds = 0;
        while (from > to) {
            from = (from + 1) / 2; 
            folds++;
        }
        return folds;
    }
    public static int minFolds(int h, int w, int h1, int w1) {
        if (h1 > h || w1 > w) return -1; 
        int option1 = foldsNeeded(h, h1) + foldsNeeded(w, w1);
        int option2 = foldsNeeded(h, w1) + foldsNeeded(w, h1);
        int result = Math.min(option1, option2);
        return result >= Integer.MAX_VALUE ? -1 : result;
    }
    public static void main(String[] args) {
        System.out.println(minFolds(8, 4, 6, 1));  // Output: 2
    }
}
