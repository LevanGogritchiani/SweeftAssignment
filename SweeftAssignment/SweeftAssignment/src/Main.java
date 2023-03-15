import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    }

    public static int singleNumber(int[] num) {
        Set<Integer> firstTime = new HashSet<>();
        Set<Integer> secondTime = new HashSet<>();
        for (int j : num) {
            if (firstTime.contains(j)) {
                secondTime.add(j);
            } else {
                firstTime.add(j);
            }

        }
        firstTime.removeAll(secondTime);
        return firstTime.toArray(new Integer[1])[0];
    }

    public static int minSplit(int amount) {
        if (amount == 0)
            return 0;

        if (amount >= 50)
            return minSplit(amount - 50) + 1;

        if (amount >= 20)
            return minSplit(amount - 20) + 1;

        if (amount >= 10)
            return minSplit(amount - 10) + 1;

        if (amount >= 5)
            return minSplit(amount - 5) + 1;

        return minSplit(amount - 1) + 1;
    }

    public static int notContains(int[] array) {
        boolean[] numbers = new boolean[array.length + 1];
        for (int num : array) {
            if (num < numbers.length) {
                numbers[num] = true;
            }
        }
        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i])
                return i;
        }

        return numbers[0] ? array.length : array.length + 1;
    }

    public static String binaryStringAdd(String a, String b) {
//        I way
//        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
//        II way
        StringBuilder result = new StringBuilder();
        if (a.length() < b.length()) {
            String c = b;
            b = a;
            a = c;
        }

        boolean carry = false;
        int offset = a.length() - b.length();
        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '1' && a.charAt(offset + i) == '1') {
                if (carry) {
                    result.insert(0, '1');
                } else {
                    result.insert(0, '0');
                    carry = true;
                }
            } else if (b.charAt(i) == '1' || a.charAt(offset + i) == '1') {
                if (carry) {
                    result.insert(0, '0');
                } else {
                    result.insert(0, '1');
                }
            } else if (carry) {
                result.insert(0, '1');
                carry = false;
            } else {
                result.insert(0, '0');
            }
        }

        for (int i = offset - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                if (carry) {
                    result.insert(0, '0');
                } else {
                    result.insert(0, '1');
                }
            } else if (carry) {
                result.insert(0, '1');
                carry = false;
            } else {
                result.insert(0, '0');
            }
        }

        return carry ? "1" + result : String.valueOf(result);
    }

    public static int countVariants(int stairsCount) {
        if (stairsCount == 0) {
            return 1;
        }
        if (stairsCount >= 2) {
            return countVariants(stairsCount - 2) + countVariants(stairsCount - 1);
        }
        return countVariants(stairsCount - 1);
    }

    public class struct{
        private Map<Integer,Integer> map;
        private ArrayList<Integer> arrayList;

        public struct(){
            map = new HashMap<>();
            arrayList = new ArrayList<>();
        }

        public void delete(int n){
            if(map.containsKey(n)){
                int index = map.get(n);
                int back = arrayList.size() - 1;
                arrayList.set(index, arrayList.get(back));
                arrayList.remove(back);

                map.remove(n);
                map.put(arrayList.get(index),index);
            }
        }

        public void add(int n){
            if (!map.containsKey(n)){
                map.put(n,arrayList.size());
                arrayList.add(n);
            }
        }
    }
}