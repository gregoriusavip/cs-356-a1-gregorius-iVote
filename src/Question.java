import java.util.List;

public interface Question {
    public void createQuestion(int a);
    public int[] getAnswerKey();
    public void setAnswer(int[] n);
    public List<Character> getAnswers();
    public int getAnswerSize();
    public String answerToString();
}
