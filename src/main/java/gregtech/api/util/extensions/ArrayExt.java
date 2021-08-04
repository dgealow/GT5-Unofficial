package gregtech.api.util.extensions;

import java.util.function.IntFunction;

public class ArrayExt {
    public static int[] of(int... objects) {
        return objects;
    }

    public static float[] of(float... objects) {
        return objects;
    }

    public static double[] of(double... objects) {
        return objects;
    }

    public static char[] of(char... objects) {
        return objects;
    }

    public static byte[] of(byte... objects) {
        return objects;
    }

    public static long[] of(long... objects) {
        return objects;
    }

    @SafeVarargs
    public static <T> T[] of(T... objects) {
        return objects;
    }

    public static <T> T[] withoutTrailingNulls(T[] array, IntFunction<T[]> arrayFactory) {
        int firstNull = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                if (firstNull == -1) {
                    firstNull = i;
                }
            } else {
                firstNull = -1;
            }
        }

        if (firstNull == -1) {
            T[] newArray = arrayFactory.apply(array.length);
            System.arraycopy(array, 0, newArray, 0, array.length);
            return newArray;
        } else if (firstNull == 0) {
            return arrayFactory.apply(0);
        } else {
            T[] newArray = arrayFactory.apply(firstNull);
            System.arraycopy(array, 0, newArray, 0, firstNull);
            return newArray;
        }
    }
}