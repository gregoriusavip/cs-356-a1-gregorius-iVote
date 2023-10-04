import java.util.*;

public class MultipleQuestion implements Question{

    int[] key;
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
    public List<Character> getAnswer(){
        // Should instead return only the correct answer
        return answers;
    }
    @Override
    public void setAnswer(int[] num){
        if(num.length > answers.size()){
            throw new IndexOutOfBoundsException("SingleQuestion must only have 1 correct answer");
        }
    }
}
