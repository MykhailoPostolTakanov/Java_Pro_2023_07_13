package exceptions;

public class ArrayValueCalculator {
    public int doCalc(String[][] arr) {
        int result = 0;
        if (arr.length != 4)
            throw new ArraySizeException("Масив не вірного розміру! Повинен бути 4х4!");
        for (var i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new ArraySizeException("Масив не вірного розміру! Срока " + (i + 1) + " має містит 4, а не " + arr[i].length);
            for (var j = 0; j < arr[i].length; j++)
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Не вірні дані в комірці: [" + (i + 1) + "]" + "[" + (j + 1) + "] = " + arr[i][j], e);
                }
        }
        return result;
    }
}
