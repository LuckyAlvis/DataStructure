package com.shenzhen.dai;

import java.util.Random;

public class ThreeDoorsProblem {
    public static void main(String[] args) {
        int successCount = 0;
        int falseCount = 0;
        for (int i = 0; i < 100000000; i++) {
            boolean result = choose("是", false);
            if (result) {
                successCount++;
            } else {
                falseCount++;
            }
        }
        System.out.println("成功次数：" + successCount);
        System.out.println("失败次数：" + falseCount);
        System.out.println("成功率：" + (successCount / (double) (successCount + falseCount)));
    }

    private static boolean choose(String answer, Boolean isPrint) {
        // 初始化随机数生成器
        Random random = new Random();

        // 初始化门的数量
        int numberOfDoors = 3;

        // 初始化奖品所在的门
        int prizeDoor = random.nextInt(numberOfDoors) + 1;
        if (isPrint) {
            System.out.println("奖品在门 " + prizeDoor + " 上。");
        }

        // 提示玩家选择一个门
        if (isPrint) {
            System.out.println("请选择一个门 (1-" + numberOfDoors + "): ");
        }
//        Scanner scanner = new Scanner(System.in);
//        int playerChoice = scanner.nextInt();
        int playerChoice = random.nextInt(numberOfDoors) + 1;
        if (isPrint) {
            System.out.println("你选择了门 " + playerChoice);
        }

        // 主持人打开一个空门
        int hostOpen = openEmptyDoor(prizeDoor, playerChoice, numberOfDoors, random, isPrint);

        // 提示玩家是否要更改选择
//        System.out.println("你要更改选择吗？(是/否): ");
//        String changeChoice = scanner.next();

        // 如果玩家选择更改，则重新选择一个未打开的门
        if (answer.equalsIgnoreCase("是")) {
            playerChoice = switchDoor(playerChoice, hostOpen, numberOfDoors, random);
            if (isPrint) {
                System.out.println("你更改了选择，现在选择了门 " + playerChoice);
            }
        }

        // 判断最终结果
        if (playerChoice == prizeDoor) {
            if (isPrint) {
                System.out.println("恭喜你，你赢得了奖品！");
            }
            return true;
        } else {
            if (isPrint) {
                System.out.println("很遗憾，奖品在门 " + (prizeDoor) + " 上。");
            }
            return false;
        }
    }

    // 主持人打开一个未选择的空门
    private static int openEmptyDoor(int prizeDoor, int playerChoice, int numberOfDoors, Random random, Boolean isPrint) {
        int hostOpen;
        do {
            hostOpen = random.nextInt(numberOfDoors) + 1;
        } while (hostOpen == prizeDoor || hostOpen == playerChoice);

        if (isPrint) {
            System.out.println("主持人打开了门 " + hostOpen);
        }
        return hostOpen; // 返回门的编号（从1开始）
    }

    // 玩家更改选择
    private static int switchDoor(int playerChoice, int hostOpen, int numberOfDoors, Random random) {
        int newChoice;
        do {
            newChoice = random.nextInt(numberOfDoors) + 1;
        } while (newChoice == playerChoice || newChoice == hostOpen);
        return newChoice;
    }
}
