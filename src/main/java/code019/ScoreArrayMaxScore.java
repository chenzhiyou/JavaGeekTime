package code019;

public class ScoreArrayMaxScore {
    public static void main(String[] args) {
        // 每门成绩对应的索引
        int YuWen = 0;
        int ShuXue = 1;
        int WaiYu = 2;
        int Wuli = 3;
        int HUaXue = 4;
        int ShengWu = 5;

        int totalScoreCount = 6;
        double[] scores = new double[totalScoreCount];
        String[] scoreNames = new String[totalScoreCount];
        scoreNames[YuWen] = "语文";
        scoreNames[ShuXue] = "数学";
        scoreNames[WaiYu] = "外语";
        scoreNames[Wuli] = "物理";
        scoreNames[HUaXue] = "化学";
        scoreNames[ShengWu] = "生物";

        for (int i=0; i<totalScoreCount; i++){
            scores[i] = 80+ Math.random()*20;
            System.out.println(scoreNames[i]+"这门课的成绩是"+ scores[i]);
        }

        double maxScore = 0;
        int maxScoreIndex = -1;

        for (int i=0; i<totalScoreCount; i++){
            if (scores[i]>maxScore){
                maxScore = scores[i];
                maxScoreIndex = i;
            }
        }
        System.out.println("最好成绩为"+maxScore+"最好成绩的科目是"+scoreNames[maxScoreIndex]);

    }
}
