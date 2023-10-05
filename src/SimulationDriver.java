import java.util.LinkedList;
import java.util.Random;
import java.util.List;
public class SimulationDriver {
    public static void main(String[] args) {
        Random random = new Random();
        final int RANDOM_STUDENT = random.nextInt(40) + 1;
        final int RANDOM_TOTAL_ANSWERS = random.nextInt(12) + 1;
        List<Student> studentList = new LinkedList<>();
        for(int i = 0 ; i < RANDOM_STUDENT; i++){
            studentList.add(new Student("student" + (i + 1)));
        }
        VotingService service = new VotingService();
        service.createQuestion(0, RANDOM_TOTAL_ANSWERS, new int[]{1});
        for(Student student : studentList){
            service.answerSingle(student,  'A');
        }
        service.printStatistic();
    }
}