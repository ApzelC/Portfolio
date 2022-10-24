// Axel Espinoza Sebastián - A01425004
// Axel Daniel Corona Ibarra - A01425010
// ACT 1.0 - REPASO POO
// Código simulador del juego Serpientes y Escaleras
// 14/08/2022
#pragma once 
#include <iostream>
#include <string>
#include<stdlib.h>
using namespace std;

class Dice{
  private: 
    int number;
  public:
    Dice();
    Dice(int);
    ~Dice();

  //getters
  int getNumber();
  //setters
  void setNumber(int);  

  int RollDice();
};