public class ArrayException {
    public static void main(String[] args) {
        int nums[] = new int[5];

        try {
            System.out.println("Before exception...");
            nums[7] = 70;
            System.out.println("This is not displayed...");
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println(ae.getMessage());
        }
        System.out.println("After Catch...");
    }
}
