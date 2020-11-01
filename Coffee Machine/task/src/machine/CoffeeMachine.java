package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static MachineState machineState;
    boolean powerOn = true;

    int water = 400;
    int milk = 540;
    int coffeeBeans = 120;
    int disposableCups = 9;
    int money = 550;


    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        coffeeMachine.setMachineState(MachineState.MENU);

        while (coffeeMachine.powerOn) {
            coffeeMachine.parseInput(scanner.nextLine());
            }
        }


    void parseInput (String input) {
        switch (machineState) {
            case MENU:
                menuSelect(input);
                break;
            case BUY:
                buy(input);
                break;
            case FILL:
                fill(input);
                break;
            case FILL_WATER:
                fill(input);
                break;
            case FILL_MILK:
                fill(input);
                break;
            case FILL_COFFEE:
                fill(input);
                break;
            case FILL_CUPS:
                fill(input);
                break;
            default:
                break;
        }

    }

    public MachineState getMachineState() {
        return machineState;
    }

    void mainMenu() {
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        setMachineState(MachineState.MENU);
    }

    void menuSelect(String input) {
        switch (input) {
            case ("buy"):
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                setMachineState(MachineState.BUY);
                buy(input);
                break;
            case ("fill"):
                setMachineState(MachineState.FILL);
                fill(input);
                break;
            case ("take"):
                take();
                break;
            case ("remaining"):
                remaining();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                setMachineState(MachineState.MENU);
                break;
            case ("exit"):
                exit();
                break;
            default:
                break;
        }
    }

    public void setMachineState(MachineState machineState) {
        switch (machineState) {
            case MENU:
                CoffeeMachine.machineState = MachineState.MENU;
                break;
            case FILL:
                CoffeeMachine.machineState = MachineState.FILL;
                break;
            case BUY:
                CoffeeMachine.machineState = MachineState.BUY;
                break;
            case FILL_WATER:
                CoffeeMachine.machineState = MachineState.FILL_WATER;
                break;
            case FILL_MILK:
                CoffeeMachine.machineState = MachineState.FILL_MILK;
                break;
            case FILL_COFFEE:
                CoffeeMachine.machineState = MachineState.FILL_COFFEE;
                break;
            case FILL_CUPS:
                CoffeeMachine.machineState = MachineState.FILL_CUPS;
                break;
            default:
                break;
        }
    }

    void buy(String input) {
        switch (input) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                    mainMenu();
                } else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    mainMenu();
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    mainMenu();
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups -= 1;
                    money += 4;
                    mainMenu();
            }
                break;
            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                    mainMenu();
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    mainMenu();
                } else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    mainMenu();
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    mainMenu();
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups -= 1;
                    money += 7;
                    mainMenu();
                }
                break;
            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                    mainMenu();
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    mainMenu();
                } else if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    mainMenu();
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    mainMenu();
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups -= 1;
                    money += 6;
                    mainMenu();
                }
                break;
            case "back":
                mainMenu();
                break;
            default:
                break;
        }
    }

    void fill(String input) {
        switch (machineState) {
            case FILL:
                System.out.println();
                System.out.println("Write how many ml of water do you want to add:");
                setMachineState(MachineState.FILL_WATER);
                break;
            case FILL_WATER:
                water += Integer.parseInt(input);
                setMachineState(MachineState.FILL_MILK);
                System.out.println("Write how many ml of milk do you want to add:");
                break;
            case FILL_MILK:
                milk += Integer.parseInt(input);
                setMachineState(MachineState.FILL_COFFEE);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                break;
            case FILL_COFFEE:
                coffeeBeans += Integer.parseInt(input);
                setMachineState(MachineState.FILL_CUPS);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                break;
            case FILL_CUPS:
                disposableCups += Integer.parseInt(input);
                setMachineState(MachineState.MENU);
                mainMenu();
                break;
            default:
                break;
        }


    }

    void take() {
        System.out.println();
        System.out.println("I gave you $" + money);
        money = 0;
        mainMenu();
    }

    void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    void exit() {
        powerOn = false;
    }
}

enum MachineState {
    MENU,
    BUY,
    FILL,
    FILL_WATER,
    FILL_MILK,
    FILL_COFFEE,
    FILL_CUPS
}

