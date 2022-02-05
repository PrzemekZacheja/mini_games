package lotto;

import java.util.Set;

public abstract class NumbersGameSetAbstract {

    NumbersGameSetAbstract() {
    }

    protected static String printSet(Set<Integer> playerChoices) {
        StringBuilder line = new StringBuilder();
        for (int i : playerChoices) {
            line.append(i).append(" ");
        }
        return line.toString();
    }
}
