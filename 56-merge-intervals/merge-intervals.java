import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();


        for (int[] i : intervals) {
            list.add(i);
        }

        boolean merged = true;

        while (merged) {
            merged = false;

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {

                    int[] a = list.get(i);
                    int[] b = list.get(j);

                    // Check overlap
                    if (a[1] >= b[0] && b[1] >= a[0]) {

                        // Merge
                        int newStart = Math.min(a[0], b[0]);
                        int newEnd = Math.max(a[1], b[1]);

                        list.set(i, new int[]{newStart, newEnd});
                        list.remove(j);

                        merged = true;
                        break;
                    }
                }

                if (merged) break;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}