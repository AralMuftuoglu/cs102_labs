import java.util.ArrayList;

public class Simulation {

    public ArrayList<Robot> redTeam = new ArrayList<Robot>();
    public ArrayList<Robot> blueTeam = new ArrayList<Robot>();
    private boolean firstStartRed;

    // random robots
    public void randomRobotGen(int x, ArrayList<Robot> team) {
        for (int i = 0; i < x; i++) {
            int random = (int) Math.floor(Math.random() * (6) + 1);

            if (random == 1) {
                Robot a = new SimpleBot();
                team.add(a);
            } else if (random == 2) {
                Robot a = new PredatorBot();
                team.add(a);
            } else if (random == 3) {
                Robot a = new DefenceBot();
                team.add(a);
            } else if (random == 4) {
                Robot a = new SpeedBot();
                team.add(a);
            } else if (random == 5) {
                Robot a = new SpreadBot();
                team.add(a);
            } else if (random == 6) {
                Robot a = new OneBot();
                team.add(a);
            }
        }
    }

    // robot sorting by speed
    public void sortingRobots(ArrayList<Robot> team) {
        for (int i = 0; i < team.size(); i++) {
            for (int a = i + 1; a < team.size(); a++) {
                if (team.get(i).speed < team.get(a).speed) {
                    Robot temp = team.get(i);
                    team.set(i, team.get(a));
                    team.set(a, temp);
                }
            }
        }
    }

    public void initialize(int teamSize) {
        randomRobotGen(teamSize, this.redTeam);
        randomRobotGen(teamSize, this.blueTeam);

        for (int i = 0; i < this.redTeam.size(); i++) {
            this.redTeam.get(i).isReadTeam = true;
            this.blueTeam.get(i).isReadTeam = false;
        }
        sortingRobots(this.redTeam);
        sortingRobots(this.blueTeam);

        System.out.println("Team Size: " + teamSize);
        System.out.println();
        System.out.println("Red team:");

        for (int i = 0; i < teamSize; i++) {
            System.out.print(this.redTeam.get(i).code + " Health: ");
            System.out.printf("%.3f", this.redTeam.get(i).health);
            System.out.print(" Attack: ");
            System.out.printf("%.3f", this.redTeam.get(i).attack);
            System.out.print(" Speed: ");
            System.out.printf("%.3f", this.redTeam.get(i).speed);
            System.out.println();
        }

        System.out.println("Blue team:");

        for (int i = 0; i < teamSize; i++) {
            System.out.print(this.blueTeam.get(i).code + " Health: ");
            System.out.printf("%.3f", this.blueTeam.get(i).health);
            System.out.print(" Attack: ");
            System.out.printf("%.3f", this.blueTeam.get(i).attack);
            System.out.print(" Speed: ");
            System.out.printf("%.3f", this.blueTeam.get(i).speed);
            System.out.println();
        }

        double totalRedSpeed = 0;
        double totalBlueSpeed = 0;

        for (int i = 0; i < teamSize; i++) {
            totalRedSpeed = totalRedSpeed + this.redTeam.get(i).speed;
            totalBlueSpeed = totalBlueSpeed + this.redTeam.get(i).speed;
        }

        System.out.print("Speed sum of Red: ");
        System.out.printf("%.3f", totalRedSpeed);
        System.out.println();
        System.out.print("Speed sum of Blue: ");
        System.out.printf("%.3f", totalBlueSpeed);
        System.out.println();

    }

