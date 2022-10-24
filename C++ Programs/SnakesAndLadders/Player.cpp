// Axel Espinoza Sebastián - A01425004
// Axel Daniel Corona Ibarra - A01425010
// ACT 1.0 - REPASO POO
// Código simulador del juego Serpientes y Escaleras
// 14/08/2022
#include <iostream>
#include <string>
using namespace std;
#include "Player.h"

Player::Player(){
  name = "";
}
Player::Player(string n){
  name = n;
}
Player::~Player(){
}

string Player::getName(){
  return name;
}
void Player::setName(string name){
  this -> name = name;
}
