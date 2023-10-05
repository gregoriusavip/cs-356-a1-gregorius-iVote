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
     * @return array of int
     */
    int[] getAnswerKey();

    /**
     * set the correct answer key
     * each element corresponds to the correct answer and within the range of maximum choices
     * @param n: must be at least one element and in range of maximum total answer choices
     */
    void setAnswerKey(int[] n);

    /**
     *
     * @return list of all possible answer choices
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
