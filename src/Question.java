import java.util.*;
public class Question {
    List<Character> answers;
    public void setQuestion(int totalAnswers){
        answers = new LinkedList<Character>();
        char ansIndex = 'A';
        for (int i = 0; i < totalAnswers; i++){
            answers.add(ansIndex);
        }
    }
}
