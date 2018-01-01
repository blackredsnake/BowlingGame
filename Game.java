package BowlingGame;

public class Game {
    private int rolls[] = new int[21];
    private int currentRoll = 0;
    private int firstInFrame = 0;
    private int score = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(firstInFrame))
                calculateScoreForSpare();
            else if (isStrike(firstInFrame))
                calculateScoreForStrike();
            else
                calculateScoreForFrame();
        }
        return score;
    }

    private void calculateScoreForFrame() {
        score += getScoreForCurrentFrame(firstInFrame);
        nextFrame();
    }

    private void calculateScoreForStrike() {
        score += 10 + nextTwoBallsInFrame(firstInFrame);
        nextFrameInCaseOfStrike();
    }

    private void calculateScoreForSpare() {
        score += 10 + nextBallInFrame(firstInFrame);
        nextFrame();
    }

    private void nextFrameInCaseOfStrike() {
        firstInFrame++;
    }

    private void nextFrame() {
        firstInFrame += 2;
    }

    private int getScoreForCurrentFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private int nextBallInFrame(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private int nextTwoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private boolean isStrike(int i) {
        return rolls[i] == 10;
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i + 1] == 10;
    }

}
