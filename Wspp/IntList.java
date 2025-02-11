package wspp;

import java.util.Arrays;

public class IntList {
    private int[] array;
    private int count = 0;

    public IntList(int[] array) {
        this.array = array;
    }

    public void add(int addInt) {
        if (count == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[count] = addInt;
        count++;
    }

    public int get(int i) {
        if ((i >= count) || (i < 0)) {
            throw new IndexOutOfBoundsException(i);
        } else {
            return array[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count - 1; i++) {
            stringBuilder.append(array[i]).append(' ');
        }
        stringBuilder.append(array[count - 1]);
        return stringBuilder.toString();
    }

    public int size() {
        return count;
    }
}
