import java.util.List;

public interface Question {
    void createQuestion(int a);
    int[] getAnswerKey();
    void setAnswer(int[] n);
    List<Character> getAnswers();
    int getAnswerSize();
    String answerToString();
}
