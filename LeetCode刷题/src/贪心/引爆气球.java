package 贪心;

import java.net.SocketTimeoutException;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * Example:
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 引爆气球 {
    public void sort(int[][] points){
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 0; j < points.length - i - 1; j++) {
                if(points[j][0] > points[j+1][0]){
                    points[j][0] = points[j][0] ^ points[j+1][0];
                    points[j+1][0] = points[j][0] ^ points[j+1][0];
                    points[j][0] = points[j][0] ^ points[j+1][0];
                    //连第二个也要换
                    points[j][1] = points[j][1] ^ points[j+1][1];
                    points[j+1][1] = points[j][1] ^ points[j+1][1];
                    points[j][1] = points[j][1] ^ points[j+1][1];
                }
            }
        }
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        //按左端排序
        sort(points);
        //射击区间开始
        int shootNum = 1;
        int shootBegin = points[0][0];
        int shootEnd = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(shootEnd >= points[i][0]){
                //选择左端小的
                shootBegin = points[i][0];
                if(shootEnd > points[i][1]){
                    shootEnd = points[i][1];
                }
            }else{
                shootNum++;
                shootBegin = points[i][0];
                shootEnd = points[i][1];
            }
        }
        return shootNum;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
    }
}