    public void simulate() {
        double totalRedSpeed = 0;
        double totalBlueSpeed = 0;

        for (int i = 0; i < this.redTeam.size(); i++) {
            totalRedSpeed = totalRedSpeed + this.redTeam.get(i).speed;
            totalBlueSpeed = totalBlueSpeed + this.redTeam.get(i).speed;
        }

        if (totalBlueSpeed > totalRedSpeed) {
            this.firstStartRed = false;
        } else {
            this.firstStartRed = true;
        }

        boolean whichTeam = firstStartRed;

        int redIndex = 0;
        int blueIndex = 0;

        while (this.blueTeam.size() != 0 && this.redTeam.size() != 0) {
            if ((redIndex + 1) % this.redTeam.size() == 0) {
                redIndex = 0;
            }
            if ((blueIndex + 1) % this.blueTeam.size() == 0) {
                blueIndex = 0;
            }

            if (whichTeam) {
                this.redTeam.get(redIndex).attack(this);
                whichTeam = false;
                redIndex++;
            } else {
                this.blueTeam.get(blueIndex).attack(this);
                whichTeam = true;
                blueIndex++;
            }
        }

        if (this.blueTeam.size() == 0) {
            System.out.println("Red team wins, remnaining robots:");
            for (int i = 0; i < this.redTeam.size(); i++) {
                System.out.print(this.redTeam.get(i).code + " Health: ");
                System.out.printf("%.3f", this.redTeam.get(i).health);
                System.out.print(" Attack: ");
                System.out.printf("%.3f", this.redTeam.get(i).attack);
                System.out.print(" Speed: ");
                System.out.printf("%.3f", this.redTeam.get(i).speed);
                System.out.println();
            }
        } else {
            System.out.println("Blue team wins, remnaining robots:");
            for (int i = 0; i < this.blueTeam.size(); i++) {
                System.out.print(this.blueTeam.get(i).code + " Health: ");
                System.out.printf("%.3f", this.blueTeam.get(i).health);
                System.out.print(" Attack: ");
                System.out.printf("%.3f", this.blueTeam.get(i).attack);
                System.out.print(" Speed: ");
                System.out.printf("%.3f", this.blueTeam.get(i).speed);
                System.out.println();
            }
        }

    }

    public Robot getRandomTarget(boolean isReadTeam) {
        Robot randomRobot;

        if (!isReadTeam) {
            int numberOfRobots = this.redTeam.size();

            int randomRobotIndex = (int) Math.floor(Math.random() * (numberOfRobots) + 0);

            randomRobot = this.redTeam.get(randomRobotIndex);
        } else {
            int numberOfRobots = this.blueTeam.size();

            int randomRobotIndex = (int) Math.floor(Math.random() * (numberOfRobots) + 0);

            randomRobot = this.blueTeam.get(randomRobotIndex);
        }

        return randomRobot;
    }

    public Robot getHighestHealth(boolean isReadTeam) {
        if (!isReadTeam) {
            double maxHealth = this.redTeam.get(0).health;

            int maxIndex = 0;

            for (int i = 1; i < this.redTeam.size(); i++) {
                double currentHealth = this.redTeam.get(i).health;

                if (currentHealth > maxHealth) {
                    maxHealth = currentHealth;
                    maxIndex = i;
                }
            }

            return this.redTeam.get(maxIndex);
        } else {
            double maxHealth = this.blueTeam.get(0).health;

            int maxIndex = 0;

            for (int i = 1; i < this.blueTeam.size(); i++) {
                double currentHealth = this.blueTeam.get(i).health;

                if (currentHealth > maxHealth) {
                    maxHealth = currentHealth;
                    maxIndex = i;
                }
            }

            return this.blueTeam.get(maxIndex);
        }
    }

    public Robot getLowestHealth(boolean isReadTeam) {
        if (!isReadTeam) {
            double lowestHealth = this.redTeam.get(0).health;

            int minIndex = 0;

            for (int i = 1; i < this.redTeam.size(); i++) {
                double currentHealth = this.redTeam.get(i).health;

                if (currentHealth < lowestHealth) {
                    lowestHealth = currentHealth;
                    minIndex = i;
                }
            }

            return this.redTeam.get(minIndex);
        } else {
            double lowestHealth = this.blueTeam.get(0).health;

            int minIndex = 0;

            for (int i = 1; i < this.blueTeam.size(); i++) {
                double currentHealth = this.blueTeam.get(i).health;

                if (currentHealth < lowestHealth) {
                    lowestHealth = currentHealth;
                    minIndex = i;
                }
            }

            return this.blueTeam.get(minIndex);
        }
    }

