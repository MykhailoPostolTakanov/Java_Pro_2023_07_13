package exceptions;

public class Main {
    public static void main(String[] args) {
        var calc = new ArrayValueCalculator();
        String[][] arrayForCalc = {{"5", "9", "3", "1"},
                {"1", "0", "2", "4"},
                {"2", "9", "1", "7"},
                {"4", "8", "7", "6"}};
        try {
            System.out.println(calc.doCalc(arrayForCalc));
        } catch (ArraySizeException exceptionArraySize) {
            System.out.println(exceptionArraySize.getMessage());
        } catch (ArrayDataException exceptionArrayData) {
            System.out.println(exceptionArrayData.getMessage());
            exceptionArrayData.printStackTrace();
        }catch (RuntimeException exceptionRuntime){
            System.out.println(exceptionRuntime.getMessage());
            exceptionRuntime.printStackTrace();
        }
    }
}
