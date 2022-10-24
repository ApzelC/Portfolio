// Axel Espinoza Sebastián - A01425004
// Axel Daniel Corona Ibarra - A01425010
// ACT 1.0 - REPASO POO
// Código simulador del juego Serpientes y Escaleras
// 14/08/2022
#pragma once 
#include <iostream>
#include <string>
using namespace std;


class Player{
  private:
    string name;
  public:
    Player();
    Player(string);
    ~Player();

  //getters
  string getName();
  //setters
  void setName(string);
  
};