    public Robot getLowestSpeed(boolean isReadTeam) {
        if (!isReadTeam) {
            double lowestSpeed = this.redTeam.get(0).speed;

            int minIndex = 0;

            for (int i = 1; i < this.redTeam.size(); i++) {
                double currentSpeed = this.redTeam.get(i).speed;

                if (currentSpeed < lowestSpeed) {
                    lowestSpeed = currentSpeed;
                    minIndex = i;
                }
            }

            return this.redTeam.get(minIndex);
        } else {
            double lowestSpeed = this.blueTeam.get(0).speed;

            int minIndex = 0;

            for (int i = 1; i < this.blueTeam.size(); i++) {
                double currentSpeed = this.blueTeam.get(i).speed;

                if (currentSpeed < lowestSpeed) {
                    lowestSpeed = currentSpeed;
                    minIndex = i;
                }
            }

            return this.blueTeam.get(minIndex);
        }
    }

    public Robot getLowestAttack(boolean isReadTeam) {
        if (!isReadTeam) {
            double lowestAttack = this.redTeam.get(0).attack;

            int minIndex = 0;

            for (int i = 1; i < this.redTeam.size(); i++) {
                double currenAttack = this.redTeam.get(i).attack;

                if (currenAttack < lowestAttack) {
                    lowestAttack = currenAttack;
                    minIndex = i;
                }
            }

            return this.redTeam.get(minIndex);
        } else {
            double lowestAttack = this.blueTeam.get(0).attack;

            int minIndex = 0;

            for (int i = 1; i < this.blueTeam.size(); i++) {
                double currenAttack = this.blueTeam.get(i).attack;

                if (currenAttack < lowestAttack) {
                    lowestAttack = currenAttack;
                    minIndex = i;
                }
            }

            return this.blueTeam.get(minIndex);
        }
    }

    public Robot[] getLowestSpeed3(boolean isReadTeam) {
        if (!isReadTeam) {
            Robot[] lowestRobots;

            if (this.redTeam.size() >= 3) {
                lowestRobots = new Robot[3];

                lowestRobots[2] = this.redTeam.get(this.redTeam.size() - 1);
                lowestRobots[1] = this.redTeam.get(this.redTeam.size() - 2);
                lowestRobots[0] = this.redTeam.get(this.redTeam.size() - 3);
            } else if (this.redTeam.size() == 2) {
                lowestRobots = new Robot[2];

                lowestRobots[1] = this.redTeam.get(1);
                lowestRobots[0] = this.redTeam.get(0);
            } else {
                lowestRobots = new Robot[1];
                lowestRobots[0] = this.redTeam.get(0);
            }

            return lowestRobots;
        } else {
            Robot[] lowestRobots;

            if (this.blueTeam.size() >= 3) {
                lowestRobots = new Robot[3];

                lowestRobots[2] = this.blueTeam.get(this.blueTeam.size() - 1);
                lowestRobots[1] = this.blueTeam.get(this.blueTeam.size() - 2);
                lowestRobots[0] = this.blueTeam.get(this.blueTeam.size() - 3);
            } else if (this.blueTeam.size() == 2) {
                lowestRobots = new Robot[2];

                lowestRobots[1] = this.blueTeam.get(1);
                lowestRobots[0] = this.blueTeam.get(0);
            } else {
                lowestRobots = new Robot[1];
                lowestRobots[0] = this.blueTeam.get(0);
            }

            return lowestRobots;
        }
    }

    public void removeRobot(Robot r) {
        System.out.println(r.code + " destroyed");

        if (r.isReadTeam) {
            this.redTeam.remove(r);
        } else {
            this.blueTeam.remove(r);
        }
    }

}
