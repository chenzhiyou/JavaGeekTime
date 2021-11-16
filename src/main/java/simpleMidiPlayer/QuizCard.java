package simpleMidiPlayer;

/***
 * 表示卡片数据的类
 */
public class QuizCard {
    private String question;
    private String answer;

    public QuizCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
}
