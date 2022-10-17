package com.company;

public class Main {

    public static void main(String[] args) {

        AnimalThread at1 = (new AnimalThread(10, "Черепаха"));
        AnimalThread at2 = (new AnimalThread(1, "Кролик"));
        at1.start();
        at2.start();

    }
}
      class AnimalThread extends Thread {
          int priority;
          String name;
          final int distance = 11;

          public AnimalThread(int priority, String name) {
              this.name = name;
              this.priority = priority;
          }

          @Override
          public void run() {
              Thread.currentThread().setPriority(priority);
              Thread.currentThread().setName(name);

              int timeToStep = 1000 / (Thread.currentThread().getPriority());
              for (int i = 0; i < distance; i++) {

                  try {
                      Thread.sleep(timeToStep);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println((getName() + ("-") + (i * 100) + "метров"));
              }


          }
      }