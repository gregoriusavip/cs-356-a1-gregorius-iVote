import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;
public class SimulationDriver {
    public static void main(String[] args) {
        Random random = new Random();
        final int RANDOM_STUDENT = random.nextInt(40) + 1;
        final int RANDOM_TOTAL_ANSWERS = random.nextInt(12) + 1;
        List<Student> studentList = new LinkedList<>();
        List<List<Character>> answerList = new LinkedList<>();
        for(int i = 0 ; i < RANDOM_STUDENT; i++){   // generate random amount of student
            List<Character> charAnswer = new LinkedList<>();
            studentList.add(new Student("student" + (i + 1)));
            int randomAnswer;
            int maxAnswer = random.nextInt(12) + 1;
            for(int j = 0; j < maxAnswer; j++){
                randomAnswer = random.nextInt(RANDOM_TOTAL_ANSWERS) + 1;
                charAnswer.add((char) ('@' + randomAnswer));
            }
            answerList.add(charAnswer);
        }
        VotingService service = new VotingService();
        service.createQuestion(random.nextInt(2), RANDOM_TOTAL_ANSWERS, new int[]{1, 3});
        for(Student student : studentList){
            service.studentAnswer(student, answerList.getFirst());
            answerList.removeFirst();
        }
        service.printStatistic();
    }
}