package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/8/19 0:00
 */
public class G03for {
    public static void main(String[] args) {

        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                System.out.print(j + '*' + i + "  ");
            }
            System.out.println();
        }
    }

}
