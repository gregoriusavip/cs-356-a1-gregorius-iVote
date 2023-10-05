import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class VotingService {
    private Question question;
    private QuestionType qType = QuestionType.NONE;
    private final Map<String, Character> singleRecord = new HashMap<String, Character>();
    private final Map<String, List<Character>> multipleRecord = new HashMap<>();
    private final Map<Character, Integer> countAnswer = new HashMap<>();

    /**
     * create a question object
     * @param questionType: takes either 0 or 1 that corresponds to SingleQuestion or MultipleQuestion
     * @param totalAnswers: takes at least 1 or more possible answer choices
     * @param answerKey: takes at least one element with maximum of totalAnswers
     */
    public void createQuestion(int questionType, int totalAnswers, int[] answerKey){
        if(questionType == 0){
            question = new SingleQuestion();
            qType = QuestionType.SINGLE;
        }
        else if (questionType == 1) {
            question = new MultipleQuestion();
            qType = QuestionType.MULTIPLE;
        }
        else{
            throw new IllegalArgumentException("Question type has to be 0 or 1");
        }
        question.createQuestion(totalAnswers);
        question.setAnswerKey(answerKey);
        for(int i = 0; i < question.getAnswerSize(); i++){
            countAnswer.put(question.getAnswers().get(i), 0);
        }
    }

    /**
     * allow student object to answer
     * @param student: take a student object with a student id
     * @param answer: take the answer of this student
     */

    public void studentAnswer(Student student, List<Character> answer){
        if(qType == QuestionType.SINGLE){
            answerSingle(student, answer);
        }
        else{
            answerMultiple(student, answer);
        }
    }

    /**
     * process the answer of a student when the question is a SingleQuestion
     * @param student: takes a student object; each student can only have one recorded submission;
     * @param answer: takes the possible answer; If answer is more than one element, only the last will be recorded
     */
    private void answerSingle(Student student, List<Character> answer){
        for (char c : answer) {
            if (question.answerToString().indexOf(c) != -1) {
                // If multiple answer given, take the latest answer
                singleRecord.put(student.getStudentID(), c);
            }
        }
    }
    /**
     * process the answer of a student when the question is a SingleQuestion
     * @param student: takes a student object
     * @param answer: takes the possible answer; If answer is more than one element, only the last will be recorded
     */
    private void answerMultiple(Student student, List<Character> answer){
        List<Character> validatedAnswer = new LinkedList<>();
        for (char c : answer){
            if(question.answerToString().indexOf(c) != -1){
                validatedAnswer.add(c);
            }
        }
        multipleRecord.put(student.getStudentID(), validatedAnswer);
    }
    /**
     * set the map countAnswer for recording students answer
     */
    private void calculateStatistic(){
        for (Character ans : singleRecord.values())
            countAnswer.put(ans, countAnswer.get(ans) + 1);
        for (List<Character> ans : multipleRecord.values())
            for (char i : ans)
                countAnswer.put(i, countAnswer.get(i) + 1);
    }

    /**
     * print the statistic of the answers to the terminal
     */
    public void printStatistic(){
        AtomicInteger count = new AtomicInteger();
        if(qType == QuestionType.SINGLE){
            System.out.println("Question Type: Single Answer");
        }
        else{
            System.out.println("Question Type: Multiple Answer");
        }
        calculateStatistic();
        System.out.println((multipleRecord.size() + singleRecord.size()) + " students on the record");
        countAnswer.forEach((key, val) -> {
            System.out.println(key + ": " + val);
            count.addAndGet(val);
                }
        );
        System.out.println("Total valid answers: " + count);
    }
}