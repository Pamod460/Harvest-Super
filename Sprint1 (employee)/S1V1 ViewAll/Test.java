import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Gender> genders = GenderController.get();
        for (Gender gender:genders){
            System.out.println(gender.getId());
            System.out.println(gender.getName());
        }
    }
}
