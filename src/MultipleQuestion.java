import java.util.*;

public class MultipleQuestion implements Question{
    private List<Character> answers;
    @Override
    public void createQuestion(int totalAnswers){
        answers = new LinkedList<Character>();
        char ansIndex = 'A';
        for (int i = 0; i < totalAnswers; i++){
            answers.add(ansIndex);
            ansIndex += 1;
        }
    }
    @Override
    public List<Character> getAnswers() {
        return answers;
    }
    @Override
    public int getAnswerSize() {
        return answers.size();
    }
    @Override
    public String answerToString(){
        return answers.toString();
    }
}
