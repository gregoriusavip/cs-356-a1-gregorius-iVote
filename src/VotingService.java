import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class VotingService {
    private Question question;
    private QuestionType qType = QuestionType.NONE;
    private final Map<String, Character> singleRecord = new HashMap<String, Character>();
    private final Map<String, Set<Character>> multipleRecord = new HashMap<>();
    private final Map<Character, Integer> countAnswer = new HashMap<>();

    /**
     * create a question object
     * @param questionType: takes either 0 or 1 that corresponds to SingleQuestion or MultipleQuestion
     * @param totalAnswers: takes at least 1 or more possible answer choices
     */
    public void createQuestion(int questionType, int totalAnswers){
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
     * process the answer of a student when the question is a SingleQuestion object
     * @param student: takes a student object; student need to have a unique id; the same id will overwrite previous response
     * @param answer: takes the student answer; If answer is more than one element, only the last will be recorded
     */
    private void answerSingle(Student student, List<Character> answer){
        singleRecord.put(student.getStudentID(), answer.getLast());
        System.out.println(student.getStudentID() + " answered: " + answer.getLast());
    }
    /**
     * process the answer of a student when the question is a MultipleQuestion object
     * @param student: takes a student object; student need to have a unique id; the same id will overwrite previous response
     * @param answer: takes the student answers;
     */
    private void answerMultiple(Student student, List<Character> answer){
        List<Character> charList = new LinkedList<>();
        for (char c : answer){
            if(question.answerToString().indexOf(c) != -1){
                charList.add(c);
            }
        }
        Set<Character> validatedAnswer = new HashSet<>(charList);   //remove duplicates
        multipleRecord.put(student.getStudentID(), validatedAnswer);
        System.out.println(student.getStudentID() + " answered: " + validatedAnswer);
    }
    /**
     * set the map countAnswer for recording students answer
     */
    private void calculateStatistic(){
        for (Character ans : singleRecord.values())
            countAnswer.put(ans, countAnswer.get(ans) + 1);
        for (Set<Character> ans : multipleRecord.values())
            for (char i : ans)
                countAnswer.put(i, countAnswer.get(i) + 1);
    }

    /**
     * print the statistic of the answers to the terminal
     */
    public void printStatistic(){
        System.out.println();
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