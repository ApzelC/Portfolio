// Axel Espinoza Sebastián - A01425004
// Axel Daniel Corona Ibarra - A01425010
// ACT 1.0 - REPASO POO
// Código simulador del juego Serpientes y Escaleras
// 14/08/2022
#include <iostream>
using namespace std;
#include "Dice.h"
#include "Player.h"

class MyGame{
  public:
    int start(){
      int opc;
      cout<<"/////welcome to 🐍🐍 y 🎢🎢/////"<<endl;
      cout<<"Main menu\n1.Play \n2.Exit game"<<endl;
      cin >>opc;
      switch(opc){
        case 1:{ 
          Dice dice;
          dice.RollDice();
          }
        break;
        case 2:{
          cout<<"Thank u :)"<<endl;
          return 0;
        }
        break;
        default:{ 
          cout<<"Press a valid number"<<endl;
          return start();
        }
      }
    }
    
};