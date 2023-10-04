import java.util.*;
public class VotingService {
    List<Question> qList = new LinkedList<Question>();
    Map<String, String> studentAnswers = new HashMap<String, String>();
    public void createQuestion(int questionType){
        if(questionType == 0){
            qList.add(new SingleQuestion());
        }
        else if (questionType == 1) {
            qList.add(new MultipleQuestion());
        }
    }
    public void studentAnswer(Student student, String answer){
        String studentID = student.getStudentID();
        // add studentID to map
        // if there exist an answer for this student id
        // add the statistic for this question
        // else, switch the statistic (reduce one, add another)
    }
}
