#pragma once 

#include <iostream>
#include <string>
#include "Video.h"
using namespace std;


class Serie: public Video{
  private:
    string tituloEp;
    int episodio, temporada;
      
  public:

  Serie();
  Serie(string, string, int, int,double, string, int, int);
  ~Serie();

  //getters
  string getTituloEp();
  int getTemporada();
  int getEpisodio();
 
  
  //setters
  void setTituloEp(string);
  void setEpisodio(int);
  void setTemporada(int);
  
  void imprimir();
  friend ostream& operator<<(ostream &out,Serie&);
  
  };
