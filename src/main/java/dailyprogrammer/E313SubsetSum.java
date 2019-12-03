package dailyprogrammer;

import java.util.*;
import java.util.stream.*;

public class E313SubsetSum {

    public static boolean subsetSumToZeroBasic(int[] input) {
        int front = 0;
        int back = input.length - 1;
        int frontValue;
        int backValue;
        int sum;

        while (front < back) {
            frontValue = input[front];
            backValue = input[back];
            sum = frontValue + backValue;

            if (frontValue == 0 || backValue == 0) {
                return true;
            }

            if (sum == 0) {
                return true;
            } else if (sum > 0) {
                back--;
            } else {
                front++;
            }
        }

        return false;
    }


    public static boolean subsetSumToZeroBonus(int[] input) {
        if (input.length == 0) {
            return false;
        }

        int sum = IntStream.of(input).sum();
        
        // Case where all elements sum to 0
        if (sum == 0) {
            return true;
        }
        
        Set<Integer> inputSet = IntStream.of(input)
            .mapToObj(i->i)
            .collect(Collectors.toSet());
        
        // Check every possible subset one at a time
        // Inefficient, but effective
        PowerSet<Integer> pset = new PowerSet<Integer>(inputSet);
        for (Set<Integer> subset : pset) {
            int subsetSum = subset.stream().mapToInt(Integer::new).sum();
            if (subsetSum == 0 && subset.size() != 0) {
                return true;
            }
        }

        // Return false if no subset sums to 0
        return false;
    }
}


class PowerSet<E> implements Iterator<Set<E>>, Iterable<Set<E>>{
    private E[] arr = null;
    private BitSet bset = null;

    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set) {
        arr = (E[]) set.toArray();
        bset = new BitSet(arr.length + 1);
    }

    @Override
    public boolean hasNext() {
        return !bset.get(arr.length);
    }

    @Override
    public Set<E> next() {
        Set<E> returnSet = new TreeSet<E>();
        for (int i = 0; i < arr.length; i++) {
            if (bset.get(i)) {
                returnSet.add(arr[i]);
            }
        }

        //increment bset
        for (int i = 0; i < bset.size(); i++) {
            if (!bset.get(i)) {
                bset.set(i);
                break;
            } else {
                bset.clear(i);
            }
        }

        return returnSet;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not Supported!");
    }

    @Override
    public Iterator<Set<E>> iterator() {
        return this;
    }

}