package core.recursion;

public class MiGong {
    public static void main(String[] args) {
        //二维数组，模拟迷宫
        int[][] map = new int[8][7];

        //使用1表示强，上下全置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯，给小球招录
        setWay(map, 1, 1);
        //输出新的地图，小球走过，并标识过的递归
        System.out.println("小球走过并标识地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 约定：当map[i][j] = 0 表示该点没有走过，当为1表示墙，2表示通路可以走，3表示该点已经走过，但是走不通
     * 在走迷宫时，需要确定一个策略(方法)：  下->右->上->左  如果该点走不通 再回溯
     * 使用i递归回溯来给小球找路
     *
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @returny
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                map[i][j] = 2; //假定该点是可以走通的
                if (setWay(map, i + 1, j)) { //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {  //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { //向左走
                    return true;
                } else {
                    //说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { //如果map[i][j] != 0  可能是1，2，3
                return false;
            }
        }

    }
}
