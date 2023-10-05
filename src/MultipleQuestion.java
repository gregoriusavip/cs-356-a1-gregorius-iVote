import java.util.*;

public class MultipleQuestion implements Question{

    private int[] key;
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
    public int[] getAnswerKey(){
        return key;
    }
    @Override
    public void setAnswer(int[] num){
        if(num.length > answers.size()){
            throw new IndexOutOfBoundsException("Multiple Question must have maximum of " + answers.size() + "answer");
        }
        for (int j : num) {
            if (j < 0 || j > answers.size()) {
                throw new IndexOutOfBoundsException("Correct answer must be between 0 to " + answers.size());
            }
        }
        this.key = num;
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
