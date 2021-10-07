package DnD;

public class ProbabilityAll {
    public static void main(String[] args) throws Exception {
        int limit = 15;
        String[] values = {"1`Acrobatics, Sleight of Hand","3`Religion",
                "4`Animal Handling, Intimidation, Medicine, Performance, Stealth, Survival","7`Deception, Insight, Perception, Persuasion"};
        for (String i : values) {
            String[] current = i.split("`");
            int mod = Integer.parseInt(current[0]);
            float probability = 0;
            for (int j=1;j<=20;++j) {
                if (probability == 0 && j+mod < limit) {
                    probability = ((float) 1/20);
                } else if (j+mod < limit) {
                    probability = probability + (float) 1/20;
                }
            }
            System.out.println("Probability for " + current[1] + " < " + limit + ": " + (int) Math.floor(probability*100)  + "%");
        }
    }
}
