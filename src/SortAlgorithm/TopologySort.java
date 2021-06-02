package SortAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 拓扑排序
 */
public class TopologySort {

    /**
     * 循环依赖检测。如，[['A', 'B'], ['B', 'C'], ['C', 'D'], ['B', 'D']] =>
     * false，[['A', 'B'], ['B', 'C'], ['C', 'A']] => true（2021.4 字节跳动-幸福里-后端）[2]
     * 手撕代码：小王写了一个makefile，其中有n个编译项编号为0~n-1，
     * 他们互相之间有依赖关系。请写一个程序解析依赖，给出一个可行的编译顺序。（2021.03 字节跳动-系统部-后端）[3]
     * [[0,2],[1,2],[2,3],[2,4]]
     *
     * @param array
     * @param n
     */
    public void sort(int[][] array, int n) {
        HashMap<Integer,LinkedList<Integer>> inArr=new HashMap<>();
        HashMap<Integer,LinkedList<Integer>> outArr=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            LinkedList<Integer> tempIn = inArr.getOrDefault(array[i][1],new LinkedList<>());
            inArr.put(array[i][1],tempIn);
            tempIn.add(array[i][0]);

            LinkedList<Integer> tempOut=outArr.getOrDefault(array[i][0],new LinkedList<>());
            outArr.put(array[i][0],tempIn);
            tempIn.add(array[i][1]);
        }
        while(!inArr.isEmpty()){

        }
    }

}
