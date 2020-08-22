public class 贪钱 {
    /**
     *
     * @param N int整型
     * @return int整型
     * 思路：贪最大的钱，要最少的硬币
     */
    public int GetCoinCount (int N) {
        int m = 1024-N;//这是剩余的钱
        int count = 0;//最后的结果，得到的硬币数
        count = count + m / 64;//换了多少个64元硬币
        m = m - 64 * m / 64;//减去相应的钱
        count = count + m / 16;//上同
        m = m - 16 * m / 16;
        count = count + m / 4;//上同
        m = m - 4 * m / 4;
        count = count + m;//到这里就所有的硬币数都算完了,不需要除了
        return count;
    }
}
