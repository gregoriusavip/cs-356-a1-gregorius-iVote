import java.util.List;

public interface Question {
    /**
     *
     * @param n: create a single question with n possible answers
     */
    void createQuestion(int n);
    /**
     * get the correct answer key as an array of integer
     * if the object is a single question, the array will be a single element
     * otherwise, it will be 1 or more
     * 0 corresponds to 'A', 1: 'B' and so on
     * @return Set of int
     */
    List<Character> getAnswers();

    /**
     *
     * @return the number of possible answer choices
     */
    int getAnswerSize();

    /**
     *
     * @return convert the list of answers to string
     */
    String answerToString();
}
