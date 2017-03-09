public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        //dp[i][j]��ʾi������һ���õ�j��ĸ��ʡ�Ҫ�õ�dp[i][j]���Կ��������һ��ɸ�ӵĵ���Ϊk��1~6������ǰi��1��ɸ��һ���õ��ĵ���Ϊj-k����Ϊi-1��ɸ�����ٵõ�i-1�㣬����j-k >= i - 1 => k <= j - i + 1��������ֻҪ�����һ��ɸ��Ϊk�ĸ����������������ٳ���6���ɣ�ÿ��һ��ɸ�Ӹ���Ҫ�����һ��6����
        List<Map.Entry<Integer, Double>> results = new ArrayList<Map.Entry<Integer, Double>>();
        
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; ++i)
            dp[1][i] = 1.0 / 6;

        for (int i = 2; i <= n; ++i) {
            for (int j = i; j <= 6 * n; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if (j > k) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
                dp[i][j] /= 6.0;
            }
        }
        for (int i = n; i <= 6 * n; ++i) {
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i]));
        }
        return results;
    }
}