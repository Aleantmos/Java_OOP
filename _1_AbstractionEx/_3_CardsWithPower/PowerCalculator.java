package _3_CardsWithPower;


public class PowerCalculator {
    private RankPower cardRank;
    private SuitPower suitPower;

    public PowerCalculator(RankPower cardRank, SuitPower suitPower) {
        this.cardRank = cardRank;
        this.suitPower = suitPower;
    }

    public int getPower() {
        int power = cardRank.getRankPower() + suitPower.getSuitPower();
        return power;
    }
}
