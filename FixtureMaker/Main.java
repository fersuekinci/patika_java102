import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> team = new ArrayList<>();
        List<String> tempTeam = new ArrayList<>();
        List<String> match = new ArrayList<>();
        List<String> match1 = new ArrayList<>();

        Random rand = new Random();

        String home;
        String other;

        team.add("galatasaray");
        team.add("bursaspor");
        team.add("fenerbahçe");
        team.add("beşiktaş");
        team.add("başakşehir");
        team.add("trabzonspor");
        team.add("deneme");

        if (team.size() % 2 != 0) {
            team.add("bay");
        }

        System.out.println("takımlar");

        for (int i = 0; i < team.size(); i++) {
            System.out.println("- " + team.get(i));
        }
        System.out.println();
        System.out.println();

        int k = 0;
        while (k < 5) {
            System.out.println();
            System.out.println("round " + (k + 1));
            tempTeam.addAll(team);

            for (int i = 0; i < team.size()/2; i++) {

                int random = rand.nextInt(tempTeam.size());
                home = tempTeam.get(random);
                tempTeam.remove(home);

                random = rand.nextInt(tempTeam.size());
                other = tempTeam.get(random);
                tempTeam.remove(other);

                System.out.println(home + " vs " + other);

                match.add(home + " vs " + other);
                match1.add(other + " vs " + home);
            }
            k++;
        }

        int j= 6;
        for (int i = 0; i < match1.size(); i++) {
            if (i %(team.size()/2) == 0) {
                System.out.println();
                System.out.println("round " + (j));
                j++;
            }
            System.out.println(match1.get(i));
        }
    }
}
