import java.util.*;

public class SingleQuestion implements Question{
    private Set<Integer> key;
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
    public Set<Integer> getAnswerKey(){
        return key;
    }
    @Override
    public void setAnswerKey(Set<Integer> num){
        if(num.size() != 1){
            throw new IllegalArgumentException("SingleQuestion must have 1 correct answer");
        }
        for(int val : num){
            if(val < 1 || val > answers.size()){
                throw new IllegalArgumentException("Correct answer must be between 1 to " + answers.size());
            }
        }
        this.key = num;
    }
    @Override
    public List<Character> getAnswers() {
        return answers;
    }
    @Override
    public int getAnswerSize(){
        return answers.size();
    }
    @Override
    public String answerToString(){
        return answers.toString();
    }
}
