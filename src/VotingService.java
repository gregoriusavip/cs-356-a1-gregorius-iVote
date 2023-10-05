import java.util.*;
public class VotingService {
    private Question question;
    private final Map<String, Character> singleRecord = new HashMap<String, Character>();
    private final Map<String, List<Character>> multipleRecord = new HashMap<>();
    private final Map<Character, Integer> countAnswer = new HashMap<>();
    public void createQuestion(int questionType, int totalAnswers, int[] answerKey){
        if(questionType == 0){
            question = new SingleQuestion();
        }
        else if (questionType == 1) {
            question = new MultipleQuestion();
        }
        else{
            throw new IllegalArgumentException("Question type has to be 0 or 1");
        }
        question.createQuestion(totalAnswers);
        question.setAnswer(answerKey);
        for(int i = 0; i < question.getAnswerSize(); i++){
            countAnswer.put(question.getAnswers().get(i), 0);
        }
    }
    public void answerSingle(Student student, char answer){
        if(question.answerToString().indexOf(answer) != -1){
            singleRecord.put(student.getStudentID(), answer);
        }
    }
    public void answerMultiple(Student student, char[] answer){
        List<Character> validatedAnswer = new LinkedList<>();
        for (int i : answer){
            if(question.answerToString().indexOf(answer[i]) != -1){
                validatedAnswer.add(answer[i]);
            }
        }
        multipleRecord.put(student.getStudentID(), validatedAnswer);
    }
    private void calculateStatistic(){
        for (Character ans : singleRecord.values())
            countAnswer.put(ans, countAnswer.get(ans) + 1);
        for (List<Character> ans : multipleRecord.values())
            for (char i : ans)
                countAnswer.put(i, countAnswer.get(i) + 1);
    }
    public void printStatistic(){
        calculateStatistic();
        System.out.println(countAnswer.toString());
    }
}
