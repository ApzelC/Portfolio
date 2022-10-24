// Axel Espinoza Sebastián - A01425004
// Axel Daniel Corona Ibarra - A01425010
// ACT 1.0 - REPASO POO
// Código simulador del juego Serpientes y Escaleras
// 14/08/2022
#include <iostream>
#include <string>
#include<stdlib.h>
#include<time.h>
using namespace std;
#include "Dice.h"
#include "Player.h"

Dice::Dice(){
  number = 0;
}
Dice::Dice(int num){
  number = num;
}
Dice::~Dice(){
}
int Dice::getNumber(){
  return number;
}
void Dice::setNumber(int number){
  this -> number = number;
}

int Dice::RollDice(){
  string s, cas1, cas2;
  int t, lim, sumap1 = 1, sumap2 =1, casilla1, casilla2;
  Player p1, p2;
  p1.setName("1");
  p2.setName("2");  
  lim=0; 
  Dice dado1, dado2;
  cout<<"🐍 Introduce the number of turns 🐍" <<endl;
  cin>>t;
  
  do{
    cout<<"Press C to play a turn or E to exit the game: "<<endl;
    cin>>s;
    if(s=="c" || s=="C"){
      if (t>0){
        srand(time(NULL));
        dado1.setNumber((rand()%6)+1);
        dado2.setNumber((rand()%6)+1);
        casilla1 = dado1.getNumber()+sumap1;
        casilla2 = dado2.getNumber()+sumap2;
        
        if (casilla1 == 5 || casilla1 == 18 ||casilla1 == 26){
          cas1 = "S";
          casilla1 = casilla1 - 3;
        }
        else if (casilla1 == 8 || casilla1 == 19 || casilla1 == 24){
          cas1 = "L";
          casilla1 = casilla1 + 3;
         
        }
        else{
          cas1 = "N";
        }
        if (casilla2 == 5 || casilla2 == 18 || casilla2 == 26){
          cas2 = "S";
          casilla2 = casilla2 - 3;
         
        }
        else if (casilla2 == 8 || casilla2 == 19 || casilla2 == 24){
          cas2 = "L";
          casilla2 = casilla2 + 3;
          
        }
        else{
          cas2 = "N";
        }
        lim++;
        if (casilla1 >= 30){
          casilla1 = 30;
        }
        if (casilla2 >=30){
          casilla2 = 30;
        }
        cout<<lim<<" "<<p1.getName()<<" "<<sumap1<<" "<<dado1.getNumber()<<" "<<cas1<<" "<<casilla1<<endl; 
        cout<<lim<<" "<<p2.getName()<<" "<<sumap2<<" "<<dado2.getNumber()<<" "<<cas2<<" "<<casilla2<<endl;
        t--;
        sumap1 = casilla1;
        sumap2 = casilla2;
        if(sumap1 >=30){
          cout<<endl<<"-- Game over :) --"<<endl;
          cout<<"The winner is #"<< p1.getName()<<endl;
          return 0;
          }
        else if(sumap2 >=30){
          cout<<endl<<"-- Game over :) --"<<endl;
          cout<<"The winner is #"<< p2.getName()<<endl;
          return 0;
        }
      }
       else{
        cout<<"Invalid number, please select one higher than 0"<<endl;
        return RollDice();
       }
     }
    else if(s =="e" || s=="E"){ 
      cout<<"-- Game over :) --"<<endl;
      return 0;
      }
    else{ 
      cout<<"Press a valid key"<<endl;
      cout<<"Press C to play a turn or E to exit the game: "<<endl;
      cin>>s;
      }
   }
    while (t>0);
  if(t<=0){
    cout<<endl<<"Turns limit reached"<<endl;
    return 0;
  }

  return 0;
}  