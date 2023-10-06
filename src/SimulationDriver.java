import java.util.*;
public class SimulationDriver {
    public static void main(String[] args) {
        Random random = new Random();
        final int STUDENT_BOUND = 20;
        final int ANSWERS_BOUND = 6;

        final int RANDOM_STUDENT = random.nextInt(STUDENT_BOUND) + 1;
        final int RANDOM_TOTAL_ANSWERS = random.nextInt(ANSWERS_BOUND) + 1;
        final int RANDOM_QUESTION_TYPE = random.nextInt(2);

        List<Student> studentList = new LinkedList<>();
        List<List<Character>> answerList = new LinkedList<>();

        for(int i = 0 ; i < RANDOM_STUDENT; i++){   // generate random amount of student
            List<Character> charAnswer = new LinkedList<>();
            studentList.add(new Student("student" + (i + 1)));
            int randomAnswer;
            int maxAnswer = random.nextInt(ANSWERS_BOUND) + 1;
            for(int j = 0; j < maxAnswer; j++){
                randomAnswer = random.nextInt(RANDOM_TOTAL_ANSWERS) + 1;
                charAnswer.add((char) ('@' + randomAnswer));
            }
            answerList.add(charAnswer);
        }
        
        VotingService service = new VotingService();
        service.createQuestion(RANDOM_QUESTION_TYPE, RANDOM_TOTAL_ANSWERS);
        for(Student student : studentList){
            service.studentAnswer(student, answerList.getFirst());
            answerList.removeFirst();
        }
        service.printStatistic();
    }
}