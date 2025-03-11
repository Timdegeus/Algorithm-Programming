public class Shot
{
    private int shooterId;
    private int shotNumber;
    private double score;
    private double xCoord;
    private double yCoord;
    private double distancePrevious;
    private String comparison;
    private double currentAverage;
    private double totalScore;

    public Shot(int shooterId, int shotNumber, double score, double xCoord, double yCoord, double distancePrevious, String comparison, double currentAverage, double totalScore)
    {
        this.shooterId = shooterId;
        this.shotNumber = shotNumber;
        this.score = score;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.distancePrevious = distancePrevious;
        this.comparison = comparison;
        this.currentAverage = currentAverage;
        this.totalScore = totalScore;
    }

    public int getShooterId() {
        return shooterId;
    }

    public void setShooterId(int shooterId) {
        this.shooterId = shooterId;
    }

    public int getShotNumber() {
        return shotNumber;
    }

    public void setShotNumber(int shotNumber) {
        this.shotNumber = shotNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public double getDistancePrevious() {
        return distancePrevious;
    }

    public void setDistancePrevious(double distancePrevious) {
        this.distancePrevious = distancePrevious;
    }

    public String getComparison() {
        return comparison;
    }

    public void setComparison(String comparison) {
        this.comparison = comparison;
    }

    public double getCurrentAverage() {
        return currentAverage;
    }

    public void setCurrentAverage(double currentAverage) {
        this.currentAverage = currentAverage;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString()
    {
        return "Shooter" + shooterId + " - shot " + shotNumber + ": " + score + " points (X: " + xCoord + ", Y: " + yCoord + ")";
    }
}
