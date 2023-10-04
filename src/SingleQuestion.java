import java.util.*;

public class SingleQuestion implements Question{
    int key;
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
        return answers;
    }
    @Override
    public void setAnswer(int[] num){
        if(num.length != 1){
            throw new IndexOutOfBoundsException("SingleQuestion must only have 1 correct answer");
        }
        if(num[0] < 0 || num[0] > answers.size()){
            throw new IndexOutOfBoundsException("Correct answer must be between 0 to " + answers.size());
        }
        else{
            this.key = num[0];
        }
    }
}
